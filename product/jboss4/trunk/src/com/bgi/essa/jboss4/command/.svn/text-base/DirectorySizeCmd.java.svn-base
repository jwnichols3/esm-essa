package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.DirectorySizeCtx;

import com.bgi.essa.jboss4.monitor.DirectorySize;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;

/**
 * Return a directory size sample
 * 
 * @author coleguy
 */
public class DirectorySizeCmd implements EssaCmd {
	
	/**
	 * Return directory size sample
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("directory size execute");
		
		DirectorySizeCtx ctx = (DirectorySizeCtx) arg;
		
		DirectorySize monitor = new DirectorySize((DirectorySizeDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(DirectorySizeCmd.class);
}
