package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * Data access object for TaskDTO
 * 
 * @author coleguy
 */
public class TaskDAO extends AbstractVersionedDao {
	
	/**
	 * Only the TaskDAO can generate task identifier.
	 */
	@Override
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {
		TaskDTO dto = (TaskDTO) arg;
		
		if (dto.getTaskId() == null) {
			//
			// fresh task, first version
			//
			dto.setTaskId(generateId());
			dto.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		} 
		
		return(insertOrUpdateRow(new TrimString("TaskDTO"), arg, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public TaskDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((TaskDTO) selectByTaskRuleId(new TrimString("TaskDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to Task.id
	 * @return selected item or null if not found
	 */
	@Override
	public TaskDTO selectRowById(final Long arg) {
		_log.debug("select Task by id:" + arg);

		final String query_string = "from TaskDTO dto where dto.id = :arg1";

		return((TaskDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a task by key (task id).  Returns all matching task rows.
	 * 
	 * @param dto selection key, maps to TaskDTO.taskId
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	@Override
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select Task by key:" + dto);
		
		TaskDTO temp = (TaskDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from TaskDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from TaskDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from TaskDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(temp.getTaskId(), query_string));		
	}

	/**
	 * Retrieve all Tasks
	 * 
	 * @param option select all or only active/inactive Tasks.
	 * @return retrieved Tasks.
	 */
	@Override
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from TaskDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from TaskDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from TaskDTO dto where dto.fauxActive = 'F'";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		query_string += " order by dto.name";

		return(getAllRows(query_string));
	}
	
	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
