package com.bgi.essa.struts1_2.utility;

import java.io.Serializable;

import java.util.Calendar;

import com.bgi.essa.shared.primitive.DateOnly;

/**
 * Support for Struts calendar drop downs
 * 
 * @author gsc
 */
public final class CalendarOptionBean implements Serializable {
	
	/**
	 * Day container
	 */
	public class DayBean implements Serializable {
		private int _ndx;
		private String _day;

		public void setDay(int ndx, String day) {
			_ndx = ndx;
			_day = day;
		}

		public int getNdx() {
			return(_ndx);
		}

		public String getDay() {
			return(_day);
		}

		/**
		 * Pacifier - never invoked. 
		 * Catalina insists on having this method or it will choke at runtime. 
		 * <TT> No getter method available for property day for bean under name... </TT>
		 */
		public void setDay(String arg) {
			// empty
		}
		
	    /**
		 * Generated serial ID 
		 */
		private static final long serialVersionUID = -1629523964716588973L;
	}

	/**
	 * Days of the month 1-31
	 */
	private static final String[] _dayz = { "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31" };

	/**
	 * Return a populated array of DayBean
	 * 
	 * @return a populated array of DayBean
	 */
	public DayBean[] getDays() {
		DayBean[] result = new DayBean[_dayz.length];

		for(int ii = 0; ii < _dayz.length; ii++) {
			DayBean db = new DayBean();
			db.setDay(ii, _dayz[ii]);
			result[ii] = db;
		}

		return (result);
	}

	/**
	 * Month container
	 */
	public final class MonthBean implements Serializable {
		private int _ndx;
		private String _month;

		/**
		 * Define month and key
		 * 
		 * @param ndx month index
		 * @param month either fully spelled out or abbrevieated
		 */
		public void setMonth(int ndx, String month) {
			_ndx = ndx;
			_month = month;
		}

		/**
		 * Return associated key
		 * 
		 * @return associated key
		 */
		public int getNdx() {
			return(_ndx);
		}

		/**
		 * Return associated month
		 * 
		 * @return associated month
		 */
		public String getMonth() {
			return(_month);
		}

		/**
		 * Pacifier - never invoked. Catalina insists on having this method or
		 * it will choke at runtime. <TT> No getter method available for
		 * property month for bean under name... </TT>
		 */
		public void setMonth(String arg) {
			// empty
		}
		
		/**
		 * Generated serial ID
		 */
		private static final long serialVersionUID = 5423618367450663451L;
	}

	/**
	 * Months fully spelled out
	 * 
	 * @return months fully spelled out
	 */
	public MonthBean[] getFullMonths() {
		MonthBean[] result = new MonthBean[_full_monthz.length];

		for (int ii = 0; ii < _full_monthz.length; ii++) {
			MonthBean mb = new MonthBean();
			mb.setMonth(ii, _full_monthz[ii]);
			result[ii] = mb;
		}

		return(result);
	}

	/**
	 * Months abbreviated (3 characters in upper case)
	 * 
	 * @return months abbreviated (3 characters in upper case)
	 */
	public MonthBean[] getAbbreviatedMonths() {
		MonthBean[] result = new MonthBean[_abbreviated_monthz.length];

		for (int ii = 0; ii < _abbreviated_monthz.length; ii++) {
			MonthBean mb = new MonthBean();
			mb.setMonth(ii, _abbreviated_monthz[ii]);
			result[ii] = mb;
		}

		return(result);
	}

	/**
	 * Fully spellect out months
	 */
	private static final String[] _full_monthz = { "January", "February",
			"March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	/**
	 * Abbreviated months, 3 characters in upper case
	 */
	private static final String[] _abbreviated_monthz = { "JAN", "FEB", "MAR",
			"APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	/**
	 * Year container
	 */
	public final class YearBean implements Serializable {
		private int _ndx;
		private String _year;

		public void setYear(int ndx, String year) {
			_ndx = ndx;
			_year = year;
		}

		public int getNdx() {
			return(_ndx);
		}

		public String getYear() {
			return(_year);
		}

		/**
		 * Pacifier - never invoked. 
		 * Catalina insists on having this method or it will choke at runtime. 
		 * <TT> No getter method available for property year for bean under name... </TT>
		 */
		public void setYear(String arg) {
			// empty
		}
		
		/**
		 * Generated serial ID
		 */
		private static final long serialVersionUID = 8422481129126911076L;
	}

	/**
	 * 
	 */
	public YearBean[] getYears() {
		YearBean[] result = new YearBean[_yearz.length];

		for (int ii = 0; ii < _yearz.length; ii++) {
			YearBean yb = new YearBean();
			yb.setYear(ii, _yearz[ii]);
			result[ii] = yb;
		}

		return (result);
	}

	// private static final String[] _yearz = { "1995", "1996", "1997", "1998",
	// "1999", "2000", "2001", "2002", "2003", "2004", "2005" };

	private static final String[] _yearz = { "2001", "2002", "2003", "2004",
			"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
			"2013", "2014", "2015" };

	/**
	 * Date value
	 */
	public final class CalendarIndices {
		public int month;
		public int year;
		public int day;
	}

	/**
	 * Return indices for today.
	 */
	public CalendarIndices getIndices() {
		return(getIndices(Calendar.getInstance()));
	}

	/**
	 * Return indices for specified CalDate
	 */
	public CalendarIndices getIndices(DateOnly arg) {
		return(getIndices(arg.getCalendarValue()));
	}

	/**
	 * Return indices for specified Calendar
	 */
	public CalendarIndices getIndices(Calendar arg) {
		CalendarIndices result = new CalendarIndices();

		result.day = arg.get(Calendar.DAY_OF_MONTH) - 1;
		result.month = arg.get(Calendar.MONTH);

		int temp_year = arg.get(Calendar.YEAR);
		String target = Integer.toString(temp_year);
		for (int ii = 0; ii < _yearz.length; ii++) {
			if (target.equals(_yearz[ii])) {
				result.year = ii;
			}
		}

		return(result);
	}

	/**
	 * Convert from indices to DateOnly
	 */
	public DateOnly getDateOnly(int year_ndx, int month_ndx, int day_ndx) {
		int year = Integer.parseInt(_yearz[year_ndx]);
		return(new DateOnly(year, month_ndx, day_ndx + 1));
	}
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 7248153665432080826L;
}