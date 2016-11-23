package com.bgi.essa.shared.exception;

/**
 * @author gsc
 */
public class CommandFailure extends EssaException {

	/**
	 * ctor
	 * 
	 * @param arg complaint
	 */
	public CommandFailure(String arg) {
		super(arg);
	}
	
	/**
	 * Error String
	 */
	public static final String COMMAND_FAILURE = "Command Failure";
	
	/**
	 * Error String
	 */
	public static final String NULL_COMMAND = "Null Command";
	
	/**
	 * Error String
	 */
	public static final String UNKNOWN_COMMAND = "Unknown Command";

	/**
	 * Error String
	 */
//	public static final String DUPLICATE_ROW = "Duplicate Row";

	/**
	 * Generated serial version ID.
	 */
	private static final long serialVersionUID = 7008953389502231253L;
}