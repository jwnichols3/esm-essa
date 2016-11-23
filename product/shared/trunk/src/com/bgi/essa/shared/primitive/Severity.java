package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal message severity
 * 
 * @author coleguy
 */
public class Severity implements Serializable {

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
	 * Return severity weight.  Used to rank severities.
	 * 
	 * @return severity weight
	 */
	public int getWeight() {
		return(_weight);
	}

	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
		return(7 * _value.hashCode());
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

		final Severity temp = (Severity) arg;
		return(_value.equals(temp._value));
	}
	
	/**
	 * Private ctor
	 * 
	 * @param value severity string value
	 * @param weight severity weight
	 */
	private Severity(final String value, int weight) {
		_value = value;
		_weight = weight;
	}
	
	/**
	 * Severity value.
	 */
	private final String _value;
	
	/**
	 * Severity weight, used for compare, higher value implies exciting severity
	 */
	private int _weight;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static Severity getInstance(final String arg) {
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
	public static Map<String, Severity> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, Severity> _instances = new HashMap<String, Severity>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 2292635400865062340L;

	/**
	 * 
	 */
	public static final Severity NORMAL = new Severity("normal", 1);
	public static final Severity WARNING = new Severity("warning", 2);
	public static final Severity MINOR = new Severity("minor", 3);
	public static final Severity MAJOR = new Severity("major", 4);
	public static final Severity CRITICAL = new Severity("critical", 5);
	
	/**
	 * 
	 */
	static {
		_instances.put(NORMAL.toString(), NORMAL);
		_instances.put(WARNING.toString(), WARNING);
		_instances.put(MINOR.toString(), MINOR);
		_instances.put(MAJOR.toString(), MAJOR);
		_instances.put(CRITICAL.toString(), CRITICAL);
	}
}
