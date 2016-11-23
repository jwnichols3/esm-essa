package com.bgi.essa.shared.primitive;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Canned actions as a enumerated type
 * 
 * @author coleguy
 */
public class CannedAction implements Serializable {

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
		return(11 * _value.hashCode());
	}

	/**
	 * Return true if objects match
	 * 
	 * @param arg test candidate
	 * @return true if periods match
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return(false);
		}

		CannedAction temp = (CannedAction) arg;
		return(_value.equals(temp._value));
	}
	
	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private CannedAction(String arg) {
		_value = arg;
	}
	
	/**
	 * CannedAction value.
	 */
	private String _value;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static CannedAction getInstance(String arg) {
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
	public static Map<String, CannedAction> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, CannedAction> _instances = new HashMap<String, CannedAction>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -370979801180084761L;

	/**
	 * Define canned actions
	 */
	public static final CannedAction EMAIL = new CannedAction("email");
	public static final CannedAction EMAILFYI = new CannedAction("emailfyi");
	public static final CannedAction COMFORT = new CannedAction("comfort");
	
	/**
	 * 
	 */
	static {
		_instances.put(EMAIL.toString(), EMAIL);
		_instances.put(EMAILFYI.toString(), EMAILFYI);
		_instances.put(COMFORT.toString(), COMFORT);
	}
}
