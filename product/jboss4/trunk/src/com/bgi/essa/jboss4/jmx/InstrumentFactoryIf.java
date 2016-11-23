package com.bgi.essa.jboss4.jmx;


/**
 * JMX factory for instrumentation.
 * 
 * @author coleguy
 */
public interface InstrumentFactoryIf {

    /**
     * Retrieve factory JNDI name
     *
     * @retrueve factory JNDI name
     */
    public String getFactoryName();

    /**
     * Retrieve FileWrapper (wrapper for java.io.File)
     *
     * @return file wrapper 
     */
    public FileWrapper getFileWrapper() throws Exception;

    /**
     * Retrieve text file reader (wrapper for BufferedReader)
     *
     * @return text file reader (wrapper for BufferedReader)
     */
    public TextFileReader getTextFileReader() throws Exception;

    /**
     * Retrieve JNI wrapper
     *
     * @return JNI wrapper
     */
    public JniStub getJniStub();
}
