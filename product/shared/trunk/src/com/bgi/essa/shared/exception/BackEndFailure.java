package com.bgi.essa.shared.exception;

/**
 * RMI back end is not responding. Is application server running?
 *
 * @author gsc
 */
public class BackEndFailure extends EssaException {

	/**
	 * Back end failure
	 */
	public BackEndFailure() {
		super(RMI_FAILURE);
	}

	/**
	 * Back end failure
	 * 
	 * @param arg complaint
	 */
	public BackEndFailure(final String arg) {
		super(arg);
	}

	/**
	 * Error String
	 */
	public static final String RMI_FAILURE = "RMI Failure";

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -1275380543513101844L;
}

