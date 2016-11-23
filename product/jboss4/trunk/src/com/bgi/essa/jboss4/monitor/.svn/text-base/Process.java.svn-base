package com.bgi.essa.jboss4.monitor;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.FileWrapper;
import com.bgi.essa.jboss4.jmx.JmxFacade;
import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.ProcessOption;
import com.bgi.essa.shared.primitive.ProcessSample;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.ProcessSampleDTO;

/**
 * @author coleguy
 */
public class Process implements MonitorIf {
	
	/**
	 * Prepare to service a file age rule
	 * 
	 * @param arg populated rule
	 */
	public Process(ProcessDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new ProcessSampleDTO();
		_sample.setTaskId(_rule.getTaskId());
		_sample.setRuleId(_rule.getRuleId());
		_sample.setRuleRowId(_rule.getRowId());
		_sample.setActive(true);
	}
	
	
	/**
	 * Return the obtained sample
	 * 
	 * @return populated sample
	 */
	public AbstractSample getSample() {
		return(_sample);
	}
	
	/**
	 * Collect sample, persist to DB
	 * 
	 * @return true if success
	 */
	public boolean collectSample() {
		_log.debug("collect process sample");
		
		boolean result = sampleDriver();
		
		_orm.insertOrUpdate(_sample);
		
		return(result);
	}

	/**
	 * Actual sampling logic
	 * 
	 * @return true if successful sample
	 */
	private boolean sampleDriver() {
		JmxFacade facade = new JmxFacade();
		List<ProcessSample> list = facade.getProcesses();
		
		if (_rule.getOptionType().equals(ProcessOption.LOCK_FILE)) {
			_sample.setExists(false);
			
			FileWrapper fw = facade.getFileWrapper();
			if (fw.exists(_rule.getTarget())) {
				String[] temp = facade.getTextFile(_rule.getTarget());
				_log.error("fix me lock file parser:" + temp.length);
			}
		} else if (_rule.getOptionType().equals(ProcessOption.PID)) {
			findByPid(Integer.parseInt(_rule.getTarget().getValue()), list);
		} else if (_rule.getOptionType().equals(ProcessOption.PROCESS_NAME)) {
			findByName(_rule.getTarget(), list);
		} else {
			_log.error("unknown option type:" + _rule.getOptionType());
		}
		
		return(true);
	}

	/**
	 * Return a sample by name
	 * 
	 * @param name
	 * @param list
	 */
	private void findByName(TrimString name, List<ProcessSample> list) {
		_sample.setExists(false);
		_sample.setName(name);
		
		int population = 0;
	
		Iterator<ProcessSample> ii = list.iterator();
		while(ii.hasNext()) {
			ProcessSample temp = ii.next();
			if (temp.getName().equals(name)) {
				++population;
				_sample.setCpuTime(temp.getSeconds());		
				_sample.setPid(temp.getPid());
			}
		}
		
		_sample.setPopulation(population);
	}
	
	/**
	 * Return a sample by PID
	 * 
	 * @param pid
	 * @param list
	 */
	private void findByPid(int pid, List<ProcessSample> list) {
		_sample.setExists(false);
		_sample.setPid(pid);
		
		Iterator<ProcessSample> ii = list.iterator();
		while(ii.hasNext()) {
			ProcessSample temp = ii.next();
			if (temp.getPid() == pid) {
				_sample.setCpuTime(temp.getSeconds());		
				_sample.setName(temp.getName());
				_sample.setPopulation(1);
				return;
			}
		}
	}
	
	/**
	 * Handle to DB
	 */
	private OrmFacade _orm = new OrmFacade();

	/**
	 * Original rule as supplied to ctor
	 */
	private ProcessDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private ProcessSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
