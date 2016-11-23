package com.bgi.essa.jboss4.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.CannedAction;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CannedActionDTO;

/**
 * Canned action container
 * 
 * @author coleguy
 */
public class RawCannedAction {
	
	private String _action;
	
	public String getAction() {
		return(_action);
	}
	
	public void setAction(String arg) {
		_action = arg;
	} 
	
	private String _address;
	
	public String getAddress() {
		return(_address);
	}
	
	public void setAddress(String arg) {
		_address = arg;
	} 
	
	private String _subject;
	
	public String getSubject() {
		return(_subject);
	}
	
	public void setSubject(String arg) {
		_subject = arg;
	} 
	
	private String _note;
	
	public String getNote() {
		return(_note);
	}
	
	public void setNote(String arg) {
		_note = arg;
	} 

	public CannedActionDTO getDto() {
		CannedActionDTO dto = new CannedActionDTO();
		dto.setActive(true);
		
		if (_action == null) {
			_log.error("canned action null action");
			dto.setAction(CannedAction.COMFORT);
		} else {
			CannedAction temp = CannedAction.getInstance(_action);
			if (temp == null) {
				_log.error("canned action bad action");
				dto.setAction(CannedAction.COMFORT);
			} else {
				dto.setAction(CannedAction.COMFORT);
			}
		}
		
		if (_address == null) {
			dto.setAddress(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setAddress(new TrimString(_address));
		}
		
		if (_subject == null) {
			dto.setSubject(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setSubject(new TrimString(_subject));
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
