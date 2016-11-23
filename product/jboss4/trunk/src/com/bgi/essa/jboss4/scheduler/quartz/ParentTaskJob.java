package com.bgi.essa.jboss4.scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import com.bgi.essa.jboss4.evaluator.Evaluator;

/**
 * Invoke a "ParentTask" command as a Quartz scheduled Job.
 * 
 * @author coleguy
 */
public class ParentTaskJob implements Job {

	/**
	 * Create a Quartz job detail from the Commons Chain context
	 * 
	 * @param arg0 job name
	 * @param arg1 task id
	 * @return quartz job detail
	 */
	public JobDetail getJobDetail(String arg0, String arg1) {
		JobDetail jd = new JobDetail(arg0, Scheduler.DEFAULT_GROUP, ParentTaskJob.class);
		JobDataMap jdm = jd.getJobDataMap();
		// Derby Quartz delegate only accepts String
		jdm.put("TASK_KEY", arg1);

		return(jd);
	}
	
	/**
	 * Run a task.  
	 * 
	 * @param arg job datum
	 */
	public void execute(JobExecutionContext arg) throws JobExecutionException {
		JobDataMap jdm = arg.getMergedJobDataMap();	
		String task_id = jdm.getString("TASK_KEY");
		
		Evaluator evaluator = new Evaluator(task_id);
		evaluator.doEvaluation();
	}
}
