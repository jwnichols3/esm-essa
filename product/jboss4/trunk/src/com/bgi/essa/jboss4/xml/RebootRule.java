package com.bgi.essa.jboss4.xml;

import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class RebootRule extends AbstractRule {
	
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
		BootTimeDTO dto = new BootTimeDTO();
		dto.setActive(true);
		
		if (note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(note));
		}

		return(dto);
	}	
	
	/**
	 * Define logger
	 */
	//private final Log _log = LogFactory.getLog(getClass());
}
