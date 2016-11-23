package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.CannedAction;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CannedActionDTO;

import com.bgi.essa.struts1_2.EssaForm;

import com.bgi.essa.struts1_2.utility.OptionStunt;
import com.bgi.essa.struts1_2.utility.CannedActionOptionBean;

/**
 * Canned Action Form.
 * 
 * @struts.form 
 *   name="cannedForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class CannedForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public CannedForm() {
		super();
		
		_action_bean = new CannedActionOptionBean(OptionStunt.NONE);
		_action_array = _action_bean.getCandidates();
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
	 * Action id
	 */
	private String _action_id;

	public String getActionId() {
		return(_action_id);
	}

	public void setActionId(String arg) {
		if (arg == null) {
			_action_id = null;
		} else {
			_action_id = arg.trim();
		}
	}
	
	/**
	 * email subject
	 */
	private String _subject;

	public String getSubject() {
		return(_subject);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setSubject(String arg) {
		if (arg == null) {
			_subject = null;
		} else {
			_subject = arg.trim();
		}
	}

	/**
	 * email address
	 */
	private String _address;

	public String getAddress() {
		return(_address);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setAddress(String arg) {
		if (arg == null) {
			_address = null;
		} else {
			_address = arg.trim();
		}
	}
	
	/**
	 * action drop down
	 */
	private CannedActionOptionBean _action_bean;
	
	private CannedActionOptionBean.CandidateBean[] _action_array;
	
	public CannedActionOptionBean.CandidateBean[] getActionArray() {
		return(_action_array);
	}
	
	/**
	 * action bean selection index
	 */
	private int _action_ndx;
	
	/**
	 * Return action bean index selection
	 * 
	 * @return action bean index selection
	 */
	public int getActionNdx() {
		return(_action_ndx);
	}
	
	/**
	 * Define action bean index selection
	 * 
	 * @param arg action bean index selection
	 */
	public void setActionNdx(int arg) {
		_action_ndx = arg;
	}

	/**
	 * Return attribute values
	 * 
	 * @return attribute values
	 */
	public CannedActionDTO getValue() {
		CannedActionDTO result = new CannedActionDTO();

		if (row_id != null) {
			result.setRowId(row_id);
		}
		
		if (_task_id != null) {
			result.setTaskId(new TrimString(_task_id));
		}
		
		if (_rule_id != null) {
			result.setRuleId(new TrimString(_rule_id));
		}
		
		if (_action_id != null) {
			result.setActionId(new TrimString(_action_id));
		}
		
		result.setActive(active_flag);	
		result.setNote(stringTweaker1(note, "No Note"));
		
		result.setAddress(stringTweaker1(_address, null));
		result.setSubject(stringTweaker1(_subject, null));
		
		CannedActionOptionBean.CandidateBean temp1 = _action_bean.getCandidate(_action_ndx);
		result.setAction((CannedAction) temp1.getPayload());
		
		return(result);
	}

	/**
	 * Define attribute values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(CannedActionDTO arg) {
		row_id = arg.getRowId();
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getTaskId() != null) {
			_task_id = arg.getTaskId().getValue();
		}
		
		if (arg.getRuleId() != null) {
			_rule_id = arg.getRuleId().getValue();
		}
	
		if (arg.getActionId() != null) {
			_action_id = arg.getActionId().getValue();
		}
		
		_address = stringTweaker2(arg.getAddress());
		_subject = stringTweaker2(arg.getSubject());
		
		CannedActionOptionBean.CandidateBean temp1 = _action_bean.getCandidate(arg.getAction());
		_action_ndx = temp1.getNdx();
	}

	/**
	 * Reset all fields
	 */
	@Override
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		row_id = null;
	//	active_flag = true;
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
	private static final long serialVersionUID = -8286259372284110504L;
}