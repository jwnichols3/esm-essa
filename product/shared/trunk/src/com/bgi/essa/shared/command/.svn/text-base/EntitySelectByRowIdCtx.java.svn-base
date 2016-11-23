package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Select from database by row id
 * 
 * @author gsc
 */
public class EntitySelectByRowIdCtx extends AbstractEntityCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.SELECT_BY_ROW_ID_CMD);
	}

	/**
	 * Retrieve selection result
	 * 
	 * @return selection result
	 */
	public DtoIf getResult() {
		return((DtoIf) get(AbstractEssaCtx.RESULT_KEY));
	}

	/**
	 * Define selection result
	 * 
	 * @param arg selection result
	 */
	@SuppressWarnings("unchecked")
	public void setResult(final DtoIf arg) {
		put(AbstractEssaCtx.RESULT_KEY, arg);
	}

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -3181572109403127179L;
}
