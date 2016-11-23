package com.bgi.essa.jboss4.xml;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class FileSystemSizeRule extends AbstractRule {
	
	private String _fs;
	
	public String getFileSystem() {
		return(_fs);
	}
	
	public void setFileSystem(String arg) {
		_fs = arg;
	}
	
	private String _block;
	
	public String getBlock() {
		return(_block);
	}
	
	public void setBlock(String arg) {
		_block = arg;
	}
	
	private String _inode;
	
	public String getInode() {
		return(_inode);
	}
	
	public void setInode(String arg) {
		_inode = arg;
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
		FileSystemSizeDTO dto = new FileSystemSizeDTO();
		dto.setActive(true);

		if (note == null) {
			dto.setNote(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setNote(new TrimString(note));
		}

		// //////////

		if (_fs == null) {
			_log.error("null target");
			dto.setTarget(new TrimString(ConstantsIf.EMPTY_STRING));
		} else {
			dto.setTarget(new TrimString(_fs));
		}
		
		try {
			dto.setBlockThreshold(Integer.parseInt(_block));
		} catch (Exception exception) {
			_log.error("bad block threshold");
			dto.setBlockThreshold(0);
		}
		
		try {
			dto.setInodeThreshold(Integer.parseInt(_inode));
		} catch (Exception exception) {
			_log.error("bad inode threshold");
			dto.setInodeThreshold(0);
		}

		return(dto);
	}

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
