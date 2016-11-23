package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Update existing or create new scheduled job
 * 
 * @author coleguy
 */
public class ScheduleUpdateCtx extends AbstractSchedulerCtx {

	/**
	 * Return command definition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.SCHEDULE_UPDATE_CMD);
	}
	
	/**
	 * Job to be scheduled
	 */
	private AbstractEssaCtx _target;
	
	/**
	 * Return job to be scheduled
	 * 
	 * @return job to be scheduled
	 */
	public AbstractEssaCtx getJob() {
		return(_target);
	}
	
	/**
	 * Define job to be scheduled
	 * 
	 * @param arg job to be scheduled
	 * @throws NullPointerException if null arg
	 */
	public void setJob(final AbstractEssaCtx arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_target = arg;
	}
	
	/**
	 * interval in minutes
	 */
	private int _interval = 0;
	
	/**
	 * Retrieve sample interval in minutes
	 * 
	 * @return sample interval in minutes
	 */
	public int getInterval() {
		return(_interval);
	}
	
	/**
	 * Define sample interval in minutes
	 * 
	 * @param arg sample interval in minutes;
	 */
	public void setInterval(final int arg) {
		if (arg < 1) {
			throw new IllegalArgumentException("bad interval");
		}
		
		_interval = arg;
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8035401563820313547L;
}
