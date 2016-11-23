package com.bgi.essa.jboss4.jmx;

import java.io.Serializable;

import com.bgi.essa.shared.primitive.ConstantsIf;

/**
 * JMX factory for instrumentation.
 * 
 * @author coleguy
 */
public class InstrumentFactory implements InstrumentFactoryIf, Serializable {
	
	/**
	 * Retrieve factory JNDI name
	 * 
	 * @retrueve factory JNDI name
	 */
	public String getFactoryName() {
		return(ConstantsIf.INSTRUMENT_FACTORY);
	}

	/**
	 * Retrieve FileWrapper (wrapper for java.io.File)
	 * 
	 * @return file wrapper
	 */
	public FileWrapper getFileWrapper() throws Exception {
		return(new FileWrapper());
	}

	/**
	 * Retrieve text file reader (wrapper for BufferedReader)
	 * 
	 * @return text file reader (wrapper for BufferedReader)
	 */
	public TextFileReader getTextFileReader() throws Exception {
		return(new TextFileReader());
	}

	/**
	 * Retrieve JNI wrapper
	 * 
	 * @return JNI wrapper
	 */
	public JniStub getJniStub() {
		return(new JniStub());
	}

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -1884551849758318761L;
}
