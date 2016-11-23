package com.bgi.essa.jboss4.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.Day;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Hour;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;

/**
 * Alarm inhibit container
 * 
 * @author coleguy
 */
public class RawAlarmInhibit {
	
	private String _day;
	
	public String getDay() {
		return(_day);
	}
	
	public void setDay(String arg) {
		_day = arg;
	} 
	
	private String _start;
	
	public String getStart() {
		return(_start);
	}
	
	public void setStart(String arg) {
		_start = arg;
	} 

	private String _stop;
	
	public String getStop() {
		return(_stop);
	}
	
	public void setStop(String arg) {
		_stop = arg;
	} 
	
	private String _note;
	
	public String getNote() {
		return(_note);
	}
	
	public void setNote(String arg) {
		_note = arg;
	}
	
	public AlarmInhibitDTO getDto() {
		AlarmInhibitDTO dto = new AlarmInhibitDTO();
		dto.setActive(true);
	
		if (_day == null) {
			_log.error("null day");
			dto.setDay(Day.MON);
		} else {
			Day temp = Day.getInstance(_day);
			if (temp == null) {
				_log.error("bad day");
				dto.setDay(Day.MON);
			} else {
				dto.setDay(temp);
			}
		}
		
		if (_start == null) {
			_log.error("null start");
			dto.setStart(Hour.H00);
		} else {
			Hour temp = Hour.getInstance(_start);
			if (temp == null) {
				_log.error("bad start");
				dto.setStart(Hour.H00);
			} else {
				dto.setStart(temp);
			}
		}
		
		if (_stop == null) {
			_log.error("null stop");
			dto.setStop(Hour.H00);
		} else {
			Hour temp = Hour.getInstance(_stop);
			if (temp == null) {
				_log.error("bad stop");
				dto.setStop(Hour.H00);
			} else {
				dto.setStop(temp);
			}
		}
		
		if (_note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(_note));
		}
		
		return(dto);
	}	
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
