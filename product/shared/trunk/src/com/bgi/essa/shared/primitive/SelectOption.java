package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal selection options
 *
 * @author gsc
 */
public final class SelectOption implements Serializable {
	
	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
	public String toString() {
		return(_value);
	}
	
	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
		return(31 * _value.hashCode());
	}
	
	/**
	 * Return true if objects match
	 * 
	 * @param arg test candidate
	 * @return true if periods match
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}

		final SelectOption temp = (SelectOption) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private SelectOption(final String arg) {
		_value = arg;
	}

	/**
	 * SelectOption value.
	 */
	private final String _value;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static SelectOption getInstance(final String arg) {
		return(_instances.get(arg));
	}
	
	/**
	 * Return a sorted array of keys
	 * 
	 * @return sorted array of keys
	 */
	public static String[] getSortedKeys() {
		String[] keyz = _instances.keySet().toArray(new String[0]);
		Arrays.sort(keyz);
		return(keyz);
	}
	
	/**
	 * Return all instances
	 * 
	 * @return all instances
	 */
	public static Map<String, SelectOption> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, SelectOption> _instances = new HashMap<String, SelectOption>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -7493133583934844098L;
	
	/**
	 * Select all matching candidates
	 */
	public static final SelectOption SELECT_ALL = new SelectOption("SELECT_ALL");
	
	/**
	 * Select only "active" rows
	 */
	public static final SelectOption SELECT_ACTIVE = new SelectOption("SELECT_ACTIVE");
	
	/**
	 * Select only "inactive" rows
	 */
	public static final SelectOption SELECT_INACTIVE = new SelectOption("SELECT_INACTIVE");	

	/**
	 * 
	 */
	static {
		_instances.put(SELECT_ALL.toString(), SELECT_ALL);
		_instances.put(SELECT_ACTIVE.toString(), SELECT_ACTIVE);
		_instances.put(SELECT_INACTIVE.toString(), SELECT_INACTIVE);
	}
}