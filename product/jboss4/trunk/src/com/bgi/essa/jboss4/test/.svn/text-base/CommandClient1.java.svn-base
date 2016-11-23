package com.bgi.essa.jboss4.test;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.JniVersionCtx;
import com.bgi.essa.shared.command.PingCtx;

/**
 * //type comment//
 *
 * @author gsc
 */
public class CommandClient1 {

	/**
	 * Exercise RMI service (ping test)
	 * 
	 * @throws Exception
	 */
	public void runClient1() throws Exception {
		final BusinessDelegate bd = new BusinessDelegate();
		final boolean flag = bd.isPingTest(false);
		System.out.println("isPingTest(false) returns:" + flag);
	}
	
	public void runClient2() throws Exception {
		PingCtx ctx = new PingCtx();
		
		ctx.setFlag(false);
		
		final BusinessDelegate bd = new BusinessDelegate();
		ctx = (PingCtx) bd.serviceCommand(ctx);	
		
		System.out.println("pingTest(false) returns:" + ctx.isFlag());
	}
	
	public void runClient3() throws Exception {
		JniVersionCtx ctx = new JniVersionCtx();
		
		final BusinessDelegate bd = new BusinessDelegate();
		ctx = (JniVersionCtx) bd.serviceCommand(ctx);	
		
		System.out.println("JNI version returns:" + ctx.getVersion());
	}

	/**
	 * Exercise RMI service (ping test)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		System.out.println("begin");

		final CommandClient1 cc1 = new CommandClient1();
		cc1.runClient1();
		cc1.runClient2();
		cc1.runClient3();
		
		System.out.println("end");
	}
}