package com.bgi.essa.jboss4.jmx;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * JNI wrapper around java.io.File
 * Access w/JNDI via InstrumentFactory
 * 
 * @author coleguy
 */
public class FileWrapper {

	/**
	 * Return true if this file exists
	 * 
	 * @param arg fully qualified file name
	 * @return true if file exists
	 */
	public boolean exists(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.exists());
		} catch(Exception exception) {
			_log.error("FileWrapper.exists", exception);
		}

		return(false);
	}
		
	/**
	 * Return true if this file exists and is a directory
	 * 
	 * @param arg fully qualified file name
	 * @return true if this file exists and is a directory
	 */
	public boolean isDirectory(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.isDirectory());
		} catch(Exception exception) {
			_log.error("FileWrapper.isDirectory", exception);
		}

		return(false);
	}
	
	/**
	 * Return true if this file exists and is a file
	 * 
	 * @param arg fully qualified file name
	 * @return true if this file exists and is a file
	 */
	public boolean isFile(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.isFile());
		} catch(Exception exception) {
			_log.error("FileWrapper.isFile", exception);
		}

		return(false);
	}
	
	/**
	 * Return time of last modification in milliseconds
	 * 
	 * @param arg fully qualified file name
	 * @return time of last modification in milliseconds or -1 if failure
	 */
	public long lastModified(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.lastModified());
		} catch(Exception exception) {
			_log.error("FileWrapper.lastModified", exception);
		}

		return(-1L);
	}
	
	/**
	 * Return file length in bytes
	 * 
	 * @param arg fully qualified file name
	 * @return file length in bytes or -1 if failure
	 */
	public long length(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.length());
		} catch(Exception exception) {
			_log.error("FileWrapper.length", exception);
		}

		return(-1L);
	}

	/**
	 * Return children of this directory
	 * 
	 * @param arg fully qualified file name
	 * @return array of file names representing children of this directory
	 */
	public String[] list(TrimString arg) {
		try {
			File file = new File(arg.getValue());
			return(file.list());
		} catch(Exception exception) {
			_log.error("FileWrapper.list", exception);
		}

		// String[] failure = new String[0];

		return(new String[0]);
	}

	/**
	 * Logger
	 */
	private static Log _log = LogFactory.getLog(FileWrapper.class);
}
