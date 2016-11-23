package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.monitor.FileSize;

import com.bgi.essa.shared.command.FileSizeCtx;

import com.bgi.essa.shared.transfer.FileSizeDTO;

/**
 * @author coleguy
 */
public class FileSizeCmd implements EssaCmd {
	/**
	 * Return file size sample
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("file size execute");
		
		FileSizeCtx ctx = (FileSizeCtx) arg;
		
		FileSize monitor = new FileSize((FileSizeDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(FileSizeCmd.class);
}
