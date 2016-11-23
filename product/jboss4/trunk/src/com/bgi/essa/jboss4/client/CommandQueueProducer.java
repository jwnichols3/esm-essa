package com.bgi.essa.jboss4.client;

import com.bgi.essa.shared.primitive.ConstantsIf;

/**
 * Command queue writer.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class CommandQueueProducer extends AbstractQueueProducer {

	/**
	 * ctor
	 * 
	 * @param arg queue name, should be defined in ConstantsIf
	 */
	public CommandQueueProducer() {
		super(ConstantsIf.COMMAND_QUEUE);
	}
}