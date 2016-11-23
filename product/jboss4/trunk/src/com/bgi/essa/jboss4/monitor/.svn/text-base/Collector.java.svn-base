package com.bgi.essa.jboss4.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.AbstractSamplingCtx;
import com.bgi.essa.shared.command.BootTimeCtx;
import com.bgi.essa.shared.command.DirectoryAgeCtx;
import com.bgi.essa.shared.command.DirectorySizeCtx;
import com.bgi.essa.shared.command.FileAgeCtx;
import com.bgi.essa.shared.command.FileSizeCtx;
import com.bgi.essa.shared.command.FileSystemSizeCtx;
import com.bgi.essa.shared.command.ParentTaskCtx;
import com.bgi.essa.shared.command.ProcessCtx;

import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Collector obtains samples for each active rule associated w/a task.
 * 
 * @author coleguy
 */
public class Collector {
	
	/**
	 * 
	 * @param dto
	 * @param parent_task
	 */
	public Collector(ParentTaskCtx parent_task) {
		_parent_task = parent_task;
	}
	
	/**
	 * Collect samples for all active rules associated w/this task
	 * 
	 * @return collected rules and samples
	 */
	public List<RuleSample> doCollection() {	
		_log.info("directory age:" + _parent_task.getDirectoryAgeList().size());
		processRules(_parent_task.getDirectoryAgeList());

		_log.info("directory size:" + _parent_task.getDirectorySizeList().size());
		processRules(_parent_task.getDirectorySizeList());
		
		_log.info("file age:" + _parent_task.getFileAgeList().size());
		processRules(_parent_task.getFileAgeList());
		
		_log.info("file size:" + _parent_task.getFileSizeList().size());
		processRules(_parent_task.getFileSizeList());
		
		_log.info("file system:" + _parent_task.getFileSystemSizeList().size());
		processRules(_parent_task.getFileSystemSizeList());
		
		_log.info("process:" + _parent_task.getProcessList().size());
		processRules(_parent_task.getProcessList());
		
		_log.info("boot time:" + _parent_task.getBootTimeList().size());
		processRules(_parent_task.getBootTimeList());
		
		return(_samples);
	}
	
	/**
	 * Visit each rule and collect a sample
	 * 
	 * @param arg list of rules
	 */	
	private void processRules(List<DtoIf> arg) {
		if ((arg == null) || arg.isEmpty()) {
			return;
		}
		
		Iterator<DtoIf> ii = arg.iterator();
		while (ii.hasNext()) {
			DtoIf dto = (DtoIf) ii.next();
			
			AbstractSamplingCtx ctx = selectContext(dto);
			
			try {
				ctx = (AbstractSamplingCtx) _bd.serviceCommand(ctx);
				
				RuleSample temp = new RuleSample();
				temp.setRule(dto);
				temp.setSample(ctx.getSample());
	
				_samples.add(temp);
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}
	
	/**
	 * Return rule specific context based upon rule
	 * 
	 * @param arg rule
	 * @return context
	 */
	private AbstractSamplingCtx selectContext(DtoIf arg) {
		AbstractSamplingCtx ctx = null;
		
		if (arg instanceof BootTimeDTO) {
			ctx = new BootTimeCtx();
		} else if (arg instanceof DirectoryAgeDTO) {
			ctx = new DirectoryAgeCtx();
		} else if (arg instanceof DirectorySizeDTO) {
			ctx = new DirectorySizeCtx();
		} else if (arg instanceof FileAgeDTO) {
			ctx = new FileAgeCtx();
		} else if (arg instanceof FileSizeDTO) {
			ctx = new FileSizeCtx();
		} else if (arg instanceof FileSystemSizeDTO) {
			ctx = new FileSystemSizeCtx();
		} else if (arg instanceof ProcessDTO) {
			ctx = new ProcessCtx();	
		} else {
			_log.error("unknown DTO:" + arg);
			return(null);
		}
		
		ctx.setRule(arg);
		return(ctx);
	}
	
	/**
	 * Task, rules, attributes, et al 
	 */
	private ParentTaskCtx _parent_task;
	
	/**
	 * Collected results
	 */
	private ArrayList<RuleSample> _samples = new ArrayList<RuleSample>();
	
	/**
	 * Command dispatch
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(Collector.class);
}
