package com.bgi.essa.jboss4.scheduler.quartz;

//import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.FileSystemCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * @author coleguy
 */
public class FileSystemJob implements EssaJob {
	
	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 commons chain context
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(TrimString arg0, AbstractEssaCtx arg1) {
		//FileSystemCtx ctx = (FileSystemCtx) arg1;

		JobDetail jd = new JobDetail(arg0.getValue(), Scheduler.DEFAULT_GROUP, FileSystemJob.class);
		//JobDataMap jdm = jd.getJobDataMap();
		
		return(jd);
	}
	
	/**
	 * Run the job.  Persist flag always true.
	 * 
	 * @param arg0 job datum
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//JobDataMap jdm = arg0.getMergedJobDataMap();
		
		FileSystemCtx ctx = new FileSystemCtx();
		//ctx.setPersist(true);
		
		BusinessDelegate bd = new BusinessDelegate();
		
		try {
			bd.serviceCommand(ctx);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
