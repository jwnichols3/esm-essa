package com.bgi.essa.jboss4.entrance;

import javax.ejb.MessageDrivenBean;

//import javax.jms.JMSException; 
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.orm.OrmFacade;

import com.bgi.essa.shared.transfer.AbstractDto;

/**
 * Persistance queue consumer. 
 * Dispatch instrumentation sample to ORM for database insertion. 
 * 
 * @ejb.bean 
 *   name="PersistConsumerEjb" 
 *   type="MDB"
 *   acknowledge-mode="Auto-acknowledge"
 *   destination-type="javax.jms.Queue"
 *   subscription-durability="NonDurable" 
 *   description="persist queue consumer"
 * 
 * @jboss.destination-jndi-name 
 *   name="queue/essa_persist"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class PersistConsumerBean implements MessageDrivenBean, MessageListener {

	/**
	 * Invoked when messages arrive via queue
	 * 
	 * @param arg fresh message
	 */
	public void onMessage(Message arg) {
		_log.debug("persist noted");

		ObjectMessage om = (ObjectMessage) arg;

		try {
			serviceCandidate((AbstractDto) om.getObject());
		} catch(Exception exception) {
			_log.error("persist consumer:" + exception);
		}
	}
	
	/**
	 * Save a sample to the database
	 * 
	 * @param arg database sample to persist
	 */
	private void serviceCandidate(AbstractDto arg) {
		_log.info("persist:" + arg);
		
		System.out.println("fix me:PersistConsumerBean.serviceCandidate");
		
		/*
		boolean result_flag = _orm.insertOrUpdate(arg);
		if (result_flag) {
			_log.info("persist success");
		} else {
			_log.info("persist failure");
		}
		*/
	}
	
	/**
	 * Handle to database 
	 */
	private final OrmFacade _orm = new OrmFacade();

	/**
	 * Define logger
	 */
	private static final Log _log = LogFactory.getLog(PersistConsumerBean.class);
}