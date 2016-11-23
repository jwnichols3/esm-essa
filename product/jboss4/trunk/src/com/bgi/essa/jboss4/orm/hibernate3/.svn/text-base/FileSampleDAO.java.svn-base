package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileSampleDTO;

/**
 * All FileSample data access operations are performed here
 * 
 * @author gsc
 */
public class FileSampleDAO extends AbstractDao {

	/**
	 * 
	 */
	public FileSampleDAO() {
		_log.info("FileSampleDAO ctor");
	}

	/**
	 * Select a specific FileSample row.
	 * 
	 * @param arg selection key, maps to FileSample.id
	 * @return selected item or null if not found
	 */
	public FileSampleDTO selectRowById(final Long arg) {
		_log.info("select FileSample by id:" + arg);

		final String query_string = "from FileSampleDTO fs where fs.id = :arg1";
		
		FileSampleDTO result = (FileSampleDTO) getRow(new TrimString(arg.toString()), query_string);
		
		//_log.info("result:" + result.toString());
		
		return(result);
	}

	/**
	 * Select a FileSample by (file) name. 
	 * 
	 * @param dto selection key, maps to FileSample.name
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.info("select FileSample by key:" + dto);

        FileSampleDTO temp = (FileSampleDTO) dto;
        TrimString arg = temp.getName();
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from FileSampleDTO fs where fs.active = true and fs.name = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from FileSampleDTO fs where fs.name = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from FileSampleDTO fs where fs.active = false and fs.name = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(arg, query_string));
	}

	/**
	 * Retrieve all FileSamples
	 * 
	 * @param option select all or only active/inactive FileSamples.
	 * @return retrieved FileSamples.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from FileSampleDTO fs where fs.active = true";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from FileSampleDTO fs";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from FileSampleDTO fs where fs.active = false";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		query_string += " order by fs.name";

		return(getAllRows(query_string));
	}

	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(FileSampleDAO.class);
}