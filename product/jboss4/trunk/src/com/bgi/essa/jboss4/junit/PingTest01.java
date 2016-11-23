package com.bgi.essa.jboss4.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.PingCtx;

import com.bgi.essa.shared.primitive.LegalCmd;

/**
 * Exercise PingCtx
 * 
 * @author coleguy
 */
public class PingTest01 extends TestCase {

	/**
	 * @param name
	 */
	public PingTest01(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Invoke test
	 */
	public void test01() {
		_log.info("test01");
		
		PingCtx ctx1 = new PingCtx();
		assertNotNull("test01a", ctx1);
		assertTrue("test01b", ctx1.getCommand().equals(LegalCmd.PING_CMD));
		
		ctx1.setFlag(false);
		assertFalse("test01c", ctx1.isFlag());
		
		PingCtx ctx2 = null;
		try {
			ctx2 = (PingCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test01d", ctx2);
		assertTrue("test01e", ctx2.isSuccess());
		assertTrue("test01f", ctx2.isFlag());
		
		assertFalse("test01g", ctx1.isSuccess());
		
		///
		
		ctx1.setFlag(true);
		assertTrue("test01h", ctx1.isFlag());
		
		try {
			ctx2 = (PingCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test01i", ctx2);
		assertTrue("test01j", ctx2.isSuccess());
		assertFalse("test01k", ctx2.isFlag());
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(PingTest01.class);
}
