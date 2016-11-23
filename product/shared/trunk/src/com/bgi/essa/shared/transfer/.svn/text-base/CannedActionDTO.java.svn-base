package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.CannedAction;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * @hibernate.class 
 *   table = "CANNED_ACTION"
 *   
 * @author coleguy
 */
public class CannedActionDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

	/**
	 * Return row ID.
	 * 
	 * @return row ID
	 * 
	 * @hibernate.id 
	 *   name="ID" 
	 *   type="long" 
	 *   column="ID" 
	 *   generator-class="native"
	 */
	public Long getRowId() {
		return(id.getLongKeyValue());
	}

	/**
	 * action identifier
	 */
	private TrimString _action_id;

	/**
	 * Return action identifier
	 * 
	 * @return action identifier
	 * 
	 * @hibernate.property
	 *   column="ACTION_ID"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getActionId() {
		return(_action_id);
	}

	/**
	 * Define action identifier
	 * 
	 * @param arg action identifier
	 */
	public void setActionId(TrimString arg) {
		_action_id = arg;
	}	
	
	/**
	 * Action type
	 */
	private CannedAction _action = CannedAction.EMAIL;

	/**
	 * Return the canned action
	 * 
	 * @return canned action
	 *
     * @hibernate.property
     *   column="ACTION_TYPE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.CannedActionUserType"
     *   not-null="true"
	 */
	public CannedAction getAction() {
		return(_action);
	}

	/**
	 * Define canned action
	 * 
	 * @param arg canned action
	 * @throws NullPointerException if null arg
	 */
	public void setAction(CannedAction arg) {
		if (arg == null) {
			throw new NullPointerException("null action");
		}
		
		_action = arg;
	}

	/**
	 * email subject line
	 */
	private TrimString _subject = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return email subject
	 * 
	 * @return email subject
	 * 
	 * @hibernate.property
	 *   column="SUBJECT"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getSubject() {
		return(_subject);
	}

	/**
	 * Define email subject
	 * 
	 * @param arg email subject
	 */
	public void setSubject(TrimString arg) {
		_subject = arg;
	}	
	
	/**
	 * email addresses
	 */
	private TrimString _address = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return email address
	 * 
	 * @return email address
	 * 
	 * @hibernate.property
	 *   column="ADDRESS"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getAddress() {
		return(_address);
	}

	/**
	 * Define email address
	 * 
	 * @param arg email address
	 */
	public void setAddress(TrimString arg) {
		_address = arg;
	}	
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "canned action:" + _action_id + ":" + _action + ":" + _subject + ":" + super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me canned action dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		CannedActionDTO dto = new CannedActionDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setAction(_action);
		dto.setActionId(_action_id);
		dto.setSubject(_subject);
		dto.setAddress(_address);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("CannedActionDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		/*
		final ApplicationName temp = ((VpoDTO) arg).getAppName();
		return(_app_name.toString().compareTo(temp.toString()));
		*/
		System.out.println("FIXME CannedActionDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 124036047886669616L;
}