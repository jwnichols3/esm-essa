package com.bgi.essa.jboss4.client;

import java.util.Hashtable;

/**
 * RMI configuration. All static methods.
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class RmiProperties {

	/**
	 * Set JNDI properties, employed by Struts plug in
	 * 
	 * @param args JNDI properties
	 */
	public static void setJndi(final Hashtable<String, String> args) {
		_hashtable = args;
	}

	/**
	 * Return JNDI properties
	 * 
	 * @return JNDI properties
	 */
	public static Hashtable<String, String> getJndiHashtable() {
		return(_hashtable);
	}

	/**
	 * Define J2EE security domain
	 * 
	 * @param arg security domain
	 */
	public static void setSecurityDomain(final String arg) {
		_security_domain = arg;
	}

	/**
	 * Return J2EE security domain
	 * 
	 * @return J2EE security domain
	 */
	public static String getSecurityDomain() {
		return(_security_domain);
	}

	/**
	 * Reference to global J2EE security domain
	 */
	private static String _security_domain;

	/**
	 * Reference to global JNDI properties
	 */
	private static Hashtable<String, String> _hashtable;
}