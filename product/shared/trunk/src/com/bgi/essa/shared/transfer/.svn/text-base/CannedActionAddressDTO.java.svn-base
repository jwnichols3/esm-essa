package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * @hibernate.class 
 *   table = "CANNED_ACTION_ADDRESS"
 *   
 * @author coleguy
 */
public class CannedActionAddressDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	private TrimString _address;

	/**
	 * Return the canned action address
	 * 
	 * @return canned action address
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
	 * Define canned action action address
	 * 
	 * @param arg canned action address
	 * @throws NullPointerException if null arg
	 */
	public void setAddress(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null action");
		}
		
		_address = arg;
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "canned action address:" + _action_id + ":" + _address + ":" + super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me canned action address dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		CannedActionAddressDTO dto = new CannedActionAddressDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setAddress(_address);
		dto.setActionId(_action_id);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("CannedActionAddressDTO fix me/isReasonable");
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
		System.out.println("FIXME CannedActionAddressDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8510770220027438280L;
}