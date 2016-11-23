package com.bgi.essa.jboss4.scheduler.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.JniStatVfsCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Invoke a StatVfs command as a Quartz scheduled Job
 * 
 * @author coleguy
 */
public class JniStatVfsJob implements EssaJob {

	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 commons chain context
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(TrimString arg0, AbstractEssaCtx arg1) {
		JniStatVfsCtx ctx = (JniStatVfsCtx) arg1;
		
		JobDetail jd = new JobDetail(arg0.getValue(), Scheduler.DEFAULT_GROUP, JniStatVfsJob.class);
		
		JobDataMap jdm = jd.getJobDataMap();
		jdm.put(JniStatVfsCtx.NAME_KEY, ctx.getName().getValue());
		
		return(jd);
	}
	
	/**
	 * Run the job.
	 * 
	 * @param arg0 job datum
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap jdm = arg0.getMergedJobDataMap();
		
		JniStatVfsCtx ctx = new JniStatVfsCtx();
//		ctx.setPersist(true);
		ctx.setName(new TrimString((String) jdm.get(JniStatVfsCtx.NAME_KEY)));
		
		BusinessDelegate bd = new BusinessDelegate();
		
		try {
			bd.serviceCommand(ctx);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
