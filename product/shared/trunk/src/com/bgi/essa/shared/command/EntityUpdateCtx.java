package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Insert or update a database row
 *
 * @author gsc
 */
public class EntityUpdateCtx extends AbstractEntityCtx {
	
	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.UPDATE_CMD);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 4806179476992530371L;
}