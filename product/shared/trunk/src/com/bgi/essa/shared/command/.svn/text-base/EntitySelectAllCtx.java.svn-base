package com.bgi.essa.shared.command;

import java.util.ArrayList;
import java.util.List;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Select all the rows for the specified table.
 *
 * @author gsc
 */
public class EntitySelectAllCtx extends AbstractEntityCtx {

	/**
	 * Return command defnition
	 * 
	 * @return command definition
	 */
	@Override
	public LegalCmd getCommand() {
		return(LegalCmd.SELECT_ALL_CMD);
	}

	/**
	 * Return the select option
	 * 
	 * @return the select option
	 */
	public SelectOption getSelectOption() {
		SelectOption temp = (SelectOption) get(AbstractEssaCtx.SELECT_OPTION_KEY);
		if (temp == null) {
			return(SelectOption.SELECT_ALL);
		}
		
		return(temp);
	}
	
	/**
	 * Define the select option
	 * 
	 * @param arg define the select option
	 */
	@SuppressWarnings("unchecked")
	public void setSelectOption(final SelectOption arg) {
		put(AbstractEssaCtx.SELECT_OPTION_KEY, arg);
	}
	
	/**
	 * Return result set, might be null, might be null or empty
	 * 
	 * @return return result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getResults() {
		return((List) get(AbstractEssaCtx.RESULT_KEY));
	}
	
	/**
	 * Define result set, might be null or empty
	 * 
	 * @param arg define result set, might be null or empty
	 */
	@SuppressWarnings("unchecked")
	public void setResults(final List<DtoIf> arg) {
		put(AbstractEssaCtx.RESULT_KEY, arg);
	}
	
	/**
	 * Add a result item, cannot be null
	 * 
	 * @param arg result item
	 */
	@SuppressWarnings("unchecked")
	public void addResult(final DtoIf arg) {
		if (arg == null) {
			return;
		}
		
		List list = getResults();
		if (list == null) {
			list = new ArrayList<DtoIf>();
		}
			
		list.add(arg);
		
		setResults(list);
	}
	
	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -9034352644584041532L;	
}
