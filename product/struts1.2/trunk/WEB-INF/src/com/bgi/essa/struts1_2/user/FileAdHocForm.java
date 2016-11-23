package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * File test "ad hoc" form.
 * 
 * @struts.form 
 *   name="fileAdHocForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class FileAdHocForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public FileAdHocForm() {
		super();
	}

	/**
	 * true, write sample to database
	 */
	private boolean _persist = false;

	/**
	 * Return true, this sample should be written to hibernate
	 * 
	 * @return true, this sample should be written to hibernate
	 */
	public boolean isPersist() {
		return(_persist);
	}

	/**
	 * Define if this sample should be written to hibernate
	 * 
	 * @param arg true, this sample should be written to hibernate
	 */
	public void setPersist(final boolean arg) {
		_persist = arg;
	}

	/**
	 * true, test sample for potential alert contention
	 */
	private boolean _evaluate = false;

	/**
	 * Return true, this sample should be tested for alerts
	 * 
	 * @return true, this sample should be tested for alerts
	 */
	public boolean isEvaluate() {
		return(_evaluate);
	}

	/**
	 * Define if this sample should be evaluated for alerts
	 * 
	 * @param arg true, this sample should be evalutated for alerts
	 */
	public void setEvaluate(final boolean arg) {
		_evaluate = arg;
	}
	
	/**
	 * target directory name
	 */
	private String _name;

	/**
	 * Return target directory name
	 * 
	 * @return target directory name
	 */
	public String getName() {
		return(_name);
	}

	/**
	 * Define target directory name
	 * 
	 * @param arg target directory name
	 * 
	 * @struts.validator 
	 *   type="required"
	 */
	public void setName(final String arg) {
		_name = arg;
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
		
		if ((_name == null) || (_name.length() < 1)) {
			errorz.add("name", new ActionMessage("file.error.bad_name"));
		}
		
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -176294214884686461L;
}