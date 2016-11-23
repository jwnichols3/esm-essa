package com.bgi.essa.struts1_2;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.UserDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Parent for all ESSA struts actions
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class EssaAction extends Action {
	
	/**
	 * Initialization.  All action.execute methods must invoke.
	 * Seeds inherited variables.
	 * 
	 * @param arg http servlet request
	 */
	public void actionPrep(HttpServletRequest arg) {
		_log.info("actionPrep");
		
		session = arg.getSession();
		
		current_user = (UserDTO) session.getAttribute(StrutsConstantsIf.USER);
		if (current_user == null) {
			_log.error("current user null");
		} else {
			_log.info("current user:" + current_user.getName());
		}
		
		action = arg.getParameter(StrutsConstantsIf.ACTION);
		_log.info("actionPrep:" + action);
		
		current_task = (TaskDTO) session.getAttribute(StrutsConstantsIf.CURRENT_TASK);
		if (current_task == null) {
			_log.info("current task null");
		} else {
			_log.info("current task:" + current_task);
		}
		
		current_rule = (TrimString) session.getAttribute(StrutsConstantsIf.CURRENT_RULE);
		if (current_rule == null) {
			_log.info("current rule null");
		} else {
			_log.info("current rule:" + current_rule);
		}
	}
	
	/**
	 * Return parsed key
	 * 
	 * @param arg request
	 * @return parsed key or null if problem
	 */
	public Long getKey(HttpServletRequest arg) {
		String temp_key = arg.getParameter(StrutsConstantsIf.SELECT_KEY);
		if (temp_key == null) {
			_log.error("null select key");
			return(null);
		}
		
		return(Long.parseLong(temp_key));
	}
	
	/**
	 * Define current task as session attribute
	 * @param arg current task
	 */
	public void setCurrentTask(TaskDTO arg) {
		_log.info("set current task:" + arg);
		session.setAttribute(StrutsConstantsIf.CURRENT_TASK, arg);
		current_task = arg;
	}
	
	/**
	 * Define current rule as a session attribute
	 * @param arg current rule
	 */
	public void setCurrentRule(TrimString arg) {
		_log.info("set current rule:" + arg);
		session.setAttribute(StrutsConstantsIf.CURRENT_RULE, arg);
		current_rule = arg;
	}

	/**
	 * Define default VPO.  Store in session as a list.
	 * 
	 * @param arg default VPO, cannot be null
	 */
	public void setDefaultVpo(VpoDTO arg) {
		_log.info("set default VPO:" + arg);
	
		default_vpo = arg;
		
		ArrayList<DtoIf> list = new ArrayList<DtoIf>();
		if (arg != null) {
			list.add(arg);
		}
		
		session.setAttribute(StrutsConstantsIf.DEFAULT_VPO_LIST, list);
	}
		
	/**
	 * Define default Custom Message Attribute (CMA) list
	 * 
	 * @param arg CMA list
	 */
	public void setDefaultCmaList(List<DtoIf> arg) {
		_log.info("set default CMA:" + arg.size());
		session.setAttribute(StrutsConstantsIf.DEFAULT_CMA_LIST, arg);
		default_cma_list = arg;
	}
	
	/**
	 * Define default canned action list
	 * @param arg
	 */
	public void setDefaultCannedActionList(List<DtoIf> arg) {
		_log.info("set default canned action:" + arg.size());
		session.setAttribute(StrutsConstantsIf.DEFAULT_CANNED_LIST, arg);
		default_canned_list = arg;
	}
	
	/**
	 * Define alarm inhibit list as a session attribute
	 * @param arg alarm inhibit list
	 */
	public void setAlarmInhibitList(List<DtoIf> arg) {
		_log.info("set alarm inhibit list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.ALARM_INHIBIT_LIST, arg);
		alarm_inhibit_list = arg;
	}
	
	/**
	 * Define current boot time list as a session attribute
	 * @param arg boot time list
	 */
	public void setBootTimeList(List<DtoIf> arg) {
		_log.info("set boot time list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.BOOT_TIME_LIST, arg);
		boot_time_list = arg;
	}
	
	/**
	 * Define current directory age list as a session attribute
	 * @param arg directory age list
	 */
	public void setDirectoryAgeList(List<DtoIf> arg) {
		_log.info("set directory age list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.DIRECTORY_AGE_LIST, arg);
		directory_age_list = arg;
	}
	
	/**
	 * Define current directory size list as a session attribute
	 * @param arg directory size list
	 */
	public void setDirectorySizeList(List<DtoIf> arg) {
		_log.info("set directory size list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.DIRECTORY_SIZE_LIST, arg);
		directory_size_list = arg;
	}
	
	/**
	 * Define current file age list as a session attribute
	 * @param arg file age list
	 */
	public void setFileAgeList(List<DtoIf> arg) {
		_log.info("set file age list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.FILE_AGE_LIST, arg);
		file_age_list = arg;
	}
	
	/**
	 * Define current file size list as a session attribute
	 * @param arg file size list
	 */
	public void setFileSizeList(List<DtoIf> arg) {
		_log.info("set file size list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.FILE_SIZE_LIST, arg);
		file_size_list = arg;
	}
	
	/**
	 * Define current file system size list as a session attribute
	 * @param arg file system size list
	 */
	public void setFileSystemSizeList(List<DtoIf> arg) {
		_log.info("set file system size list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.FILE_SYSTEM_SIZE_LIST, arg);
		file_system_size_list = arg;
	}
	
	/**
	 * Define current process list as a session attribute
	 * @param arg file system size list
	 */
	public void setProcessList(List<DtoIf> arg) {
		_log.info("set process list:" + arg.size());
		session.setAttribute(StrutsConstantsIf.PROCESS_LIST, arg);
		process_list = arg;
	}

	/**
	 * Current task
	 */
	protected TaskDTO current_task;

	/**
	 * Current rule
	 */
	protected TrimString current_rule;
	
	/**
	 * Current user
	 */
	protected UserDTO current_user;

	/**
	 * Default VPO
	 */
	protected VpoDTO default_vpo;
	
	/**
	 * Default CMA list
	 */
	protected List<DtoIf> default_cma_list;
	
	/**
	 * Default canned actions
	 */
	protected List<DtoIf> default_canned_list;

	/**
	 * Current alarm inhibit attribute list
	 */
	protected List<DtoIf> alarm_inhibit_list;
	
	/**
	 * Current boot time rule/monitor list
	 */
	protected List<DtoIf> boot_time_list;
	
	/**
	 * Current directory age rule/monitor list
	 */
	protected List<DtoIf> directory_age_list;
	
	/**
	 * Current directory size rule/monitor list
	 */
	protected List<DtoIf> directory_size_list;
	
	/**
	 * Current file age rule/monitor list
	 */
	protected List<DtoIf> file_age_list;
	
	/**
	 * Current file size rule/monitor list
	 */
	protected List<DtoIf> file_size_list;
	
	/**
	 * Current file system size rule/monitor list
	 */
	protected List<DtoIf> file_system_size_list;
	
	/**
	 * Current process rule/monitor list
	 */
	protected List<DtoIf> process_list;
	
	/**
	 * Collected errors
	 */
	protected ActionErrors errorz = new ActionErrors();

	/**
	 * Handle from request.getSession()
	 */
	protected HttpSession session;
	
	/**
	 * Current action parameter
	 */
	protected String action;

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(EssaAction.class);
}
