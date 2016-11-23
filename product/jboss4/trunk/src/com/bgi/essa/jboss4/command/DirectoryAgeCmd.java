package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.DirectoryAgeCtx;

import com.bgi.essa.jboss4.monitor.DirectoryAge;

import com.bgi.essa.shared.transfer.DirectoryAgeDTO;

/**
 * Return a directory age sample
 * 
 * @author linden
 */
public class DirectoryAgeCmd implements EssaCmd {
	
	/**
	 * Return file age sample
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("file age execute");
		
		DirectoryAgeCtx ctx = (DirectoryAgeCtx) arg;
		
		DirectoryAge monitor = new DirectoryAge((DirectoryAgeDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(DirectoryAgeCmd.class);
}
