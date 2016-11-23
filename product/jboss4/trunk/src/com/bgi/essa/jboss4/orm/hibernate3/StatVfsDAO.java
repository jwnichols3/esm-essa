package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.StatVfsDTO;

/**
 * @author coleguy
 */
public class StatVfsDAO extends AbstractDao {

	/**
	 * 
	 */
	public StatVfsDAO() {
		_log.info("StatVfsDAO ctor");
	}

	/**
	 * Select a specific StatVfs row.
	 * 
	 * @param arg selection key, maps to StatVfs.id
	 * @return selected item or null if not found
	 */
	public StatVfsDTO selectRowById(final Long arg) {
		_log.info("select StatVfs by id:" + arg);

		final String query_string = "from StatVfsDTO svfs where svfs.id = :arg1";
		
		StatVfsDTO result = (StatVfsDTO) getRow(new TrimString(arg.toString()), query_string);
		
		//_log.info("result:" + result.toString());
		
		return(result);
	}

	/**
	 * Select a StatVfs sample by (file) name. 
	 * 
	 * @param dto selection key, maps to FileSample.name
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.info("select StatVfs by key:" + dto);

        StatVfsDTO temp = (StatVfsDTO) dto;
        TrimString arg = temp.getName();
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from StatVfsDTO svfs where svfs.active = true and svfs.name = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from StatVfsDTO svfs where svfs.name = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from StatVfsDTO svfs where svfs.active = false and svfs.name = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(arg, query_string));
	}

	/**
	 * Retrieve all StatVfs samples
	 * 
	 * @param option select all or only active/inactive rows.
	 * @return retrieved rows.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from StatVfsDTO svfs where svfs.active = true";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from StatVfsDTO svfs";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from StatVfsDTO svfs where svfs.active = false";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		query_string += " order by svfs.name";

		return(getAllRows(query_string));
	}

	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(StatVfsDAO.class);
}
