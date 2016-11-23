package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * File sample command context.
 *
 * @author gsc
 */
public class FileSampleCtx extends AbstractSamplingCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.FILE_SAMPLE_CMD);
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
	private static final long serialVersionUID = 5695222145775864781L;
}