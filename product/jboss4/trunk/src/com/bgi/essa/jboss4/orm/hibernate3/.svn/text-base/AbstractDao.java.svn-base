package com.bgi.essa.jboss4.orm.hibernate3;

import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Parent for data access objects.  All DAO descend from here.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class AbstractDao {

	/**
	 * Return a hibernate session
	 * 
	 * @return a hibernate session or null if failure
	 */
	Session getSession() {
		try {
			InitialContext ctx = new InitialContext();
			SessionFactory factory = (SessionFactory) ctx.lookup(ConstantsIf.SESSION_FACTORY);
			return(factory.getCurrentSession());
		} catch(Exception exception) {
			_log.error("getSession", exception);
		}

		return(null);
	}

	/**
	 * Insert or update a row.
	 * 
	 * @param arg row to insert or update.
	 * @param flush_flag true, perform session flush
	 * @return true, success else failure
	 */
	public boolean insertOrUpdateRow(final DtoIf arg, final boolean flush_flag) {
		_log.debug("insertOrUpate:" + arg);

		final Session ss = getSession();
		if (ss == null) {
			return(false);
		}

		try {
			ss.saveOrUpdate(arg);
			if (flush_flag) {
				ss.flush();
			}
		} catch(final Exception exception) {
			_log.error("insertOrUpdate", exception);
			return(false);
		}

		return(true);
	}

	/**
	 * Perform selection and return the results.
	 * 
	 * @param arg selection string
	 * @return results or null
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getAllRows(final String arg) {
		_log.debug("getAllRows:" + arg);

		final Session ss = getSession();
		if (ss == null) {
			return(null);
		}

		try {
			final Query query = ss.createQuery(arg);
			return(query.list());
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(null);
	}

	/**
	 * Return all rows
	 * 
	 * @param target target
	 * @param query_string selector
	 * @return selected item or null
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getAllRows(final TrimString target, final String query_string) {
		_log.debug("getAllRows:" + target + ":" + query_string);

		Session ss = getSession();
		if (ss == null) {
			return(null);
		}

		try {
			Query query = ss.createQuery(query_string);
			query.setString("arg1", target.getValue());
			return(query.list());
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(null);
	}
	
	/**
	 * Return all rows for a given task/rule tuple
	 * 
	 * @param task
	 * @param rule
	 * @param query_string selector
	 * @return selected item or null
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getAllRows(TrimString task, TrimString rule, String query_string) {
		_log.debug("getAllRows:" + task + ":" + rule + ":" + query_string);

		final Session ss = getSession();
		if (ss == null) {
			return(null);
		}

		try {
			final Query query = ss.createQuery(query_string);
			query.setString("arg1", task.getValue());
			query.setString("arg2", rule.getValue());
			return(query.list());
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(null);
	}
	
	/**
	 * Return all rows for a given task/rule/audit
	 * 
	 * @param task
	 * @param rule
	 * @param audit
	 * @param query_string selector
	 * @return selected item or null
	 */
	@SuppressWarnings("unchecked")
	public List<DtoIf> getAllRows(TrimString task, TrimString rule, TrimString audit, String query_string) {
		_log.debug("getAllRows:" + task + ":" + rule + ":" + audit + ":" + query_string);

		Session ss = getSession();
		if (ss == null) {
			return(null);
		}

		try {
			Query query = ss.createQuery(query_string);
			query.setString("arg1", task.getValue());
			query.setString("arg2", rule.getValue());
			query.setString("arg3", audit.getValue());
			return(query.list());
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(null);
	}
	
	/**
	 * Return a single row based on a string
	 * 
	 * @param target target
	 * @param query_string selector
	 * @return selected item or null
	 */
	public DtoIf getRow(final TrimString target, final String query_string) {
		_log.debug("getRow:" + target + ":" + query_string);

		DtoIf result = null;

		final List<DtoIf> list = getAllRows(target, query_string);
		if (list == null) {
			return(null);
		}

		_log.info("results size:" + list.size());

		if (list.size() < 1) {
			return(null);
		}

		if (list.size() > 1) {
			_log.error("getRow selects multiple items but should only be one");
		}

		for (final Iterator<DtoIf> ii = list.iterator(); ii.hasNext();) {
			result = (DtoIf) ii.next();
		}

		return(result);
	}

	/**
	 * Return a integer from a aggregate
	 * 
	 * @param query_string selector
	 * @return selected integer
	 */
	@SuppressWarnings("unchecked")
	public int getIntegerAggregate(final String query_string) {
		final Session ss = getSession();
		if (ss == null) {
			return(-1);
		}

		int result = 0;

		try {
			final Query query = ss.createQuery(query_string);
			for (final Iterator ii = query.iterate(); ii.hasNext();) {
				final Integer temp = (Integer) ii.next();
				result = temp.intValue();
			}
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(result);
	}

	/**
	 * Delete a row.
	 * 
	 * @param target row to delete
	 * @param flush_flag true, perform session flush
	 * @return true, success else failure
	 */
	public boolean deleteRow(final DtoIf target, final boolean flush_flag) {
		_log.debug("deleteRow:" + target);

		final Session ss = getSession();
		if (ss == null) {
			return(false);
		}

		try {
			ss.delete(target);
			if (flush_flag) {
				ss.flush();
			}

			return(true);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(false);
	}
	
	/**
	 * 
	 * @param query_string
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int getMax(String query_string) {
		_log.debug("getMax:" + query_string);
		
		final Session ss = getSession();
		if (ss == null) {
			return(0);
		}

		try {
			Query query = ss.createQuery(query_string);
			for (Iterator ii = query.iterate(); ii.hasNext();) {
				/*
				final Integer temp = (Integer) ii.next();
				result = temp.intValue();
				*/
				System.out.println(ii.next());
			}
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}

		return(0);
	}

	/**
	 * Select a specific row.
	 * 
	 * @param arg selection key
	 * @return selected item or null if not found
	 */
	public abstract DtoIf selectRowById(Long arg);

	/**
	 * Select items by key where key is table specific.
	 * 
	 * @param dto selector
	 * @param option selection option
	 * @return selected item or null if not found
	 */
	public abstract List<DtoIf> selectRowByKey(DtoIf dto, SelectOption option);

	/**
	 * Select all rows
	 * 
	 * @param arg option to select only active/inactive rows
	 * @return retrieved rows
	 */
	public abstract List<DtoIf> selectAllRows(SelectOption arg);

	/**
	 * Log Factory
	 */
	private final Log _log = LogFactory.getLog(AbstractDao.class);
}