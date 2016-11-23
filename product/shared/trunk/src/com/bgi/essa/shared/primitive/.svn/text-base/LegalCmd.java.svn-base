package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Define legal back end commands, treat as enumerated type.
 * 
 * @author gsc
 */
public final class LegalCmd implements Serializable {

	/**
	 * stub command, does nothing
	 */
	public static final LegalCmd BOGUS_CMD = new LegalCmd("BOGUS_CMD");
	
	/**
	 * Invoke ping test
	 */
	public static final LegalCmd PING_CMD = new LegalCmd("PING_CMD");
	
	/**
	 * Return system boot time (from JNI)
	 */
	public static final LegalCmd BOOT_TIME_SAMPLE_CMD = new LegalCmd("BOOT_TIME_SAMPLE_CMD");
	
	/**
	 * Return file system datum (from JNI)
	 */
	public static final LegalCmd JNI_STAT_VFS_CMD = new LegalCmd("JNI_STAT_VFS_CMD");
	
	/**
	 * Return JNI version string
	 */
	public static final LegalCmd JNI_VERSION_CMD = new LegalCmd("JNI_VERSION_CMD");
	
	/**
	 * Delete a database row
	 */
	public static final LegalCmd DELETE_CMD = new LegalCmd("DELETE_CMD");
	
	/**
	 * Update or Insert a database row
	 */
	public static final LegalCmd UPDATE_CMD = new LegalCmd("UPDATE_CMD");
	
	/**
	 * Discover all the components of a task
	 */
	public static final LegalCmd PARENT_TASK_CMD = new LegalCmd("PARENT_TASK_CMD");
	
	/**
	 * Delete a scheduled item
	 */
	public static final LegalCmd SCHEDULE_DELETE_CMD = new LegalCmd("SCHEDULE_DELETE_CMD");
	
	/**
	 * Update or insert a scheduled item
	 */
	public static final LegalCmd SCHEDULE_UPDATE_CMD = new LegalCmd("SCHEDULE_UPDATE_CMD");
	
	/**
	 * Schdule utility, discover jobs, scheduler name, etc
	 */
	public static final LegalCmd SCHEDULE_UTILITY_CMD = new LegalCmd("SCHEDULE_UTILITY_CMD");
	
	/**
	 * Select all rows
	 */
	public static final LegalCmd SELECT_ALL_CMD = new LegalCmd("SELECT_ALL_CMD");
	
	/**
	 * Select a row by key
	 */
	public static final LegalCmd SELECT_BY_KEY_CMD = new LegalCmd("SELECT_BY_KEY_CMD");
	
	/**
	 * Select a row by row id
	 */
    public static final LegalCmd SELECT_BY_ROW_ID_CMD = new LegalCmd("SELECT_BY_ROW_ID_CMD");
    
    /**
     * Return file sample
     */
    public static final LegalCmd FILE_SAMPLE_CMD = new LegalCmd("FILE_SAMPLE_CMD");
   
    /**
     * Return file age
     */
    public static final LegalCmd FILE_AGE_SAMPLE_CMD = new LegalCmd("FILE_AGE_SAMPLE_CMD");
 
    /**
     * Return file system
     */
    public static final LegalCmd FILE_SYSTEM_SAMPLE_CMD = new LegalCmd("FILE_SYSTEM_SAMPLE_CMD");
   
    /**
     * Return directory age
     */
    public static final LegalCmd DIRECTORY_AGE_SAMPLE_CMD = new LegalCmd("DIRECTORY_AGE_SAMPLE_CMD");
    
    /**
     * Return directory size
     */
    public static final LegalCmd DIR_SIZE_SAMPLE_CMD = new LegalCmd("DIR_SIZE_SAMPLE_CMD");
    
    /**
     * Return file size
     */
    public static final LegalCmd FILE_SIZE_SAMPLE_CMD = new LegalCmd("FILE_SIZE_SAMPLE_CMD");

    /**
     * Return file system size
     */
    public static final LegalCmd FILE_SYSTEM_SIZE_SAMPLE_CMD = new LegalCmd("FILE_SYSTEM_SIZE_SAMPLE_CMD");

	/**
	 * Return ps(1) datum
	 */
	public static final LegalCmd PROCESS_SAMPLE_CMD = new LegalCmd("PROCESS_SAMPLE_CMD");

	/**
	 * Parse a XML configuration
	 */
	public static final LegalCmd LOAD_XML_CMD = new LegalCmd("LOAD_XML_CMD");	
    
	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
	@Override
	public String toString() {
		return(_value);
	}

	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return(_value);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param tag xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if tag is null
	 */
	public String toXml(String tag) {
		if (tag == null) {
			throw new NullPointerException("null XML tag");
		}
		
		return("<" + tag + ">" + toXml() + "</" + tag + ">");
	}
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static LegalCmd getInstance(final String arg) {
		return(_instances.get(arg));
	}

	/**
	 * Return all instances
	 * 
	 * @return all instances
	 */
	public static Map<String, LegalCmd> getAll() {
		return(_instances);
	}

	/**
	 * Private ctor
	 * 
	 * @param arg command value
	 */
	private LegalCmd(final String arg) {
		_value = arg;
	}

	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	@Override
	public int hashCode() {
		return(31 * _value.hashCode());
	}

	/**
	 * Return true if objects match
	 * 
	 * @param arg test candidate
	 * @return true if periods match
	 * @throws ClassCastException if arg cannot be cast
	 */
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}

		final LegalCmd temp = (LegalCmd) arg;
		return(_value.equals(temp._value));
	}

	/**
	 * Command value.
	 */
	private final String _value;

	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, LegalCmd> _instances = new HashMap<String, LegalCmd>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 3427811410895779595L;

	/**
	 * All legal commands
	 */
	static {
		_instances.put(BOGUS_CMD.toString(), BOGUS_CMD);
		
		_instances.put(PING_CMD.toString(), PING_CMD);
		
		_instances.put(LOAD_XML_CMD.toString(), LOAD_XML_CMD);
		
		_instances.put(BOOT_TIME_SAMPLE_CMD.toString(), BOOT_TIME_SAMPLE_CMD);
		_instances.put(JNI_STAT_VFS_CMD.toString(), JNI_STAT_VFS_CMD);
		_instances.put(JNI_VERSION_CMD.toString(), JNI_VERSION_CMD);

		_instances.put(DELETE_CMD.toString(), DELETE_CMD);
		_instances.put(UPDATE_CMD.toString(), UPDATE_CMD);
		
		_instances.put(SCHEDULE_DELETE_CMD.toString(), SCHEDULE_DELETE_CMD);
		_instances.put(SCHEDULE_UPDATE_CMD.toString(), SCHEDULE_UPDATE_CMD);
		_instances.put(SCHEDULE_UTILITY_CMD.toString(), SCHEDULE_UTILITY_CMD);
		
		_instances.put(SELECT_ALL_CMD.toString(), SELECT_ALL_CMD);
		_instances.put(SELECT_BY_KEY_CMD.toString(), SELECT_BY_KEY_CMD);
		_instances.put(SELECT_BY_ROW_ID_CMD.toString(), SELECT_BY_ROW_ID_CMD);
		
		_instances.put(DIRECTORY_AGE_SAMPLE_CMD.toString(), DIRECTORY_AGE_SAMPLE_CMD);
		_instances.put(DIR_SIZE_SAMPLE_CMD.toString(), DIR_SIZE_SAMPLE_CMD);
		_instances.put(FILE_SIZE_SAMPLE_CMD.toString(), FILE_SIZE_SAMPLE_CMD);
		_instances.put(FILE_SYSTEM_SIZE_SAMPLE_CMD.toString(), FILE_SYSTEM_SIZE_SAMPLE_CMD);
		_instances.put(FILE_SAMPLE_CMD.toString(), FILE_SAMPLE_CMD);
		_instances.put(FILE_SYSTEM_SAMPLE_CMD.toString(), FILE_SYSTEM_SAMPLE_CMD);
		_instances.put(FILE_AGE_SAMPLE_CMD.toString(), FILE_AGE_SAMPLE_CMD);	
		_instances.put(PROCESS_SAMPLE_CMD.toString(), PROCESS_SAMPLE_CMD);		  
	}
}
