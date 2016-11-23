package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.VpoDTO;

import com.bgi.essa.struts1_2.EssaForm;

import com.bgi.essa.struts1_2.utility.ApplicationNameOptionBean;
import com.bgi.essa.struts1_2.utility.OptionStunt;
import com.bgi.essa.struts1_2.utility.SeverityOptionBean;

/**
 * VPO Form.
 * 
 * @struts.form 
 *   name="vpoForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class VpoForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public VpoForm() {
		super();
		
		_app_name_bean = new ApplicationNameOptionBean(OptionStunt.NONE);
		_app_name_array = _app_name_bean.getCandidates();
		
		_severity_bean = new SeverityOptionBean(OptionStunt.NONE);
		_severity_array = _severity_bean.getCandidates();
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
	 * Retry frequency
	 */
	private String _frequency = "60";

	public String getFrequency() {
		return(_frequency);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setFrequency(String arg) {
		if (arg == null) {
			_frequency = null;
		} else {
			_frequency = arg.trim();
		}
	}
	
	/**
	 * Boilerplate message
	 */
	private String _message;

	public String getMessage() {
		return(_message);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setMessage(String arg) {
		if (arg == null) {
			_message = null;
		} else {
			_message = arg.trim();
		}
	}
	
	/**
	 * Source host
	 */
	private String _source_host;

	public String getSource() {
		return(_source_host);
	}
	
	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setSource(String arg) {
		if (arg == null) {
			_source_host = null;
		} else {
			_source_host = arg.trim();
		}
	}

	/**
	 * application name drop down
	 */
	private ApplicationNameOptionBean _app_name_bean;
	
	private ApplicationNameOptionBean.CandidateBean[] _app_name_array;
	
	public ApplicationNameOptionBean.CandidateBean[] getAppNameArray() {
		return(_app_name_array);
	}
	
	/**
	 * application name selection index
	 */
	private int _app_name_ndx;
	
	/**
	 * Return application name index selection
	 * 
	 * @return application name index selection
	 */
	public int getAppNameNdx() {
		return(_app_name_ndx);
	}
	
	/**
	 * Define application name index selection
	 * 
	 * @param arg application name index selection
	 */
	public void setAppNameNdx(int arg) {
		_app_name_ndx = arg;
	}
	
	/**
	 * severity drop down
	 */
	private SeverityOptionBean _severity_bean;
	
	private SeverityOptionBean.CandidateBean[] _severity_array;
	
	public SeverityOptionBean.CandidateBean[] getSeverityArray() {
		return(_severity_array);
	}
	
	/**
	 * severity bean selection index
	 */
	private int _severity_ndx;
	
	/**
	 * Return severity bean index selection
	 * 
	 * @return severity bean index selection
	 */
	public int getSeverityNdx() {
		return(_severity_ndx);
	}
	
	/**
	 * Define severity bean index selection
	 * 
	 * @param arg severity bean index selection
	 */
	public void setSeverityNdx(int arg) {
		_severity_ndx = arg;
	}

	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public VpoDTO getValue() {
		VpoDTO result = new VpoDTO();

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
		
		ApplicationNameOptionBean.CandidateBean temp1 = _app_name_bean.getCandidate(_app_name_ndx);
		result.setAppName((ApplicationName) temp1.getPayload());
		
		SeverityOptionBean.CandidateBean temp2 = _severity_bean.getCandidate(_severity_ndx);
		result.setSeverity((Severity) temp2.getPayload());
	
		result.setFrequency(Integer.parseInt(_frequency));
		result.setMessage(stringTweaker1(_message, null));
		result.setSourceHost(stringTweaker1(_source_host, null));
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(VpoDTO arg) {
		row_id = arg.getRowId();
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getTaskId() != null) {
			_task_id = arg.getTaskId().getValue();
		}
		
		if (arg.getRuleId() != null) {
			_rule_id = arg.getRuleId().getValue();
		}
		
		ApplicationNameOptionBean.CandidateBean temp1 = _app_name_bean.getCandidate(arg.getAppName());
		_app_name_ndx = temp1.getNdx();
		
		SeverityOptionBean.CandidateBean temp2 = _severity_bean.getCandidate(arg.getSeverity());
		_severity_ndx = temp2.getNdx();
		
		_frequency = Integer.toString(arg.getFrequency());
		_message = stringTweaker2(arg.getMessage());
		_source_host = stringTweaker2(arg.getSourceHost());
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
		
		int temp1 = 0;
		
		try {
			temp1 = Integer.parseInt(_frequency);
		} catch(Exception exception) {
			//exception.printStackTrace();
			temp1 = -1;
		}
		
		if (temp1 < 10) {
			errorz.add("vpo.column.retry", new ActionMessage("vpo.form.error.bad_retry"));
		}
		
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -4478924902371012023L;
}