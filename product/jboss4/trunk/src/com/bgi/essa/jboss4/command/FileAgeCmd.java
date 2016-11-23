package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.FileAgeCtx;

import com.bgi.essa.jboss4.monitor.FileAge;

import com.bgi.essa.shared.transfer.FileAgeDTO;

/**
 * Return a file age sample
 * 
 * @author coleguy
 */
public class FileAgeCmd implements EssaCmd {
	
	/**
	 * Return file age sample
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("file age execute");
		
		FileAgeCtx ctx = (FileAgeCtx) arg;
		
		FileAge monitor = new FileAge((FileAgeDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(FileAgeCmd.class);
}
