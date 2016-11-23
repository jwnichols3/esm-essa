package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.SizeThreshold;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;

import com.bgi.essa.struts1_2.utility.OptionStunt;
import com.bgi.essa.struts1_2.utility.SizeThresholdOptionBean;

/**
 * Directory Size Form.
 * 
 * @struts.form 
 *   name="directorySizeForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class DirectorySizeForm extends AbstractVersionForm {
	
	/**
	 * empty ctor
	 */
	public DirectorySizeForm() {
		super();
		
		_option_bean = new SizeThresholdOptionBean(OptionStunt.NONE);
		_option_array = _option_bean.getCandidates();
	}

	/**
	 * directory name
	 */
	private String _directory;

	public String getDirectory() {
		return(_directory);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setDirectory(String arg) {
		if (arg == null) {
			_directory = null;
		} else {
			_directory = arg.trim();
		}
	}
	
	/**
	 * Minimum threshold
	 */
	private String _min_threshold = "0";

	public String getMinThreshold() {
		return(_min_threshold);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setMinThreshold(String arg) {
		if (arg == null) {
			_min_threshold = null;
		} else {
			_min_threshold = arg.trim();
		}
	}

	/**
	 * Maximum threshold
	 */
	private String _max_threshold = "0";

	public String getMaxThreshold() {
		return(_max_threshold);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setMaxThreshold(String arg) {
		if (arg == null) {
			_max_threshold = null;
		} else {
			_max_threshold = arg.trim();
		}
	}
	
	/**
	 * Return true, recursive directories
	 */
	private boolean _recursive = false;

	/**
	 * Return true, visit child directories
	 * 
	 * @return true, visit child directories
	 */
	public boolean getRecursive() {
		return(_recursive);
	}

	/**
	 * Return true, visit child directories
	 * 
	 * @return true, visit child directories
	 */
	public boolean isRecursive() {
		return(_recursive);
	}

	/**
	 * Define if recursive directory
	 * 
	 * @param arg true, visit child directories
	 * 
	 * @struts.validator 
	 *   type="required"
	 */
	public void setRecursive(boolean arg) {
		_recursive = arg;
	}
	
	/**
	 * size threshold drop down
	 */
	private SizeThresholdOptionBean _option_bean;
	
	private SizeThresholdOptionBean.CandidateBean[] _option_array;
	
	public SizeThresholdOptionBean.CandidateBean[] getOptionArray() {
		return(_option_array);
	}
	
	/**
	 * option bean selection index
	 */
	private int _option_ndx;
	
	/**
	 * Return option bean index selection
	 * 
	 * @return option bean index selection
	 */
	public int getOptionNdx() {
		return(_option_ndx);
	}
	
	/**
	 * Define option bean index selection
	 * 
	 * @param arg option bean index selection
	 */
	public void setOptionNdx(int arg) {
		_option_ndx = arg;
	}
	
	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public DirectorySizeDTO getValue() {
		DirectorySizeDTO result = new DirectorySizeDTO();
		
		getValue(result);

		result.setTarget(stringTweaker1(_directory, null));
		result.setRecursive(_recursive);
		
		SizeThresholdOptionBean.CandidateBean temp1 = _option_bean.getCandidate(_option_ndx);
		result.setThresholdType((SizeThreshold) temp1.getPayload());
		
		if (result.getThresholdType().equals(SizeThreshold.FIXED_DECREASING)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(0);
		} else if (result.getThresholdType().equals(SizeThreshold.FIXED_INCREASING)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(0);
		} else if (result.getThresholdType().equals(SizeThreshold.GROWTH_DECREASING)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(0);
		} else if (result.getThresholdType().equals(SizeThreshold.GROWTH_INCREASING)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(0);
		} else if (result.getThresholdType().equals(SizeThreshold.GROWTH_NONE)) {
			result.setMinimumThreshold(0);
			result.setMaximumThreshold(0);
		} else if (result.getThresholdType().equals(SizeThreshold.RANGE_EXCLUSIVE)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(Integer.parseInt(_max_threshold));
		} else if (result.getThresholdType().equals(SizeThreshold.RANGE_INCLUSIVE)) {
			result.setMinimumThreshold(Integer.parseInt(_min_threshold));
			result.setMaximumThreshold(Integer.parseInt(_max_threshold));
		}
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(DirectorySizeDTO arg) {
		super.setValue(arg);
		
		_directory = stringTweaker2(arg.getTarget());
		_recursive = arg.isRecursive();
		
		SizeThresholdOptionBean.CandidateBean temp1 = _option_bean.getCandidate(arg.getThresholdType());
		_option_ndx = temp1.getNdx();
		
		_min_threshold = Integer.toString(arg.getMinimumThreshold());
		_max_threshold = Integer.toString(arg.getMaximumThreshold());
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

		if ((_directory == null) || (_directory.length() < 1)) {
			errorz.add("directory", new ActionMessage("directory_size.error.bad_name"));
		}
		
		int temp1 = 0;
		int temp2 = 0;
		
		try {
			temp1 = Integer.parseInt(_min_threshold);
			temp2 = Integer.parseInt(_max_threshold);
		} catch(Exception exception) {
			exception.printStackTrace();
			
			temp1 = -1;
			temp2 = -1;
		}
	
		SizeThresholdOptionBean.CandidateBean bean = _option_bean.getCandidate(_option_ndx);
		if (bean.getPayload().equals(SizeThreshold.FIXED_DECREASING)) {
			if (temp1 < 0) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_fixed"));
			}
		} else if (bean.getPayload().equals(SizeThreshold.FIXED_INCREASING)) {
			if (temp1 < 0) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_fixed"));
			}
		} else if (bean.getPayload().equals(SizeThreshold.GROWTH_DECREASING)) {
			if (temp1 < 0) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_growth"));
			}
		} else if (bean.getPayload().equals(SizeThreshold.GROWTH_INCREASING)) {
			if (temp1 < 0) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_growth"));
			}
		} else if (bean.getPayload().equals(SizeThreshold.GROWTH_NONE)) {
			//empty
		} else if (bean.getPayload().equals(SizeThreshold.RANGE_EXCLUSIVE)) {
			if ((temp1 < 0) || (temp2 < 0)) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_range"));
			}
		} else if (bean.getPayload().equals(SizeThreshold.RANGE_INCLUSIVE)) {
			if ((temp1 < 0) || (temp2 < 0)) {
				errorz.add("min", new ActionMessage("directory_size.error.bad_range"));
			}
		}

		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = 8830709351621988863L;
}