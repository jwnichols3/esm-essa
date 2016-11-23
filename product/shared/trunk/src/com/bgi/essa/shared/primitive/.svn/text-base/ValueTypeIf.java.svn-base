package com.bgi.essa.shared.primitive;

import java.io.Serializable;

/**
 * Hibernate value type
 * 
 * @author gsc
 */
public interface ValueTypeIf extends Cloneable, Serializable {
	
	/**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone();

	/**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
	public int hashCode();

	/**
	 * Return true if values match
	 * 
	 * @param arg test candidate
	 * @return true if values match
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(Object arg);

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString();
	
	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml();
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param arg xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if arg is null
	 */
	public String toXml(String arg);
}