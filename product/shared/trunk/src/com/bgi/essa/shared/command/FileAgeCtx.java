package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * File age sample context
 * 
 * @author coleguy
 */
public class FileAgeCtx extends AbstractSamplingCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.FILE_AGE_SAMPLE_CMD);
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -588403950748114068L;
}
