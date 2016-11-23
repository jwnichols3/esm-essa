package com.bgi.essa.jboss4.entrance;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.command.Eclectic;

import com.bgi.essa.shared.command.AbstractEssaCtx;
import com.bgi.essa.shared.exception.CommandFailure;

/**
 * Dedicated entry point into JBoss services for RMI clients.
 * 
 * @ejb.bean
 *   name="SessionFacadeEjb" 
 *   type="Stateless"
 *   jndi-name="${jndi.base}/SessionFacadeRemote"
 *   local-jndi-name="${jndi.base}/SessionFacadeLocalHome"
 *   description="rmi gateway"
 * 
 * @ejb.transaction 
 *   type="Required"
 * 
 * @ejb.transaction-type 
 *   type="Container"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class SessionFacadeBean implements SessionBean {

	/**
	 * Test method, flip arg and return result.
	 * 
	 * @param arg flag to flip
	 * @return flipped flag
	 * 
	 * @ejb.interface-method
	 */
	public boolean isPingTest(boolean arg) {
		_log.info("isPingTest() active for user:" + getUserName());	
		return(!arg);
	}

	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////

	/**
	 * Service generic commands
	 * 
	 * @param context w/input arguments 
	 * @return updated context w/output results
	 * @throws CommandFailure if problem
	 * 
	 * @ejb.interface-method
	 */
	public AbstractEssaCtx serviceCommand(final AbstractEssaCtx context) throws CommandFailure {
		_log.debug("service generic command:" + context.getCommand() + ":user:" + getUserName());
		
		_eclectic.serviceCommand(context);
		
		return(context);
	}
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////

	/**
	 * Define context
	 * 
	 * @param arg fresh context
	 */
	public void setSessionContext(final SessionContext arg) {
		_context = arg;
	}

	/**
	 * Return user name
	 * 
	 * @return user name
	 */
	private String getUserName() {
		return(_context.getCallerPrincipal().getName());
	}

	/**
	 * Context
	 */
	private SessionContext _context;
	
	/**
	 * Command dispatch
	 */
	private final Eclectic _eclectic = new Eclectic();

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(SessionFacadeBean.class);
}
