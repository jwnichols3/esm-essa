package com.bgi.essa.shared.command;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Parent for context supporting instrumentation samples
 * 
 * @author coleguy
 */
public abstract class AbstractSamplingCtx extends AbstractEssaCtx {
	
	/**
	 * Return rule
	 * 
	 * @return rule
	 */
	public DtoIf getRule() {
		return((DtoIf) get(AbstractEssaCtx.RULE_KEY));
	}
	
	/**
	 * Define rule
	 * 
	 * @param arg rule
	 */
	@SuppressWarnings("unchecked")
	public void setRule(final DtoIf arg) {
		put(AbstractEssaCtx.RULE_KEY, arg);
	}
	
	/**
	 * Return collected sample (if isSuccess() true)
	 * 
	 * @return collected sample (if isSuccess() true)
	 */
	public DtoIf getSample() {
		return((DtoIf) get(AbstractEssaCtx.SAMPLE_KEY));
	}
	
	/**
	 * Define collected sample
	 * 
	 * @param arg collected sample
	 */
	@SuppressWarnings("unchecked")
	public void setSample(final DtoIf arg) {
		put(AbstractEssaCtx.SAMPLE_KEY, arg);
	}
}
