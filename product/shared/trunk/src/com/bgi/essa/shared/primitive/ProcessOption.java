package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal process monitor options
 *
 * @author gsc
 */
public final class ProcessOption implements Serializable {

	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
	@Override
	public String toString() {
		return(_value);
	}

	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return(_value);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param tag xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if tag is null
	 */
	public String toXml(String tag) {
		if (tag == null) {
			throw new NullPointerException("null XML tag");
		}
		
		return("<" + tag + ">" + toXml() + "</" + tag + ">");
	}
	
	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	@Override
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
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}

		final ProcessOption temp = (ProcessOption) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private ProcessOption(final String arg) {
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
	public static ProcessOption getInstance(final String arg) {
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
	public static Map<String, ProcessOption> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, ProcessOption> _instances = new HashMap<String, ProcessOption>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 7659270655399045839L;
	
	/**
	 * Lock file
	 */
	public static final ProcessOption LOCK_FILE = new ProcessOption("Lock File");
	
	/**
	 * Process name
	 */
	public static final ProcessOption PROCESS_NAME = new ProcessOption("Process Name");
	
	/**
	 * Process name
	 */
	public static final ProcessOption PID = new ProcessOption("PID");
	
	/**
	 * 
	 */
	static {
		_instances.put(LOCK_FILE.toString(), LOCK_FILE);
		_instances.put(PROCESS_NAME.toString(), PROCESS_NAME);
		_instances.put(PID.toString(), PID);
	}
}