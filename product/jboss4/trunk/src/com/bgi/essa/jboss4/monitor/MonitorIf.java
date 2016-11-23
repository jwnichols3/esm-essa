package com.bgi.essa.jboss4.monitor;

import com.bgi.essa.shared.transfer.AbstractSample;

/**
 * Ancestral parent for monitor classes
 * 
 * @author coleguy
 */
public interface MonitorIf {

	/**
	 * Collect sample
	 * 
	 * @return true if success
	 */
	boolean collectSample();
	
	/**
	 * Return the obtained sample
	 * 
	 * @return populated sample
	 */
	AbstractSample getSample();
}
