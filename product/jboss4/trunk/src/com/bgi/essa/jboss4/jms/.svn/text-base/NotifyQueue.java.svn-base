package com.bgi.essa.jboss4.jms;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.ObjectMessage;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;

import com.bgi.essa.shared.transfer.DtoIf;

/**
 * Notification queue writer
 * 
 * @author coleguy
 */
public class NotifyQueue {
	
	/**
	 * Write the specified transfer object to the evaluation queue to test for notification.
	 * 
	 * @param arg DTO evaluate
	 * @return true if success else failure
	 */
	public boolean queueWriter(DtoIf arg) {
		try {
			Context context = new InitialContext();
			Queue queue = (Queue) context.lookup(ConstantsIf.NOTIFY_QUEUE);
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup(ConstantsIf.CONNECTION_FACTORY);
			QueueConnection connect = factory.createQueueConnection();
			QueueSession session = connect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			ObjectMessage message = session.createObjectMessage();
			message.setObject((DtoIf) arg);
			sender.send(message);
			connect.close();
			return(true);
		} catch(Exception exception) {
			_log.error(exception);
		}
		
		return(false);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(NotifyQueue.class);
}
