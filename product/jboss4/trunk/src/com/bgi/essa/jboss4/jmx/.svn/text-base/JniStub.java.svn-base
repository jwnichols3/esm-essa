package com.bgi.essa.jboss4.jmx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;

/**
 * JNI wrapper
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class JniStub {

	/**
	 * Cause shared objects to load (once)
	 */
	public JniStub() {
		JniStub.loadStub();
	}

	/**
	 * Return time system booted (milliseconds from epoch)
	 * 
	 * @return time system booted (milliseconds from epoch)
	 */
	public native long getBootTime();

	/**
	 * Return shared library version string
	 * 
	 * @return shared library version string
	 */
	public native String getVersion();

	/**
	 * Perform a statvfs(2) to obtain file system statistics
	 * 
	 * @return various space delimited parameters, see code for details
	 */
	public native String getStatVfs(String arg);
	
	/**
	 * Inspect /proc for process information
	 * 
	 * @return all processes as a long string, see code for details
	 */
	public native String getProcesses();

	/**
	 * Cause shared objects to load (once)
	 */
	private synchronized static void loadStub() {
		_log.debug("load stub active");

		if (_load_flag) {
			_log.debug("load flag true");
			return;
		}

		_log.info(System.getProperty("java.library.path"));

		try {
			System.loadLibrary(ConstantsIf.JNI_STUB_LIBRARY);
			_log.info("stubs loaded");

			_load_flag = true;
		} catch (Throwable throwable) {
			_log.error("stub load failure:" + throwable);
		}
	}

	/**
	 * Inhibit multiple shared library loads
	 */
	private static boolean _load_flag = false;

	/**
	 * Define logger
	 */
	private static Log _log = LogFactory.getLog(JniStub.class);
}
