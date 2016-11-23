package com.bgi.essa.jboss4.command;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;
import com.bgi.essa.jboss4.xml.AbstractRule;
import com.bgi.essa.jboss4.xml.RawAlarmInhibit;
import com.bgi.essa.jboss4.xml.ConfigurationParseTree;
import com.bgi.essa.jboss4.xml.ConfigurationParser;
import com.bgi.essa.jboss4.xml.ConfigurationRuleSet;
import com.bgi.essa.jboss4.xml.RawCma;
import com.bgi.essa.jboss4.xml.TaskTree;

import com.bgi.essa.shared.command.LoadXmlCtx;
import com.bgi.essa.shared.command.ParentTaskCtx;
import com.bgi.essa.shared.command.ScheduleUpdateCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class LoadXmlCmd implements EssaCmd {

	/**
	 * Test command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.info("load xml execute");
		
		LoadXmlCtx ctx = (LoadXmlCtx) arg;
		
		ConfigurationParser parser = new ConfigurationParser();

		ConfigurationParseTree tree = parser.xmlParser(ctx.getCandidate(), new ConfigurationRuleSet());
		Iterator<TaskTree> ii = tree.getTaskTree().iterator();
		while(ii.hasNext()) {
			processTask(ii.next());
		}

		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * 
	 * @param arg
	 * @return
	 */
	private boolean processTask(TaskTree arg) {
		TaskDTO task = (TaskDTO) _bd.saveOrUpdate(arg.getTaskDto());
		if (task == null) {
			_log.error("task insert failure");
			return(false);
		}
		
		_log.info("fresh task:" + task.getTaskId());
		
		VpoDTO default_vpo = arg.getVpoDto();
		default_vpo.setTaskId(task.getTaskId());
		default_vpo.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		default_vpo = (VpoDTO) _bd.saveOrUpdate(default_vpo);	
		
		List<CannedActionDTO> canned = arg.getDefaultVpo().getCannedActionDto();
		Iterator<CannedActionDTO> ii = canned.iterator();
		while (ii.hasNext()) {
			CannedActionDTO cad = ii.next();
			
			cad.setTaskId(task.getTaskId());
			cad.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
			cad.setActionId(null); //DAO will generate
			
			_bd.saveOrUpdate(cad);
		}
		
		List<RawAlarmInhibit> inhibitz = arg.getAlarmInhibit();
		Iterator<RawAlarmInhibit> jj = inhibitz.iterator();
		while (jj.hasNext()) {
			AlarmInhibitDTO aid = jj.next().getDto();
			aid.setTaskId(task.getTaskId());
			aid.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
			
			_bd.saveOrUpdate(aid);
		}
		
		List<RawCma> cmaz = arg.getCma();
		Iterator<RawCma> mm = cmaz.iterator();
		while (mm.hasNext()) {
			CustomMessageAttributeDTO cmad = mm.next().getDto();
			cmad.setTaskId(task.getTaskId());
			cmad.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		
			_bd.saveOrUpdate(cmad);
		}
		
		List<AbstractRule> rulez = arg.getRule();
		Iterator<AbstractRule> nn = rulez.iterator();
		while (nn.hasNext()) {	
			AbstractRule ar = nn.next();
			AbstractVersioned rule = ar.getDto();
			rule.setTaskId(task.getTaskId());
			rule = (AbstractVersioned) _bd.saveOrUpdate(rule);
			
			VpoDTO vpo = ar.getVpoDto();
			if (vpo != null) {
				vpo.setTaskId(task.getTaskId());
				vpo.setRuleId(rule.getRuleId());
			
				_bd.saveOrUpdate(vpo);
			}
			
			List<CannedActionDTO> canz = ar.getCannedAction();
			if (canz != null) {
				Iterator<CannedActionDTO> oo = canz.iterator();
				while(oo.hasNext()) {
					CannedActionDTO cad = oo.next();
					cad.setTaskId(task.getTaskId());
					cad.setRuleId(rule.getRuleId());
			
					_bd.saveOrUpdate(cad);
				}
			}
		}
		
		//add to scheduler
		ParentTaskCtx ptx = new ParentTaskCtx();
		ptx.setCandidate(task);
			
		ScheduleUpdateCtx ctx = new ScheduleUpdateCtx();
		ctx.setInterval(task.getFrequency());
		ctx.setJob(ptx);
		ctx.setName(task.getTaskId());
			
		try {
			ctx = (ScheduleUpdateCtx) _bd.serviceCommand(ctx);
		} catch(Exception exception) {
			_log.error("choke", exception);
			return(false);
		}

		return(true);
	}
	
	/**
	 * Handle to back end services
	 */
	private final BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(LoadXmlCmd.class);
}
