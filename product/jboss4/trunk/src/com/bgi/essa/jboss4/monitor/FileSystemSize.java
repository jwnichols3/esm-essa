package com.bgi.essa.jboss4.monitor;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.primitive.FileSystem;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.FileSystemSampleDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeSampleDTO;
import com.bgi.essa.shared.transfer.StatVfsDTO;

/**
 * @author coleguy
 */
public class FileSystemSize implements MonitorIf {

	/**
	 * Prepare to service a FileSystemSize rule
	 * 
	 * @param arg populated rule
	 */
	public FileSystemSize(FileSystemSizeDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_rule = arg;
		
		_sample = new FileSystemSizeSampleDTO();
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
		_log.debug("collect file system size sample");
		
		boolean result = sampleDriver();
		
		_orm.insertOrUpdate(_sample);
		
		return(result);
	}
	
	/**
	 * Actual sampling logic.
	 * 
	 * @return true if success
	 */
	private boolean sampleDriver() {
		JmxFacade facade = new JmxFacade();
	
		if (testLegalFileSystem(facade) == false) {
			_log.error("unknown file system:" + _rule.getTarget());
			return(false);
		}
		
		_sample.setExists(true);
		
		StatVfsDTO vfs = facade.getFileSystem(_rule.getTarget());
		
		double total_blocks = 1.0 * vfs.getFileSystemBlocks();
		double available_blocks = 1.0 * vfs.getFreeBlocks();
		double value = 100.0 - available_blocks/total_blocks * 100.0;
		
		_sample.setBlockPercentage((int) value); 

		double total_inodes = 1.0 * vfs.getInodes();
		double available_inodes = 1.0 * vfs.getFreeInodes();
		value = 100.0 - available_inodes/total_inodes * 100.0; 
		
		_sample.setInodePercentage((int) value);
	
		return(true);
	}
	
	/**
	 * Determine if target is really a file system or just a directory
	 * 
	 * @param arg
	 * @return
	 */
	public boolean testLegalFileSystem(JmxFacade arg) {
		FileSystemSampleDTO dto = arg.getFileSystems();
		
		Iterator<FileSystem> ii = dto.getCandidates().iterator();
		while(ii.hasNext()) {
			FileSystem temp = (FileSystem) ii.next();
			
			if (temp.getMountPoint().equals(_rule.getTarget())) {
				return(true);
			}
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
	private FileSystemSizeDTO _rule;
	
	/**
	 * Collected sample datum
	 */
	private FileSystemSizeSampleDTO _sample;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
