package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;

/**
 * Data access object for CustomMessageAttribute.
 * 
 * @author coleguy
 */
public class CustomMessageAttributeDAO extends AbstractVersionedDao {
	
	
	/**
	 * CannedAction is associated w/a task or a rule (does not generate task or rule id).
	 */
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {		
		CustomMessageAttributeDTO dto = (CustomMessageAttributeDTO) arg;
		
		if (dto.getRuleId() == null) {
			//
			// fresh rule, first version
			//
			dto.setRuleId(generateId());
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		}
		
		return(insertOrUpdateRow(new TrimString("CustomMessageAttributeDTO"), arg, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public CustomMessageAttributeDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((CustomMessageAttributeDTO) selectByTaskRuleId(new TrimString("CustomMessageAttributeDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to cma.id
	 * @return selected item or null if not found
	 */
	public CustomMessageAttributeDTO selectRowById(final Long arg) {
		_log.debug("select CustomMessageAttribute by id:" + arg);

		final String query_string = "from CustomMessageAttributeDTO dto where dto.id = :arg1";

		return((CustomMessageAttributeDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a CMA
	 * 
	 * @param dto selection key, maps to taskId
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select CustomMessageAttribute by key:" + dto);

		CustomMessageAttributeDTO temp = (CustomMessageAttributeDTO) dto;

		String query_string = null;
		
		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from CustomMessageAttributeDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from CustomMessageAttributeDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from CustomMessageAttributeDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}
		
		return(getAllRows(temp.getTaskId(), query_string));
	}

	/**
	 * Retrieve all CMA
	 * 
	 * @param option select all or only active/inactive CMA.
	 * @return retrieved Tasks.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from CustomMessageAttributeDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from CustomMessageAttributeDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from CustomMessageAttributeDTO dto where dto.fauxActive = 'F'";
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
