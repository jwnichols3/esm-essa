package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Stub command context.  Test and development only.
 * 
 * @author coleguy
 */
public class BogusCtx extends AbstractEssaCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.BOGUS_CMD);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 7740956478641134511L;
}
