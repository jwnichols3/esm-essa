package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.TaskDTO;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * Task form.
 * 
 * @struts.form 
 *   name="taskForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class TaskForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public TaskForm() {
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
	 * Task name
	 */
	private String _name;

	public String getName() {
		return(_name);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setName(String arg) {
		if (arg == null) {
			_name = null;
		} else {
			_name = arg.trim();
		}
	}
	
	/**
	 * Sample frequency
	 */
	private String _frequency = "30";

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
	
	private boolean _match_all;
	
	public boolean isMatchAll() {
		return(_match_all);
	}
	
	public void setMatchAll(boolean arg) {
		_match_all = arg;
	}
	
	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public TaskDTO getValue() {
		TaskDTO result = new TaskDTO();

		if (row_id != null) {
			result.setRowId(row_id);
		}

		result.setActive(active_flag);
		result.setNote(stringTweaker1(note, null));
		
		if (_task_id != null) {
			result.setTaskId(new TrimString(_task_id));
		}
		
		result.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		
		result.setName(stringTweaker1(_name, null));
		result.setMatchAll(_match_all);
		
		result.setFrequency(Integer.parseInt(_frequency));
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(TaskDTO arg) {
		row_id = arg.getRowId();
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getTaskId() != null) {
			_task_id = arg.getTaskId().getValue();
		}
		
		_name = stringTweaker2(arg.getName());
		_match_all = arg.getMatchAll();
		
		_frequency = Integer.toString(arg.getFrequency());
	}

	/**
	 * Reset all fields
	 */
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		row_id = null;
		active_flag = false;
		_match_all = false;
		note = "No Note";
	}

	/**
	 * Form validator
	 */
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errorz = new ActionErrors();
		
		if ((_name == null) || (_name.length() < 1)) {
			errorz.add("name", new ActionMessage("task.form.error.bad_name"));
		}
		
		int temp = 1;
		
		try {	
			temp = Integer.parseInt(_frequency);

			if ((temp < ConstantsIf.MIN_SAMPLE_FREQUENCY) || (temp > ConstantsIf.MAX_SAMPLE_FREQUENCY)) {
				errorz.add("frequency", new ActionMessage("task.form.error.bad_frequency"));
			}
		} catch(Exception exception) {
			errorz.add("frequency", new ActionMessage("task.form.error.bad_frequency"));
		}

		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -6573891890980775633L;
}