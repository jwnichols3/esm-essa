package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.monitor.Process;

import com.bgi.essa.shared.command.ProcessCtx;

import com.bgi.essa.shared.transfer.ProcessDTO;

/**
 * Collect ps(1) datum
 * 
 * @author coleguy
 */
public class ProcessCmd implements EssaCmd {

	/**
	 * Service the Process command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("process execute");
		
		ProcessCtx ctx = (ProcessCtx) arg;
		
		Process monitor = new Process((ProcessDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(ProcessCmd.class);
}
