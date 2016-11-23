package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.EntityUpdateCtx;

/**
 * Update or insert a database row
 *
 * @author gsc
 */
public class EntityUpdateCmd implements EssaCmd {

	/**
	 * Update or insert a database row
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("entity update execute");
	
		final EntityUpdateCtx ctx = (EntityUpdateCtx) arg;
		
		final boolean result_flag = _orm.insertOrUpdate(ctx.getCandidate());
		
		ctx.setSuccess(result_flag);
	
		return(Command.CONTINUE_PROCESSING);
	}
	
	/**
	 * Handle to database 
	 */
	private final OrmFacade _orm = new OrmFacade();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(EntityUpdateCmd.class);
}