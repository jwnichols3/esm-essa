package com.bgi.essa.struts1_2.utility;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gsc
 */
public class OptionStunt implements Serializable {

	/*
	 * Stunts
	 */
	public static final OptionStunt ANY = new OptionStunt("ANY");
	public static final OptionStunt NONE = new OptionStunt("NONE");
	public static final OptionStunt UNKNOWN = new OptionStunt("UNKNOWN");
	
	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
	public String toString() {
		return(_value);
	}
	
	/**
	 * Return a sorted array of string keys
	 * @return sorted array
	 */
	public static String[] getSortedKeys() {
		String[] keyz = (String[]) _instances.keySet().toArray(new String[0]);		
		Arrays.sort(keyz);	
		return(keyz);
	}

	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static OptionStunt getInstance(final String arg) {
		return(_instances.get(arg));
	}

	/**
	 * Return all instances
	 * 
	 * @return all instances
	 */
	public static Map<String, OptionStunt> getAll() {
		return(_instances);
	}

	/**
	 * Private ctor
	 * 
	 * @param arg legal stunt
	 */
	private OptionStunt(String arg) {
		_value = arg;
	}

	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	@Override
	public int hashCode() {
		return(29 * _value.hashCode());
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

		final OptionStunt temp = (OptionStunt) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Command value.
	 */
	private final String _value;

	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, OptionStunt> _instances = new HashMap<String, OptionStunt>();

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -8665021252506626663L;
	
	/**
	 * All sources
	 */
	static {
		_instances.put(ANY.toString(), ANY);
		_instances.put(NONE.toString(), NONE);
		_instances.put(UNKNOWN.toString(), UNKNOWN);
	}
}