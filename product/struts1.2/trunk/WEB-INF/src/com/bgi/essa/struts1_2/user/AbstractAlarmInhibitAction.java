package com.bgi.essa.struts1_2.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.DtoIf;

import com.bgi.essa.struts1_2.EssaAction;

/**
 * Abstract parent for "alarm inhibit" actions
 * 
 * @author coleguy
 */
public abstract class AbstractAlarmInhibitAction extends EssaAction {
	
	/**
	 * Save a new rule
	 * 
	 * @param arg fresh rule
	 * @return true if success else failure
	 */
	boolean performRuleInsert(AlarmInhibitDTO arg) {
		arg.setTaskId(current_task.getTaskId());
		arg.setActive(true);
		
		arg = (AlarmInhibitDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
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
	boolean performRuleUpdate(AlarmInhibitDTO arg) {
		arg = (AlarmInhibitDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Return all rules (and versions) for this task
	 * 
	 * @param arg selection option
	 * @return selected candidates
	 */
	List<DtoIf> selectAudit(SelectOption arg) {		
		AlarmInhibitDTO dto = new AlarmInhibitDTO();
		dto.setTaskId(current_task.getTaskId());
		
		List<DtoIf> result = bd.selectByKey(dto, SelectOption.SELECT_ALL);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}

	/**
	 * Select a list of boot time rules (for this task)
	 * 
	 * @param true selection option
	 * @return list of all selected rules
	 */
	List<DtoIf> selectRules(SelectOption arg) {		
		List<DtoIf> result = bd.selectAll(new AlarmInhibitDTO(), arg);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}
	
	/**
	 * Define the current rule
	 * 
	 * @param key task id
	 * @return true if success
	 */
	AlarmInhibitDTO selectCurrentRule(Long key) {
		AlarmInhibitDTO dto = new AlarmInhibitDTO();
		dto.setRowId(key);
		dto = (AlarmInhibitDTO) bd.selectByRowId(dto);
		if (dto == null) {
			_log.error("null rule row returned:" + key);
		}	
		
		return(dto);
	}
	
	/**
	 * Select a rule from database and load the form (for editing)
	 * 
	 * @param key database row id
	 * @param form supporting rule form
	 * @return true if success
	 */
	boolean selectRuleForEdit(Long key, AlarmInhibitForm form) {
		AlarmInhibitDTO dto = selectCurrentRule(key);
		if (dto != null) {
			form.setValue(dto);
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
