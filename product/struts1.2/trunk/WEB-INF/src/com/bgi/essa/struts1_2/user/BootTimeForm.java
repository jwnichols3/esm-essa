package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.transfer.BootTimeDTO;

/**
 * Boot Time Form.
 * 
 * @struts.form 
 *   name="bootTimeForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class BootTimeForm extends AbstractVersionForm {

	/**
	 * empty ctor
	 */
	public BootTimeForm() {
		super();
	}

	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public BootTimeDTO getValue() {
		BootTimeDTO result = new BootTimeDTO();
		
		getValue(result);
	
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(BootTimeDTO arg) {
		super.setValue(arg);
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
	private static final long serialVersionUID = 3911556398867170889L;
}