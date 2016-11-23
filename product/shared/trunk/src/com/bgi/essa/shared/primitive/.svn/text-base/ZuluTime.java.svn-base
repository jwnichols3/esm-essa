package com.bgi.essa.shared.primitive;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Zulu time, all ESSA times use GMT.
 * 
 * @author coleguy
 */
public class ZuluTime implements Comparable<Object>, ValueTypeIf {

	/**
	 * empty ctor, instantiates for current time
	 */
	public ZuluTime() {
		//empty
	}
	
	/**
	 * ctor w/binary time (DB storage is in this format)
	 * 
	 * @param arg gmt in milliseconds
	 */
	public ZuluTime(final long arg) {
		_value.setTimeInMillis(arg);
	}

	/**
	 * Copy constructor
	 *
	 * @param arg value to copy
	 * @throws NullPointerException if null arg
	 */
	public ZuluTime(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null ZuluTime arg");
		}

		_value.setTimeInMillis(arg._value.getTimeInMillis());
	}
	
	/**
	 * ctor w/initialization
	 * 
	 * @param year year
	 * @param month month(0-11)
	 * @param day day of month
	 * @param hour 24 hour
	 * @param minute minute
	 */
	public ZuluTime(int year, int month, int day, int hour, int minute) {
		_value.clear();
		_value.set(year, month, day, hour, minute);
	}
	
	/**
	 * Return binary time (DB storage is in this format)
	 * 
	 * @return binary time
	 */
	public long getTimeInMillis() {
		return(_value.getTimeInMillis());
	}
	
	/**
	 * Return hour to compare w/alarm inhibit window
	 * 
	 * @return hour
	 */
	public int getHour() {
		return(_value.get(Calendar.HOUR_OF_DAY));
	}
	
	/**
	 * Return day of week to compare w/alarm inhibit window
	 * 
	 * @return day of week
	 */
	public Day getDayOfWeek() {
		int temp = _value.get(Calendar.DAY_OF_WEEK);
		
		if (temp == Calendar.SUNDAY) {
			return(Day.SUN);
		} else if (temp == Calendar.MONDAY) {
			return(Day.MON);
		} else if (temp == Calendar.TUESDAY) {
			return(Day.TUE);
		} else if (temp == Calendar.WEDNESDAY) {
			return(Day.WED);
		} else if (temp == Calendar.THURSDAY) {
			return(Day.THU);
		} else if (temp == Calendar.FRIDAY) {
			return(Day.FRI);
		} 
		
		return(Day.SAT);
	}

	/**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		final ZuluTime result = new ZuluTime();
		result._value.setTimeInMillis(_value.getTimeInMillis());
		return(result);
	}
	
	/**
	 * Return true if the supplied argument refers to the same date as this instance.
	 * 
	 * @param arg item to compare.
	 * @return true, if arg contains the same date as this instance.
	 * @throws ClassCastException if arg cannot be cast to ZuluTime
	 */
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}
		
		final ZuluTime temp = (ZuluTime) arg;
		
		if (_value.getTimeInMillis() == temp._value.getTimeInMillis()) {
			return(true);
		}
		
		return(false);
	}

	/**
	 * Return true if I am after arg time
	 * 
	 * @param arg to compare
	 * @return true if I am after arg time
	 */
	public boolean after(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null ZuluTime arg");
		}

		final long left = _value.getTimeInMillis();
		final long right = arg.getTimeInMillis();

		return(left > right);
	}

	/**
	 * Return true if I am before arg time
	 * 
	 * @param arg to compare
	 * @return true if I am before arg time
	 */
	public boolean before(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null ZuluTime arg");
		}

		final long left = _value.getTimeInMillis();
		final long right = arg.getTimeInMillis();

		return(left < right);
	}

	/**
	 * Support for Comparable.compareTo
	 * 
	 * @param arg item to compare
	 * @return -1 if less, 1 if greater or zero if equal
	 * @throws NullPointerException if null arg
	 */
	public int compareTo(final Object arg) {
		if (arg == null) {
			throw new NullPointerException("null ZuluTime arg");
		}

		final ZuluTime temp = (ZuluTime) arg;

		if (after(temp)) {
			return(1);
		}

		if (before(temp)) {
			return(-1);
		}

		return(0);
	}
	
	/**
	 * Wrapper for Calendar.hashCode()
	 * 
	 * @return hash code for this key
	 */
	@Override
	public int hashCode() {
		return(_value.hashCode() * 5);
	}
	
	/**
	 * Return formatted time
	 * 
	 * @return formatted time
	 */
	@Override
	public String toString() {
		_sdf1.setTimeZone(_tz);
		
		return(_sdf1.format(_value.getTime()));
	}

	/**
	 * Return object state as a XML formatted string YYYY-MM-DD HH:MM:SS
	 * 
	 * @return object state as a XML formatted string YYYY-MM-DD HH:MM:SS
	 */
	public String toXml() {
		return(_sdf2.format(_value.getTime()));
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
	 * format employed by toString() method, MM/DD/YYYY HH:MM:SS
	 */
	private static final SimpleDateFormat _sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	/**
	 * format employed by toXml() method, YYYY-MM-DD HH:MM:SS
	 */
	private static final SimpleDateFormat _sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Hard wired for GMT
	 */
	private final TimeZone _tz = TimeZone.getTimeZone("GMT");
	
	/**
	 * Date as represented by this instance.
	 */
	private final Calendar _value = Calendar.getInstance(_tz);
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 4758577818582618553L;
}
