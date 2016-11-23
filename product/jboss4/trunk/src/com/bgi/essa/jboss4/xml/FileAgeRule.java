package com.bgi.essa.jboss4.xml;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FileAgeOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class FileAgeRule extends AbstractRule {
	
	private String _file;
	
	public String getFile() {
		return(_file);
	}
	
	public void setFile(String arg) {
		_file = arg;
	}
	
	private String _threshold;
	
	public String getThreshold() {
		return(_threshold);
	}
	
	public void setThreshold(String arg) {
		_threshold = arg;
	}
	
	private String _older;
	
	public String getOlder() {
		return(_older);
	}
	
	public void setOlder(String arg) {
		_older = arg;
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
		FileAgeDTO dto = new FileAgeDTO();
		dto.setActive(true);
		
		if (note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(note));
		}
		
		////////////
		
		if (_file == null) {
			_log.error("null file");
			dto.setFileName(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setFileName(new TrimString(_file));
		}
		
		
		FileAgeOption option = null;
		
		if (_older == null) {
			_log.error("null older");
			dto.setFileAgeOption(FileAgeOption.SINGLE);
		} else {
			option = FileAgeOption.getInstance(_older);
			if (option == null) {
				_log.error("bad option");
				dto.setFileAgeOption(FileAgeOption.SINGLE);
			} else {
				dto.setFileAgeOption(option);
			}
		}
		
		try {
			dto.setThreshold(Integer.parseInt(_threshold));
		} catch(Exception exception) {
			_log.error("bad threshold");
			dto.setThreshold(0);
		}
		
		return(dto);
	}	
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
