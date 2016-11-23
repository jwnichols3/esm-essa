package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bgi.essa.struts1_2.EssaForm;

/**
 * Disk space size "ad hoc" form.
 * 
 * @struts.form 
 *   name="diskSpaceAdHocForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class DiskSpaceAdHocForm extends EssaForm {

	/**
	 * empty ctor
	 */
	public DiskSpaceAdHocForm() {
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
	 * true, visit all subdirectories
	 */
	private boolean _recursive = false;

	/**
	 * Return true, visit all subdirectories
	 * 
	 * @return true, visit all subdirectories
	 */
	public boolean isRecursive() {
		return(_recursive);
	}

	/**
	 * Define if this sample includes all subdirectories
	 * 
	 * @param arg true, this sample includes all subdirectories
	 */
	public void setRecursive(final boolean arg) {
		_recursive = arg;
	}
	
	/**
	 * target file system
	 */
	private String _name;

	/**
	 * Return target file system name
	 * 
	 * @return target file system name
	 */
	public String getName() {
		return(_name);
	}

	/**
	 * Define target file system name
	 * 
	 * @param arg target file system name
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
		//System.out.println("XXX XXX XXX Form Reset XXX XXX XXX");
		row_id = null;
		active_flag = true;
		note = "No Note";
		
		_persist = false;
		_evaluate = false;
		_recursive = false;
		_name = null;
	}

	/**
	 * Form validator
	 */
	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errorz = new ActionErrors();
		
		if ((_name == null) || (_name.length() < 1)) {
			errorz.add("name", new ActionMessage("disk_space.error.bad_name"));
		}
		
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = -659488417402068570L;
}