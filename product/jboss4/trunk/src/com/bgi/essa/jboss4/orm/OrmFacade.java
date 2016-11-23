package com.bgi.essa.jboss4.orm;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.hibernate3.AbstractDao;
import com.bgi.essa.jboss4.orm.hibernate3.AlarmInhibitDAO;
import com.bgi.essa.jboss4.orm.hibernate3.BootTimeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.BootTimeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.CannedActionDAO;
import com.bgi.essa.jboss4.orm.hibernate3.CustomMessageAttributeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.DirectoryAgeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.DirectoryAgeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.DirectorySizeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.DirectorySizeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileAgeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileAgeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileSizeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileSizeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileSystemSizeDAO;
import com.bgi.essa.jboss4.orm.hibernate3.FileSystemSizeSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.ProcessDAO;
import com.bgi.essa.jboss4.orm.hibernate3.ProcessSampleDAO;
import com.bgi.essa.jboss4.orm.hibernate3.StatVfsDAO;
import com.bgi.essa.jboss4.orm.hibernate3.TaskDAO;
import com.bgi.essa.jboss4.orm.hibernate3.VpoDAO;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;
import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.DirectoryAgeSampleDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.FileAgeSampleDTO;
import com.bgi.essa.shared.transfer.FileSampleDTO;
import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSizeSampleDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeSampleDTO;
import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.ProcessSampleDTO;
import com.bgi.essa.shared.transfer.StatVfsDTO;
import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * Object Relational Mapping Facade. 
 * All data transfer objects pass via this class.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class OrmFacade {

	/**
	 * Delete a row.
	 * 
	 * @param arg row to delete
	 * @return true, success else failure
	 */
	public boolean delete(DtoIf arg) {
		_log.debug("delete noted");

		AbstractDao dao = DaoDispatch(arg);
		if (dao == null) {
			return(false);
		}

		if (arg.isReasonable()) {
			return(dao.deleteRow(arg, false));
		}

		_log.error("not reasonable");

		return(false);
	}

	/**
	 * Insert or update a row.  Returns w/updated DTO (like row id).  
	 * Downstream consumers (like JUnit tests) are counting on updated DTO.
	 * 
	 * @param arg row to insert or update.
	 * @return true, success else failure
	 */
	public boolean insertOrUpdate(DtoIf arg) {
		_log.debug("insert/update noted:" + arg);
		
		AbstractDao dao = DaoDispatch(arg);
		if (dao == null) {
			return(false);
		}

		if (arg.isReasonable()) {
			boolean result = dao.insertOrUpdateRow(arg, false);
			_log.debug("insert/update done:" + arg);
			return(result);
		}

		return(false);
	}

	/**
	 * Select all rows
	 * 
	 * @param dto transfer object to select for
	 * @param option all, active, inactive
	 * @return selected rows
	 */
	public List<DtoIf> selectAll(DtoIf dto, SelectOption option) {
		_log.debug("select all noted:" + dto);

		AbstractDao dao = DaoDispatch(dto);
		if (dao == null) {
			return(null);
		}

		return(dao.selectAllRows(option));
	}

	/**
	 * Select by Key. Actual selection depends on table.
	 * 
	 * @param dto transfer object w/key
	 * @param option all, active, inactive
	 * @return selected rows
	 */
	public List<DtoIf> selectByKey(DtoIf dto, SelectOption option) {
		_log.debug("select by key noted:" + dto);

		AbstractDao dao = DaoDispatch(dto);
		if (dao == null) {
			return(null);
		}

		return(dao.selectRowByKey(dto, option));
	}

	/**
	 * Select by Row ID. Can only match a single element (or none)
	 * 
	 * @param dto transfer object w/row id
	 * @return selected item or null if not found
	 */
	public DtoIf selectByRowId(DtoIf dto) {
		_log.debug("select by row id noted:" + dto);

		AbstractDao dao = DaoDispatch(dto);
		if (dao == null) {
			return(null);
		}
		
		DtoIf result = dao.selectRowById(dto.getRowId());

		return(result);
	}

	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	
	/**
	 * Return the most current row of a versioned table
	 * 
	 * @param dto type
	 * @param task_id task identifier
	 * @param rule_id rule identifier
	 * @return selected row or null if not found
	 */
	public DtoIf selectByTaskRuleId(DtoIf dto, TrimString task_id, TrimString rule_id) {
		_log.debug("select by task/rule id noted:" + task_id + ":" + rule_id);
		
		if (dto instanceof VpoDTO) {
			VpoDAO dao = new VpoDAO();
			return(dao.selectByTaskRuleId(task_id, rule_id));
		}
		
		_log.error("unknown entity type:" + dto);
		return(null);
	}
	
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	/**
	 * Discover affiliated access object to support this request
	 * 
	 * @param arg transfer object of interest
	 * @return null if not known or appropriate DTO
	 */
	private AbstractDao DaoDispatch(DtoIf arg) { 
		if (arg instanceof AlarmInhibitDTO) {
			_log.debug("alarm inhibit vo noted");
			return(new AlarmInhibitDAO());
		} else if (arg instanceof BootTimeDTO) {
			_log.debug("reboot vo noted");
			return(new BootTimeDAO());
		} else if (arg instanceof BootTimeSampleDTO) {
			_log.debug("boot time sample vo noted");
			return(new BootTimeSampleDAO());
		} else if (arg instanceof CannedActionDTO) {
			_log.debug("canned action vo noted");
			return(new CannedActionDAO());
		} else if (arg instanceof CustomMessageAttributeDTO) {
			_log.debug("custom message attribute vo noted");
			return(new CustomMessageAttributeDAO());
		} else if (arg instanceof DirectoryAgeDTO) {
			_log.debug("directory age vo noted");
			return(new DirectoryAgeDAO());
		} else if (arg instanceof DirectoryAgeSampleDTO) {
			_log.debug("directory age sample vo noted");
			return(new DirectoryAgeSampleDAO());
		} else if (arg instanceof DirectorySizeDTO) {
			_log.debug("directory size vo noted");
			return(new DirectorySizeDAO());
		} else if (arg instanceof DirectorySizeSampleDTO) {
			_log.debug("directory size sample vo noted");
			return(new DirectorySizeSampleDAO());
		} else if (arg instanceof FileAgeDTO) {
			_log.debug("file age vo noted");
			return(new FileAgeDAO());
		} else if (arg instanceof FileAgeSampleDTO) {
			_log.debug("file sample vo noted");
			return(new FileAgeSampleDAO());
		} else if (arg instanceof FileSampleDTO) {
			_log.debug("file sample vo noted");
			return(new FileSampleDAO());
		} else if (arg instanceof FileSizeDTO) {
			_log.debug("file size vo noted");
			return(new FileSizeDAO());
		} else if (arg instanceof FileSizeSampleDTO) {
			_log.debug("file size sample vo noted");
			return(new FileSizeSampleDAO());
		} else if (arg instanceof FileSystemSizeDTO) {
			_log.debug("file size vo noted");
			return(new FileSystemSizeDAO());
		} else if (arg instanceof FileSystemSizeSampleDTO) {
			_log.debug("file size sample vo noted");
			return(new FileSystemSizeSampleDAO());
		} else if (arg instanceof StatVfsDTO) {
			_log.debug("stat vfs sample vo noted");
			return(new StatVfsDAO());
		} else if (arg instanceof ProcessDTO) {
			_log.debug("process vo noted");
			return(new ProcessDAO());
		} else if (arg instanceof ProcessSampleDTO) {
			_log.debug("process sample vo noted");
			return(new ProcessSampleDAO());
		} else if (arg instanceof TaskDTO) {
			_log.debug("task vo noted");
			return(new TaskDAO());
		} else if (arg instanceof VpoDTO) {
			_log.debug("vpo vo noted");
			return(new VpoDAO());
		}

		_log.error("unknown entity type:" + arg);
		return(null);
	}

	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(OrmFacade.class);
}
