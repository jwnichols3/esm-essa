package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Retrieve StatVfs results
 *
 * @author gsc
 */
public class JniStatVfsCtx extends AbstractSamplingCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.JNI_STAT_VFS_CMD);
	}

	/**
	 * Return candidate name
	 * 
	 * @return candidate name
	 */
	public TrimString getName() {
		return((TrimString) get(AbstractEssaCtx.NAME_KEY));
	}

	/**
	 * Define candidate name
	 * 
	 * @param arg candidate name
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setName(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
		
		put(AbstractEssaCtx.NAME_KEY, arg);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -3731922869263459712L;
}