package com.bgi.essa.shared.command;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Parent for entity commands
 * 
 * @author coleguy
 */
public abstract class AbstractEntityCtx extends AbstractEssaCtx {
	
	/**
	 * Return reference transfer object
	 * 
	 * @return reference transfer object
	 */
	public DtoIf getCandidate() {
		return((DtoIf) get(AbstractEssaCtx.CANDIDATE_KEY));
	}
	
	/**
	 * Define reference transfer object
	 * 
	 * @param arg reference transfer object
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setCandidate(final DtoIf arg) {
		if (arg == null) {
			throw new NullPointerException("null candidate");
		}
		
		put(AbstractEssaCtx.CANDIDATE_KEY, arg);
	}
}
