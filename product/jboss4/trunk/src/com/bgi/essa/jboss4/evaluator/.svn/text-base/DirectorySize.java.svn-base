package com.bgi.essa.jboss4.evaluator;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.SizeThreshold;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.RuleSample;

/**
 * Determine if a directory size sample is eligible for alert generation
 * 
 * @author coleguy
 */
public class DirectorySize implements EvaluatorIf {
	
	/**
	 * Evaluate a directory size sample for alert generation
	 * 
	 * @param arg
	 */
	public DirectorySize(RuleSample arg) {
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
		DirectorySizeDTO rule = (DirectorySizeDTO) _candidate.getRule();
		DirectorySizeSampleDTO sample = (DirectorySizeSampleDTO) _candidate.getSample();
		
		//target file does not exist
		if (sample.isExists() == false) {
			return;
		}
		
		if (rule.getThresholdType().equals(SizeThreshold.RANGE_EXCLUSIVE)) {
			serviceRangeExclusive(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.RANGE_INCLUSIVE)) {
			serviceRangeInclusive(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.FIXED_DECREASING)) {
			serviceFixedDecreasing(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.FIXED_INCREASING)) {
			serviceFixedIncreasing(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.GROWTH_DECREASING)) {
			serviceGrowthDecreasing(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.GROWTH_INCREASING)) {
			serviceGrowthIncreasing(rule, sample); 
		} else if (rule.getThresholdType().equals(SizeThreshold.GROWTH_NONE)) {
			serviceGrowthNone(rule, sample); 
		} else {
			_log.error("unknown threshold type:" + rule.getThresholdType());
		}
	}
	
	/**
	 * Match if sample is not within specified range
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceRangeExclusive(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		long min = rule.getMinimumThreshold() * 1000; //rule in KB
		long max = rule.getMaximumThreshold() * 1000; //rule in KB
		long candidate = sample.getBytePopulation();  //sample in bytes
		
		if ((candidate > min) && (candidate < max)) {
			return;
		}
			
		_log.info("range exclusive match");
		ruleMatch(rule, sample);
	}
	
	/**
	 * Match if sample falls within specified range
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceRangeInclusive(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		long min = rule.getMinimumThreshold() * 1000; //rule in KB
		long max = rule.getMaximumThreshold() * 1000; //rule in KB
		long candidate = sample.getBytePopulation();  //sample in bytes
		
		if ((candidate < min) || (candidate > max)) {
			return;
		}
			
		_log.info("range inclusive match");
		ruleMatch(rule, sample);
	}

	/**
	 * Match if sample is below threshold
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceFixedDecreasing(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		long min = rule.getMinimumThreshold() * 1000; //rule in KB
		long candidate = sample.getBytePopulation();  //sample in bytes

		if (candidate < min) {
			_log.info("decreasing match");
			ruleMatch(rule, sample);
		}
	}

	/**
	 * Match if sample is above threshold
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceFixedIncreasing(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		long min = rule.getMinimumThreshold() * 1000; //rule in KB
		long candidate = sample.getBytePopulation();  //sample in bytes

		if (candidate > min) {
			_log.info("increasing match");
			ruleMatch(rule, sample);
		}
	}
	
	/**
	 * Match if sample has shrunk between samples 
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceGrowthDecreasing(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		DirectorySizeSampleDTO almost_last = getAlmostLastSample(sample);
		if (almost_last == null) {
			return;
		}
		
		long threshold = rule.getMinimumThreshold() * 1000; //rule in KB
		long delta = sample.getBytePopulation() - almost_last.getBytePopulation();
		if (delta < threshold) {
			_log.info("growth increasing match");
			ruleMatch(rule, sample);
		}
	}

	/**
	 * Match if sample has grown between samples 
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceGrowthIncreasing(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		DirectorySizeSampleDTO almost_last = getAlmostLastSample(sample);
		if (almost_last == null) {
			return;
		}
		
		long threshold = rule.getMinimumThreshold() * 1000; //rule in KB
		long delta = sample.getBytePopulation() - almost_last.getBytePopulation();
		
		if (delta > threshold) {
			_log.info("growth increasing match");
			ruleMatch(rule, sample);
		}
	}

	/**
	 * Match if sample size has remained constant 
	 * 
	 * @param rule rule
	 * @param sample sample
	 */
	private void serviceGrowthNone(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
		DirectorySizeSampleDTO almost_last = getAlmostLastSample(sample);
		if (almost_last == null) {
			return;
		}
		
		if (almost_last.getBytePopulation() == sample.getBytePopulation()) {
			_log.info("no growth match");
			ruleMatch(rule, sample);
		}
	}
	
	/**
	 * 
	 */
	private void ruleMatch(DirectorySizeDTO rule, DirectorySizeSampleDTO sample) {
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
	private DirectorySizeSampleDTO getAlmostLastSample(DirectorySizeSampleDTO sample) {
		DirectorySizeSampleDTO result = null;
		
		List<DtoIf> list = _bd.selectByKey(sample, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			return(result);
		}
		
		Iterator<DtoIf> ii = list.iterator();
		while (ii.hasNext()) {
			DirectorySizeSampleDTO temp = (DirectorySizeSampleDTO) ii.next();
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
	private final Log _log = LogFactory.getLog(DirectorySize.class);
}
