package com.bgi.essa.shared.command;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * @author coleguy
 */
public class LoadXmlCtx extends AbstractEssaCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.LOAD_XML_CMD);
	}
	
	/**
	 * Return XML configuration
	 * 
	 * @return XML configuration
	 */
	public String getCandidate() {
		return((String) get(AbstractEssaCtx.CANDIDATE_KEY));
	}
	
	/**
	 * Define XML configuration
	 * 
	 * @param arg XML configuration
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setCandidate(String arg) {
		if (arg == null) {
			throw new NullPointerException("null candidate");
		}
		
		put(AbstractEssaCtx.CANDIDATE_KEY, arg);
	}
	
	/**
	 * Eclipse generated serial version ID
	 */
	private static final long serialVersionUID = -7422418285910677752L;
}
