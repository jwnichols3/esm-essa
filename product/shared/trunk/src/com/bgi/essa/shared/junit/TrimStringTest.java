package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * Exercise TrimString
 * 
 * @author coleguy
 */
public class TrimStringTest extends TestCase {

	/**
	 * @param name
	 */
	public TrimStringTest(String name) {
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
	 * string ctor
	 */
	public void test01() {
		_log.info("test01");
		
		TrimString ts1 = new TrimString("test string");
		assertNotNull("test01a", ts1);
		assertTrue("test01b", ts1.getValue().equals("test string"));
		
		ts1 = new TrimString(" test string ");
		assertNotNull("test01c", ts1);
		assertTrue("test01d", ts1.getValue().equals("test string"));
		
		boolean exception_flag = false;
		try {
			ts1 = new TrimString((String) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}

		assertTrue("test01e", exception_flag);
		
		exception_flag = false;
		try {
			ts1 = new TrimString("   ");
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}

		assertTrue("test01f", exception_flag);
	}
	
	/**
	 * TrimString ctor
	 */
	public void test02() {
		_log.info("test02");
		
		TrimString ts1 = new TrimString("test string");
		assertNotNull("test02a", ts1);
		
		TrimString ts2 = new TrimString(ts1);
		assertNotNull("test02b", ts2);
		
		assertTrue("test02c", ts1.getValue().equals(ts2.getValue()));
		assertTrue("test02d", ts2.getValue().equals(ts1.getValue()));
		
		assertTrue("test02e", ts2.getValue().equals("test string"));
				
		boolean exception_flag = false;
		try {
			ts1 = new TrimString((TrimString) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}

		assertTrue("test02f", exception_flag);
	}
	
	/**
	 * exercise field methods
	 */
	public void test03() {
		_log.info("test03");
		
		TrimString ts1 = new TrimString("test string");
		assertNotNull("test03a", ts1);
		
		assertTrue("test03b", ts1.toString().equals("test string"));
		assertTrue("test03c", ts1.getUpperCaseValue().equals("TEST STRING"));
		
		ts1.toUpperCase();
		assertTrue("test03d", ts1.getValue().equals("TEST STRING"));
		assertTrue("test03e", ts1.toString().equals("TEST STRING"));
		
		TrimString ts2 = (TrimString) ts1.clone();
		assertNotNull("test03f", ts2);
		
		assertTrue("test03g", ts1.getValue().equals(ts2.getValue()));
		assertTrue("test03h", ts2.getValue().equals(ts1.getValue()));

		assertEquals("test03i", ts1.hashCode(), ts2.hashCode());

		assertTrue("test03j", ts1.equals(ts2));
		assertTrue("test03k", ts2.equals(ts1));
		
		assertFalse("test03m", ts1.equals(null));
		
		TrimString ts3 = new TrimString("something different");
		
		assertFalse("test03n", ts1.equals(ts3));
		assertFalse("test03o", ts3.equals(ts1));
		
		assertEquals("test03p", 0, ts1.compareTo(ts1));
		assertEquals("test03q", 1, ts3.compareTo(ts1));
		assertEquals("test03r", -1, ts1.compareTo(ts3));
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(TrimStringTest.class);
}
