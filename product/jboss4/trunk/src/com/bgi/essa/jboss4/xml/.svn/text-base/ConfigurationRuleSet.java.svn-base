package com.bgi.essa.jboss4.xml;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

/**
 * @author coleguy
 */
public class ConfigurationRuleSet extends RuleSetBase {

	/**
	 * Digester parsing rules
	 * 
	 * @param digester instance
	 */
	public void addRuleInstances(Digester digester) {
		digester.addObjectCreate("essa_configuration", "com.bgi.essa.jboss4.xml.ConfigurationParseTree");

		digester.addObjectCreate("essa_configuration/tasks/task", "com.bgi.essa.jboss4.xml.TaskTree");
		digester.addSetNext("essa_configuration/tasks/task", "addTaskTree");
		
		digester.addCallMethod("essa_configuration/tasks/task/name", "setName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/match_rule", "setMatchRule", 0);
		digester.addCallMethod("essa_configuration/tasks/task/sample_interval", "setSampleInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/note", "setNote", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/vpo", "setDefaultVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/vpo/actions/vpo_action/subject", "setSubject", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/alarm_inhibit_windows/window", "com.bgi.essa.jboss4.xml.RawAlarmInhibit");
		digester.addSetNext("essa_configuration/tasks/task/alarm_inhibit_windows/window", "addAlarmInhibit");
		
		digester.addCallMethod("essa_configuration/tasks/task/alarm_inhibit_windows/window/day", "setDay", 0);
		digester.addCallMethod("essa_configuration/tasks/task/alarm_inhibit_windows/window/start", "setStart", 0);
		digester.addCallMethod("essa_configuration/tasks/task/alarm_inhibit_windows/window/stop", "setStop", 0);
		digester.addCallMethod("essa_configuration/tasks/task/alarm_inhibit_windows/window/note", "setNote", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/cma/key_value_pair", "com.bgi.essa.jboss4.xml.RawCma");
		digester.addSetNext("essa_configuration/tasks/task/cma/key_value_pair", "addCma");
		
		digester.addCallMethod("essa_configuration/tasks/task/cma/key_value_pair/key", "setKey", 0);
		digester.addCallMethod("essa_configuration/tasks/task/cma/key_value_pair/value", "setValue", 0);
		digester.addCallMethod("essa_configuration/tasks/task/cma/key_value_pair/note", "setNote", 0);
		
		//
		// directory size
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/directory_size_monitor", "com.bgi.essa.jboss4.xml.DirSizeRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/directory_size_monitor", "addRule");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/lower", "setLower", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/recursive", "setRecursive", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/target", "setTarget", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/threshold_type", "setThreshold", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/upper", "setUpper", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/directory_size_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);
		
		//
		// file age
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_age_monitor", "com.bgi.essa.jboss4.xml.FileAgeRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_age_monitor", "addRule");

		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/file", "setFile", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/older", "setOlder", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/threshold", "setThreshold", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_age_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);
		
		//
		// file size
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_size_monitor", "com.bgi.essa.jboss4.xml.FileSizeRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_size_monitor", "addRule");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/lower", "setLower", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/target", "setTarget", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/threshold_type", "setThreshold", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/upper", "setUpper", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_size_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);
		
		//
		// file system size
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_system_size_monitor", "com.bgi.essa.jboss4.xml.FileSystemSizeRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_system_size_monitor", "addRule");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/block", "setBlock", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/file_system", "setFileSystem", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/inode", "setInode", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/note", "setNote", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/file_system_size_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);
		
		//
		// process monitor
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/process_monitor", "com.bgi.essa.jboss4.xml.ProcessRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/process_monitor", "addRule");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/duration", "setDuration", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/lower", "setLower", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/option", "setOption", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/target", "setTarget", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/threshold_type", "setType", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/upper", "setUpper", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/process_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/process_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/process_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);

		//
		// reboot monitor
		//
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/reboot_monitor", "com.bgi.essa.jboss4.xml.RebootRule");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/reboot_monitor", "addRule");
	
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/note", "setNote", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo", "com.bgi.essa.jboss4.xml.VpoTree");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo", "setVpo");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/application_name", "setApplicationName", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/severity", "setSeverity", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/retry_interval", "setRetryInterval", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/message_text", "setMessage", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/source_host", "setSource", 0);
		
		digester.addObjectCreate("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action", "com.bgi.essa.jboss4.xml.RawCannedAction");
		digester.addSetNext("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action", "addCannedAction");
		
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action/canned_action", "setAction", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action/address", "setAddress", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action/note", "setNote", 0);
		digester.addCallMethod("essa_configuration/tasks/task/rules/rule/reboot_monitor/vpo/actions/vpo_action/subject", "setSubject", 0);
	}
}
