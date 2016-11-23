package com.bgi.essa.jboss4.entrance;

import javax.ejb.MessageDrivenBean;

//import javax.jms.JMSException; 
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.transfer.AbstractDto;

/**
 * Notification queue consumer. 
 * Event requires external nogification.
 * 
 * @ejb.bean 
 *   name="NotificationConsumerEjb" 
 *   type="MDB"
 *   acknowledge-mode="Auto-acknowledge"
 *   destination-type="javax.jms.Queue"
 *   subscription-durability="NonDurable" 
 *   description="notification queue consumer"
 * 
 * @jboss.destination-jndi-name 
 *   name="queue/essa_notify"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class NotificationConsumerBean implements MessageDrivenBean, MessageListener {

	/**
	 * Invoked when messages arrive via queue
	 * 
	 * @param arg fresh message
	 */
	public void onMessage(Message arg) {
		_log.debug("notification noted");

		ObjectMessage om = (ObjectMessage) arg;

		try {
			serviceCandidate((AbstractDto) om.getObject());
		} catch(Exception exception) {
			_log.error("command consumer:" + exception);
		}
	}
	
	/**
	 * Evaluate a sample 
	 * 
	 * @param arg database sample to persist
	 */
	private void serviceCandidate(AbstractDto arg) {
		_log.info("evaluate:" + arg);
	}

	/**
	 * Define logger
	 */
	private static final Log _log = LogFactory.getLog(NotificationConsumerBean.class);
}