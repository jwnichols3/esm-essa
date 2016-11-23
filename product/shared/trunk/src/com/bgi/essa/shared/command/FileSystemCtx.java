package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * File system command context (discover file systems).
 *
 * @author gsc
 */
public class FileSystemCtx extends AbstractSamplingCtx {
	
	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.FILE_SYSTEM_SAMPLE_CMD);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 5808337655953708415L;
}