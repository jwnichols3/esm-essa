package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * @author coleguy
 */
public abstract class AbstractSchedulerCtx extends AbstractEssaCtx {


	/**
	 * Return candidate name
	 * 
	 * @return candidate name
	 */
	public TrimString getName() {
		return((TrimString) get(AbstractEssaCtx.NAME_KEY));
	}

	/**
	 * Define candidate name
	 * 
	 * @param arg candidate name
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setName(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
		
		put(AbstractEssaCtx.NAME_KEY, arg);
	}
}
