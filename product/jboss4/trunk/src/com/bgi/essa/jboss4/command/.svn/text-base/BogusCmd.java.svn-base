package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.AbstractEssaCtx;

/**
 * Stub command, used for test and development only.
 * 
 * @author coleguy
 */
public class BogusCmd implements EssaCmd {
	
	/**
	 * Test command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.info("bogus command execute");
		
		AbstractEssaCtx ctx = (AbstractEssaCtx) arg;
		
		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(BogusCmd.class);
}
