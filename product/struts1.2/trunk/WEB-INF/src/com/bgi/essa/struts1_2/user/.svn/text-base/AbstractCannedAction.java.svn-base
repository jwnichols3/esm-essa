package com.bgi.essa.struts1_2.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.DtoIf;

import com.bgi.essa.struts1_2.EssaAction;

/**
 * Abstract parent for "canned action" actions
 * 
 * @author coleguy
 */
public abstract class AbstractCannedAction extends EssaAction {
	
	/**
	 * Save a new attribute
	 * 
	 * @param arg fresh attribute
	 * @return true if success else failure
	 */
	boolean performAttributeInsert(CannedActionDTO arg) {
		arg.setTaskId(current_task.getTaskId());
		arg.setRuleId(current_rule);
		arg.setActionId(null); //DAO will generate
		
		arg = (CannedActionDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Update existing attribute
	 * 
	 * @param arg fresh attribute
	 * @return true if success else failure
	 */
	boolean performAttributeUpdate(CannedActionDTO arg) {
		arg = (CannedActionDTO) bd.saveOrUpdate(arg);
		if (arg == null) {
			_log.error("saveOrUpdate returns null");
			return(false);
		}
		
		return(true);
	}
	
	/**
	 * Return all attributes (and versions) for this task
	 * 
	 * @param arg selection option
	 * @return selected candidates
	 */
	List<DtoIf> selectAudit(SelectOption arg) {		
		CannedActionDTO dto = new CannedActionDTO();
		dto.setTaskId(current_task.getTaskId());
		
		List<DtoIf> result = bd.selectByKey(dto, SelectOption.SELECT_ALL);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}

	/**
	 * Select a list of attributes (for this task)
	 * 
	 * @param true selection option
	 * @return list of all selected rules
	 */
	List<DtoIf> selectAttributes(SelectOption arg) {		
		List<DtoIf> result = bd.selectAll(new CannedActionDTO(), arg);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}
	
	/**
	 * Define the current attribute
	 * 
	 * @param key task id
	 * @return true if success
	 */
	CannedActionDTO selectCurrentAttribute(Long key) {
		CannedActionDTO dto = new CannedActionDTO();
		dto.setRowId(key);
		dto = (CannedActionDTO) bd.selectByRowId(dto);
		if (dto == null) {
			_log.error("null attribute row returned:" + key);
		}	
		
		return(dto);
	}
	
	/**
	 * Select a attribute from database and load the form (for editing)
	 * 
	 * @param key database row id
	 * @param form supporting rule form
	 * @return true if success
	 */
	boolean selectAttributeForEdit(Long key, CannedForm form) {
		CannedActionDTO dto = selectCurrentAttribute(key);
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
