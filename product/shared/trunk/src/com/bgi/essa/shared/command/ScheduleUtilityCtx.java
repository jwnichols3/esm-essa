package com.bgi.essa.shared.command;

import java.util.ArrayList;
import java.util.List;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Utility support for Quartz scheduler
 * 
 * @author coleguy
 */
public class ScheduleUtilityCtx extends AbstractSchedulerCtx {

	/**
	 * Return command definition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.SCHEDULE_UTILITY_CMD);
	}
	
	/**
	 * Scheduler name
	 */
	private TrimString scheduler_name;

	/**
	 * Return scheduler name
	 * 
	 * @return scheduler name
	 */
	public TrimString getSchedulerName() {
		return(scheduler_name);
	}

	/**
	 * Define scheduler name
	 * 
	 * @param arg scheduler name
	 * @throws NullPointerException if null arg
	 */
	public void setSchedulerName(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null scheduler name");
		}
		
		scheduler_name = arg;
	}

	/**
	 * Job names
	 */
	private List<TrimString> job_names = new ArrayList<TrimString>();
	
	/**
	 * Return job names
	 * 
	 * @return job names as a list of TrimString.  Never null (might be empty).
	 */
	public List<TrimString> getJobNames() {
		return(job_names);
	}

	/**
	 * Define job names
	 * 
	 * @param arg job names
	 * @throws NullPointerException if null arg
	 */
	public void setJobNames(List<TrimString> arg) {
		if (arg == null) {
			throw new NullPointerException("null job names");
		}
		
		job_names = arg;
	}
	
	/**
	 * Add a job name to the list.
	 * 
	 * @param arg fresh job name
	 * @throws NullPointerException if null arg
	 */
	public void addJobName(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null job name");
		}
		
		job_names.add(arg);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -7471940953251764964L;
}
