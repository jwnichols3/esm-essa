package com.bgi.essa.struts1_2.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.DirectoryAgeSampleDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

import com.bgi.essa.struts1_2.EssaAction;

/**
 * Abstract parent for "file age" actions
 * 
 * @author linden
 */
public abstract class AbstractDirectoryAgeAction extends EssaAction {
	
	/**
	 * Handle to back end services
	 */
	protected final BusinessDelegate bd = new BusinessDelegate();
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());

	/**
	 * Save a new rule
	 * 
	 * @param arg fresh rule
	 * @return true if success else failure
	 */
	boolean performRuleInsert(DirectoryAgeDTO arg) {
		arg.setTaskId(current_task.getTaskId());
		arg.setActive(true);
		
		arg = (DirectoryAgeDTO) bd.saveOrUpdate(arg);
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
	boolean performRuleUpdate(DirectoryAgeDTO arg) {
		arg = (DirectoryAgeDTO) bd.saveOrUpdate(arg);
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
		DirectoryAgeDTO dto = new DirectoryAgeDTO();
		dto.setTaskId(current_task.getTaskId());
		
		List<DtoIf> result = bd.selectByKey(dto, SelectOption.SELECT_ALL);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}
	
	/**
	 * Return all boot time samples
	 * 
	 * @param arg selection option
	 * @return selected candidates
	 */
	List<DtoIf> selectSamples(Long key, SelectOption arg) {
		DirectoryAgeDTO dto1 = selectCurrentRule(key);
		if (dto1 == null) {
			return(new ArrayList<DtoIf>());
		}

		DirectoryAgeSampleDTO dto2 = new DirectoryAgeSampleDTO();
		dto2.setRuleId(dto1.getRuleId());
		
		List<DtoIf> result = bd.selectByKey(dto2, arg);
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
	DirectoryAgeDTO selectCurrentRule(Long key) {
		DirectoryAgeDTO dto1 = new DirectoryAgeDTO();
		dto1.setRowId(key);
		dto1 = (DirectoryAgeDTO) bd.selectByRowId(dto1);
		if (dto1 == null) {
			_log.error("null rule row returned:" + key);
		} else {
			setCurrentRule(dto1.getRuleId());
			
			CannedActionDTO dto2 = new CannedActionDTO();
			dto2.setTaskId(dto1.getTaskId());
			dto2.setRuleId(dto1.getRuleId());
			
			List<DtoIf> list = bd.selectByKey(dto2, SelectOption.SELECT_ACTIVE);
			if (list == null) {
				setDefaultCannedActionList(new ArrayList<DtoIf>());
			} else {
				setDefaultCannedActionList(list);
			}
			
			VpoDTO dto3 = new VpoDTO();
			dto3.setTaskId(dto1.getTaskId());
			dto3.setRuleId(dto1.getRuleId());
			
			list = bd.selectByKey(dto3, SelectOption.SELECT_ACTIVE);
			if ((list == null) || (list.isEmpty())) {
				setDefaultVpo(null);
			} else {
				setDefaultVpo((VpoDTO) list.get(0));
			}	
		}
		
		return(dto1);
	}

	/**
	 * Select a rule from database and load the form (for editing)
	 * 
	 * @param key database row id
	 * @param form supporting rule form
	 * @return true if success
	 */
	boolean selectRuleForEdit(Long key, DirectoryAgeForm form) {
		DirectoryAgeDTO dto = selectCurrentRule(key);
		if (dto != null) {
			form.setValue(dto);
			return(true);
		}
		
		return(false);
	}

	/**
	 * Select a list of file age rules (for this task)
	 * 
	 * @param true selection option
	 * @return list of all selected rules
	 */
	List<DtoIf> selectRules(SelectOption arg) {		
		List<DtoIf> result = bd.selectAll(new DirectoryAgeDTO(), arg);
		if (result == null) {
			result = new ArrayList<DtoIf>();
		}
		
		return(result);
	}
}
