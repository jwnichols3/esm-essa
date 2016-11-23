package com.bgi.essa.jboss4.evaluator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeSampleDTO;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Determine if a file system size sample is eligible for alert generation
 * 
 * @author coleguy
 */
public class FileSystemSize implements EvaluatorIf {
	
	/**
	 * Evaluate a file size sample for alert generation
	 * 
	 * @param arg
	 */
	public FileSystemSize(RuleSample arg) {
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
		FileSystemSizeDTO rule = (FileSystemSizeDTO) _candidate.getRule();
		FileSystemSizeSampleDTO sample = (FileSystemSizeSampleDTO) _candidate.getSample();
		
		//target file does not exist
		if (sample.isExists() == false) {
			return;
		}
		
		if (rule.getBlockThreshold() > 0) {
			if (sample.getBlockPercentage() > rule.getBlockThreshold()) {
				_log.info("over block allocation");
				ruleMatch(rule, sample);
			}
		}
		
		if (rule.getInodeThreshold() > 0) {
			if (sample.getInodePercentage() > rule.getInodeThreshold()) {
				_log.info("over inode allocation");
				ruleMatch(rule, sample);
			}
		}
	}

	/**
	 * 
	 */
	private void ruleMatch(FileSystemSizeDTO rule, FileSystemSizeSampleDTO sample) {
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
	private final Log _log = LogFactory.getLog(FileSystemSize.class);
}
