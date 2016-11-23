package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.DirectoryAgeSampleDTO;

/**
 * DirectoryAgeSample data access operations 
 * 
 * @author linden
 */
public class DirectoryAgeSampleDAO extends AbstractDao {

	/**
	 * Select a specific file age sample row.
	 * 
	 * @param arg selection key, maps to DirectoryAgeSample.id
	 * @return selected item or null if not found
	 */
	@Override
	public DirectoryAgeSampleDTO selectRowById(final Long arg) {
		_log.debug("select fileage sample by id:" + arg);

		final String query_string = "from DirectoryAgeSampleDTO dto where dto.id = :arg1";

		return((DirectoryAgeSampleDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select file age samples by rule id
	 * 
	 * @param dto selection key
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	@Override
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select fileage sample by key:" + dto);
		
		DirectoryAgeSampleDTO temp = (DirectoryAgeSampleDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from DirectoryAgeSampleDTO dto where dto.fauxActive = 'T' and dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from DirectoryAgeSampleDTO dto where dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from DirectoryAgeSampleDTO dto where dto.fauxActive = 'F' and dto.ruleId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(temp.getRuleId(), query_string));
	}

	/**
	 * Retrieve all reboot rules
	 * 
	 * @param option select all or only active/inactive rules.
	 * @return retrieved Tasks.
	 */
	@Override
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from DirectoryAgeSampleDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from DirectoryAgeSampleDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from DirectoryAgeSampleDTO dto where dto.fauxActive = 'F'";
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
