package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionMessage;

import org.apache.struts.upload.FormFile;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * configuration form.
 * 
 * @struts.form 
 *   name="configurationForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class ConfigurationForm extends EssaForm {
	
	/**
	 * empty ctor
	 */
	public ConfigurationForm() {
		super();
	}
	
	/**
	 * Handle to raw uploaded file
	 */
	private FormFile _raw_item;
	
	/**
	 * Return uploaded file
	 * @return uploaded file
	 */
	public FormFile getRawItem() {
		return(_raw_item);
	}

	/**
	 * Define uploaded file
	 * @param arg uploaded file
	 */
	public void setRawItem(FormFile arg) {
		_raw_item = arg;
	}

	/**
	 * Reset all fields
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		row_id = null;
		active_flag = false;
		note = "No Note";
	}

	/**
	 * Form validator
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errorz = new ActionErrors();
		
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -2158838062996231541L;
}