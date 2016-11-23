package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Data access object for VPO.
 * 
 * @author coleguy
 */
public class VpoDAO extends AbstractVersionedDao {

	/**
	 * VPO is associated w/a task or a rule (does not generate task or rule id).
	 */
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {		
		VpoDTO dto = (VpoDTO) arg;
		
		if (dto.getRowId().longValue() < 1L) {
			dto.setRuleId(dto.getRuleId());
			dto.setVersion(1L);
			dto.setActive(true);
			return(super.insertOrUpdateRow(dto, flush_flag));
		}
		
		return(insertOrUpdateRow(new TrimString("VpoDTO"), arg, flush_flag));
	}
	
	/**
	 * Select the most current version by task id/rule id
	 * 
	 * @param task id
	 * @param rule id
	 * @return
	 */
	public VpoDTO selectByTaskRuleId(TrimString task, TrimString rule) {
		return((VpoDTO) selectByTaskRuleId(new TrimString("VpoDTO"), task, rule));
	}
	
	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to vpo.id
	 * @return selected item or null if not found
	 */
	public VpoDTO selectRowById(final Long arg) {
		_log.debug("select VPO by id:" + arg);

		final String query_string = "from VpoDTO dto where dto.id = :arg1";

		return((VpoDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a VPO 
	 * 
	 * @param dto selection key, maps to taskId
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select VPO by key:" + dto);
		
		VpoDTO temp = (VpoDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from VpoDTO dto where dto.fauxActive = 'T' and dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from VpoDTO dto where dto.taskId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from VpoDTO dto where dto.fauxActive = 'F' and dto.taskId = :arg1";
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
	 * Retrieve all VPO
	 * 
	 * @param option select all or only active/inactive VPO.
	 * @return retrieved Tasks.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from VpoDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from VpoDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from VpoDTO dto where dto.fauxActive = 'F'";
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
