package com.bgi.essa.jboss4.evaluator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.monitor.Collector;

import com.bgi.essa.shared.command.ParentTaskCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.RuleSample;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Main driver for collection, evaluation and alerting.
 * Invoked from Quartz (or JUnit, depending upon situation).
 * Task must exist prior to entry.  
 * 
 * @author coleguy
 */
public final class Evaluator {
	
	/**
	 * Obtain samples for each active rule
	 * 
	 * @param arg task identifier
	 */
	public Evaluator(String arg) { 
		_task_id = new TrimString(arg);
	}
	
	/**
	 * Main driver for evaluation work flow
	 */
	public void doEvaluation() {
		if (findTask() == false) {
			_log.error("unable to evaluate task:" + _task_id);
			return;
		}
				
		//collect samples
		Collector collector = new Collector(_parent_task);
		List<RuleSample> samples = collector.doCollection();
		_log.info("collector result size:" + samples.size());
		
		//compare sample to rule
		boolean alert_noted = false;
		Iterator<RuleSample> ii = samples.iterator();
		while (ii.hasNext()) {
			if (testRule(ii.next())) {
				alert_noted = true;
			}
		}
		
		//no alerts, all done
		if (alert_noted == false) {
			_log.info("all done, no samples w/rule match");
			return;
		}
		
		//alarm inhibit active?
		//only need one alarm inhibit active, marks all rule match rows as suppressed
		if (alarmInhibit(samples)) {
			_log.info("all done, alarm inhibit noted");
			suppressSamples(true, samples);
			return;
		}
		
		//match all rules or just one?
		if (_dto.isMatchAll()) {	
			int rule_population = samples.size();
			int match_population = getMatchPopulation(samples);
			
			_log.info("all rules must match:" + rule_population + ":" + match_population);
			
			if (rule_population != match_population) {
				return;
			}
		} else {
			_log.info("single rule match");
		}
		
		//select rule to generate alert
		RuleSample highest = getHighestAlert(samples);		
		if (highest == null) {
			_log.info("use task VPO defaults");
			
			highest = (RuleSample) samples.get(0);
			highest.setVpo(getTaskDefaultVpo(_task_id));
		} else {
			_log.info("use highest rule VPO");
		}
	
		//any prior alerts?
		if (testQuietPeriod(highest)) {
			_log.info("all done, too soon to complain again");
			suppressSamples(true, samples);
			return;
		}
		
		//falling through implies alert must be generated for this rule
		generateAlert(highest);
	}
	
	/**
	 * Dispatch fresh alert
	 * @param arg
	 * @return
	 */
	private boolean generateAlert(RuleSample arg) {
		_log.info("XXXX GENERATE ALERT WINNER XXXX");
		
		if (arg.getRule() == null) {
			System.out.println("get rule null");
		} else {
			System.out.println(arg.getRule());
		}
	
		if (arg.getSample() == null) {
			System.out.println("get sample null");
		} else {
			System.out.println(arg.getSample());
		}
		
		if (arg.getVpo() == null) {
			System.out.println("get vpo null");
		} else {
			System.out.println(arg.getVpo());
		}

		//mark sample as winner
		AbstractSample sample = (AbstractSample) arg.getSample();
		sample.setSuppressed(false);
		_bd.saveOrUpdate(sample);
		
		//does rule have canned actions?
		List<DtoIf> canned = getCanned(sample.getRuleId());
		if ((canned == null) || (canned.isEmpty())) {
			//nothing defined for rule, try task defaults
			canned = getCanned(new TrimString(ConstantsIf.DEFAULT_RULE));
		}
		
		//
		// Build argument list for opcmsg.
		// If there are no canned actions defined, this is a simple OV event.
		// Canned action implies email.
		//
		ArrayList<String> argz = new ArrayList<String>();
		argz.add("severity=" + arg.getVpo().getSeverity());
		argz.add("msg_group=" + arg.getVpo().getAppName().toString());
		argz.add("msg_text=" + arg.getVpo().getMessage().toString());
		argz.add("object=prod");
		
		if ((canned == null) || (canned.isEmpty())) {
			//no canned actions, simple scenario
			argz.add("application=ESSA");
		} else {
			//canned actions, generate email
			argz.add("application=Canned");
			argz.add("service_id=ESM");
			argz.add("node=XXX");
			argz.add("-option supkey=\"root\"");
			
			Iterator<DtoIf> icanz = canned.iterator();
			while(icanz.hasNext()) {
				CannedActionDTO cad = (CannedActionDTO) icanz.next();
				argz.add("-option action=\"" + cad.getAction().toString() + "\"");
				argz.add("-option address=\"" + cad.getAddress().toString() + "\"");
			}
		}
		
		//does task have custom message attributes?
		List<DtoIf> cma = getCma(_task_id);
		if ((cma == null) || (cma.isEmpty())) {
			//empty
		} else {
			argz.add("-option");
			
			Iterator<DtoIf> ii = cma.iterator();
			while (ii.hasNext()) {
				CustomMessageAttributeDTO cma_dto = (CustomMessageAttributeDTO) ii.next();
				argz.add(cma_dto.getKey() + "=" + cma_dto.getValue());
			}
		}

		JmxFacade facade = new JmxFacade();
		facade.executeNativeProcess(ConstantsIf.EXTERNAL_PROCESS, argz);
		
		return(true);
	}
	
	/**
	 * Determine the last time an alert was generated (and if the current alert suppressed)
	 * @param arg candidate
	 * @return true, quiet period still active
	 */
	private boolean testQuietPeriod(RuleSample arg) {
		List<DtoIf> list = _bd.selectByKey(arg.getSample(), SelectOption.SELECT_ACTIVE);
		
		AbstractSample matched = null;
		
		Iterator<DtoIf> ii = list.iterator();
		while(ii.hasNext()) {
			AbstractSample temp = (AbstractSample) ii.next();
			if ((temp.isMatch()) && (!temp.isSuppressed()) && (!temp.getRowId().equals(arg.getSample().getRowId()))) {
				matched = temp;
			}
		}
		
		_log.info("last generated:" + matched);
		
		AbstractSample temp1 = (AbstractSample) arg.getSample();
		
		long delta = temp1.getTimeStamp().getTimeInMillis() - matched.getTimeStamp().getTimeInMillis();
		delta /= 1000;
		long target = arg.getVpo().getFrequency() * 60;
		
		_log.info("delta:" + delta);
		_log.info("must wait for:" + target);
		
		if (delta > target) {
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Return the rule w/the highest priority.
	 * @param samples collected samples
	 * @return null, use task default otherwise use this rule
	 */
	private RuleSample getHighestAlert(List<RuleSample> samples) {
		RuleSample result = null;
		Severity severity = null;
		
		Iterator<RuleSample> ii = samples.iterator();
		while(ii.hasNext()) {
			RuleSample temp = ii.next();
			AbstractSample sample = (AbstractSample) temp.getSample();
			if (sample.isMatch()) {
				//discover optional VPO attribute for rule
				VpoDTO vpo_dto = new VpoDTO();
				vpo_dto.setTaskId(sample.getTaskId());
				vpo_dto.setRuleId(sample.getRuleId());
				
				List<DtoIf> list = _bd.selectByKey(vpo_dto, SelectOption.SELECT_ACTIVE);
				if ((list == null) || (list.isEmpty())) {
					//empty
				} else {
					vpo_dto = (VpoDTO) list.get(0);
					temp.setVpo(vpo_dto);
					
					if (result == null) {
						//uncontested winner
						result = temp;
						severity = vpo_dto.getSeverity();
					} else {
						if (severity.getWeight() < vpo_dto.getSeverity().getWeight()) {	
							result = temp;
							severity = vpo_dto.getSeverity();
						}
					}
				}
			}
		}
		
		return(result);
	}
	
	/**
	 * Return population of matched rules
	 * @param samples collected samples
	 * @return population of matched rules
	 */
	private int getMatchPopulation(List<RuleSample> samples) {
		int population = 0;
		
		Iterator<RuleSample> ii = samples.iterator();
		while(ii.hasNext()) {
			RuleSample temp = ii.next();
			AbstractSample sample = (AbstractSample) temp.getSample();
			if (sample.isMatch()) {
				++population;
			}
		}	
		
		return(population);
	}
	
	/**
	 * Given a task, determine if suppressed by alert window
	 * 
	 * @param arg current task
	 * @return true, must be suppressed
	 */
	private boolean alarmInhibit(List<RuleSample> samples) {
		boolean result = false;
		
		List<DtoIf> list = _parent_task.getAlarmInhibitList();
		if ((list == null) || (list.isEmpty())) {
			_log.info("no alarm inhibit window");
			return(result);
		} 
			
		_log.debug("alarm inhibit window population:" + list.size());
		
		int matched_population = 0;
		int suppressed_population = 0;
		
		Iterator<RuleSample> ii = samples.iterator();
		while(ii.hasNext()) {
			RuleSample temp = ii.next();
			AbstractSample sample = (AbstractSample) temp.getSample();
			if (sample.isMatch()) {
				++matched_population;
				if (testWindow(sample, list)) {
					++suppressed_population;
				}
			}
		}	
		
		_log.debug("suppress population:" + suppressed_population);
		
		if (suppressed_population > 0) {
			result = true;
		}
	
		return(result);
	}
	
	/**
	 * Determine if sample time is within alert inhibit window
	 * @param sample
	 * @param windoze
	 * @return true, inhibit noted
	 */
	private boolean testWindow(AbstractSample sample, List<DtoIf> windoze) {
		ZuluTime sample_time = sample.getTimeStamp();
		
		Iterator<DtoIf> ii = windoze.iterator();
		
		while (ii.hasNext()) {
			AlarmInhibitDTO dto = (AlarmInhibitDTO) ii.next();
			if (dto.testInhibit(sample_time)) {
				return(true);
			}
		}
		
		return(false);
	}
	
	/**
	 * Given a rule and sample, determine if alert thresholds were met
	 * 
	 * @param arg rule/sample
	 * @return true, alert threshold met
	 */
	private boolean testRule(RuleSample arg) {
		EvaluatorIf target = null;
	
		if (arg.getRule() instanceof BootTimeDTO) {
			target = new BootTime(arg);
		} else if (arg.getRule() instanceof DirectorySizeDTO) {
			target = new DirectorySize(arg);
		} else if (arg.getRule() instanceof FileAgeDTO) {
			target = new FileAge(arg);
		} else if (arg.getRule() instanceof FileSizeDTO) {
			target = new FileSize(arg);
		} else if (arg.getRule() instanceof FileSystemSizeDTO) {
			target = new FileSystemSize(arg);
		} else if (arg.getRule() instanceof ProcessDTO) {
			target = new Process(arg);
		} else {
			_log.error("unknown rule:" + arg.getRule());
		}
		
		target.testRule();
		
		return(target.isAlert());
	}
	
	/**
	 * Return default VPO for task.  Cannot fail, should always be a default VPO.
	 * 
	 * @param arg task id
	 * @return populated VPO
	 */
	private VpoDTO getTaskDefaultVpo(TrimString arg) {
		VpoDTO dto = new VpoDTO();
		dto.setTaskId(arg);
		dto.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		
		List<DtoIf> list = _bd.selectByKey(dto, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			_log.error("no default vpo");
		}
		
		return((VpoDTO) list.get(0));
	} 
	
	/**
	 * Return CMA list for a task.  Legal to be empty/null.
	 * 
	 * @param arg task id
	 * @return CMA list, might be empty or null
	 */
	private List<DtoIf> getCma(TrimString arg) {
		CustomMessageAttributeDTO dto = new CustomMessageAttributeDTO();
		dto.setTaskId(arg);
		
		List<DtoIf> list = _bd.selectByKey(dto, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			_log.error("no cma");
		} else {
			_log.info("cma population:" + list.size());
		}
		
		return(list);
	}
	
	/**
	 * Return canned arguments.  Legal to be empty/null
	 * 
	 * @param arg rule id
	 * @return canned list, might be empty or null
	 */
	private List<DtoIf> getCanned(TrimString arg) {
		CannedActionDTO dto = new CannedActionDTO();
		dto.setTaskId(_task_id);
		dto.setRuleId(arg);
		
		List<DtoIf> list = _bd.selectByKey(dto, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			_log.error("no canned arguments");
		} else {
			_log.info("canned population:" + list.size());
		}
		
		return(list);
	}
	
	/**
	 * Find the DTO, et al, based upon task id, returns most current version.
	 * 
	 * @return true if success
	 */
	private boolean findTask() {
		_log.info("target task:" + _task_id);
		
		_dto = new TaskDTO();
		_dto.setTaskId(_task_id);
		
		/// get version
		
		List<DtoIf> list = _bd.selectByKey(_dto, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			_log.error("empty or null task list");
			return(false);
		}
		
		_log.info("-------------------------------------------------");
		_log.info("select population:" + list.size());
		for (int ii = 0; ii < list.size(); ii++) {
			_log.info(list.get(ii));
		}
		_log.info("-------------------------------------------------");
		
		_dto = (TaskDTO) list.get(0);
		_log.info("evaluate task:" + _dto.toString());
	
		//now discover all rules, attributes, etc
		_parent_task = new ParentTaskCtx();
		_parent_task.setCandidate(_dto);
		
		try {
			_parent_task = (ParentTaskCtx) _bd.serviceCommand(_parent_task);
		} catch(Exception exception) {
			_log.error("unable to get parent task", exception);
			return(false);
		}
		
		//happy, happy, joy, joy
		return(true);
	}
	
	/**
	 * Mark the samples as suppressed (or not)
	 * 
	 * @param flag true, an alert could have been generated but was suppressed
	 * @param samples rows to update
	 */
	private void suppressSamples(boolean flag, List<RuleSample> samples) {
		Iterator<RuleSample> ii = samples.iterator();
		while(ii.hasNext()) {
			RuleSample rule_sample = ii.next();
			AbstractSample sample = (AbstractSample) rule_sample.getSample();
			if (sample.isMatch()) {
				sample.setSuppressed(flag);
				_bd.saveOrUpdate(sample);
			}
		}
	}
	
	/**
	 * Target task
	 */
	private TrimString _task_id;
	
	/**
	 * Current task DTO
	 */
	private TaskDTO _dto;
	
	/**
	 * Task, rules, attributes, et al 
	 */
	private ParentTaskCtx _parent_task;
	
	/**
	 * Command dispatch
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(Evaluator.class);
}
