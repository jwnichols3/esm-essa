package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.AlarmInhibitDTO;

/**
 * Data access object for alarm inhibit DTO
 * 
 * @author coleguy
 */
public class AlarmInhibitDAO extends AbstractVersionedDao {

	/**
	 * Insert/update a row.  Create rule id if fresh rule.
	 */
	public boolean insertOrUpdateRow(DtoIf arg, boolean flush_flag) {
		AlarmInhibitDTO dto = (AlarmInhibitDTO) arg;
		
		if (dto.getRuleId() == null) {
			//
			// fresh rule, first version
			//
			dto.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		}
		
		return(insertOrUpdateRow(new TrimString("AlarmInhibitDTO"), arg, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public AlarmInhibitDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((AlarmInhibitDTO) selectByTaskRuleId(new TrimString("AlarmInhibitDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to alarmInhibit.id
	 * @return selected item or null if not found
	 */
	public AlarmInhibitDTO selectRowById(Long arg) {
		_log.debug("select alarm inhibit by id:" + arg);

		String query_string = "from AlarmInhibitDTO dto where dto.id = :arg1";

		return((AlarmInhibitDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a rule by task ID
	 * 
	 * @param dto selection key, maps to task_id
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(DtoIf dto, SelectOption option) {
		_log.debug("select alarm inhibit by key:" + dto);
		
		AlarmInhibitDTO temp = (AlarmInhibitDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from AlarmInhibitDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from AlarmInhibitDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from AlarmInhibitDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
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
			query_string = "from AlarmInhibitDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from AlarmInhibitDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from AlarmInhibitDTO dto where dto.fauxActive = 'F'";
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
