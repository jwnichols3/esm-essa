package com.bgi.essa.jboss4.xml;

import java.io.ByteArrayInputStream;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author coleguy
 */
public class ConfigurationParser {

	public ConfigurationParseTree xmlParser(String message, RuleSetBase rules) {
		_digester.setValidating(false);
		
		rules.addRuleInstances(_digester);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(message.getBytes());
		
		try {
			return((ConfigurationParseTree) _digester.parse(bais));
		} catch(Exception exception) {
			_log.error("parser choke", exception);
		}
		
		return(null);
	}

	/**
	 * Duty Digester
	 */
	private Digester _digester = new Digester();
	
	/**
	 * Duty Logger
	 */
	private static final Log _log = LogFactory.getLog(ConfigurationParser.class);
	
}
