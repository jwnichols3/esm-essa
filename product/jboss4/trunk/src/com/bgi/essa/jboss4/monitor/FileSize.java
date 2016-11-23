package com.bgi.essa.jboss4.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.FileWrapper;
import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSizeSampleDTO;

/**
 * Determine if the specified file exists and collect a size.
 * 
 * @author coleguy
 */
public class FileSize implements MonitorIf {
	
	/**
	 * Prepare to service a FileSize rule
	 * 
	 * @param arg populated rule
	 */
	public FileSize(FileSizeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new FileSizeSampleDTO();
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
		_log.debug("collect file size sample");
		
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
		FileWrapper fw = facade.getFileWrapper();
		
		//
		// ensure target exists and is a file
		//
		if (fw.exists(_rule.getTarget())) {
			if (fw.isFile(_rule.getTarget())) {
				_sample.setExists(true);
			} else {
				_log.error("target not file:" + _rule.getTarget());
				_sample.setExists(false);
				return(false);
			}
		} else {
			_sample.setExists(false);
			_log.error("target not found:" + _rule.getTarget());
			return(false);
		}

		//
		// falling through implies reasonable target
		//
		_sample.setBytePopulation(fw.length(_rule.getTarget()));
		
		return(true);
	}

	/**
	 * Handle to DB
	 */
	private OrmFacade _orm = new OrmFacade();

	/**
	 * Original rule as supplied to ctor
	 */
	private FileSizeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private FileSizeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
