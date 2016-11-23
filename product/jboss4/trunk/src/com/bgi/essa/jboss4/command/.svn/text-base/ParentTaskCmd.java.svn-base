package com.bgi.essa.jboss4.command;

import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.ParentTaskCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Task has several components spread across multiple tables.
 * Given a parent task, discover and return all the components.
 * 
 * @author coleguy
 */
public class ParentTaskCmd implements EssaCmd {

	/**
	 * Discover all task components
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("parent task execute");
	
		ParentTaskCtx ctx = (ParentTaskCtx) arg;
		
		TaskDTO parent = (TaskDTO) ctx.getCandidate();
		
		VpoDTO vpo1 = (VpoDTO) _orm.selectByTaskRuleId(new VpoDTO(), parent.getTaskId(), new TrimString(ConstantsIf.DEFAULT_RULE));
		if (vpo1 == null) {
			_log.error("unable to select default VPO");
		} else {
			ctx.setDefaultVpo(vpo1);
		}
		
		/////////////////////////////////////////////////////////
		// task attributes follow
		/////////////////////////////////////////////////////////
		
		AlarmInhibitDTO inhibit = new AlarmInhibitDTO();
		inhibit.setTaskId(parent.getTaskId());
		List<DtoIf> inhibit_list = _orm.selectByKey(inhibit, SelectOption.SELECT_ACTIVE);
		ctx.setAlarmInhibitList(inhibit_list);
		
		CannedActionDTO canned = new CannedActionDTO();
		canned.setTaskId(parent.getTaskId());
		canned.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		List<DtoIf> canned_list = _orm.selectByKey(canned, SelectOption.SELECT_ACTIVE);
		ctx.setDefaultCannedActionList(canned_list);
		
		CustomMessageAttributeDTO cma = new CustomMessageAttributeDTO();
		cma.setTaskId(parent.getTaskId());
		//cma.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		List<DtoIf> cma_list = _orm.selectByKey(cma, SelectOption.SELECT_ACTIVE);
		ctx.setCmaList(cma_list);
		
		/////////////////////////////////////////////////////////
		// rules follow
		/////////////////////////////////////////////////////////
		
		BootTimeDTO reboot = new BootTimeDTO();
		reboot.setTaskId(parent.getTaskId());
		List<DtoIf> reboot_list = _orm.selectByKey(reboot, SelectOption.SELECT_ACTIVE);
		ctx.setBootTimeList(reboot_list);
		
		DirectoryAgeDTO directory_age = new DirectoryAgeDTO();
		directory_age.setTaskId(parent.getTaskId());
		List<DtoIf> directory_age_list = _orm.selectByKey(directory_age, SelectOption.SELECT_ACTIVE);
		ctx.setDirectoryAgeList(directory_age_list);
		
		DirectorySizeDTO dir_size = new DirectorySizeDTO();
		dir_size.setTaskId(parent.getTaskId());
		List<DtoIf> dir_list = _orm.selectByKey(dir_size, SelectOption.SELECT_ACTIVE);
		ctx.setDirectorySizeList(dir_list);
		
		FileAgeDTO file_age = new FileAgeDTO();
		file_age.setTaskId(parent.getTaskId());
		List<DtoIf> file_age_list = _orm.selectByKey(file_age, SelectOption.SELECT_ACTIVE);
		ctx.setFileAgeList(file_age_list);
		
		FileSizeDTO file_size = new FileSizeDTO();
		file_size.setTaskId(parent.getTaskId());
		List<DtoIf> file_size_list = _orm.selectByKey(file_size, SelectOption.SELECT_ACTIVE);
		ctx.setFileSizeList(file_size_list);
		
		FileSystemSizeDTO file_system_size = new FileSystemSizeDTO();
		file_system_size.setTaskId(parent.getTaskId());
		List<DtoIf> file_system_size_list = _orm.selectByKey(file_system_size, SelectOption.SELECT_ACTIVE);
		ctx.setFileSystemSizeList(file_system_size_list);
		
		ProcessDTO process = new ProcessDTO();
		process.setTaskId(parent.getTaskId());
		List<DtoIf> process_list = _orm.selectByKey(process, SelectOption.SELECT_ACTIVE);
		ctx.setProcessList(process_list);
		
		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to database 
	 */
	private final OrmFacade _orm = new OrmFacade();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ParentTaskCmd.class);
}
