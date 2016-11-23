package com.bgi.essa.jboss4.evaluator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.ProcessThreshold;

import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.ProcessSampleDTO;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Determine if a process sample is eligible for alert generation
 * 
 * @author coleguy
 */
public class Process implements EvaluatorIf {

	/**
	 * Evaluate a process sample for alert generation
	 * 
	 * @param arg
	 */
	public Process(RuleSample arg) {
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
		ProcessDTO rule = (ProcessDTO) _candidate.getRule();
		ProcessSampleDTO sample = (ProcessSampleDTO) _candidate.getSample();
	
		if (rule.getThresholdType().equals(ProcessThreshold.ALWAYS_RUN)) {
			if (sample.getPopulation() < 1) {
				ruleMatch(rule, sample);
			}
			
			if (sample.getPopulation() < rule.getMinimumPopulation()) {
				ruleMatch(rule, sample);
			}
			
			if (sample.getPopulation() > rule.getMaximumPopulation()) {
				ruleMatch(rule, sample);
			}
		} else if (rule.getThresholdType().equals(ProcessThreshold.CPU_MAX_TIME)) {
			if (sample.getCpuTime() > rule.getMaximumTime()) {
				ruleMatch(rule, sample);
			}
			
			if (sample.getPopulation() < rule.getMinimumPopulation()) {
				ruleMatch(rule, sample);
			}
			
			if (sample.getPopulation() > rule.getMaximumPopulation()) {
				ruleMatch(rule, sample);
			}
		} else if (rule.getThresholdType().equals(ProcessThreshold.NEVER_RUN)) {
			if (sample.getPopulation() > 0) {
				ruleMatch(rule, sample);
			}
		} else {
			_log.error("unknown threshold type:" + rule.getThresholdType());
		}
	}
	
	/**
	 * 
	 */
	private void ruleMatch(ProcessDTO rule, ProcessSampleDTO sample) {
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
	private final Log _log = LogFactory.getLog(Process.class);
}
