package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.PingCtx;

/**
 * Test command
 *
 * @author gsc
 */
public class PingCmd implements EssaCmd {

	/**
	 * Test command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.info("ping execute");
		
		final PingCtx ctx = (PingCtx) arg;

		boolean flag = ctx.isFlag();
		flag = !flag;
		ctx.setFlag(flag);
		
		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(PingCmd.class);
}