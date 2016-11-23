package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * ps(1) sample
 * 
 * @author coleguy
 */
public class ProcessCtx extends AbstractSamplingCtx {

	/**
	 * Return command definition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.PROCESS_SAMPLE_CMD);
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8473115732977316254L;
}
