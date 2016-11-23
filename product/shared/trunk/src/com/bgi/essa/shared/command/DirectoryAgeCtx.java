package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * File age sample context
 * 
 * @author linden
 */
public class DirectoryAgeCtx extends AbstractSamplingCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.DIRECTORY_AGE_SAMPLE_CMD);
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -588403950748114069L;
}
