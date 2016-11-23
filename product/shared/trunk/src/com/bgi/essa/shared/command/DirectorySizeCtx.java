package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Directory size sample context
 * 
 * @author coleguy
 */
public class DirectorySizeCtx extends AbstractSamplingCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.DIR_SIZE_SAMPLE_CMD);
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -9000024521019443912L;
}
