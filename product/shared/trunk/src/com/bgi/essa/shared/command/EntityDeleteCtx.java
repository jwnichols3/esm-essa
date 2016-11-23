package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Delete a database row
 *
 * @author gsc
 */
public class EntityDeleteCtx extends AbstractEntityCtx {
	
	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.DELETE_CMD);
	}
	
	/**
	 * Serial version identifier. 
	 */
	private static final long serialVersionUID = -1698892108232104601L;
}