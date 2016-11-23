package com.bgi.essa.jboss4.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.ParentTaskCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.transfer.TaskDTO;

import com.bgi.essa.jboss4.scheduler.quartz.ParentTaskJob;

/**
 * Public face of Quartz operations.
 * 
 * @author coleguy
 */
public final class ScheduleFacade {
	
	/**
	 * Return scheduler name
	 * 
	 * @return scheduler name or null if problem.
	 */
	public TrimString getSchedulerName() {
		_log.debug("getSchedulerName");
		
		try {
			Scheduler scheduler = getScheduler();
			if (scheduler == null) {
				_log.error("unable to obtain scheduler");
				return(null);
			} 
			
			return(new TrimString(scheduler.getSchedulerName()));
		} catch(Exception exception) {
			_log.error(exception);
		}
		
		return(null);
	}
	
	/**
	 * Return a list of job names known to the scheduler
	 * 
	 * @return list of job names or null if problem
	 */
	public List<TrimString> getJobNames() {
		_log.debug("getJobNames");
		
		try {
			Scheduler scheduler = getScheduler();
			if (scheduler == null) {
				_log.error("unable to obtain scheduler");
				return(null);
			} 
			
			ArrayList<TrimString> list = new ArrayList<TrimString>();
			
			String[] stringz = scheduler.getJobNames(Scheduler.DEFAULT_GROUP);
			for (int ii = 0; ii < stringz.length; ii++) {
				list.add(new TrimString(stringz[ii]));
			}
			
			return(list);
		} catch(Exception exception) {
			_log.error(exception);
		}
		
		return(null);
	}

	/**
	 * Delete the specified job/trigger from Quartz
	 * 
	 * @param arg job to delete
	 * @return true if successful
	 */
	public boolean delete(TrimString arg) {
		_log.debug("delete job:" + arg.toString());
		
		Scheduler scheduler = getScheduler();
		if (scheduler == null) {
			_log.error("null scheduler");
			return(false);
		}
		
		try {
			return(scheduler.deleteJob(arg.getValue(), Scheduler.DEFAULT_GROUP));
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return(false);
	}
	
	/**
	 * Update or create a quartz job w/a repeat interval in minutes
	 * 
	 * @param job_name job name, must be unique
	 * @param interval interval in minutes
	 * @param ctx job type
	 * @return true if success
	 */
	public boolean updateOrCreate(TrimString job_name, int interval, AbstractEssaCtx ctx) {
		_log.debug("update job:" + job_name.toString());
		
		if (interval < 1) {
			throw new IllegalArgumentException("bad interval:" + interval);
		}
		
		Trigger trigger = TriggerUtils.makeMinutelyTrigger(interval);
		trigger.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT);

		return(updateOrCreate(job_name, trigger, ctx));
	}
	
	/**
	 * Update or create a quartz job w/the specified trigger
	 * 
	 * @param job_name job name, must be unique
	 * @param trigger quartz trigger
	 * @param ctx job type
	 * @return true if success
	 */
	public boolean updateOrCreate(TrimString job_name, Trigger trigger, AbstractEssaCtx ctx) {
		_log.debug("update job:" + job_name.toString());
		
		trigger.setName(job_name.getValue() + "_t");
		
		Scheduler scheduler = getScheduler();
		if (scheduler == null) {
			_log.error("null scheduler");
			return(false);
		}
		
		JobDetail job_detail = null;
		
		try {
			job_detail = scheduler.getJobDetail(job_name.getValue(), Scheduler.DEFAULT_GROUP);
			scheduler.deleteJob(job_name.getValue(), Scheduler.DEFAULT_GROUP);
		} catch(Exception exception) {
			//OK to fail
			_log.info("delete failure for:" + job_name.getValue());
		}
		
		if (ctx instanceof ParentTaskCtx) {
			ParentTaskCtx ctx2 = (ParentTaskCtx) ctx;
			TaskDTO dto = (TaskDTO) ctx2.getCandidate();
			
			ParentTaskJob job = new ParentTaskJob();
			job_detail = job.getJobDetail(job_name.getValue(), dto.getTaskId().getValue());
		} else {
			_log.error("unknown job type");
		}

		try {
			scheduler.scheduleJob(job_detail, trigger);
		} catch(Exception exception) {
			_log.error("choked", exception);
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Return scheduler instance
	 * 
	 * @return scheduler instance or null if not found
	 */
	private Scheduler getScheduler() {
		Scheduler scheduler = null;
		
		try {
			InitialContext ctx = new InitialContext();
			scheduler = (Scheduler) ctx.lookup(ConstantsIf.QUARTZ_SCHEDULER);
		} catch(Exception exception) {
			_log.error(exception);
		}
		
		return(scheduler);
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ScheduleFacade.class);
}
