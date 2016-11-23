package com.bgi.essa.shared.command;

import java.util.List;

import com.bgi.essa.shared.primitive.LegalCmd;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Task has several components spread across multiple tables.
 * Given a parent task, discover and return all the components.
 * 
 * @author coleguy
 */
public class ParentTaskCtx extends AbstractEntityCtx {
	
	/**
	 * Return command definition
	 * 
	 * @return command definition
	 */
	public LegalCmd getCommand() {
		return(LegalCmd.PARENT_TASK_CMD);
	}

	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getCmaList() {
		return((List) get(AbstractEssaCtx.CMA_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setCmaList(List<DtoIf> arg) {
		put(AbstractEssaCtx.CMA_LIST_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getDefaultCannedActionList() {
		return((List) get(AbstractEssaCtx.DEFAULT_CANNED_ACTION_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setDefaultCannedActionList(List<DtoIf> arg) {
		put(AbstractEssaCtx.DEFAULT_CANNED_ACTION_LIST_KEY, arg);
	}

	/**
	 * Return default VPO arguments. 
	 * These are the arguments employed if not defined by a rule.
	 * 
	 * @return default VPO arguments
	 */
	public VpoDTO getDefaultVpo() {
		return((VpoDTO) get(AbstractEssaCtx.DEFAULT_VPO_KEY));
	}
	
	/**
	 * Define default VPO arguments.
	 * These are the arguments employed if not defined by a rule.
	 * 
	 * @param arg default VPO arguments
	 * @throws NullPointerException if null arg
	 */
	@SuppressWarnings("unchecked")
	public void setDefaultVpo(VpoDTO arg) {
		if (arg == null) {
			throw new NullPointerException("null default VPO");
		}
		
		put(AbstractEssaCtx.DEFAULT_VPO_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getAlarmInhibitList() {
		return((List) get(AbstractEssaCtx.ALARM_INHIBIT_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setAlarmInhibitList(List<DtoIf> arg) {
		put(AbstractEssaCtx.ALARM_INHIBIT_LIST_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getBootTimeList() {
		return((List) get(AbstractEssaCtx.REBOOT_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setBootTimeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.REBOOT_LIST_KEY, arg);
	}

	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getDirectoryAgeList() {
		return((List) get(AbstractEssaCtx.DIRECTORY_AGE_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setDirectoryAgeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.DIRECTORY_AGE_LIST_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getDirectorySizeList() {
		return((List) get(AbstractEssaCtx.DIRECTORY_SIZE_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setDirectorySizeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.DIRECTORY_SIZE_LIST_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getFileAgeList() {
		return((List) get(AbstractEssaCtx.FILE_AGE_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setFileAgeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.FILE_AGE_LIST_KEY, arg);
	}

	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getFileSizeList() {
		return((List) get(AbstractEssaCtx.FILE_SIZE_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setFileSizeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.FILE_SIZE_LIST_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getFileSystemSizeList() {
		return((List) get(AbstractEssaCtx.FILE_SYSTEM_SIZE_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setFileSystemSizeList(List<DtoIf> arg) {
		put(AbstractEssaCtx.FILE_SYSTEM_SIZE_LIST_KEY, arg);
	}

	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getProcessList() {
		return((List) get(AbstractEssaCtx.PROCESS_LIST_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setProcessList(List<DtoIf> arg) {
		put(AbstractEssaCtx.PROCESS_LIST_KEY, arg);
	}	
	
	/**
	 * Generated serial version ID 
	 */
	private static final long serialVersionUID = -6207951169719535399L;
}
