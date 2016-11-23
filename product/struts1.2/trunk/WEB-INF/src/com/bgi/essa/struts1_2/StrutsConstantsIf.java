package com.bgi.essa.struts1_2;

/**
 * Useful global constants.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public interface StrutsConstantsIf {
	
	/**
	 * Constants used by AbstractOptionBean
	 */
	String ANY = "Any";
	String UNKNOWN = "Unknown";

    /**
     * Struts action command
     */
    String INSERT = "insert";
    String UPDATE = "update";
    String EDIT = "edit";
    
	/**
	 * Struts action parameter
	 */
	String ACTION = "action";
	String CURRENT_TASK = "current_task";
	String CURRENT_RULE = "current_rule";
	
	String AUDIT_LIST = "audit_list";
	
	String ATTRIBUTE_AUDIT = "audit_attribute";
	String ATTRIBUTE_BROWSE = "browse_attribute";
	String ATTRIBUTE_EDIT = "edit_attribute";
	String ATTRIBUTE_LIST = "attribute_list";
	String ATTRIBUTE_NEW = "new_attribute";
	String ATTRIBUTE_FAILURE = "failed_attribute";
	String ATTRIBUTE_SUCCESS = "success_attribute";

	String DUMP = "dump";
	
	String RULE_AUDIT = "audit_rule";
	String RULE_LIST = "rule_list";
	String RULE_BROWSE = "browse_rule";
	String RULE_EDIT = "edit_rule";
	String RULE_NEW = "new_rule";
	String RULE_SUCCESS = "success_rule";
	String RULE_FAILURE = "failed_rule";
	
	String SAMPLE_BROWSE = "browse_sample";
	String SAMPLE_LIST = "sample_list";
	
	String TASK_LIST = "task_list";
	String TASK_BROWSE = "browse_task";
	String TASK_EDIT = "edit_task";
	String TASK_SUCCESS = "success_task";
	String TASK_FAILURE = "failed_task";
	
	//String DEFAULT_VPO = "default_vpo";
	
	String ALARM_INHIBIT_LIST = "alarm_inhibit_list";
	String BOOT_TIME_LIST = "boot_time_list";
	String DIRECTORY_AGE_LIST = "directory_age_list";
	String DIRECTORY_SIZE_LIST = "directory_size_list";
	String FILE_AGE_LIST = "file_age_list";
	String FILE_SIZE_LIST = "file_size_list";
	String FILE_SYSTEM_SIZE_LIST = "file_system_size_list";
	String PROCESS_LIST = "process_list";
	String DEFAULT_VPO_LIST = "default_vpo_list";
	String DEFAULT_CMA_LIST = "default_cma_list";
	String DEFAULT_CANNED_LIST = "default_canned_list";
	
	String BROWSE_LIST = "browse_list";
	
	/**
	 * Ad hoc parameter/command.
	 */
	String ADHOC = "adhoc";
	String AUDIT = "audit";
	String BROWSE = "browse";
	String UPLOAD = "upload";
	String REFRESH = "refresh";
	String SAMPLE = "sample";
	
	/**
	 * Struts forward
	 */
	String BOOT_ADHOC = "adhoc_boot"; 
	String BOOT_ADHOC_RESPONSE = "adhoc_boot_response";
	
	String CONFIGURATION_DUMP = "dump_configuration";
	String CONFIGURATION_NEW = "new_configuration";
	String CONFIGURATION_RESPONSE = "configuration_response";
	
	String DIRECTORY_SIZE_NEW = "new_directory_size";
	String DIRECTORY_SIZE_ADHOC_RESPONSE = "directory_size_response";
	
	String FILE_ADHOC_NEW = "new_adhoc_file"; 
	String FILE_ADHOC_RESPONSE = "adhoc_file_response";
	
	String FILE_SYSTEM_ADHOC = "adhoc_file_system"; 
	String FILE_SYSTEM_ADHOC_RESPONSE = "adhoc_file_system_response";
	
	String FS_SIZE_NEW = "new_fs_size";
	String FS_SIZE_ADHOC_RESPONSE = "fs_size_response";

	String PROCESS_NEW = "new_process";
	String PROCESS_ADHOC_RESPONSE = "process_response";

	String TASK_NEW = "new_task";
	String TASK_RESPONSE = "task_response";
	
	/**
	 * Struts action command/forward: generic cancel
	 */
	String CANCEL = "cancel";
	
	/**
	 * Struts action command/forward: generic failure
	 */
	String FAILURE = "failure";

	/**
	 * Struts action command/forward
	 */
    String NEW = "new";
    String NEW_DEFAULT = "new_default";
    
	/**
	 * Struts action command/forward
	 */
	String PREPARE = "prepare";
	
	/**
	 * Session attribute
	 */
	String RESPONSE1 = "response1";
	String RESPONSE2 = "response2";
	
	/**
     * Struts action command/forward: welcome page
     */
    String WELCOME = "welcome";
    
    /**
     * File UpLoad Buffer Size
     */
    int MAX_FILE_BUFFER=32768;
    
    /**
     * Struts action command: select all
     */
    String SELECT_ALL = "all";

    /**
     * Struts key
     */
    String SELECT_KEY = "key";

    /**
     * Selected result set
     */
    String SELECT_REPONSE = "select_response";

    /**
     * Struts action command: select one
     */
    String SELECT_SINGLE = "single";

    /**
     * Struts action command: select active
     */
    String SELECT_ACTIVE = "active";
    
    /**
     * Struts response
     */
    String SELECT_RESPONSE = "select_response";
     
    String SUCCESS = "success";
    String PAGE1 = "page1";
    String PAGE2 = "page2";
    String PAGE3 = "page3";
    String PAGE4 = "page4";
    
    String SESSION_RESET = "session_reset";
    String USER = "user";
    
    /**
     * Release Version
     */
    public static final String VERSION = "Version 0.0 from 24 JAN 06";
}
