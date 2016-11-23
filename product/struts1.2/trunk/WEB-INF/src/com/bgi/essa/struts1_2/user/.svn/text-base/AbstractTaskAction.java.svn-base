package com.bgi.essa.struts1_2.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.ParentTaskCtx;
import com.bgi.essa.shared.command.ScheduleDeleteCtx;
import com.bgi.essa.shared.command.ScheduleUpdateCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

import com.bgi.essa.struts1_2.EssaAction;

/**
 * Abstract parent for Task actions
 * 
 * @author coleguy
 */
public abstract class AbstractTaskAction extends EssaAction {

	/**
	 * Discover default VPO parameters
	 * 
	 * @param dto
	 * @return
	 */
	VpoDTO discoverDefaultVpo(TaskDTO dto) {
		return(null);
	}
	
	/**
	 * Discover the rest of this task
	 * 
	 * @param dto current task
	 */
	void discoverTaskComponents(TaskDTO dto) {
		setCurrentTask(dto);		
	}
	
	/**
	 * Save the task, create the task id
	 * 
	 * @param arg fresh task
	 * @return true if success else failure
	 */
	boolean performTaskInsert(TaskDTO arg) {
		arg.setActive(true);
		
		arg = (TaskDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
			return(false);
		}
		
		VpoDTO temp = new VpoDTO();
		temp.setTaskId(arg.getTaskId());
		temp.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		setDefaultVpo((VpoDTO) bd.saveOrUpdate(temp));		
		
		//add to scheduler
		ParentTaskCtx ptx = new ParentTaskCtx();
		ptx.setCandidate(arg);
			
		ScheduleUpdateCtx ctx = new ScheduleUpdateCtx();
		ctx.setInterval(arg.getFrequency());
		ctx.setJob(ptx);
		ctx.setName(arg.getTaskId());
			
		try {
			ctx = (ScheduleUpdateCtx) bd.serviceCommand(ctx);
		} catch(Exception exception) {
			_log.error("choke", exception);
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Update existing task, create the task id
	 * 
	 * @param arg fresh task
	 * @return true if success else failure
	 */
	boolean performTaskUpdate(TaskDTO arg) {
		arg = (TaskDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
			return(false);
		}
		
		if (arg.isActive()) {
			setCurrentTask(arg);
			
			//update scheduler
			ParentTaskCtx ptx = new ParentTaskCtx();
			ptx.setCandidate(arg);
			
			ScheduleUpdateCtx ctx = new ScheduleUpdateCtx();
			ctx.setInterval(arg.getFrequency());
			ctx.setJob(ptx);
			ctx.setName(arg.getTaskId());
				
			try {
				ctx = (ScheduleUpdateCtx) bd.serviceCommand(ctx);
			} catch(Exception exception) {
				_log.error("choke", exception);
				return(false);
			}
			
		} else {
			//remove from scheduler
			ScheduleDeleteCtx ctx = new ScheduleDeleteCtx();
			ctx.setName(arg.getTaskId());
			
			try {
				bd.serviceCommand(ctx);
			} catch(Exception exception) {
				_log.error("choke", exception);
				return(false);
			}
		}
			
		return(true);
	}

	/**
	 * Select a list of all active tasks.
	 * 
	 * @return list of all active tasks, might be empty but never null.
	 */
	List<DtoIf> selectActiveTask() {
		List<DtoIf> result = bd.selectAll(new TaskDTO(), SelectOption.SELECT_ACTIVE);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}
	
	/**
	 * Define the current task and components
	 * 
	 * @param key task id
	 * @return true if success
	 */
	boolean selectCurrentTask(Long key) {
		// ensure valid task
		TaskDTO dto = new TaskDTO();
		dto.setRowId(key);
		dto = (TaskDTO) bd.selectByRowId(dto);
		if (dto == null) {
			_log.error("null task row returned:" + key);
			return(false);
		}	
		
		// retrieve all task components
		ParentTaskCtx ctx = new ParentTaskCtx();
		ctx.setCandidate(dto);
		
		try {
			ctx = (ParentTaskCtx) bd.serviceCommand(ctx);
		} catch(Exception exception) {
			_log.error("choke", exception);
			return(false);
		}
		
		// place task components in session
		setCurrentTask(dto);
	
		setAlarmInhibitList(ctx.getAlarmInhibitList());
		
		setBootTimeList(ctx.getBootTimeList());
        setDirectoryAgeList ( ctx.getDirectoryAgeList() );
		setDirectorySizeList(ctx.getDirectorySizeList());
		setFileAgeList(ctx.getFileAgeList());
		setFileSizeList(ctx.getFileSizeList());
		setFileSystemSizeList(ctx.getFileSystemSizeList());
		setProcessList(ctx.getProcessList());
		
		setDefaultVpo(ctx.getDefaultVpo());
		setDefaultCmaList(ctx.getCmaList());
		setDefaultCannedActionList(ctx.getDefaultCannedActionList());
		
		return(true);
	}
	
	/**
	 * Select a task from database and load the form (for editing)
	 * 
	 * @param key database row id
	 * @param form supporting task form
	 * @return true if success
	 */
	boolean selectTaskForEdit(Long key, TaskForm form) {
		if (selectCurrentTask(key)) {
			form.setValue(current_task);
			return(true);
		}
		
		return(false);
	}

	/**
	 * Handle to back end services
	 */
	protected final BusinessDelegate bd = new BusinessDelegate();

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
