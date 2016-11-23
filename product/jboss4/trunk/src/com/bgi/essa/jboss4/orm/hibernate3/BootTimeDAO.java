package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.BootTimeDTO;

/**
 * Data access object for boot time DTO
 * 
 * @author coleguy
 */
public class BootTimeDAO extends AbstractVersionedDao {

	/**
	 * Insert/update a row.  Create rule id if fresh rule.
	 */
	@Override
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {
		BootTimeDTO dto = (BootTimeDTO) arg;
		
		if (dto.getRuleId() == null) {
			//
			// fresh rule, first version
			//
			dto.setRuleId(generateId());
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		}
		
		return(insertOrUpdateRow(new TrimString("BootTimeDTO"), arg, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public BootTimeDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((BootTimeDTO) selectByTaskRuleId(new TrimString("BootTimeDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to reboot.id
	 * @return selected item or null if not found
	 */
	@Override
	public BootTimeDTO selectRowById(final Long arg) {
		_log.debug("select boot time by id:" + arg);

		final String query_string = "from BootTimeDTO dto where dto.id = :arg1";

		return((BootTimeDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a rule by task ID
	 * 
	 * @param dto selection key, maps to task_id
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	@Override
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select boot time by key:" + dto);
		
		BootTimeDTO temp = (BootTimeDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from BootTimeDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from BootTimeDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from BootTimeDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(temp.getTaskId(), query_string));
	}

	/**
	 * Retrieve all reboot rules
	 * 
	 * @param option select all or only active/inactive rules.
	 * @return retrieved Tasks.
	 */
	@Override
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from BootTimeDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from BootTimeDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from BootTimeDTO dto where dto.fauxActive = 'F'";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(query_string));
	}
	
	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
