package com.bgi.essa.jboss4.jmx;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.jboss.system.ServiceMBeanSupport;

import org.jboss.util.naming.Util;

/**
 * JMX factory for instrumentation.
 * 
 * @author coleguy
 */
public class InstrumentFactoryService extends ServiceMBeanSupport implements InstrumentFactoryServiceMBean {

    /**
     *
     */
    public void startService() {
	factory = new InstrumentFactory();

	try {
	    Context context = (Context) new InitialContext();
	    Util.rebind(context, factory.getFactoryName(), factory);
	} catch(Exception exception) {
	    log.error("startService:", exception);
	}
    }

    public void stopService() {
	try {
	    Context context = (Context) new InitialContext();
	    Util.unbind(context, factory.getFactoryName());
	} catch(Exception exception) {
	    log.error("stopService:", exception);
	}
    }

    InstrumentFactory factory;
}
