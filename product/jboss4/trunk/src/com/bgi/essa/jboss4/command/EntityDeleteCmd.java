package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.EntityDeleteCtx;

/**
 * Delete specified database row
 *
 * @author gsc
 */
public class EntityDeleteCmd implements EssaCmd {

	/**
	 * Delete specified database row
	 * 
	 * @param arg context w/row to delete
	 * @return true, continue processing
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		_log.debug("entity delete execute");
		
		final EntityDeleteCtx ctx = (EntityDeleteCtx) arg;
	
		final boolean result_flag = _orm.delete(ctx.getCandidate());
		
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
	private final Log _log = LogFactory.getLog(EntityDeleteCmd.class);
}