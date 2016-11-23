package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Ping test command context.
 *
 * @author gsc
 */
public class PingCtx extends AbstractEssaCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.PING_CMD);
	}

	/**
	 * Return true, this sample should be written to hibernate
	 * 
	 * @return true, this sample should be written to hibernate
	 */
	public boolean isFlag() {
		Boolean temp = (Boolean) get(AbstractEssaCtx.FLAG_KEY);
		return(temp.booleanValue());
	}
	
	/**
	 * Define if this sample should be written to hibernate
	 * 
	 * @param arg true, this sample should be written to hibernate
	 */
	@SuppressWarnings("unchecked")
	public void setFlag(final boolean arg) {
		put(AbstractEssaCtx.FLAG_KEY, new Boolean(arg));
	}

	/**
	 * Define flag value
	 * 
	 * @param arg flag value
	 */
	@SuppressWarnings("unchecked")
	public void setFlag(Boolean arg) {
		put(AbstractEssaCtx.FLAG_KEY, arg);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -3451625256513149159L;
}