package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.jmx.JmxFacade;
import com.bgi.essa.jboss4.jmx.JniStub;

import com.bgi.essa.shared.command.JniVersionCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Test command
 *
 * @author gsc
 */
public class JniVersionCmd implements EssaCmd {

	/**
	 * Test command
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.info("jni version execute");
		
		JniVersionCtx ctx = (JniVersionCtx) arg;

		JmxFacade facade = new JmxFacade();
		JniStub js = facade.getJniStub();
		ctx.setVersion(new TrimString(js.getVersion()));

		ctx.setSuccess(true);
		
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(JniVersionCmd.class);
}