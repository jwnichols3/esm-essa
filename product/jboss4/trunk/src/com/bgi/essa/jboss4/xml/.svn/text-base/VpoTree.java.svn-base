package com.bgi.essa.jboss4.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * VPO container
 * 
 * @author coleguy
 */
public class VpoTree {
	
	public VpoTree() {
		System.out.println("vpo tree ctor");
	}
	
	private String _name;
	
	public String getApplicationName() {
		return(_name);
	}
	
	public void setApplicationName(String arg) {
		_name = arg;
	}
	
	private String _severity;
	
	public String getSeverity() {
		return(_severity);
	}
	
	public void setSeverity(String arg) {
		_severity = arg;
	}
	
	private String _retry;
	
	public String getRetryInterval() {
		return(_retry);
	}
	
	public void setRetryInterval(String arg) {
		_retry = arg;
	}

	private String _message;
	
	public String getMessage() {
		return(_message);
	}
	
	public void setMessage(String arg) {
		_message = arg;
	}
	
	private String _source;
	
	public String getSource() {
		return(_source);
	}
	
	public void setSource(String arg) {
		_source = arg;
	}

	/**
	 * Return collected actions.
	 * 
	 * @return collected actions
	 */
	public List<RawCannedAction> getCannedAction() {
		return(_action_list);
	}
	
	/**
	 * Add new action
	 * 
	 * @param arg fresh action
	 */
	public void addCannedAction(RawCannedAction arg) {
		System.out.println("canned action add");
		_action_list.add(arg);
	}
	
	private List<RawCannedAction> _action_list = new ArrayList<RawCannedAction>();
	
	/**
	 * Convert to DTO
	 * 
	 * @return convert to list
	 */
	public List<CannedActionDTO> getCannedActionDto() {
		ArrayList<CannedActionDTO> result = new ArrayList<CannedActionDTO>();
		
		Iterator<RawCannedAction> ii = _action_list.iterator();
		while (ii.hasNext()) {
			RawCannedAction temp = ii.next();
			result.add(temp.getDto());
		}
		
		return(result);
	}
	
	/**
	 * Return parsed DTO
	 * 
	 * @return parsed DTO
	 */
	public VpoDTO getVpoDto() {
		VpoDTO dto = new VpoDTO();
		
		if (_name == null) {
			_log.error("vpo null application name");
			dto.setAppName(ApplicationName.ESM);
		} else {
			ApplicationName temp = ApplicationName.getInstance(_name);
			if (temp == null) {
				_log.error("vpo bad application name");
				dto.setAppName(ApplicationName.ESM);
			} else {
				dto.setAppName(temp);
			}
		}
			
		if (_severity == null) {
			_log.error("vpo null severity");
			dto.setSeverity(Severity.NORMAL);
		} else {
			Severity temp = Severity.getInstance(_severity);
			if (temp == null) {
				_log.error("vpo bad severity");
				dto.setSeverity(Severity.NORMAL);
			} else {
				dto.setSeverity(temp);
			}
		}		
		
		int itemp = 0;
		
		try {
			itemp = Integer.parseInt(_retry);
		} catch(Exception exception) {
			_log.error("bad retry interval");
		}
		
		if (itemp < ConstantsIf.MIN_RETRY_FREQUENCY) {
			itemp = ConstantsIf.MIN_RETRY_FREQUENCY;
		}
		
		dto.setFrequency(itemp);
		
		if (_message == null) {
			dto.setMessage(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setMessage(new TrimString(_message));
		}
		
		if (_source == null) {
			dto.setSourceHost(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setSourceHost(new TrimString(_source));
		}

		return(dto);
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
