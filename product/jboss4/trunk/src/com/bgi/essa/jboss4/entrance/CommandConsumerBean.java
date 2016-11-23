package com.bgi.essa.jboss4.entrance;

import javax.ejb.MessageDrivenBean;

//import javax.jms.JMSException; 
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.command.Eclectic;

import com.bgi.essa.shared.command.AbstractEssaCtx;

/**
 * Command queue consumer. 
 * Dispatch to eclectic when a fresh queue message arrives.
 * 
 * @ejb.bean 
 *   name="CommandConsumerEjb" 
 *   type="MDB"
 *   acknowledge-mode="Auto-acknowledge"
 *   destination-type="javax.jms.Queue"
 *   subscription-durability="NonDurable" 
 *   description="command queue consumer"
 * 
 * @jboss.destination-jndi-name 
 *   name="queue/essa_command"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class CommandConsumerBean implements MessageDrivenBean, MessageListener {

	/**
	 * Invoked when messages arrive via queue
	 * 
	 * @param arg fresh message
	 */
	public void onMessage(Message arg) {
		_log.debug("command noted");

		ObjectMessage om = (ObjectMessage) arg;

		try {
			_eclectic.serviceCommand((AbstractEssaCtx) om.getObject());
		} catch(Exception exception) {
			_log.error("command consumer:" + exception);
		}
	}

	/**
	 * Command dispatch
	 */
	private final Eclectic _eclectic = new Eclectic();

	/**
	 * Define logger
	 */
	private static final Log _log = LogFactory.getLog(CommandConsumerBean.class);
}