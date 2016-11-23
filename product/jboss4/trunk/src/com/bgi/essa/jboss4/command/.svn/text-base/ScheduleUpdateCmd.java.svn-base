package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.ScheduleUpdateCtx;

import com.bgi.essa.jboss4.scheduler.ScheduleFacade;

/**
 * Create or update scheduled item
 * 
 * @author coleguy
 */
public class ScheduleUpdateCmd implements EssaCmd {
	
	/**
	 * Create or updated specified schedule item
	 * 
	 * @param arg context w/item to create or update
	 * @return true, continue processing
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("schedule update execute");
		
		final ScheduleUpdateCtx ctx = (ScheduleUpdateCtx) arg;
	
		ctx.setSuccess(_facade.updateOrCreate(ctx.getName(), ctx.getInterval(), ctx.getJob()));
	
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to schedule facade
	 */
	private final ScheduleFacade _facade = new ScheduleFacade();

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ScheduleUpdateCmd.class);
}
