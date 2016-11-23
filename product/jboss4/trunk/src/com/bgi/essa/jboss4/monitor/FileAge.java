package com.bgi.essa.jboss4.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.FileWrapper;
import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileAgeSampleDTO;

/**
 * Collect a file age sample
 * 
 * @author coleguy
 */
public class FileAge implements MonitorIf {

	/**
	 * Prepare to service a file age rule
	 * 
	 * @param arg populated rule
	 */
	public FileAge(FileAgeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new FileAgeSampleDTO();
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
		_log.debug("collect file age sample");
		
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
			
		FileWrapper fw = facade.getFileWrapper();
		if (fw.exists(_rule.getFileName())) {
			_sample.setExists(true);
			_sample.setFileName(_rule.getFileName());
			_sample.setModificationTime(new ZuluTime(fw.lastModified(_rule.getFileName())));
			return(true);
		} else {
			_sample.setExists(false);
			_log.error("missing file:" + _rule.getFileName());
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
	private FileAgeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private FileAgeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
