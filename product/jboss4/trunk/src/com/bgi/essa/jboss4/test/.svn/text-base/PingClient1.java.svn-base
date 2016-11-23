package com.bgi.essa.jboss4.test;

import com.bgi.essa.jboss4.client.BusinessDelegate;

/**
 * Exercise ping test (simple trip to session facade)
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class PingClient1 {

	/**
	 * Exercise RMI service (ping test)
	 * 
	 * @throws Exception
	 */
	public void runClient() throws Exception {
		final BusinessDelegate bd = new BusinessDelegate();

		final boolean flag = bd.isPingTest(false);
		System.out.println("isPingTest(false) returns:" + flag);
	}

	/**
	 * Exercise RMI service (ping test)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		System.out.println("begin");

		final PingClient1 pc1 = new PingClient1();
		pc1.runClient();

		System.out.println("end");
	}
}