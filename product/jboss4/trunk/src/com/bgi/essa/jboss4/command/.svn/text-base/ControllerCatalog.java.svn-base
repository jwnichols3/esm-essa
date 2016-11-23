package com.bgi.essa.jboss4.command;

import org.apache.commons.chain.Command;

import org.apache.commons.chain.impl.CatalogBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.exception.CommandFailure;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Map controller names to classes
 *
 * @author gsc
 */
public class ControllerCatalog extends CatalogBase {

	/**
	 * ctor, associate names w/commands
	 */
	public ControllerCatalog() {
		addCommand(LegalCmd.DELETE_CMD.toString(), new EntityDeleteCmd());
		addCommand(LegalCmd.UPDATE_CMD.toString(), new EntityUpdateCmd());
		
		addCommand(LegalCmd.SCHEDULE_DELETE_CMD.toString(), new ScheduleDeleteCmd());
		addCommand(LegalCmd.SCHEDULE_UPDATE_CMD.toString(), new ScheduleUpdateCmd());
		addCommand(LegalCmd.SCHEDULE_UTILITY_CMD.toString(), new ScheduleUtilityCmd());
		
		addCommand(LegalCmd.SELECT_ALL_CMD.toString(), new EntitySelectAllCmd());	
		addCommand(LegalCmd.SELECT_BY_KEY_CMD.toString(), new EntitySelectByKeyCmd());
		addCommand(LegalCmd.SELECT_BY_ROW_ID_CMD.toString(), new EntitySelectByRowIdCmd());
		
		addCommand(LegalCmd.BOGUS_CMD.toString(), new BogusCmd());
		addCommand(LegalCmd.PING_CMD.toString(), new PingCmd());
		
		addCommand(LegalCmd.LOAD_XML_CMD.toString(), new LoadXmlCmd());
		
		addCommand(LegalCmd.BOOT_TIME_SAMPLE_CMD.toString(), new BootTimeCmd());
		addCommand(LegalCmd.JNI_STAT_VFS_CMD.toString(), new JniStatVfsCmd());
		addCommand(LegalCmd.JNI_VERSION_CMD.toString(), new JniVersionCmd());
		
		addCommand(LegalCmd.DIRECTORY_AGE_SAMPLE_CMD.toString(), new DirectoryAgeCmd());
		addCommand(LegalCmd.DIR_SIZE_SAMPLE_CMD.toString(), new DirectorySizeCmd());
		addCommand(LegalCmd.FILE_SIZE_SAMPLE_CMD.toString(), new FileSizeCmd());
		addCommand(LegalCmd.FILE_SYSTEM_SIZE_SAMPLE_CMD.toString(), new FileSystemSizeCmd());
		addCommand(LegalCmd.FILE_SAMPLE_CMD.toString(), new FileSampleCmd());
		addCommand(LegalCmd.FILE_SYSTEM_SAMPLE_CMD.toString(), new FileSystemCmd());
		addCommand(LegalCmd.FILE_AGE_SAMPLE_CMD.toString(), new FileAgeCmd());
		addCommand(LegalCmd.PROCESS_SAMPLE_CMD.toString(), new ProcessCmd());
		
		addCommand(LegalCmd.PARENT_TASK_CMD.toString(), new ParentTaskCmd());
	}
	
	/**
	 * Return specified command
	 * 
	 * @param arg command name
	 * @return selected command
	 * @throws CommandFailure if unknown command
	 */
	public EssaCmd getCommand(final TrimString arg) throws CommandFailure {
		final Command command = getCommand(arg.getValue());	
		if (command == null) {
			_log.error("unknown command:" + arg);
			throw new CommandFailure(CommandFailure.UNKNOWN_COMMAND);
		}
		
		return((EssaCmd) command);
	}
	
	/**
	 * Return specified command
	 * 
	 * @param arg command name
	 * @return selected command
	 * @throws CommandFailure if unknown command
	 */
	public Command getCommand(final LegalCmd arg) throws CommandFailure {
		final Command command = getCommand(arg.toString());	
		if (command == null) {
			_log.error("unknown command:" + arg);
			throw new CommandFailure(CommandFailure.UNKNOWN_COMMAND);
		}
		
		return(command);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ControllerCatalog.class);
}
