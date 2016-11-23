package com.bgi.essa.jboss4.jmx;

import javax.management.ObjectName;

import org.jboss.mx.util.ObjectNameFactory;

import org.jboss.system.ServiceMBean;

/**
 * JMX factory for instrumentation.
 * 
 * @author coleguy
 */
public interface InstrumentFactoryServiceMBean extends ServiceMBean {

    /**
     *
     */
    public static final String DEFAULT_NAME = "essa.jmx:service=InstrumentFactoryIf";

    /**
     *
     */
    public static final ObjectName OBJECT_NAME = ObjectNameFactory.create(DEFAULT_NAME);
}
