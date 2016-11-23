package com.bgi.essa.jboss4.xml;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.ProcessOption;
import com.bgi.essa.shared.primitive.ProcessThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class ProcessRule extends AbstractRule {

	private String _option;
	
	public String getOption() {
		return(_option);
	}
	
	public void setOption(String arg) {
		_option = arg;
	}
	
	private String _target;
	
	public String getTarget() {
		return(_target);
	}
	
	public void setTarget(String arg) {
		_target = arg;
	}
	
	private String _type;
	
	public String getType() {
		return(_type);
	}
	
	public void setType(String arg) {
		_type = arg;
	}
	
	private String _duration;
	
	public String getDuration() {
		return(_duration);
	}
	
	public void setDuration(String arg) {
		_duration = arg;
	}

	private String _upper;
	
	public String getUpper() {
		return(_upper);
	}
	
	public void setUpper(String arg) {
		_upper = arg;
	}

	private String _lower;
	
	public String getLower() {
		return(_lower);
	}
	
	public void setLower(String arg) {
		_lower = arg;
	}	
	
	private VpoTree _vpo;
	
	public VpoTree getVpo() {
		return(_vpo);
	}
	
	public void setVpo(VpoTree arg) {
		_vpo = arg;
	}
	
	public VpoDTO getVpoDto() {
		if (_vpo == null) {
			return(null);
		}
		
		return(_vpo.getVpoDto());
	}
	
	public List<CannedActionDTO> getCannedAction() {
		if (_vpo == null) {
			return(null);
		}
		
		return(_vpo.getCannedActionDto());		
	}
	
	public AbstractVersioned getDto() {
		ProcessDTO dto = new ProcessDTO();
		dto.setActive(true);

		if (note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(note));
		}

		// //////////

		if (_target == null) {
			_log.error("null target");
			dto.setTarget(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setTarget(new TrimString(_target));
		}
		
		ProcessOption option = null;
		
		if (_option == null) {
			_log.error("null option");
			dto.setOptionType(ProcessOption.PID);
		} else {
			option = ProcessOption.getInstance(_option);
			if (option == null) {
				_log.error("bad option");
				dto.setOptionType(ProcessOption.PID);
			} else {
				dto.setOptionType(option);
			}
		}
		
		ProcessThreshold threshold = null;
		
		if (_type == null) {
			_log.error("null type");
			dto.setThresholdType(ProcessThreshold.ALWAYS_RUN);
		} else {
			threshold = ProcessThreshold.getInstance(_type);
			if (threshold == null) {
				_log.error("bad threshold");
				dto.setThresholdType(ProcessThreshold.ALWAYS_RUN);
			} else {
				dto.setThresholdType(threshold);
			}
		}
		
		try {
			dto.setMinimumPopulation(Integer.parseInt(_lower));
		} catch (Exception exception) {
			_log.error("bad min pop");
			dto.setMinimumPopulation(0);
		}
		
		try {
			dto.setMaximumPopulation(Integer.parseInt(_upper));
		} catch (Exception exception) {
			_log.error("bad max pop");
			dto.setMaximumPopulation(0);
		}
		
		try {
			dto.setMaximumTime(Integer.parseInt(_duration));
		} catch (Exception exception) {
			_log.error("bad duration");
			dto.setMaximumTime(0);
		}

		return(dto);
	}

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
