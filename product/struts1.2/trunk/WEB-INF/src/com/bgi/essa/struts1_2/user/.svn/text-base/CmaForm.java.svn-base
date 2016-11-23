package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * Custom Message Attribute (CMA) Form.
 * 
 * @struts.form 
 *   name="cmaForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class CmaForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public CmaForm() {
		super();
	}
	
	/**
	 * Task id
	 */
	private String _task_id;

	public String getTaskId() {
		return(_task_id);
	}

	public void setTaskId(String arg) {
		if (arg == null) {
			_task_id = null;
		} else {
			_task_id = arg.trim();
		}
	}
	
	/**
	 * Rule id
	 */
	private String _rule_id;

	public String getRuleId() {
		return(_rule_id);
	}

	public void setRuleId(String arg) {
		if (arg == null) {
			_rule_id = null;
		} else {
			_rule_id = arg.trim();
		}
	}
		
	/**
	 * key
	 */
	private String _key;

	public String getKey2() {
		return(_key);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setKey2(String arg) {
		if (arg == null) {
			_key = null;
		} else {
			_key = arg.trim();
		}
	}

	/**
	 * value
	 */
	private String _value;

	public String getValue2() {
		return(_value);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setValue2(String arg) {
		if (arg == null) {
			_value = null;
		} else {
			_value = arg.trim();
		}
	}

	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public CustomMessageAttributeDTO getValue() {
		CustomMessageAttributeDTO result = new CustomMessageAttributeDTO();

		if (row_id != null) {
			result.setRowId(row_id);
		}
		
		if (_task_id != null) {
			result.setTaskId(new TrimString(_task_id));
		}
		
		if (_rule_id != null) {
			result.setRuleId(new TrimString(_rule_id));
		}
		
		result.setActive(active_flag);	
		result.setNote(stringTweaker1(note, null));
		
		result.setKey(stringTweaker1(_key, null));
		result.setValue(stringTweaker1(_value, null));
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(CustomMessageAttributeDTO arg) {
		row_id = arg.getRowId();
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getTaskId() != null) {
			_task_id = arg.getTaskId().getValue();
		}
		
		if (arg.getRuleId() != null) {
			_rule_id = arg.getRuleId().getValue();
		}
		
		_key = stringTweaker2(arg.getKey());
		_value = stringTweaker2(arg.getValue());
	}

	/**
	 * Reset all fields
	 */
	@Override
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		row_id = null;
		active_flag = false;
		note = "No Note";
	}

	/**
	 * Form validator
	 */
	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errorz = new ActionErrors();
	
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = 5692266597038676065L;
}