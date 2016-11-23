package com.bgi.essa.shared.command;

import java.util.HashMap;

import org.apache.commons.chain.Context;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Abstract parent for ESSA command context
 *
 * @author gsc
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEssaCtx extends HashMap implements Context {

	/**
	 * Return command definition
	 * 
	 * @return command definition
	 */
	public abstract LegalCmd getCommand();
	
	/**
	 * Return true if command success
	 * 
	 * @return true if command success
	 */
	public boolean isSuccess() {
		final Boolean temp = (Boolean) get(SUCCESS_KEY);
		if (temp == null) {
			return(false);
		}
		
		return(temp.booleanValue());
	}
	
	/**
	 * Define command success
	 * 
	 * @param arg true, command success
	 */
	@SuppressWarnings("unchecked")
	public void setSuccess(final boolean arg) {
		put(SUCCESS_KEY, new Boolean(arg));
	}
	
	public static String ALARM_INHIBIT_LIST_KEY         = "ALARM_INHIBIT_LIST_KEY";
	public static String CANDIDATE_KEY                  = "CANDIDATE_KEY";
	public static String CMA_LIST_KEY                   = "CMA_LIST_KEY";
	public static String DEFAULT_CANNED_ACTION_LIST_KEY = "DEFAULT_CANNED_ACTION_LIST_KEY";
	public static String DEFAULT_VPO_KEY                = "DEFAULT_VPO_KEY";
	public static String DIRECTORY_AGE_LIST_KEY         = "DIRECTORY_AGE_LIST_KEY";
	public static String DIRECTORY_SIZE_LIST_KEY        = "DIRECTORY_SIZE_LIST_KEY";
	public static String EVALUATE_KEY                   = "EVALUATE_KEY";
	public static String FILE_AGE_LIST_KEY              = "FILE_AGE_LIST_KEY";
	public static String FILE_SIZE_LIST_KEY             = "FILE_SIZE_LIST_KEY";
	public static String FILE_SYSTEM_SIZE_LIST_KEY      = "FILE_SYSTEM_SIZE_LIST_KEY";
	public static String FLAG_KEY                       = "flag";
	public static String NAME_KEY                       = "NAME_KEY";
	public static String PERSIST_KEY                    = "PERSIST_KEY";
	public static String PROCESS_LIST_KEY               = "PROCESS_LIST_KEY";
	public static String REBOOT_LIST_KEY                = "REBOOT_LIST_KEY";
	public static String RECURSIVE_KEY                  = "RECURSIVE_KEY";
	public static String RESULT_KEY                     = "RESULT_KEY";
	public static String RULE_KEY                       = "RULE_KEY";
	public static String SAMPLE_KEY                     = "SAMPLE_KEY";
	public static String SELECT_OPTION_KEY              = "SELECT_OPTION_KEY";
	public static String SUCCESS_KEY                    = "SUCCESS_KEY";
	
	//Quartz Context
	public static String JOB_NAMES_KEY                  = "JOB_NAMES_KEY";
	public static String SCHEDULER_NAME_KEY             = "SCHEDULER_NAME_KEY";
	public static String TASK_KEY                       = "TASK_KEY";
}
