package com.bgi.essa.shared.transfer;

import java.io.Serializable;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Parent for data/transfer (DTO) classes
 * 
 * @author gsc
 */
public interface DtoIf extends Serializable {

	/**
	 * Return row id.
	 * 
	 * @return row id
	 */
	Long getRowId();
	
	/**
	 * Return active flag
	 * 
	 * @return true, row is active
	 */
	boolean isActive();

	/**
	 * Define the active state.
	 * 
	 * @param arg true, this row entry is active
	 */
	void setActive(boolean arg);

	/**
	 * Return the free form note.
	 * 
	 * @return free form note regarding this row
	 */
	TrimString getNote();
	
	/**
	 * Define the free form note.
	 * 
	 * @param arg free form note.
	 */
	void setNote(TrimString arg);
	
	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	boolean isReasonable();

	/**
	 * Return object state as a String
	 * 
	 * @return object state as a String
	 */
	String toString();
	
	/**
	 * Return object state as a String
	 * 
	 * @return object state as a String
	 */
	String toXml();

	/**
	 * Return hash code value for this object
	 * 
	 * @see java.lang.Object
	 * @return hash code value for this object
	 */
	abstract int hashCode();

	/**
	 * Return true if this object has equal content
	 * 
	 * @see java.lang.Object
	 * @return true if this object has equal content
	 */
	abstract boolean equals(Object arg);
}
