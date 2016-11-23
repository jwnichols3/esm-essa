package com.bgi.essa.jboss4.evaluator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileAgeSampleDTO;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Determine if a file age sample is eligible for alert generation
 * 
 * @author coleguy
 */
public class FileAge implements EvaluatorIf {

	/**
	 * Evaluate a file age sample for alert generation
	 *  
	 * @param arg
	 */
	public FileAge(RuleSample arg) {
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
		FileAgeDTO rule = (FileAgeDTO) _candidate.getRule();
		FileAgeSampleDTO sample = (FileAgeSampleDTO) _candidate.getSample();
		
		//target file does not exist
		if (sample.isExists() == false) {
			return;
		}
		
		int threshold = Math.abs(rule.getThreshold());
		long delta = sample.getTimeStamp().getTimeInMillis() - sample.getModificationTime().getTimeInMillis(); 
		int delta_minutes = (int) (delta/60000);
		
		if (rule.getThreshold() > 0) {
			//older
			if (delta_minutes > threshold) {
				_log.info("file too old");
				ruleMatch(rule, sample);
			}
		} else {
			//newer
			if (delta_minutes <threshold) {
				_log.info("file too new");
				ruleMatch(rule, sample);
			}
		}
	}
	
	/**
	 * 
	 */
	private void ruleMatch(FileAgeDTO rule, FileAgeSampleDTO sample) {
		sample.setMatch(true);
		_bd.saveOrUpdate(sample);
		
		_alert_flag = true;
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
	private final Log _log = LogFactory.getLog(FileAge.class);
}
