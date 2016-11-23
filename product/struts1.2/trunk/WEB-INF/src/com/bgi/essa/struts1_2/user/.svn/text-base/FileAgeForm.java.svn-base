package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.FileAgeOption;

import com.bgi.essa.shared.transfer.FileAgeDTO;

/**
 * File Age Form.
 * 
 * @struts.form 
 *   name="fileAgeForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class FileAgeForm extends AbstractVersionForm {
	
	/**
	 * empty ctor
	 */
	public FileAgeForm() {
		super();
	}

	/**
	 * directory name
	 */
	private String _directory_name;

	public String getDirectoryName() {
		return(_directory_name);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setDirectoryName(String arg) {
		if (arg == null) {
			_directory_name = null;
		} else {
			_directory_name = arg.trim();
		}
	}

	/**
	 * file name
	 */
	private String _file_name;

	public String getFileName() {
		return(_file_name);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setFileName(String arg) {
		if (arg == null) {
			_file_name = null;
		} else {
			_file_name = arg.trim();
		}
	}
	
	/**
	 * Sample threshold
	 */
	private String _threshold;

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
	 * older/newer option
	 */
	private String _age_option = "OLDER";

	public String getAgeOption() {
		return(_age_option);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setAgeOption(String arg) {
		if (arg == null) {
			_age_option = null;
		} else {
			_age_option = arg.trim();
		}
	}
	
	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public FileAgeDTO getValue() {
		FileAgeDTO result = new FileAgeDTO();
		
		getValue(result);
		
		result.setFileName(stringTweaker1(_file_name, null));
		result.setDirectory(stringTweaker1(_directory_name, null));
		
		result.setThreshold(Integer.parseInt(_threshold));
		result.setFileAgeOption(FileAgeOption.SINGLE);
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(FileAgeDTO arg) {
		super.setValue(arg);
		
		_directory_name = stringTweaker2(arg.getDirectory());
		_file_name = stringTweaker2(arg.getFileName());
		
		_threshold = arg.getAbsThreshold();
		
		if (arg.getOlderNewer().equals("Newer")) {
			_age_option = "NEWER";
		} else {
			_age_option = "OLDER";
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

		if ((_file_name == null) || (_file_name.length() < 1)) {
			errorz.add("name", new ActionMessage("file_age.error.bad_name"));
		}
		
		int temp = 0;
		
		try {
			temp = Integer.parseInt(_threshold);
			
			if (temp < 1) {
				errorz.add("threshold", new ActionMessage("file_age.error.bad_threshold"));
			}
		} catch(Exception exception) {
			errorz.add("threshold", new ActionMessage("file_age.error.bad_threshold"));
		}

		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = 8845911974356208092L;
}