package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Retrieve JNI version string.
 *
 * @author gsc
 */
public class JniVersionCtx extends AbstractEssaCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.JNI_VERSION_CMD);
	}
	
	/**
	 * Return version string
	 * 
	 * @return version string
	 */
	public TrimString getVersion() {
		return((TrimString) get(AbstractEssaCtx.RESULT_KEY));
	}

	/**
	 * Define version string
	 * 
	 * @param arg version string
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setVersion(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
		
		put(AbstractEssaCtx.RESULT_KEY, arg);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -1173371002364716792L;
}