package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.EntitySelectByRowIdCtx;

/**
 * Select an entity by row ID
 * 
 * @author gsc
 */
public class EntitySelectByRowIdCmd implements EssaCmd {

	/**
	 * Select an entity by row ID.    
	 * 
	 * @param arg command context
	 * @return true if success
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		final EntitySelectByRowIdCtx ctx = (EntitySelectByRowIdCtx) arg;

		ctx.setResult(_orm.selectByRowId(ctx.getCandidate()));

		ctx.setSuccess(true);

		return(Command.CONTINUE_PROCESSING);
	}

	/**
	 * Handle to database
	 */
	private final OrmFacade _orm = new OrmFacade();
}