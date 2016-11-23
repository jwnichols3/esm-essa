package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;
//import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;

/**
 * BootTimeSample data access operations 
 * 
 * @author coleguy
 */
public class BootTimeSampleDAO extends AbstractDao {

	/**
	 * Select a specific BootTimeSample row.
	 * 
	 * @param arg selection key, maps to BootTimeSample.id
	 * @return selected item or null if not found
	 */
	public BootTimeSampleDTO selectRowById(final Long arg) {
		_log.debug("select BootTimeSample by id:" + arg);

		final String query_string = "from BootTimeSampleDTO dto where dto.id = :arg1";

		return((BootTimeSampleDTO) getRow(new TrimString(arg.toString()), query_string));
	}

	/**
	 * Select BootTimeSamples by rule id
	 * 
	 * @param dto selection key
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public List<DtoIf> selectRowByKey(final DtoIf dto, final SelectOption option) {
		_log.debug("select BootTimeSample by key:" + dto);

		BootTimeSampleDTO temp = (BootTimeSampleDTO) dto;
		
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from BootTimeSampleDTO dto where dto.fauxActive = 'T' and dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from BootTimeSampleDTO dto where dto.ruleId = :arg1";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from BootTimeSampleDTO dto where dto.fauxActive = 'F' and dto.ruleId = :arg1";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		return(getAllRows(temp.getRuleId(), query_string));
	}

	/**
	 * Retrieve all BootTimeSamples
	 * 
	 * @param option select all or only active/inactive BootTimeSamples.
	 * @return retrieved BootTimeSamples.
	 */
	public List<DtoIf> selectAllRows(final SelectOption option) {
		String query_string = null;

		if (option.equals(SelectOption.SELECT_ACTIVE)) {
			query_string = "from BootTimeSampleDTO dto where dto.fauxActive = 'T'";
		} else if (option.equals(SelectOption.SELECT_ALL)) {
			query_string = "from BootTimeSampleDTO dto";
		} else if (option.equals(SelectOption.SELECT_INACTIVE)) {
			query_string = "from BootTimeSampleDTO dto where dto.fauxActive = 'F'";
		} else {
			_log.error("unknown selection option:" + option);
			return(null);
		}

		query_string += " order by dto.timeStamp";

		return(getAllRows(query_string));
	}

	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(BootTimeSampleDAO.class);
}
