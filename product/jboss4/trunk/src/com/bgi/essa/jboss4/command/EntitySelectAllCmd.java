package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.EntitySelectAllCtx;

/**
 * Select all database rows
 *
 * @author gsc
 */
public class EntitySelectAllCmd implements EssaCmd {

	/**
	 * Select all database rows
	 * 
	 * @param arg context w/table to select
	 * @return true, continue processing
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("entity select all execute");
	
		final EntitySelectAllCtx ctx = (EntitySelectAllCtx) arg;
		
		ctx.setResults(_orm.selectAll(ctx.getCandidate(), ctx.getSelectOption()));
		
		ctx.setSuccess(true);
	
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to database 
	 */
	private final OrmFacade _orm = new OrmFacade();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(EntitySelectAllCmd.class);
}