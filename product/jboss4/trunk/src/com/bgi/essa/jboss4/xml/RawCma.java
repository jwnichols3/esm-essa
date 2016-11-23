package com.bgi.essa.jboss4.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;

/**
 * @author coleguy
 */
public class RawCma {
	
	private String _key;
	
	public String getKey() {
		return(_key);
	}
	
	public void setKey(String arg) {
		_key = arg;
	} 
	
	private String _value;
	
	public String getValue() {
		return(_value);
	}
	
	public void setValue(String arg) {
		_value = arg;
	} 
	
	private String _note;
	
	public String getNote() {
		return(_note);
	}
	
	public void setNote(String arg) {
		_note = arg;
	}
	
	public CustomMessageAttributeDTO getDto() {
		CustomMessageAttributeDTO dto = new CustomMessageAttributeDTO();
		dto.setActive(true);
		
		if (_key == null) {
			_log.error("null key");
			dto.setKey(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setKey(new TrimString(_key));
		}
		
		if (_value == null) {
			_log.error("null value");
			dto.setValue(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setValue(new TrimString(_value));
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
