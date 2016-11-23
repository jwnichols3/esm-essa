package com.bgi.essa.jboss4.xml;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class DirSizeRule extends AbstractRule {
	
	private String _target;
	
	public String getTarget() {
		return(_target);
	}
	
	public void setTarget(String arg) {
		_target = arg;
	}

	private String _threshold;
	
	public String getThreshold() {
		return(_threshold);
	}
	
	public void setThreshold(String arg) {
		_threshold = arg;
	}
	
	private String _lower;
	
	public String getLower() {
		return(_lower);
	}
	
	public void setLower(String arg) {
		_lower = arg;
	}

	private String _upper;
	
	public String getUpper() {
		return(_upper);
	}
	
	public void setUpper(String arg) {
		_upper = arg;
	}
	
	private String _recursive;
	
	public String getRecursive() {
		return(_recursive);
	}
	
	public void setRecursive(String arg) {
		_recursive = arg;
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
		DirectorySizeDTO dto = new DirectorySizeDTO();
		dto.setActive(true);

		if (note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(note));
		}

		//////////
		
		if (_target == null) {
			_log.error("null target");
			dto.setTarget(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setTarget(new TrimString(_target));
		}
		
		SizeThreshold threshold = null;
		
		if (_threshold == null) {
			_log.error("null threshold");
			dto.setThresholdType(SizeThreshold.GROWTH_NONE);
		} else {
			threshold = SizeThreshold.getInstance(_threshold);
			if (threshold == null) {
				_log.error("bad threshold");
				dto.setThresholdType(SizeThreshold.GROWTH_NONE);
			} else {
				dto.setThresholdType(threshold);
			}
		}
	
		try {
			int itemp = Integer.parseInt(_lower);
			dto.setMinimumThreshold(itemp);
		} catch(Exception exception) {
			_log.error("bad lower threshold");
			dto.setMinimumThreshold(0);
		}
		
		try {
			int itemp = Integer.parseInt(_upper);
			dto.setMaximumThreshold(itemp);
		} catch(Exception exception) {
			_log.error("bad upper threshold");
			dto.setMaximumThreshold(0);
		}
		
		if (_recursive == null) {
			dto.setRecursive(false);
		} else {
			if (_recursive.equals("true")) {
				dto.setRecursive(true);
			} else {
				dto.setRecursive(false);
			}
		}
		
		return(dto);
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
