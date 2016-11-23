package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal size threshold options
 *
 * @author gsc
 */
public final class SizeThreshold implements Serializable {
	
	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
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
	public int hashCode() {
		return(33 * _value.hashCode());
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

		final SizeThreshold temp = (SizeThreshold) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private SizeThreshold(final String arg) {
		_value = arg;
	}

	/**
	 * Size threshold value.
	 */
	private final String _value;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static SizeThreshold getInstance(final String arg) {
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
	public static Map<String, SizeThreshold> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, SizeThreshold> _instances = new HashMap<String, SizeThreshold>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 7383169355107454766L;
	
	/**
	 * Alert if range in bounds
	 */
	public static final SizeThreshold RANGE_INCLUSIVE = new SizeThreshold("Range - Inclusive");

	/**
	 * Alert if range NOT in bounds
	 */
	public static final SizeThreshold RANGE_EXCLUSIVE = new SizeThreshold("Range - Exclusive");
	
	/**
	 * Fixed size - alert if decrease below specified threshold
	 */
	public static final SizeThreshold FIXED_DECREASING = new SizeThreshold("Fixed - Below");
		
	/**
	 * Fixed size - alert if increase beyond specified threshold
	 */
	public static final SizeThreshold FIXED_INCREASING = new SizeThreshold("Fixed - Above");
	
	/**
	 * Alert if growth shrinks below threshold
	 */
	public static final SizeThreshold GROWTH_DECREASING = new SizeThreshold("Growth - Shrinking");

	/**
	 * Alert if growth exceeds threshold
	 */
	public static final SizeThreshold GROWTH_INCREASING = new SizeThreshold("Growth - Increasing");

	/**
	 * Alert if no growth
	 */
	public static final SizeThreshold GROWTH_NONE = new SizeThreshold("Growth - None");

	/**
	 * 
	 */
	static {
		_instances.put(RANGE_EXCLUSIVE.toString(), RANGE_EXCLUSIVE);
		_instances.put(RANGE_INCLUSIVE.toString(), RANGE_INCLUSIVE);
		
		_instances.put(FIXED_DECREASING.toString(), FIXED_DECREASING);
		_instances.put(FIXED_INCREASING.toString(), FIXED_INCREASING);
		
		_instances.put(GROWTH_DECREASING.toString(), GROWTH_DECREASING);
		_instances.put(GROWTH_INCREASING.toString(), GROWTH_INCREASING);
		_instances.put(GROWTH_NONE.toString(), GROWTH_NONE);
	}
}