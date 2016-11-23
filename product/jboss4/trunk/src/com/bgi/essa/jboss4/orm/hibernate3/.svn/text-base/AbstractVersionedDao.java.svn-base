package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jboss.ejb.plugins.keygenerator.KeyGenerator;
import org.jboss.ejb.plugins.keygenerator.KeyGeneratorFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractVersioned;
import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Parent for DAO which supports versioned tables.
 * 
 * <P>
 * Versioned tables are rarely (perhaps never) deleted from. 
 * 
 * @author coleguy
 */
public abstract class AbstractVersionedDao extends AbstractDao {
	
	/**
	 * Return row w/highest version for a specified task id/rule id
	 *  
	 * @param arg0 target table
	 * @param arg1 task identifier
	 * @param arg2 rule identifier
	 * @return row w/the highest version for specified task/rule or null if not found
	 */
	public DtoIf selectByTaskRuleId(TrimString arg0, TrimString arg1, TrimString arg2) {
		_log.debug("select:" + arg0 + ":task id:" + arg1 + ":rule id:" + arg2);
		
		DtoIf result = null;
		String query_string = "from " + arg0.getValue() + " dto where dto.taskId = :arg1 and dto.ruleId = :arg2 order by version";
		
		List<DtoIf> list = getAllRows(arg1, arg2, query_string);
		if (list == null) {
			return(null);
		}
		
		Iterator<DtoIf> ii = list.iterator();
		while(ii.hasNext()) {
			result = (DtoIf) ii.next();
		}
		
		_log.debug("selectByTaskRule:" + result);
		
		return(result);
	}
	
	/**
	 * Perform versioned insert/update
	 * 
	 * @param arg0 target table
	 * @param arg1 fresh row
	 * @param flush_flag true, flush update
	 * @return true, success
	 */
	public boolean insertOrUpdateRow(TrimString arg0, DtoIf arg1, boolean flush_flag) {
		AbstractVersioned fresh = (AbstractVersioned) arg1;
		
		AbstractVersioned current = (AbstractVersioned) selectByTaskRuleId(arg0, fresh.getTaskId(), fresh.getRuleId());
		if (current != null) {
			current.setActive(false);
			super.insertOrUpdateRow(current, flush_flag);
			
			fresh.setVersion(1 + current.getVersion());
			fresh.setCreation(current.getCreation());
		} else {
			fresh.setVersion(1L);
		}
		
		fresh.setRowId(new Long(0));
	//	fresh.setActive(true);
	
		return(super.insertOrUpdateRow(fresh, flush_flag));
	}
	
	/**
	 * Generate a identifier (task id, rule id, etc)
	 * @return fresh task identifier as hex string
	 */
	public TrimString generateId() {
		try {
			InitialContext ctx = new InitialContext();
			KeyGeneratorFactory kgf = (KeyGeneratorFactory) ctx.lookup(ConstantsIf.KEY_GEN_FACTORY);
			KeyGenerator kg = kgf.getKeyGenerator();
			return(new TrimString((String) kg.generateKey()));
		} catch (Exception exception) {
			_log.error("choke", exception);
		}
		
		return(new TrimString(ConstantsIf.DEFAULT_ID));
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(AbstractVersionedDao.class);
}
