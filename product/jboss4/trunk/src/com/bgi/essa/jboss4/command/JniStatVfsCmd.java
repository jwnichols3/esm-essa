package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;

import com.bgi.essa.shared.command.JniStatVfsCtx;

import com.bgi.essa.shared.transfer.StatVfsDTO;

/**
 * Collect file system statistics
 *
 * @author gsc
 */
public class JniStatVfsCmd implements EssaCmd {

	/**
	 * Collect file system statistics
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.info("jni stat vfs execute");
		
		JniStatVfsCtx ctx = (JniStatVfsCtx) arg;

		JmxFacade facade = new JmxFacade();
		
		StatVfsDTO dto = facade.getFileSystem(ctx.getName());
		if (dto == null) {
			ctx.setSuccess(false);
		} else {		
			ctx.setSuccess(true);
			ctx.setSample(dto);
		}
				
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(JniStatVfsCmd.class);
}