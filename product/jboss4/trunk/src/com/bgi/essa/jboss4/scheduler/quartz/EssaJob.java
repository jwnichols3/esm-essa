package com.bgi.essa.jboss4.scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;

import com.bgi.essa.shared.command.AbstractEssaCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Parent for ESSA Quartz jobs
 * 
 * @author coleguy
 */
public interface EssaJob extends Job {

	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 commons chain context
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(TrimString arg0, AbstractEssaCtx arg1);
}