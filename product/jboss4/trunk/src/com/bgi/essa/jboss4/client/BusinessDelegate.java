package com.bgi.essa.jboss4.client;

import java.rmi.RemoteException;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.command.EntitySelectAllCtx;
import com.bgi.essa.shared.command.EntitySelectByKeyCtx;
import com.bgi.essa.shared.command.EntitySelectByRowIdCtx;
import com.bgi.essa.shared.command.EntityUpdateCtx;

import com.bgi.essa.shared.exception.BackEndFailure;
import com.bgi.essa.shared.exception.EssaException;

import com.bgi.essa.shared.primitive.SelectOption;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Classic Business Delegate (as described in "Core J2EE Patterns")
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class BusinessDelegate {

	/**
	 * Hook for shutdown action.
	 */
	public void gracefulShutDown() {
		_log.info("graceful shutdown");
	}

	/**
	 * Configure RMI for localhost.
	 */
	public void loadLocalHost() {
		final Hashtable<String, String> jndi = new Hashtable<String, String>();

		jndi.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		jndi.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		RmiProperties.setJndi(jndi);
	}

	/**
	 * Test method, flip arg and return result.
	 * 
	 * @param arg flag to flip
	 * @return flipped flag
	 * @throws EssaException if problem
	 */
	public boolean isPingTest(final boolean arg) throws EssaException {
		final SessionFacadeEjbRemote sfer = getRemote();

		try {
			return(sfer.isPingTest(arg));
		} catch(final RemoteException re) {
			_log.error(BackEndFailure.RMI_FAILURE, re);
			throw new BackEndFailure(BackEndFailure.RMI_FAILURE);
		}
	}

	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	/**
	 * Service a generic command
	 * 
	 * @param arg command
	 * @return updated command
	 * @throws EssaException if problem
	 */
	public AbstractEssaCtx serviceCommand(final AbstractEssaCtx arg) throws EssaException {
		final SessionFacadeEjbRemote sfer = getRemote();

		try {
			return(sfer.serviceCommand(arg));
		} catch(final RemoteException re) {
			_log.error(BackEndFailure.RMI_FAILURE, re);
			throw new BackEndFailure(BackEndFailure.RMI_FAILURE);
		}
	}
	
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	/**
	 * Save or update to database
	 * 
	 * @param arg fresh row
	 * @return updated row
	 */
	public DtoIf saveOrUpdate(final DtoIf arg) {
		final EntityUpdateCtx ctx1 = new EntityUpdateCtx();
		ctx1.setCandidate(arg);

		try {
			EntityUpdateCtx ctx2 = (EntityUpdateCtx) serviceCommand(ctx1);
			if (ctx2.isSuccess() == false) {
				_log.info("save or update failure noted");
			}
			
			return(ctx2.getCandidate());
		} catch(final Exception exception) {
			_log.error("save or update exception noted");
		}
		
		return(null);
	}

	/**
	 * Generic select all
	 * 
	 * @param target transfer object to select for
	 * @param option selection option
	 * @return candidates or null if failure
	 */
	public List<DtoIf> selectAll(final DtoIf target, final SelectOption option) {
		EntitySelectAllCtx ctx = new EntitySelectAllCtx();
		ctx.setCandidate(target);
		ctx.setSelectOption(option);

		List<DtoIf> result = null;

		try {
			ctx = (EntitySelectAllCtx) serviceCommand(ctx);
			result = ctx.getResults();
		} catch(final Exception exception) {
			_log.error("select all exception noted");
		}

		if (result == null) {
			_log.debug("select all null results");
		} else {
			_log.debug("select all list size:" + result.size());
		}

		return(result);
	}

	/**
	 * Generic select by row id
	 * 
	 * @param target transfer object (contains row id)
	 * @return candidate or null if not found
	 */
	public DtoIf selectByRowId(final DtoIf target) {
		final EntitySelectByRowIdCtx esbric1 = new EntitySelectByRowIdCtx();
		esbric1.setCandidate(target);

		EntitySelectByRowIdCtx esbric2 = null;

		try {
			esbric2 = (EntitySelectByRowIdCtx) serviceCommand(esbric1);
		} catch(final Exception exception) {
			_log.error("select by row id exception noted");
		}

		if (esbric2.getCandidate() == null) {
			_log.debug("select by row id null result");
		} else {
			_log.debug("select by row id populated result");
			return(esbric2.getResult());
		}

		return(null);
	}
	
	/**
	 * Generic select by key (where key for versioned DAO/DTO is task id)
	 * 
	 * @param target DTO w/task id
	 * @param option selection option
	 * @return candidates or null if failure
	 */
	public List<DtoIf> selectByKey(DtoIf target, SelectOption option) {
		EntitySelectByKeyCtx ctx = new EntitySelectByKeyCtx();
		ctx.setCandidate(target);
		ctx.setSelectOption(option);

		List<DtoIf> result = null;

		try {
			ctx = (EntitySelectByKeyCtx) serviceCommand(ctx);
			result = ctx.getResults();
		} catch(final Exception exception) {
			_log.error("select by key exception noted");
		}

		if (result == null) {
			_log.debug("select by key null results");
		} else {
			_log.debug("select by key list size:" + result.size());
		}

		return(result);
	}

	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////

	/**
	 * Return remote interface to JBoss
	 * 
	 * @return remote interface to JBoss
	 * @throws BackEndFailure if RMI failure
	 */
	private SessionFacadeEjbRemote getRemote() throws BackEndFailure {
		try {
			loadLocalHost();
			final SessionFacadeEjbHomeRemote sfehr = SessionFacadeEjbUtil.getHome(RmiProperties.getJndiHashtable());
			return(sfehr.create());
		} catch(final Exception exception) {
			_log.error(BackEndFailure.RMI_FAILURE, exception);
			throw new BackEndFailure();
		}
	}

	/**
	 * Define logger
	 */
	private static final Log _log = LogFactory.getLog(BusinessDelegate.class);
}
