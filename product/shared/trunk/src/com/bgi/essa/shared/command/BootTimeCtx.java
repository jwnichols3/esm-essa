package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Retrieve system boot time via JNI.
 *
 * @author gsc
 */
public class BootTimeCtx extends AbstractSamplingCtx {
		
	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.BOOT_TIME_SAMPLE_CMD);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -2543066084449377264L;
}