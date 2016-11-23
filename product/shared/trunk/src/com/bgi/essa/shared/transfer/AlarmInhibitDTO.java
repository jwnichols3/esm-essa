package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.Day;
import com.bgi.essa.shared.primitive.Hour;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * Each task can have "zero to many" inhibit windows which specify alert suppression.
 * Windows are specified w/a start day/hour and ending hour.
 * Start = 8, Stop = 12 inhibits alerts for four hours between 0800-1200.  
 * Minutes don't count, there is no way to even specify minutes.
 * 
 * Windows have the capability of wrapping through midnight, i.e. 22-6 implies 
 * suppression from 2200 to 0600 the next morning.
 * 
 * @hibernate.class 
 *   table = "ALARM_INHIBIT"
 * 
 * @author coleguy
 */
public class AlarmInhibitDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {
	
	/**
	 * Return row ID.
	 * 
	 * @return row ID
	 * 
	 * @hibernate.id 
	 *   name="ID" 
	 *   type="long" 
	 *   column="ID" 
	 *   generator-class="native"
	 */
	@Override
	public Long getRowId() {
		return(id.getLongKeyValue());
	}

	/**
	 * Day (of week) to start suppression.
	 */
	private Day _day = Day.MON;

	/**
	 * Return the day of suppression start
	 * 
	 * @return day of suppression start
	 * 
	 * @hibernate.property 
	 *   column="DAY"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.DayUserType"
	 *   not-null="true"
	 */
	public Day getDay() {
		return(_day);
	}

	/**
	 * Define the day of suppression start
	 * 
	 * @param arg day of suppression start
	 * @throws NullPointerException if null arg
	 */
	public void setDay(Day arg) {
		if (arg == null) {
			throw new NullPointerException("null day");
		}

		_day = arg;
	}
	
	/**
	 * Start hour
	 */
	private Hour _start = Hour.H00;
	
	/**
	 * Return start hour
	 * 
	 * @return start hour 
	 * 
	 * @hibernate.property 
	 *   column="START_TIME"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.HourUserType"
	 *   not-null="true"
	 */
	public Hour getStart() {
		return(_start);
	}
	
	/**
	 * Define start hour
	 * 
	 * @param arg start hour 
	 * @throws NullPointerException if null value
	 */
	public void setStart(Hour arg) {
		if (arg == null) {
			throw new NullPointerException("null start hour");
		}
		
		_start = arg;
	}
	
	/**
	 * Stop hour
	 */
	private Hour _stop = Hour.H00;
	
	/**
	 * Return stop hour
	 * 
	 * @return stop hour
	 * 
	 * @hibernate.property 
	 *   column="STOP_TIME"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.HourUserType"
	 *   not-null="true"
	 */
	public Hour getStop() {
		return(_stop);
	}
	
	/**
	 * Define stop hour
	 * 
	 * @param arg stop hour
	 * @throws NullPointerException if null value
	 */
	public void setStop(Hour arg) {
		if (arg == null) {
			throw new NullPointerException("null stop hour");
		}
		
		_stop = arg;
	}
	
	/**
	 * Determine if the supplied time falls within suppression window
	 * 
	 * @param arg candidate time
	 * @return true, valid inhibit
	 */
	public boolean testInhibit(ZuluTime arg) {
		Day today1 = _day;

		boolean flag = true;
		int hour1 = _start.getIvalue();
	
		while(flag) {	
			//System.out.println(today1 + ":" + hour1 + ":" + arg.getDayOfWeek() + ":" + arg.getHour());
		
			if (hour1 == arg.getHour()) {
				if (today1.equals(arg.getDayOfWeek())) {
					return(true);
				}
			}
			
			++hour1;
			
			if (hour1 == _stop.getIvalue()) {
				flag = false;
			}
			
			if (hour1 > 23) {
				hour1 = 0;
				today1 = Day.nextDay(today1);
			}
		}
		
		return(false);
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "inhibit:" + _day + ":" + _start + ":" + _stop + ":";
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	@Override
	public String toXml() {
		return("fix me alarm inhibit dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		AlarmInhibitDTO dto = new AlarmInhibitDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);

		dto.setDay(_day);
		dto.setStart(_start);
		dto.setStop(_stop);

		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("AlarmInhibitDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object. Sort by XXX
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		System.out.println("AlarmInhibitDTO fix me/compareTo");
		
		/*
		final ApplicationName temp = ((VpoDTO) arg).getAppName();
		return(_app_name.toString().compareTo(temp.toString()));
		*/
		
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 1201473311313850321L;
}
