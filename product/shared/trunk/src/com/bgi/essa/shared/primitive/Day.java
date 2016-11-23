package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Define days of week
 * 
 * @author coleguy
 */
public class Day implements Serializable {

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
		return(7 * _value.hashCode());
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

		Day temp = (Day) arg;
		return(_value.equals(temp._value));
	}
	
	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private Day(String arg) {
		_value = arg;
	}
	
	/**
	 * Day value.
	 */
	private String _value;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static Day getInstance(String arg) {
		return(_instances.get(arg));
	}
	
	/**
	 * Return a sorted array of keys
	 * 
	 * @return sorted array of keys
	 */
	public static String[] getSortedKeys() {
		String[] keyz = new String[7];
		
		keyz[0] = MON.toString();
		keyz[1] = TUE.toString();
		keyz[2] = WED.toString();
		keyz[3] = THU.toString();
		keyz[4] = FRI.toString();
		keyz[5] = SAT.toString();
		keyz[6] = SUN.toString();
		
		return(keyz);
	}
	
	/**
	 * Return all instances
	 * 
	 * @return all instances
	 */
	public static Map<String, Day> getAll() {
		return(_instances);
	}

	/**
	 * Return tomorrow
	 * 
	 * @param arg today
	 * @return tomorrow
	 */
	public static Day nextDay(Day arg) {
		if (arg.equals(Day.SUN)) {
			return(Day.MON);
		} else if (arg.equals(Day.MON)) {
			return(Day.TUE);
		} else if (arg.equals(Day.TUE)) {
			return(Day.WED);
		} else if (arg.equals(Day.WED)) {
			return(Day.THU);
		} else if (arg.equals(Day.THU)) {
			return(Day.FRI);
		} else if (arg.equals(Day.FRI)) {
			return(Day.SAT);
		}
		
		return(Day.SUN);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, Day> _instances = new HashMap<String, Day>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -7197969536956706480L;

	/**
	 * Define days of week
	 */
	public static final Day MON = new Day("Monday");
	public static final Day TUE = new Day("Tuesday");
	public static final Day WED = new Day("Wednesday");
	public static final Day THU = new Day("Thursday");
	public static final Day FRI = new Day("Friday");
	public static final Day SAT = new Day("Saturday");
	public static final Day SUN = new Day("Sunday");
	
	/**
	 * 
	 */
	static {
		_instances.put(MON.toString(), MON);
		_instances.put(TUE.toString(), TUE);
		_instances.put(WED.toString(), WED);
		_instances.put(THU.toString(), THU);
		_instances.put(FRI.toString(), FRI);
		_instances.put(SAT.toString(), SAT);
		_instances.put(SUN.toString(), SUN);
	}
}
