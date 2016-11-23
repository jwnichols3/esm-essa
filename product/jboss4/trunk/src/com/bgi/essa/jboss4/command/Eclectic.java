package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.AbstractEssaCtx;

import com.bgi.essa.shared.exception.CommandFailure;

/**
 * Central command dispatch
 *
 * @author gsc
 */
public class Eclectic {
	
	/**
	 * Generic command dispatch
	 * 
	 * @param context w/input arguments 
	 * @return updated context w/output results
	 * @throws CommandFailure if problem
	 */
	public void serviceCommand(final AbstractEssaCtx context) throws CommandFailure {
		_log.info("serviceCommand w/context:" + context.getCommand());
		
		if (context == null) {
			throw new CommandFailure(CommandFailure.NULL_COMMAND);
		}
		
		final Command command = _catalog.getCommand(context.getCommand());
		
		try {
			command.execute(context);
		} catch(final Exception exception) {
			_log.error("choke", exception);
			throw new CommandFailure(CommandFailure.COMMAND_FAILURE);
		}
	}
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	 * Command catalog
	 */
	private final ControllerCatalog _catalog = new ControllerCatalog();

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(Eclectic.class);
}