package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
//import org.apache.struts.action.ActionMessage;

import com.bgi.essa.shared.primitive.ProcessOption;
import com.bgi.essa.shared.primitive.ProcessThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.ProcessDTO;

import com.bgi.essa.struts1_2.utility.OptionStunt;
import com.bgi.essa.struts1_2.utility.ProcessOptionBean;
import com.bgi.essa.struts1_2.utility.ProcessThresholdOptionBean;

/**
 * Process Form.
 * 
 * @struts.form 
 *   name="processForm"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class ProcessForm extends AbstractVersionForm {

	/**
	 * empty ctor
	 */
	public ProcessForm() {
		super();

		_option_bean = new ProcessOptionBean(OptionStunt.NONE);
		_option_array = _option_bean.getCandidates();
		
		_threshold_bean = new ProcessThresholdOptionBean(OptionStunt.NONE);
		_threshold_array = _threshold_bean.getCandidates();
	}
	
	/**
	 * target
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
	 * Maximum threshold CPU time
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
	 * Minimum population
	 */
	private String _min_population = "0";

	public String getMinPopulation() {
		return(_min_population);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setMinPopulation(String arg) {
		if (arg == null) {
			_min_population = null;
		} else {
			_min_population = arg.trim();
		}
	}

	/**
	 * Maximum population
	 */
	private String _max_population = "0";

	public String getMaxPopulation() {
		return(_max_population);
	}

	/**
	 * @struts.validator 
	 *   type="required"
	 */
	public void setMaxPopulation(String arg) {
		if (arg == null) {
			_max_population = null;
		} else {
			_max_population = arg.trim();
		}
	}
	
	/**
	 *  option drop down
	 */
	private ProcessOptionBean _option_bean;
	
	private ProcessOptionBean.CandidateBean[] _option_array;
	
	public ProcessOptionBean.CandidateBean[] getOptionArray() {
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
	 *  threshold drop down
	 */
	private ProcessThresholdOptionBean _threshold_bean;
	
	private ProcessThresholdOptionBean.CandidateBean[] _threshold_array;
	
	public ProcessThresholdOptionBean.CandidateBean[] getThresholdArray() {
		return(_threshold_array);
	}
	
	/**
	 * threshold bean selection index
	 */
	private int _threshold_ndx;
	
	/**
	 * Return threshold bean index selection
	 * 
	 * @return threshold bean index selection
	 */
	public int getThresholdNdx() {
		return(_threshold_ndx);
	}
	
	/**
	 * Define threshold bean index selection
	 * 
	 * @param arg threshold bean index selection
	 */
	public void setThresholdNdx(int arg) {
		_threshold_ndx = arg;
	}

	/**
	 * Return task values
	 * 
	 * @return task values
	 */
	public ProcessDTO getValue() {
		ProcessDTO result = new ProcessDTO();
		
		getValue(result);

		result.setTarget(new TrimString(_target));
		
		ProcessOptionBean.CandidateBean temp1 = _option_bean.getCandidate(_option_ndx);
		result.setOptionType((ProcessOption) temp1.getPayload());
		
		ProcessThresholdOptionBean.CandidateBean temp2 = _threshold_bean.getCandidate(_threshold_ndx);
		result.setThresholdType((ProcessThreshold) temp2.getPayload());
		
		if (result.getThresholdType().equals(ProcessThreshold.CPU_MAX_TIME)) {
			result.setMaximumTime(Integer.parseInt(_max_threshold));
		} else {
			result.setMaximumTime(0);
		}
			
		result.setMaximumPopulation(Integer.parseInt(_max_population));
		result.setMinimumPopulation(Integer.parseInt(_min_population));
		
		return(result);
	}

	/**
	 * Define task values
	 * 
	 * @param arg values to copy
	 */
	public void setValue(ProcessDTO arg) {
		super.setValue(arg);
		
		_target = arg.getTarget().getValue();
		
		ProcessOptionBean.CandidateBean temp1 = _option_bean.getCandidate(arg.getOptionType());
		_option_ndx = temp1.getNdx();
		
		ProcessThresholdOptionBean.CandidateBean temp2 = _threshold_bean.getCandidate(arg.getThresholdType());
		_threshold_ndx = temp2.getNdx();
		
		if (arg.getThresholdType().equals(ProcessThreshold.CPU_MAX_TIME)) {
			_max_threshold = Integer.toString(arg.getMaximumTime());
		} 
		
		_min_population = Integer.toString(arg.getMinimumPopulation());
		_max_population = Integer.toString(arg.getMaximumPopulation());
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
			errorz.add("target", new ActionMessage("process.error.bad_target"));
		}
		
		int temp1 = 0;
		
		try {
			temp1 = Integer.parseInt(_min_population);
			temp1 = Integer.parseInt(_max_population);
			temp1 = Integer.parseInt(_max_threshold);
		} catch(Exception exception) {
			exception.printStackTrace();
			temp1 = -1;
		}
		
		ProcessThresholdOptionBean.CandidateBean bean = _threshold_bean.getCandidate(_threshold_ndx);
		if (bean.getPayload().equals(ProcessThreshold.CPU_MAX_TIME)) {
			if (temp1 < 0) {
				errorz.add("threshold", new ActionMessage("process.error.bad_min_max"));
			}
		} 
		
		return(errorz);
	}

	/**
	 * Eclipse generated version ID
	 */
	private static final long serialVersionUID = 1286173805198106413L;
}