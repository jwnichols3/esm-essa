package com.bgi.essa.shared.primitive;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Wrapper for java.util.Calendar - only dates, no time.
 * 
 * <P>
 * Immutable value type.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class DateOnly implements Comparable<Object>, ValueTypeIf {

	/**
	 * Initialize for today
	 */
	public DateOnly() {
		_value.set(Calendar.HOUR_OF_DAY, 0);
		_value.set(Calendar.MINUTE, 0);
		_value.set(Calendar.SECOND, 0);
		_value.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Create DateOnly from Date. 
	 * Copies values, does not maintain reference to arg. 
	 * Note that exception leaves original value unchanged.
	 * 
	 * @param arg date to copy
	 * @throws NullPointerException if null arg
	 */
	public DateOnly(final Date arg) {
		if (arg == null) {
			throw new NullPointerException("null Date arg");
		}

		_value.clear();
		_value.setTime(arg);

		_value.set(Calendar.HOUR_OF_DAY, 0);
		_value.set(Calendar.MINUTE, 0);
		_value.set(Calendar.SECOND, 0);
		_value.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Create DateOnly from Calendar. 
	 * Copies values, does not maintain reference to arg. 
	 * Note that exception leaves original value unchanged.
	 * 
	 * @param arg date to copy
	 * @throws NullPointerException if null arg
	 */
	public DateOnly(final Calendar arg) {
		if (arg == null) {
			throw new NullPointerException("null Calendar arg");
		}

		_value.clear();
		_value.setTimeInMillis(arg.getTimeInMillis());

		_value.set(Calendar.HOUR_OF_DAY, 0);
		_value.set(Calendar.MINUTE, 0);
		_value.set(Calendar.SECOND, 0);
		_value.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Define the current date value. 
	 * Note that exception leaves original value unchanged.
	 * 
	 * @param arg in the format mm/dd/yyyy
	 * @throws NullPointerException if null arg
	 * @throws ParseException if parse failure
	 */
	public DateOnly(final String arg) throws ParseException {
		if (arg == null) {
			throw new NullPointerException("null String arg");
		}

		_value.clear();
		_value.setTime(_sdf1.parse(arg));

		_value.set(Calendar.HOUR_OF_DAY, 0);
		_value.set(Calendar.MINUTE, 0);
		_value.set(Calendar.SECOND, 0);
		_value.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Define the current date value.
	 * 
	 * @param year four digit year (1990 to 2050).
	 * @param month zero based month (0 to 11).
	 * @param day day of month (0 to 31).
	 * 
	 * @throws IllegalArgumentException out of range argument
	 */
	public DateOnly(final int year, final int month, final int day) {
		if ((year < MIN_YEAR) || (year > MAX_YEAR)) {
			throw new IllegalArgumentException("bad year");
		}

		if ((month < MIN_MONTH) || (month > MAX_MONTH)) {
			throw new IllegalArgumentException("bad month");
		}

		if ((day < MIN_DAY) || (day > MAX_DAY)) {
			throw new IllegalArgumentException("bad day");
		}

		_value.clear();
		_value.set(year, month, day);

		_value.set(Calendar.HOUR_OF_DAY, 0);
		_value.set(Calendar.MINUTE, 0);
		_value.set(Calendar.SECOND, 0);
		_value.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Define the current date value. 
	 * Copies values, does not maintain reference to arg. 
	 * Note that exception leaves original value unchanged.
	 * 
	 * @param arg value to copy
	 * @throws NullPointerException if null arg
	 */
	public DateOnly(final DateOnly arg) {
		if (arg == null) {
			throw new NullPointerException("null DateOnly arg");
		}

		_value.setTimeInMillis(arg._value.getTimeInMillis());
	}

	/**
	 * Bump date for next day.
	 */
	public void setTomorrow() {
		_value.add(Calendar.DATE, 1);
	}

	/**
	 * Decrement date.
	 */
	public void setYesterday() {
		_value.add(Calendar.DATE, -1);
	}

	/**
	 * Return true if date evaluations to Saturday/Sunday
	 * 
	 * @return true if date evaluations to Saturday/Sunday
	 */
	public boolean isWeekEnd() {
		if (_value.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return(true);
		}

		if (_value.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return(true);
		}

		return(false);
	}

	/**
	 * Return populated calendar instance
	 * 
	 * @return populated calendar instance
	 */
	public Calendar getCalendarValue() {
		return((Calendar) _value.clone());
	}

	/**
	 * Return populated date instance
	 * 
	 * @return populated date instance
	 */
	public Date getDateValue() {
		return(_value.getTime());
	}

	/**
	 * Return populated SQL Date instance
	 * 
	 * @return populated SQL Date instance
	 */
	public java.sql.Date getSqlDateValue() {
		return(new java.sql.Date(_value.getTimeInMillis()));
	}

	/**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		return(new DateOnly(_value));
	}

	/**
	 * Return true if the supplied arguments match the same date as this instance.
	 * 
	 * @param year four digit year.
	 * @param month zero based month.
	 * @param day day of month.
	 * @return true, if the specified date matches this instance.
	 */
	public boolean equals(final int year, final int month, final int day) {
		if (year != _value.get(Calendar.YEAR)) {
			return(false);
		}

		if (month != _value.get(Calendar.MONTH)) {
			return(false);
		}

		if (day != _value.get(Calendar.DAY_OF_MONTH)) {
			return(false);
		}

		return(true);
	}

	/**
	 * Return true if the supplied argument refers to the same date as this instance.
	 * 
	 * @param arg item to compare.
	 * @return true, if arg contains the same date as this instance.
	 * @throws ClassCastException if arg cannot be cast to DateOnly
	 */
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}

		final Calendar cc = ((DateOnly) arg).getCalendarValue();

		final int year = cc.get(Calendar.YEAR);
		final int month = cc.get(Calendar.MONTH);
		final int day = cc.get(Calendar.DAY_OF_MONTH);

		return(equals(year, month, day));
	}

	/**
	 * Return true if I am after arg time
	 * 
	 * @param arg to compare
	 * @return true if I am after arg time
	 */
	public boolean after(final DateOnly arg) {
		final long left = _value.getTimeInMillis();
		final long right = arg.getCalendarValue().getTimeInMillis();

		return(left > right);
	}

	/**
	 * Return true if I am before arg time
	 * 
	 * @param arg to compare
	 * @return true if I am before arg time
	 */
	public boolean before(final DateOnly arg) {
		final long left = _value.getTimeInMillis();
		final long right = arg.getCalendarValue().getTimeInMillis();

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
			throw new NullPointerException("null DateOnly arg");
		}

		final DateOnly temp = (DateOnly) arg;

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
		return(_value.hashCode() * 7);
	}

	/**
	 * Return a formatted string representing the state of this instance. 
	 * Has the form MM/DD/YYYY.
	 * 
	 * @return a formatted string representing the state of this instance.
	 */
	@Override
	public String toString() {
		return(_sdf1.format(_value.getTime()));
	}
	
	/**
	 * Return object state as a XML formatted string YYYY-MM-DD
	 * 
	 * @return object state as a XML formatted string YYYY-MM-DD
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
	 * Date as represented by this instance.
	 */
	private final Calendar _value = Calendar.getInstance();

	/**
	 * format employed by toString() method, MM/DD/YYYY
	 */
	private static final SimpleDateFormat _sdf1 = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * format employed by toXml() method, YYYY-MM-DD
	 */
	private static final SimpleDateFormat _sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -7595510765521315586L;

	/**
	 * Smallest legal year
	 */
	public static final int MIN_YEAR = 1990;

	/**
	 * Largest legal year
	 */
	public static final int MAX_YEAR = 2050;

	/**
	 * Smallest legal month (of the year)
	 */
	public static final int MIN_MONTH = 0;

	/**
	 * Largest legal month (of the year)
	 */
	public static final int MAX_MONTH = 11;

	/**
	 * Smallest legal day (of the month)
	 */
	public static final int MIN_DAY = 0;

	/**
	 * Largest legal day (of the month)
	 */
	public static final int MAX_DAY = 31;
}