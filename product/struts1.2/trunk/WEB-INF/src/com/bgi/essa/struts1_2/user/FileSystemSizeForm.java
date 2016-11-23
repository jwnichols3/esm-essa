package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSystemSizeDTO;

/**
 * File System Form.
 * 
 * @struts.form 
 *   name="fileSystemSizeForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class FileSystemSizeForm extends AbstractVersionForm {

	/**
	 * empty ctor
	 */
	public FileSystemSizeForm() {
		super();
	}
	
	/**
	 * target name
	 */
	private String _target;

	public String getTarget() {
		return(_target);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setTarget(String arg) {
		if (arg == null) {
			_target = null;
		} else {
			_target = arg.trim();
		}
	}
	
	/**
	 * Alert threshold
	 */
	private String _threshold = "90";

	public String getThreshold() {
		return(_threshold);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setThreshold(String arg) {
		if (arg == null) {
			_threshold = null;
		} else {
			_threshold = arg.trim();
		}
	}
	
	/**
	 * Determine if threshold is for bock or inode
	 */
	private String _threshold_flag = BLOCK;

	/** 
	 * @return BLOCK or INODE
	 */
	public String getThresholdFlag() {
		return(_threshold_flag);
	}

	/**
	 * @param arg BLOCK or INODE
	 */
	public void setThresholdFlag(String arg) {
		_threshold_flag = arg;
	}

	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public FileSystemSizeDTO getValue() {
		FileSystemSizeDTO result = new FileSystemSizeDTO();
		
		getValue(result);
	
		result.setTarget(new TrimString(_target));
		
		if (_threshold_flag.equals(BLOCK)) {
			result.setBlockThreshold(Integer.parseInt(_threshold));
		} else {
			result.setInodeThreshold(Integer.parseInt(_threshold));
		}
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(FileSystemSizeDTO arg) {
		super.setValue(arg);
				
		_target = arg.getTarget().getValue();
		
		if (arg.getBlockThreshold() > 0) {
			_threshold_flag = BLOCK;
			_threshold = Integer.toString(arg.getBlockThreshold());
		} else {
			_threshold_flag = INODE;
			_threshold = Integer.toString(arg.getInodeThreshold());
		}
	}

	/**
	 * Reset all fields
	 */
	@Override
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		row_id = null;
		active_flag = false;
		note = "No Note";
	}

	/**
	 * Form validator
	 */
	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errorz = new ActionErrors();

		if ((_target == null) || (_target.length() < 1)) {
			errorz.add("target", new ActionMessage("fs_size.error.bad_target"));
		}
		
		int threshold = 0;
		
		try {
			threshold = Integer.parseInt(_threshold);
		} catch(Exception exception) {
			//empty
		}
		
		if (threshold < 1) {
			errorz.add("threshold", new ActionMessage("fs_size.error.bad_threshold"));
		}
		
		return(errorz);
	}
	
	public static String BLOCK = "BLOCK";
	public static String INODE = "INODE";

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = 8852058583532623906L;
}