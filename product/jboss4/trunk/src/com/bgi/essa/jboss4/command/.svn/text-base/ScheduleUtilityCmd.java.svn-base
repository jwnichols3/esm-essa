package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.scheduler.ScheduleFacade;

import com.bgi.essa.shared.command.ScheduleUtilityCtx;

/**
 * @author coleguy
 */
public class ScheduleUtilityCmd implements EssaCmd {
	
	/**
	 * Return utility information for Quartz
	 * 
	 * @param arg context
	 * @return true, continue processing
	 * @throws Exception if any problem
	 */
	@SuppressWarnings("unchecked")
	public boolean execute(final Context arg) throws Exception {
		_log.debug("schedule utility execute");
		
		final ScheduleUtilityCtx ctx = (ScheduleUtilityCtx) arg;
	
		ctx.setSchedulerName(_facade.getSchedulerName());
		ctx.setJobNames(_facade.getJobNames());	
		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to schedule facade
	 */
	private final ScheduleFacade _facade = new ScheduleFacade();

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ScheduleUtilityCmd.class);
}
