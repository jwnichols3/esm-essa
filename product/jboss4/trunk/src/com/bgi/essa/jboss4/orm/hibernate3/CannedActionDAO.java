package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.CannedActionDTO;

/**
 * Data access object for CannedAction.
 * 
 * @author coleguy
 */
public class CannedActionDAO extends AbstractVersionedDao {
		
	/**
	 * CannedAction is associated w/a task or a rule 
	 * (does not generate task or rule id).
	 */
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {		
		CannedActionDTO dto = (CannedActionDTO) arg;
		
		if (dto.getActionId() == null) {
			dto.setActionId(generateId());
		}
				
		CannedActionDTO current = null;
		String query_string = "from CannedActionDTO dto where dto.taskId = :arg1 and dto.ruleId = :arg2 and dto.actionId = :arg3 order by version";
		
		List<DtoIf> list = getAllRows(dto.getTaskId(), dto.getRuleId(), dto.getActionId(), query_string);
		if ((list == null) || (list.isEmpty())) {
			dto.setRowId(new Long(0));
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		}
		
		Iterator<DtoIf> ii = list.iterator();
		while(ii.hasNext()) {
			current = (CannedActionDTO) ii.next();
		}
		
		current.setActive(false);
		super.insertOrUpdateRow(current, flush_flag);
		
		dto.setRowId(new Long(0));
		dto.setVersion(1 + current.getVersion());
		dto.setCreation(current.getCreation());
		
		return(super.insertOrUpdateRow(dto, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public CannedActionDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((CannedActionDTO) selectByTaskRuleId(new TrimString("CannedActionDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to vpo.id
	 * @return selected item or null if not found
	 */
	public CannedActionDTO selectRowById(final Long arg) {
		_log.debug("select CannedAction by id:" + arg);

		final String query_string = "from CannedActionDTO dto where dto.id = :arg1";

		return((CannedActionDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a CannedAction
	 * 
	 * @param dto selection key, maps to taskId
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select CannedAction by key:" + dto);
		
		CannedActionDTO temp = (CannedActionDTO) dto;
		
		String query_string = null;
		
		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from CannedActionDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from CannedActionDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from CannedActionDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}
		
		if (temp.getRuleId() == null) {
			//return all actions for a task
			return(getAllRows(temp.getTaskId(), query_string));
		}
		
		//falling through services all actions for a rule
		query_string += " and dto.ruleId = :arg2";
		return(getAllRows(temp.getTaskId(), temp.getRuleId(), query_string));
	}

	/**
	 * Retrieve all CannedAction
	 * 
	 * @param option select all or only active/inactive CannedAction.
	 * @return retrieved Tasks.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from CannedActionDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from CannedActionDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from CannedActionDTO dto where dto.fauxActive = 'F'";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		//query_string += " order by dto.name";

		return(getAllRows(query_string));
	}
	
	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
