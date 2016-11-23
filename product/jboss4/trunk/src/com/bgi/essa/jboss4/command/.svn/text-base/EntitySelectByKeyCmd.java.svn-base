package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.command.EntitySelectByKeyCtx;

/**
 * Select DB rows by key (where key depends upon table)
 * 
 * @author gsc
 */
public class EntitySelectByKeyCmd implements EssaCmd {

	/**
	 * Select DB rows by key (where key depends upon table)
	 * 
	 * @param arg command context
	 * @throws Exception if any problem
	 */
	public boolean execute(final Context arg) throws Exception {
		final EntitySelectByKeyCtx ctx = (EntitySelectByKeyCtx) arg;

		ctx.setResults(_orm.selectByKey(ctx.getCandidate(), ctx.getSelectOption()));

		ctx.setSuccess(true);

		return(Command.CONTINUE_PROCESSING);
	}

	/**
	 * Handle to database
	 */
	private final OrmFacade _orm = new OrmFacade();
}