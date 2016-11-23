package com.bgi.essa.jboss4.monitor;

import java.io.File;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.FileWrapper;
import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;

/**
 * Perform a "directory size" monitor operation
 * 
 * @author coleguy
 */
public class DirectorySize implements MonitorIf {
	
	/**
	 * Prepare to service a DirectorySize rule
	 * 
	 * @param arg populated rule
	 */
	public DirectorySize(DirectorySizeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new DirectorySizeSampleDTO();
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
		// ensure target exists and is a directory
		//
		if (fw.exists(_rule.getTarget())) {
			if (fw.isDirectory(_rule.getTarget())) {
				_sample.setExists(true);
			} else {
				_log.error("target not directory:" + _rule.getTarget());
				_sample.setExists(false);
				return(false);
			}
		} else {
			_log.error("target not found:" + _rule.getTarget());
			_sample.setExists(false);
			return(false);
		}

		//
		// falling through implies reasonable target
		//
		if (_rule.isRecursive()) {
			long total = performRecursiveCensus(_rule.getTarget(), fw);
			_sample.setBytePopulation(total);
		} else {
			long total = performCensus(_rule.getTarget(), fw);	
			_sample.setBytePopulation(total);
		}
		
		return(true);
	}
	
	/**
	 * Discover statistics are current directory and all children
	 * 
	 * @param target starting directory
	 * @param fw handle to FileWrapper
	 */
	private long performRecursiveCensus(TrimString target, FileWrapper fw) {
		ArrayList<TrimString> list = new ArrayList<TrimString>();

		list.add(_rule.getTarget());
		
		//
		// discover all subdirectories
		//
		for (int ii = 0; ii < list.size(); ii++) {
			TrimString current = list.get(ii);
			String[] filez = fw.list(current);
			if (filez != null) {
				for (int jj = 0; jj < filez.length; jj++) {
					TrimString temp1 = new TrimString(current.getValue() + File.separator + filez[jj]);
					if (fw.isDirectory(temp1)) {
						list.add(temp1);
					}
				}
			}
		}	
		
		//
		// visit each subdirectory and collect statistics
		//
		long total = 0L;
		for (int ii = 0; ii < list.size(); ii++) {
			total += performCensus(list.get(ii), fw);
		}
		
		return(total);
	}
	
	/**
	 * Discover total byte population for a given directory
	 * 
	 * @param target directory
	 * @param fw handle to FileWrapper/JMX
	 * @return total byte population
	 */
	private long performCensus(TrimString target, FileWrapper fw) {
		 String[] filez = fw.list(target);
		 if (filez == null) {
			 _log.error("unable to list:" + target);
			 return(0L);
		 }
		 
		 long total = 0L;
		 for (int ii = 0; ii < filez.length; ii++) {
			 TrimString temp1 = new TrimString(target.getValue() + File.separator + filez[ii]);
			 if (fw.isFile(temp1)) {
				 total += fw.length(temp1);
			 }
		 }
		 
		 return(total);
	}

	/**
	 * Handle to DB
	 */
	private OrmFacade _orm = new OrmFacade();

	/**
	 * Original rule as supplied to ctor
	 */
	private DirectorySizeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private DirectorySizeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
