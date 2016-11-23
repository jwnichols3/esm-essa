package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.ScheduleDeleteCtx;

import com.bgi.essa.jboss4.scheduler.ScheduleFacade;

/**
 * Delete specified schedule item
 * 
 * @author coleguy
 */
public class ScheduleDeleteCmd implements EssaCmd {
	
	/**
	 * Delete specified schedule item
	 * 
	 * @param arg context w/item to delete
	 * @return true, continue processing
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("schedule delete execute");
		
		final ScheduleDeleteCtx ctx = (ScheduleDeleteCtx) arg;
	
		ctx.setSuccess(_facade.delete(ctx.getName()));
	
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to schedule facade
	 */
	private final ScheduleFacade _facade = new ScheduleFacade();

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ScheduleDeleteCmd.class);
}
