package com.bgi.essa.jboss4.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;

/**
 * Collect a sample of the system boot time.
 * 
 * @author coleguy
 */
public class BootTime implements MonitorIf {

	/**
	 * Prepare to service a BootTime rule
	 * 
	 * @param arg populated rule
	 */
	public BootTime(BootTimeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new BootTimeSampleDTO();
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
		_log.debug("collect boot time sample");
		
		boolean result = sampleDriver();
		
		_orm.insertOrUpdate(_sample);
		
		return(result);
	}
	
	/**
	 * Actual sampling logic
	 * 
	 * @return true if success
	 */
	private boolean sampleDriver() {
		JmxFacade facade = new JmxFacade();
			
		ZuluTime sample = facade.getBootTime();
		if (sample != null) {
			_sample.setBootTime(sample);
			return(true);
		}

		return(false);
	}

	/**
	 * Handle to DB
	 */
	private OrmFacade _orm = new OrmFacade();

	/**
	 * Original rule as supplied to ctor
	 */
	private BootTimeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private BootTimeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
