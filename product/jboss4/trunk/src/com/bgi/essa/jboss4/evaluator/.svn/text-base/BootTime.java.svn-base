package com.bgi.essa.jboss4.evaluator;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Determine if a boot time sample is eligible for alert generation.
 * 
 * @author coleguy
 */
public class BootTime implements EvaluatorIf {

	/**
	 * 
	 * @param arg
	 */
	public BootTime(RuleSample arg) {
		if (arg == null) {
			throw new NullPointerException("null arg");
		}
		
		_candidate = arg;
	}
	
	/**
	 * Return true if this rule requires an alert.
	 * 
	 * @return true if alert required.
	 */
	public boolean isAlert() {
		return(_alert_flag);
	}
		
	/**
	 * Perform rule/sample evaluation
	 */
	public void testRule() {
		BootTimeDTO rule = (BootTimeDTO) _candidate.getRule();
		BootTimeSampleDTO sample = (BootTimeSampleDTO) _candidate.getSample();
		
		if (rule != null) {
			//just to pacify eclipse warning
		}
		
		BootTimeSampleDTO almost_last = getAlmostLastSample(sample);
		if (almost_last == null) {
			return;
		}
		
		long boot_time1 = sample.getBootTime().getTimeInMillis();
		long boot_time2 = almost_last.getBootTime().getTimeInMillis();
		
		if (boot_time1 != boot_time2) {
			_log.info("reboot match");
			ruleMatch(rule, sample);
		}
	}
	
	/**
	 * 
	 */
	private void ruleMatch(BootTimeDTO rule, BootTimeSampleDTO sample) {
		sample.setMatch(true);
		_bd.saveOrUpdate(sample);
		
		_alert_flag = true;
	}

	/**
	 * Return the "next to last" sample (I already know the "last" sample)
	 * 
	 * @param sample "last" sample
	 * @return "next to last" sample or null if not found
	 */
	private BootTimeSampleDTO getAlmostLastSample(BootTimeSampleDTO sample) {
		BootTimeSampleDTO result = null;
		
		List<DtoIf> list = _bd.selectByKey(sample, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			return(result);
		}
		
		Iterator<DtoIf> ii = list.iterator();
		while (ii.hasNext()) {
			BootTimeSampleDTO temp = (BootTimeSampleDTO) ii.next();
			if (temp.getRuleRowId().equals(sample.getRuleRowId())) {
				if (temp.getRowId().equals(sample.getRowId())) {
					//empty
				} else {
					result = temp;
				}
			}
		}
		
		return(result);
	}

	/**
	 * True, sample matched rule and requires an alert.
	 */
	private boolean _alert_flag = false;
	
	/**
	 * Sample and Rule
	 */
	private RuleSample _candidate;
		
	/**
	 * Command dispatch
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(BootTime.class);
}
