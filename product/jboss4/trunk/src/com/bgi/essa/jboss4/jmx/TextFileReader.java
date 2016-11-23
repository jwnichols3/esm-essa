package com.bgi.essa.jboss4.jmx;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Read a text file and return the contents as a string array
 * Access w/JNDI via InstrumentFactory
 * 
 * @author coleguy
 */
public class TextFileReader {

	/**
	 * Read a text file and return the contents as a string array
	 * 
	 * @param arg fully qualified file name
	 * @return contents as string array, might be empty but never null
	 */
	public String[] readFile(String arg) {
		ArrayList<String> content = new ArrayList<String>();

		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(arg));

			String temp = null;
			do {
				temp = bf.readLine();
				if (temp != null) {
					content.add(temp);
				}
			} while(temp != null);
		} catch (Exception exception) {
			_log.error("text file reader", exception);
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
			} catch (Exception exception) {
				_log.error("problem closing text file");
			}
		}

		String[] results = new String[content.size()];

		for (int ii = 0; ii < content.size(); ii++) {
			results[ii] = (String) content.get(ii);
		}

		return(results);
	}

	/**
	 * Logger
	 */
	private static Log _log = LogFactory.getLog(TextFileReader.class);
}
