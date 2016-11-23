package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.shared.command.FileSampleCtx;

import com.bgi.essa.shared.transfer.FileSampleDTO;

/**
 * Examine the specified file by using the JMX based "FileWrapper"
 *
 * @author gsc
 */
public class FileSampleCmd implements EssaCmd {

	/**
	 * Service the FileSample command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("file sample execute");
		
		final FileSampleCtx ctx = (FileSampleCtx) arg;
		
		final JmxFacade facade = new JmxFacade();
		final FileSampleDTO dto = facade.getFileSample(ctx.getName());
		
		if (dto == null) {
			_log.info("setSuccess false");
			ctx.setSuccess(false);
		} else {
			_log.info("setSuccess true");
			ctx.setSuccess(true);
			ctx.setSample(dto);
		}
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSampleCmd.class);
}