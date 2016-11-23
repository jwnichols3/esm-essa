package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.monitor.BootTime;

import com.bgi.essa.shared.command.BootTimeCtx;

import com.bgi.essa.shared.transfer.BootTimeDTO;

/**
 * Return system boot time.
 *
 * @author gsc
 */
public class BootTimeCmd implements EssaCmd {
	
	/**
	 * Return system boot time.
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("jni boot time execute");
		
		BootTimeCtx ctx = (BootTimeCtx) arg;
		
		BootTime monitor = new BootTime((BootTimeDTO) ctx.getRule());
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
	private final Log _log = LogFactory.getLog(BootTimeCmd.class);
}