package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.LongKey;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Exercise LongKey
 * 
 * @author coleguy
 */
public class LongKeyTest extends TestCase {

	/**
	 * @param name
	 */
	public LongKeyTest(String name) {
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
		
		//
		//ctor(long)
		//
		LongKey lk2 = new LongKey(123L);
		assertNotNull("test01a", lk2);
		assertEquals("test01b", 123L, lk2.getValue());
		
		boolean exception_flag = false;
		try {
			lk2 = new LongKey(-123);
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}
		assertTrue("test01c", exception_flag);
		
		//
		//ctor(Long)
		//
		lk2 = new LongKey(new Long(123L));
		assertNotNull("test01d", lk2);
		assertEquals("test01e", 123L, lk2.getValue());
		
		exception_flag = false;
		try {
			lk2 = new LongKey(-123);
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}
		assertTrue("test01f", exception_flag);
		
		exception_flag = false;
		try {
			lk2 = new LongKey((Long) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test01g", exception_flag);
		
		//
		//ctor(LongKey)
		//
		LongKey lk3 = new LongKey(234L);
		assertNotNull("test01h", lk3);
		assertEquals("test01i", 234L, lk3.getValue());
		
		LongKey lk4 = new LongKey(lk3);
		assertNotNull("test01j", lk4);
		assertEquals("test01k", 234L, lk4.getValue());
		
		//
		//ctor(String)
		//
		lk2 = new LongKey("567");
		assertNotNull("test01m", lk2);
		assertEquals("test01n", 567L, lk2.getValue());
		
		exception_flag = false;
		try {
			lk2 = new LongKey((String) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test01o", exception_flag);	
		
		exception_flag = false;
		try {
			lk2 = new LongKey("-123");
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}
		assertTrue("test01p", exception_flag);
		
		//
		//ctor(TrimString)
		//
		lk2 = new LongKey(new TrimString("789"));
		assertNotNull("test01q", lk2);
		assertEquals("test01r", 789L, lk2.getValue());
		
		exception_flag = false;
		try {
			lk2 = new LongKey((TrimString) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test01s", exception_flag);	
		
		exception_flag = false;
		try {
			lk2 = new LongKey(new TrimString("-123"));
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}
		assertTrue("test01t", exception_flag);
	}
	
	/**
	 * field method tests
	 */
	public void test02() {
		_log.info("test02");
		
		LongKey lk2 = new LongKey(123L);
		assertNotNull("test02a", lk2);
		assertEquals("test02b", 123L, lk2.getValue());
		assertEquals("test02c", 123L, lk2.getLongKeyValue().longValue());
		
		LongKey lk3 = (LongKey) lk2.clone();
		assertNotNull("test02d", lk3);
		assertEquals("test02e", 123L, lk3.getValue());
		
		assertEquals("test02f", 1353, lk3.hashCode());
		
		assertTrue("test02g", lk2.equals(lk3));
		assertTrue("test02h", lk3.equals(lk2));
		
		assertTrue("test02i", lk2.equals(new Long(123)));
		
		assertFalse("test02j", lk2.equals(new Long(321L)));
		assertFalse("test02k", lk2.equals(null));
		
		assertEquals("test02m", 0, lk2.compareTo(lk3));
		assertEquals("test02n", 1, lk2.compareTo(new LongKey(111)));
		assertEquals("test02o", -1, lk2.compareTo(new LongKey(222)));
		
		assertTrue("test02p", lk2.toString().equals("00000123"));
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(LongKeyTest.class);
}
