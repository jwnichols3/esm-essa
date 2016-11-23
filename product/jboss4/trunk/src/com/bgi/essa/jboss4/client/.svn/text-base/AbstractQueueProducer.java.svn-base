package com.bgi.essa.jboss4.client;

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

import com.bgi.essa.shared.command.AbstractEssaCtx;

import com.bgi.essa.shared.primitive.ConstantsIf;

/**
 * Generic (more or less) queue writer.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public abstract class AbstractQueueProducer {

	/**
	 * ctor
	 * 
	 * @param arg queue name, should be defined in ConstantsIf
	 */
	public AbstractQueueProducer(final String arg) {
		_queue_name = arg;
	}

	/**
	 * Write an object to the (already specified) queue. 
	 * Note that queues are expecting certain classes only (enforced here).
	 * 
	 * @param arg object bound for queue
	 * @return true successful write
	 */
	public boolean queueWriter(final Object arg) {
		_log.info("queue write:" + _queue_name + ":" + arg.toString());

		try {
			final Context jndiContext = new InitialContext();

			final Queue queue = (Queue) jndiContext.lookup(_queue_name);

			final QueueConnectionFactory factory = (QueueConnectionFactory) jndiContext.lookup("ConnectionFactory");

			final QueueConnection connect = factory.createQueueConnection();

			final QueueSession session = connect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

			final QueueSender sender = session.createSender(queue);

			final ObjectMessage message = session.createObjectMessage();

			//
			// Generic Object is not serialized and compiler complains.
			// Must cast to serialized object
			//
			if (ConstantsIf.COMMAND_QUEUE.equals(_queue_name)) {
				message.setObject((AbstractEssaCtx) arg);
				sender.send(message);
			} else {
				_log.error("unknown queue name:" + _queue_name);
			}

			connect.close();

			return(true); // success
		} catch (final Exception exception) {
			_log.error("queue producer", exception);
		}

		return(false); // failure
	}

	/**
	 * Queue name, should be defined in ConstantsIf
	 */
	private final String _queue_name;

	/**
	 * Define logger
	 */
	private static final Log _log = LogFactory.getLog(AbstractQueueProducer.class);
}