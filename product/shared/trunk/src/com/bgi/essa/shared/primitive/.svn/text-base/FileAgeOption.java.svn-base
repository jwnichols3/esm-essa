package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal file age options
 *
 * @author gsc
 */
public final class FileAgeOption implements Serializable {

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

		final FileAgeOption temp = (FileAgeOption) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private FileAgeOption(final String arg) {
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
	public static FileAgeOption getInstance(final String arg) {
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
	public static Map<String, FileAgeOption> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, FileAgeOption> _instances = new HashMap<String, FileAgeOption>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -5485530898479938631L;
	
	/**
	 * Only the specified single file must match
	 */
	public static final FileAgeOption SINGLE = new FileAgeOption("Single");
	
	/**
	 * All files within a directory
	 */
	public static final FileAgeOption ALL = new FileAgeOption("All");
	
	/**
	 * At least one file within a directory must match
	 */
	public static final FileAgeOption AT_LEAST_ONE = new FileAgeOption("At Least One");	

	/**
	 * 
	 */
	static {
		_instances.put(SINGLE.toString(), SINGLE);
		_instances.put(ALL.toString(), ALL);
		_instances.put(AT_LEAST_ONE.toString(), AT_LEAST_ONE);
	}
}