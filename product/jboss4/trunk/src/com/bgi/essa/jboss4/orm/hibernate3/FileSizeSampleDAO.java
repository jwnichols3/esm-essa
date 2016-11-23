package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileSizeSampleDTO;

/**
 * FileSizeSample data access operations
 * 
 * @author coleguy
 */
public class FileSizeSampleDAO extends AbstractDao {

	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key, maps to dto.id
	 * @return selected item or null if not found
	 */
	public FileSizeSampleDTO selectRowById(Long arg) {
		_log.debug("select file size sample by id:" + arg);

		final String query_string = "from FileSizeSampleDTO dto where dto.id = :arg1";

		return((FileSizeSampleDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select a rule by rule ID
	 * 
	 * @param dto selection key
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(DtoIf dto, SelectOption option) {
		_log.debug("select file size sample by key:" + dto);
		
		FileSizeSampleDTO temp = (FileSizeSampleDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from FileSizeSampleDTO dto where dto.fauxActive = 'T' and dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from FileSizeSampleDTO dto where dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from FileSizeSampleDTO dto where dto.fauxActive = 'F' and dto.ruleId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}
		
		query_string += " order by dto.timeStamp";

		return(getAllRows(temp.getRuleId(), query_string));
	}

	/**
	 * Retrieve all file size rules
	 * 
	 * @param option select all or only active/inactive rules.
	 * @return retrieved Tasks.
	 */
	public List<DtoIf> selectAllRows(SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from FileSizeSampleDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from FileSizeSampleDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from FileSizeSampleDTO dto where dto.fauxActive = 'F'";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(query_string));
	}
	
	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
