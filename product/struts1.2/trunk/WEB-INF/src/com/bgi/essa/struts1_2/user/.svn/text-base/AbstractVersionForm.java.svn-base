package com.bgi.essa.struts1_2.user;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * Abstract parent form w/version support 
 *
 * @author coleguy
 */
public class AbstractVersionForm extends EssaForm {
	
	/**
	 * Task id
	 */
	String task_id;

	public String getTaskId() {
		return(task_id);
	}

	public void setTaskId(String arg) {
		if (arg == null) {
			task_id = null;
		} else {
			task_id = arg.trim();
		}
	}

	/**
	 * Rule id
	 */
	String rule_id;

	public String getRuleId() {
		return(rule_id);
	}

	public void setRuleId(String arg) {
		if (arg == null) {
			rule_id = null;
		} else {
			rule_id = arg.trim();
		}
	}
	
	/**
	 * Return task values
	 * 
	 * @return task/rule values
	 */
	public AbstractVersioned getValue(AbstractVersioned arg) {
		arg.setActive(active_flag);
		arg.setNote(stringTweaker1(note, "No Note"));
		
		if (row_id != null) {
			arg.setRowId(row_id);
		}
		
		if (task_id != null) {
			arg.setTaskId(new TrimString(task_id));
		}
		
		if (rule_id != null) {
			arg.setRuleId(new TrimString(rule_id));
		}
		
		return(arg);
	}
	
	/**
	 * Values to seed
	 * 
	 * @param arg seed values
	 */
	public void setValue(AbstractVersioned arg) {
		active_flag = arg.isActive();
		note = stringTweaker2(arg.getNote());
		
		if (arg.getRowId() != null) {
			row_id = arg.getRowId();
		}
		
		if (arg.getTaskId() != null) {
			task_id = arg.getTaskId().getValue();
		}
		
		if (arg.getRuleId() != null) {
			rule_id = arg.getRuleId().getValue();
		}
	}
	
	/**
	 * eclipse generated uid
	 */
	private static final long serialVersionUID = 5670324348249708507L;
}
