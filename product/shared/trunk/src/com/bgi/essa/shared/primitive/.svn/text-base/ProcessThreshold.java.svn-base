package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal process threshold options
 *
 * @author gsc
 */
public final class ProcessThreshold implements Serializable {

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

		final ProcessThreshold temp = (ProcessThreshold) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private ProcessThreshold(final String arg) {
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
	public static ProcessThreshold getInstance(final String arg) {
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
	public static Map<String, ProcessThreshold> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, ProcessThreshold> _instances = new HashMap<String, ProcessThreshold>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -7814195074959026280L;

	/**
	 * Alert on processes exceeding threshold
	 */
	public static final ProcessThreshold CPU_MAX_TIME = new ProcessThreshold("CPU MaxTime");
	
	/**
	 * Alert on processes exceeding threshold
	 */
	public static final ProcessThreshold ALWAYS_RUN = new ProcessThreshold("Always Run");
	
	/**
	 * Alert on processes exceeding threshold
	 */
	public static final ProcessThreshold NEVER_RUN = new ProcessThreshold("Never Run");

	/**
	 * 
	 */
	static {
		_instances.put(CPU_MAX_TIME.toString(), CPU_MAX_TIME);
		_instances.put(ALWAYS_RUN.toString(), ALWAYS_RUN);
		_instances.put(NEVER_RUN.toString(), NEVER_RUN);
	}
}