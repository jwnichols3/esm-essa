package com.bgi.essa.struts1_2;

import java.io.Serializable;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractDto;

import org.apache.struts.action.ActionForm;

/**
 * Parent for all ESSA struts forms
 */
public class EssaForm extends ActionForm implements Serializable {

	/**
	 * empty ctor
	 */
	public EssaForm() {
		// empty
	}

	/**
	 * ctor
	 * 
	 * @param arg0 row id
	 * @param arg1 transfer object
	 */
	public EssaForm(Long arg0, AbstractDto arg1) {
		row_id = arg0;
		active_flag = arg1.isActive();
		note = arg1.getNote().getValue();
	}

	/**
	 * Database row ID
	 */
	protected Long row_id;

	/**
	 * Define database row id.
	 * 
	 * @param arg database row id
	 */
	public void setRowId(Long arg) {
		row_id = arg;
	}

	/**
	 * Return database row id.
	 * 
	 * @return database row id
	 */
	public Long getRowId() {
		return(row_id);
	}

	/**
	 * Return true, row is "active"
	 */
	protected boolean active_flag;

	/**
	 * Return true, row is "active"
	 * 
	 * @return true, row is "active"
	 */
	public boolean getActive() {
		return(active_flag);
	}

	/**
	 * Return true, row is "active"
	 * 
	 * @return true, row is "active"
	 */
	public boolean isActive() {
		return(active_flag);
	}

	/**
	 * Define if a row is "active"
	 * 
	 * @param arg true, row is "active"
	 * 
	 * @struts.validator 
	 *   type="required"
	 */
	public void setActive(boolean arg) {
		active_flag = arg;
	}

	/**
	 * Free form note
	 */
	protected String note = "No Note";

	/**
	 * Return free form note
	 * 
	 * @return free form note
	 */
	public String getNote() {
		return(note);
	}

	/**
	 * Define free form note
	 * 
	 * @param arg free form note
	 * 
	 * @struts.validator 
	 *   type="required"
	 */
	public void setNote(String arg) {
		note = arg;
	}
	
	/**
	 * Test (and tweak) form strings.  
	 * Null values are not permitted in the database.
	 * Instead, null values are replaced w/a manifest constant.  
	 * The null surrogate is not displayed to the operator.
	 * 
	 * @param arg1 raw form string to test
	 * @param arg2 default value of form string, can be null
	 * @return value ready for back end processing.
	 */
	protected TrimString stringTweaker1(String arg1, String arg2) {
		String defaultz = ConstantsIf.EMPTY_STRING;
		if (arg2 != null) {
			defaultz = arg2;
		}
		
		if (arg1 == null) {
			return(new TrimString(defaultz));
		}
		
		String temp1 = arg1.trim();
		if ((temp1 == null) || (temp1.length()<1)) {
			return(new TrimString(defaultz));
		}
		
		return(new TrimString(temp1));
	}
	
	/**
	 * Test (and tweak) form strings.
	 * Null values are not permitted in the database.
	 * Instead, null values are replaced w/a manifest constant.  
	 * The null surrogate is not displayed to the operator.
	 * 
	 * @param arg raw value from back end
	 * @return null if surrogate else string value
	 */
	protected String stringTweaker2(TrimString arg) {
		if (arg.equals(ConstantsIf.EMPTY_STRING)) {
			return(null);
		}
		
		return(arg.getValue());
	}

	/**
	 * Eclipse generated serial version identifier
	 */
	private static final long serialVersionUID = -7517286993657801713L;
}
