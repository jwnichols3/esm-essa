package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define hours
 * 
 * @author coleguy
 */
public class Hour implements Serializable {

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
	 * Return integer hour value
	 * 
	 * @return integer hour value
	 */
	public int getIvalue() {
		return(_ivalue);
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

		Hour temp = (Hour) arg;
		return(_value.equals(temp._value));
	}
	
	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private Hour(String arg0, int arg1) {
		_value = arg0;
		_ivalue = arg1;
	}
	
	/**
	 * Hour value.
	 */
	private String _value;
	
	/**
	 * Hour value
	 */
	private int _ivalue;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static Hour getInstance(String arg) {
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
	public static Map<String, Hour> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, Hour> _instances = new HashMap<String, Hour>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -4297479307933910658L;

	/**
	 * Define hours of day
	 */
	public static final Hour H00 = new Hour("00Z", 0);
	public static final Hour H01 = new Hour("01Z", 1);
	public static final Hour H02 = new Hour("02Z", 2);
	public static final Hour H03 = new Hour("03Z", 3);
	public static final Hour H04 = new Hour("04Z", 4);
	public static final Hour H05 = new Hour("05Z", 5);
	public static final Hour H06 = new Hour("06Z", 6);
	public static final Hour H07 = new Hour("07Z", 7);
	public static final Hour H08 = new Hour("08Z", 8);
	public static final Hour H09 = new Hour("09Z", 9);
	public static final Hour H10 = new Hour("10Z", 10);
	public static final Hour H11 = new Hour("11Z", 11);	
	public static final Hour H12 = new Hour("12Z", 12);
	public static final Hour H13 = new Hour("13Z", 13);
	public static final Hour H14 = new Hour("14Z", 14);
	public static final Hour H15 = new Hour("15Z", 15);
	public static final Hour H16 = new Hour("16Z", 16);
	public static final Hour H17 = new Hour("17Z", 17);
	public static final Hour H18 = new Hour("18Z", 18);
	public static final Hour H19 = new Hour("19Z", 19);
	public static final Hour H20 = new Hour("20Z", 20);
	public static final Hour H21 = new Hour("21Z", 21);
	public static final Hour H22 = new Hour("22Z", 22);
	public static final Hour H23 = new Hour("23Z", 23);	
	
	/**
	 * 
	 */
	static {
		_instances.put(H00.toString(), H00);
		_instances.put(H01.toString(), H01);
		_instances.put(H02.toString(), H02);
		_instances.put(H03.toString(), H03);
		_instances.put(H04.toString(), H04);
		_instances.put(H05.toString(), H05);
		_instances.put(H06.toString(), H06);
		_instances.put(H07.toString(), H07);
		_instances.put(H08.toString(), H08);
		_instances.put(H09.toString(), H09);
		_instances.put(H10.toString(), H10);
		_instances.put(H11.toString(), H11);
		_instances.put(H12.toString(), H12);
		_instances.put(H13.toString(), H13);
		_instances.put(H14.toString(), H14);
		_instances.put(H15.toString(), H15);
		_instances.put(H16.toString(), H16);
		_instances.put(H17.toString(), H17);
		_instances.put(H18.toString(), H18);
		_instances.put(H19.toString(), H19);
		_instances.put(H20.toString(), H20);
		_instances.put(H21.toString(), H21);
		_instances.put(H22.toString(), H22);
		_instances.put(H23.toString(), H23);
	}
}
