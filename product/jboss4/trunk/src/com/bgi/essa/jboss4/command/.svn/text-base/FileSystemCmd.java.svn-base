package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.shared.command.FileSystemCtx;

/**
 * Discover file systems
 *
 * @author gsc
 */
public class FileSystemCmd implements EssaCmd {

	/**
	 * Service the FileSystem command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(Context arg) throws Exception {
		_log.debug("file system execute");
		
		FileSystemCtx ctx = (FileSystemCtx) arg;
		
		JmxFacade facade = new JmxFacade();
		ctx.setSample(facade.getFileSystems());
		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSystemCmd.class);
}