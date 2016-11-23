package com.bgi.essa.struts1_2.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;
import com.bgi.essa.shared.command.ParentTaskCtx;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Return the system tasking as XML
 * 
 * @author coleguy
 */
public class XmlDump {
	
	/**
	 * Dump the system configuration
	 * 
	 * @return list of string containing raw XML
	 */
	public List<String> dumpAllActiveTasks() {
		ArrayList<String> result = new ArrayList<String>();
		
		//result.add("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		result.add("<essa_configuration>");	
		result.add("<tasks>");
		
		List<DtoIf> tasks = bd.selectAll(new TaskDTO(), SelectOption.SELECT_ACTIVE);
		if ((tasks == null) || (tasks.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> ii = tasks.iterator();
			while (ii.hasNext()) {
				TaskDTO dto = (TaskDTO) ii.next();
				result.addAll(dumpTask(dto));
			}
		}
		
		result.add("</tasks>");
		result.add("</essa_configuration>");
		
		return(result);
	}
	
	/**
	 * 
	 * @param arg
	 * @return
	 */
	private List<String> dumpTask(TaskDTO arg) {
		ArrayList<String> result = new ArrayList<String>();
		
		ParentTaskCtx parent_task = new ParentTaskCtx();
		parent_task.setCandidate(arg);
		
		try {
			parent_task = (ParentTaskCtx) bd.serviceCommand(parent_task);
		} catch(Exception exception) {
			_log.error("unable to get parent task", exception);
			return(result);
		}
		
		result.add("<task>");
		
		result.add(arg.getName().toXml("name"));
		
		if (arg.isMatchAll()) {
			result.add("<match_rule>MATCH_ALL_RULES</match_rule>");
		} else {
			result.add("<match_rule>MATCH_ANY_RULE</match_rule>");
		}
		
		result.add(toXml("sample_interval", arg.getFrequency()));
		result.add(arg.getNote().toXml("note"));
		
		//default VPO
		result.addAll(dumpVpo(parent_task.getDefaultVpo(), parent_task.getDefaultCannedActionList()));

		//alarm inhibit
		result.addAll(dumpAlarmInhibit(parent_task.getAlarmInhibitList()));
		
		//cma
		result.addAll(dumpCma(parent_task.getCmaList()));
		
		//rules
		result.add("<rules>");
		
		List<DtoIf> boot_time_list = parent_task.getBootTimeList();
		if ((boot_time_list == null) || (boot_time_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> boot_time = boot_time_list.iterator();
			while(boot_time.hasNext()) {
				result.addAll(dumpRebootRule((BootTimeDTO) boot_time.next()));
			}
		}

		List<DtoIf> dir_size_list = parent_task.getDirectorySizeList();
		if ((dir_size_list == null) || (dir_size_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> dir_size = dir_size_list.iterator();
			while(dir_size.hasNext()) {
				result.addAll(dumpDirectorySizeRule((DirectorySizeDTO) dir_size.next()));
			}
		}

		List<DtoIf> file_age_list = parent_task.getFileAgeList();	
		if ((file_age_list == null) || (file_age_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> file_age = file_age_list.iterator();
			while(file_age.hasNext()) {
				result.addAll(dumpFileAgeRule((FileAgeDTO) file_age.next()));
			}
		}

		List<DtoIf> file_size_list = parent_task.getFileSizeList();
		if ((file_size_list == null) || (file_size_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> file_size = file_size_list.iterator();
			while(file_size.hasNext()) {
				result.addAll(dumpFileSizeRule((FileSizeDTO) file_size.next()));
			}
		}
		
		List<DtoIf> file_system_size_list = parent_task.getFileSystemSizeList();
		if ((file_system_size_list == null) || (file_system_size_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> file_system_size = file_system_size_list.iterator();
			while(file_system_size.hasNext()) {
				result.addAll(dumpFileSystemSizeRule((FileSystemSizeDTO) file_system_size.next()));
			}	
		}
		
		List<DtoIf> process_list = parent_task.getProcessList();
		if ((process_list == null) || (process_list.isEmpty())) {
			//empty
		} else {
			Iterator<DtoIf> process = process_list.iterator();
			while(process.hasNext()) {
				result.addAll(dumpProcessRule((ProcessDTO) process.next()));
			}
		}
		
		result.add("</rules>");
		result.add("</task>");

		return(result);
	}
	
	/**
	 * Dump alarm inhibit window
	 * 
	 * @param arg
	 * @return
	 */
	private List<String> dumpAlarmInhibit(List<DtoIf> arg) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<alarm_inhibit_windows>");
		
		Iterator<DtoIf> ii = arg.iterator();
		while(ii.hasNext()) {
			AlarmInhibitDTO dto = (AlarmInhibitDTO) ii.next();
			
			result.add("<window>");
			result.add(dto.getDay().toXml("day"));
			result.add(dto.getStart().toXml("start"));
			result.add(dto.getStop().toXml("stop"));
			result.add(dto.getNote().toXml("note"));
			result.add("</window>");
		}
		
		result.add("</alarm_inhibit_windows>");
		
		return(result);
	}
	
	/**
	 * Dump custom message attribute
	 * 
	 * @param arg
	 * @return
	 */
	private List<String> dumpCma(List<DtoIf> arg) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<cma>");
		
		Iterator<DtoIf> ii = arg.iterator();
		while(ii.hasNext()) {
			CustomMessageAttributeDTO dto = (CustomMessageAttributeDTO) ii.next();
			
			result.add("<key_value_pair>");
			result.add(dto.getKey().toXml("key"));
			result.add(dto.getValue().toXml("value"));
			result.add(dto.getNote().toXml("note"));
			result.add("</key_value_pair>");
		}
		
		result.add("</cma>");
		
		return(result);
	}
	
	/**
	 * Dump VPO
	 * 
	 * @param vpo
	 * @param canned
	 * @return
	 */
	private List<String> dumpVpo(VpoDTO vpo, List<DtoIf> canned) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<vpo>");
		result.add(vpo.getAppName().toXml("application_name"));
		result.add(vpo.getSeverity().toXml("severity"));
		result.add(toXml("retry_interval", vpo.getFrequency()));
		result.add(vpo.getMessage().toXml("message_text"));
		result.add(vpo.getSourceHost().toXml("source_host"));
		
		if (canned != null) {
			result.add("<actions>");
			Iterator<DtoIf> ii = canned.iterator();
			while (ii.hasNext()) {
				CannedActionDTO cad = (CannedActionDTO) ii.next();

				result.add("<vpo_action>");
				result.add(cad.getAction().toXml("canned_action"));
				result.add(cad.getSubject().toXml("subject"));
				result.add(cad.getAddress().toXml("address"));
				result.add(cad.getNote().toXml("note"));
				result.add("</vpo_action>");
			}
			result.add("</actions>");
		}
		result.add("</vpo>");
		
		return(result);
	}
	
	/**
	 * 
	 * @param task
	 * @param rule
	 * @return
	 */
	List<String> getVpo(TrimString task, TrimString rule) {
		VpoDTO vpo = new VpoDTO();
		vpo.setTaskId(task);
		vpo.setRuleId(rule);
		
		List<DtoIf> list = bd.selectByKey(vpo, SelectOption.SELECT_ACTIVE);
		if ((list == null) || (list.isEmpty())) {
			return(new ArrayList<String>());
		} else {
			vpo = (VpoDTO) list.get(0);
			
			CannedActionDTO cad = new CannedActionDTO();
			cad.setTaskId(task);
			cad.setRuleId(rule);
			
			list = bd.selectByKey(cad, SelectOption.SELECT_ACTIVE);
		}
		
		return(dumpVpo(vpo, list));
	}
	
	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpDirectorySizeRule(DirectorySizeDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());
		
		result.add("<directory_size_monitor>");
		result.addAll(vpo);
		result.add(rule.getTarget().toXml("target"));
		result.add(rule.getThresholdType().toXml("threshold_type"));
		result.add(toXml("lower", rule.getMinimumThreshold()));
		result.add(toXml("upper", rule.getMaximumThreshold()));
		result.add(toXml("recursive", rule.isRecursive()));
		result.add(rule.getNote().toXml("note"));
		result.add("</directory_size_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}
	
	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpFileAgeRule(FileAgeDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());
		
		result.add("<file_age_monitor>");
		result.addAll(vpo);
		result.add(rule.getFileName().toXml("file"));
		result.add(toXml("threshold", rule.getThreshold()));
		result.add(rule.getFileAgeOption().toXml("older"));
		result.add(rule.getNote().toXml("note"));
		result.add("</file_age_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}

	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpFileSizeRule(FileSizeDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());
		
		result.add("<file_size_monitor>");
		result.addAll(vpo);
		result.add(rule.getTarget().toXml("target"));
		result.add(rule.getThresholdType().toXml("threshold_type"));
		result.add(toXml("lower", rule.getMinimumThreshold()));
		result.add(toXml("upper", rule.getMaximumThreshold()));
		result.add(rule.getNote().toXml("note"));
		result.add("</file_size_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}

	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpFileSystemSizeRule(FileSystemSizeDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());
		
		result.add("<file_system_size_monitor>");
		result.addAll(vpo);
		result.add(rule.getTarget().toXml("file_system"));
		result.add(toXml("block", rule.getBlockThreshold()));
		result.add(toXml("inode", rule.getInodeThreshold()));
		result.add(rule.getNote().toXml("note"));
		result.add("</file_system_size_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}

	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpProcessRule(ProcessDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());

		result.add("<process_monitor>");
		result.addAll(vpo);
		result.add(rule.getOptionType().toXml("option"));
		result.add(rule.getTarget().toXml("target"));
		result.add(rule.getThresholdType().toXml("threshold_type"));
		result.add(toXml("duration", rule.getMaximumTime()));
		result.add(toXml("upper", rule.getMaximumPopulation()));
		result.add(toXml("lower", rule.getMinimumPopulation()));
		result.add(rule.getNote().toXml("note"));
		result.add("</process_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}

	/**
	 * 
	 * @param rule
	 * @return
	 */
	private List<String> dumpRebootRule(BootTimeDTO rule) {
		ArrayList<String> result = new ArrayList<String>();
		
		result.add("<rule>");
		
		List<String> vpo = getVpo(rule.getTaskId(), rule.getRuleId());

		result.add("<reboot_monitor>");
		result.addAll(vpo);
		result.add(rule.getNote().toXml("note"));
		result.add("</reboot_monitor>");
		
		result.add("</rule>");
		
		return(result);
	}

	/**
	 * 
	 * @param tag
	 * @param value
	 * @return
	 */
	private String toXml(String tag, int value) {
		return("<" + tag + ">" + Integer.toString(value) + "</" + tag + ">");
	}
	
	/**
	 * 
	 * @param tag
	 * @param value
	 * @return
	 */
	private String toXml(String tag, boolean value) {
		return("<" + tag + ">" + Boolean.toString(value) + "</" + tag + ">");
	}

	/**
	 * Handle to back end services
	 */
	protected final BusinessDelegate bd = new BusinessDelegate();
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
