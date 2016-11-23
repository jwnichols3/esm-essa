package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * Exercise ZuluTime
 * 
 * @author coleguy
 */
public class ZuluTimeTest extends TestCase {

	/**
	 * @param name
	 */
	public ZuluTimeTest(String name) {
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
	 * ctor tests
	 */
	public void test01() {
		_log.info("test01");
		
		ZuluTime zt1 = new ZuluTime(TEST_MILLISECONDS);
		assertNotNull("test01a", zt1);
		assertEquals("test01b", TEST_MILLISECONDS, zt1.getTimeInMillis());
		assertTrue("test01c", zt1.toString().equals("05/15/2007 19:20:49"));
		assertEquals("test01d", -708535468, zt1.hashCode());
		
		ZuluTime zt2 = (ZuluTime) zt1.clone();
		assertNotNull("test01e", zt2);
		assertEquals("test01f", zt1.getTimeInMillis(), zt2.getTimeInMillis());
		
		ZuluTime zt3 = new ZuluTime(zt1);
		assertNotNull("test01g", zt3);
		assertEquals("test01h", zt1.getTimeInMillis(), zt3.getTimeInMillis());
		
		boolean exception_flag = false;
		try {
			zt1 = new ZuluTime((ZuluTime) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}

		assertTrue("test01i", exception_flag);
	}

	/**
	 * exercise field methods
	 */
	public void test02() {
		_log.info("test02");
		
		ZuluTime zt1 = new ZuluTime(TEST_MILLISECONDS);
		assertNotNull("test02a", zt1);
	
		ZuluTime zt2 = new ZuluTime(zt1);
		assertNotNull("test02b", zt2);
		
		ZuluTime zt3 = new ZuluTime();
		assertNotNull("test02c", zt3);
		
		assertTrue("test02d", zt1.equals(zt1));
		assertFalse("test02e", zt1.equals(null));
		
		assertTrue("test02f", zt1.equals(zt2));
		assertTrue("test02g", zt2.equals(zt1));
		
		assertFalse("test02h", zt1.equals(zt3));
		assertFalse("test02i", zt3.equals(zt1));
		
		assertEquals("test02j", 0, zt1.compareTo(zt1));
		assertEquals("test02k", 1, zt3.compareTo(zt1));
		assertEquals("test02m", -1, zt1.compareTo(zt3));
		
		assertFalse("test02n", zt1.after(zt3));
		assertTrue("test02o", zt1.before(zt3));
		
		assertTrue("test02p", zt3.after(zt1));
		assertFalse("test02q", zt3.before(zt1));
	}
	
	/**
	 * 05/15/2007 19:20:49
	 */
	public static final long TEST_MILLISECONDS = 1179256849293L;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ZuluTimeTest.class);
}
