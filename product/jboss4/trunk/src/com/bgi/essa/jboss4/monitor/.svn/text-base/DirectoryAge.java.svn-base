package com.bgi.essa.jboss4.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.FileWrapper;
import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.DirectoryAgeSampleDTO;

/**
 * Collect a directory age sample
 * 
 * @author linden 
 */
public class DirectoryAge implements MonitorIf {

	/**
	 * Prepare to service a file age rule
	 * 
	 * @param arg populated rule
	 */
	public DirectoryAge(DirectoryAgeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new DirectoryAgeSampleDTO();
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
		if (fw.exists(_rule.getDirectoryName())) {
			_sample.setExists(true);
			_sample.setDirectoryName(_rule.getDirectoryName());
			_sample.setModificationTime(new ZuluTime(fw.lastModified(_rule.getDirectoryName())));
			return(true);
		} else {
			_sample.setExists(false);
			_log.error("missing file:" + _rule.getDirectoryName());
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
	private DirectoryAgeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private DirectoryAgeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
