package com.bgi.essa.jboss4.scheduler.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import com.bgi.essa.jboss4.command.Eclectic;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.PingCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Invoke a ping command as a Quartz scheduled Job.
 * No useful work here, simply a demo command
 * 
 * @author coleguy
 */
public class PingJob implements EssaJob {

	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 commons chain context
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(TrimString arg0, AbstractEssaCtx arg1) {
		PingCtx ctx = (PingCtx) arg1;
		Boolean temp = new Boolean(ctx.isFlag());
		
		JobDetail jd = new JobDetail(arg0.getValue(), Scheduler.DEFAULT_GROUP, PingJob.class);
		
		JobDataMap jdm = jd.getJobDataMap();
		// Derby Quartz delegate only accepts String
		jdm.put(PingCtx.FLAG_KEY, temp.toString()); 
		
		return(jd);
	}
	
	/**
	 * Run the job.
	 * 
	 * @param arg0 job datum
	 */
	public void execute(final JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap jdm = arg0.getMergedJobDataMap();	
		String temp1 = jdm.getString(PingCtx.FLAG_KEY);
		Boolean temp2 = Boolean.valueOf(temp1);
		
		PingCtx ctx = new PingCtx();
		ctx.setFlag(temp2.booleanValue());
		
		try {
			_eclectic.serviceCommand(ctx);
		} catch(final Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Command dispatch
	 */
	private final Eclectic _eclectic = new Eclectic();
}
