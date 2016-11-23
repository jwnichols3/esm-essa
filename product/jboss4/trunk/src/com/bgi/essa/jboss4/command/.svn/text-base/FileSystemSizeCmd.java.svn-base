package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.monitor.FileSystemSize;

import com.bgi.essa.shared.command.FileSystemSizeCtx;

import com.bgi.essa.shared.transfer.FileSystemSizeDTO;

/**
 * @author coleguy
 */
public class FileSystemSizeCmd implements EssaCmd {

	/**
	 * Service the FileSystemSize command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("file system size execute");
		
		FileSystemSizeCtx ctx = (FileSystemSizeCtx) arg;
		
		FileSystemSize monitor = new FileSystemSize((FileSystemSizeDTO) ctx.getRule());
		if (monitor.collectSample()) {
			ctx.setSample(monitor.getSample());
			ctx.setSuccess(true);
		} else {
			ctx.setSuccess(false);
		}
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSystemSizeCmd.class);
}
