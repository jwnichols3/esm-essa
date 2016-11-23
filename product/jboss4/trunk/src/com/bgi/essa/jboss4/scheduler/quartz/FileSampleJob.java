package com.bgi.essa.jboss4.scheduler.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.FileSampleCtx;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.jboss4.client.BusinessDelegate;

/**
 * Invoke file sample command as a Quartz scheduled Job.
 *  
 * @author coleguy
 */
public class FileSampleJob implements EssaJob {
	
	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 commons chain context
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(TrimString arg0, AbstractEssaCtx arg1) {
		FileSampleCtx ctx = (FileSampleCtx) arg1;

		JobDetail jd = new JobDetail(arg0.getValue(), Scheduler.DEFAULT_GROUP, FileSampleJob.class);
		JobDataMap jdm = jd.getJobDataMap();
		
		jdm.put(FileSampleCtx.NAME_KEY, ctx.getName().getValue());

		return(jd);
	}
	
	/**
	 * Run the job.  Persist flag always true.
	 * 
	 * @param arg0 job datum
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap jdm = arg0.getMergedJobDataMap();
		
		FileSampleCtx ctx = new FileSampleCtx();
	//	ctx.setPersist(true);
		ctx.setName(new TrimString(jdm.getString(FileSampleCtx.NAME_KEY)));
	
		BusinessDelegate bd = new BusinessDelegate();
		
		try {
			bd.serviceCommand(ctx);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
