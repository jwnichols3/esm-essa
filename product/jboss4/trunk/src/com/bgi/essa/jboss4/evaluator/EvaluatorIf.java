package com.bgi.essa.jboss4.evaluator;

/**
 * @author coleguy
 */
public interface EvaluatorIf {
	
	/**
	 * Perform rule/sample evaluation
	 */
	public void testRule();

	/**
	 * Return true if this rule requires an alert.
	 * 
	 * @return true if alert required.
	 */
	public boolean isAlert();
}
