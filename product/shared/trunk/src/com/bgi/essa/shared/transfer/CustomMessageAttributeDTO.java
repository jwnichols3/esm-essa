package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * @hibernate.class 
 *   table = "CMA"
 *   
 * @author coleguy
 */
public class CustomMessageAttributeDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * key
	 */
	private TrimString _key = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return key
	 * 
	 * @return key
	 * 
	 * @hibernate.property
	 *   column="KEY2"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getKey() {
		return(_key);
	}

	/**
	 * Define key
	 * 
	 * @param arg key
	 * @throws NullPointerException if null arg
	 */
	public void setKey(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null key");
		}
		
		_key = arg;
	}	
	
	/**
	 * Value
	 */
	private TrimString _value = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return associated value
	 * 
	 * @return associated value
	 *
     * @hibernate.property
     *   column="VALUE2"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getValue() {
		return(_value);
	}

	/**
	 * Define associated value
	 * 
	 * @param arg associated value
	 * @throws NullPointerException if null arg
	 */
	public void setValue(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null value");
		}
		
		_value = arg;
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "cma:" + _key + ":" + _value + ":" + super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me cma dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		CustomMessageAttributeDTO dto = new CustomMessageAttributeDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setKey(_key);
		dto.setValue(_value);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("CustomMessageAttributeDTO fix me/isReasonable");
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
		System.out.println("FIXME CannedMessageAttributeDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 6611299923180204016L;
}