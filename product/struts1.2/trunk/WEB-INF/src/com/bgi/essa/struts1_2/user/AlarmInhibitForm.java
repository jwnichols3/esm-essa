package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.Day;
import com.bgi.essa.shared.primitive.Hour;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;

import com.bgi.essa.struts1_2.EssaForm;

import com.bgi.essa.struts1_2.utility.DayOptionBean;
import com.bgi.essa.struts1_2.utility.HourOptionBean;
import com.bgi.essa.struts1_2.utility.OptionStunt;

/**
 * Alarm Inhibit Form.
 * 
 * @struts.form 
 *   name="alarmInhibitForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class AlarmInhibitForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public AlarmInhibitForm() {
		super();
		
		_day_bean = new DayOptionBean(OptionStunt.NONE);
		_day_array = _day_bean.getCandidates();
		
		_start_bean = new HourOptionBean(OptionStunt.NONE);
		_start_array = _start_bean.getCandidates();
		
		_stop_bean = new HourOptionBean(OptionStunt.NONE);
		_stop_array = _stop_bean.getCandidates();
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
	 * day drop down
	 */
	private DayOptionBean _day_bean;
	
	private DayOptionBean.CandidateBean[] _day_array;
	
	public DayOptionBean.CandidateBean[] getDayArray() {
		return(_day_array);
	}
	
	/**
	 * day selection index
	 */
	private int _day_ndx;
	
	/**
	 * Return day index selection
	 * 
	 * @return day index selection
	 */
	public int getDayNdx() {
		return(_day_ndx);
	}
	
	/**
	 * Define day index selection
	 * 
	 * @param arg day index selection
	 */
	public void setDayNdx(int arg) {
		_day_ndx = arg;
	}
	
	/**
	 * start hour drop down
	 */
	private HourOptionBean _start_bean;
	
	private HourOptionBean.CandidateBean[] _start_array;
	
	public HourOptionBean.CandidateBean[] getStartArray() {
		return(_start_array);
	}
	
	/**
	 * start bean selection index
	 */
	private int _start_ndx;
	
	/**
	 * Return start bean index selection
	 * 
	 * @return start bean index selection
	 */
	public int getStartNdx() {
		return(_start_ndx);
	}
	
	/**
	 * Define start bean index selection
	 * 
	 * @param arg start bean index selection
	 */
	public void setStartNdx(int arg) {
		_start_ndx = arg;
	}

	/**
	 * stop hour drop down
	 */
	private HourOptionBean _stop_bean;
	
	private HourOptionBean.CandidateBean[] _stop_array;
	
	public HourOptionBean.CandidateBean[] getStopArray() {
		return(_stop_array);
	}
	
	/**
	 * stop bean selection index
	 */
	private int _stop_ndx;
	
	/**
	 * Return stop bean index selection
	 * 
	 * @return stop bean index selection
	 */
	public int getStopNdx() {
		return(_stop_ndx);
	}
	
	/**
	 * Define stop bean index selection
	 * 
	 * @param arg stop bean index selection
	 */
	public void setStopNdx(int arg) {
		_stop_ndx = arg;
	}
	
	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public AlarmInhibitDTO getValue() {
		AlarmInhibitDTO result = new AlarmInhibitDTO();

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
		
		DayOptionBean.CandidateBean temp1 = _day_bean.getCandidate(_day_ndx);
		result.setDay((Day) temp1.getPayload());
		
		HourOptionBean.CandidateBean temp2 = _start_bean.getCandidate(_start_ndx);
		result.setStart((Hour) temp2.getPayload());
		
		HourOptionBean.CandidateBean temp3 = _stop_bean.getCandidate(_stop_ndx);
		result.setStop((Hour) temp3.getPayload());
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(AlarmInhibitDTO arg) {
		row_id = arg.getRowId();
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getTaskId() != null) {
			_task_id = arg.getTaskId().getValue();
		}
		
		if (arg.getRuleId() != null) {
			_rule_id = arg.getRuleId().getValue();
		}
		
		DayOptionBean.CandidateBean temp1 = _day_bean.getCandidate(arg.getDay());
		_day_ndx = temp1.getNdx();
		
		HourOptionBean.CandidateBean temp2 = _start_bean.getCandidate(arg.getStart());
		_start_ndx = temp2.getNdx();
		
		
		HourOptionBean.CandidateBean temp3 = _stop_bean.getCandidate(arg.getStop());
		_stop_ndx = temp3.getNdx();
	}

	/**
	 * Reset all fields
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		row_id = null;
		active_flag = false;
		note = "No Note";
	}

	/**
	 * Form validator
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		final ActionErrors errorz = new ActionErrors();
	
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -7602487964335030682L;
}