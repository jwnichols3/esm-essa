package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;

/**
 * Exercise FauxBoolean
 * 
 * @author coleguy
 */
public class FauxBooleanTest extends TestCase {

	/**
	 * @param name
	 */
	public FauxBooleanTest(String name) {
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
		
		FauxBoolean fb1 = new FauxBoolean(true);
		assertNotNull("test01a", fb1);
		assertTrue("test01b", fb1.isTrue());
		
		fb1 = new FauxBoolean(false);
		assertNotNull("test01c", fb1);
		assertFalse("test01d", fb1.isTrue());
	}
	
	/**
	 * ctor tests
	 */
	public void test02() {
		_log.info("test02");
		
		FauxBoolean fb1 = new FauxBoolean('y');
		assertNotNull("test02a", fb1);
		assertTrue("test02b", fb1.isTrue());
		
		fb1 = new FauxBoolean('Y');
		assertNotNull("test02c", fb1);
		assertTrue("test02d", fb1.isTrue());
		
		fb1 = new FauxBoolean('t');
		assertNotNull("test02e", fb1);
		assertTrue("test02f", fb1.isTrue());
		
		fb1 = new FauxBoolean('T');
		assertNotNull("test02g", fb1);
		assertTrue("test02h", fb1.isTrue());
		
		fb1 = new FauxBoolean('n');
		assertNotNull("test02i", fb1);
		assertFalse("test02j", fb1.isTrue());
		
		fb1 = new FauxBoolean('N');
		assertNotNull("test02k", fb1);
		assertFalse("test02m", fb1.isTrue());
		
		fb1 = new FauxBoolean('f');
		assertNotNull("test02n", fb1);
		assertFalse("test02o", fb1.isTrue());
		
		fb1 = new FauxBoolean('F');
		assertNotNull("test02p", fb1);
		assertFalse("test02q", fb1.isTrue());
		
		boolean exception_flag = false;
		try {
			fb1 = new FauxBoolean('x');
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}

		assertTrue("test02r", exception_flag);
	}
	
	/**
	 * ctor tests
	 */
	public void test03() {
		_log.info("test03");
		
		FauxBoolean fb1 = new FauxBoolean("y");
		assertNotNull("test03a", fb1);
		assertTrue("test03b", fb1.isTrue());
		
		fb1 = new FauxBoolean("Y");
		assertNotNull("test03c", fb1);
		assertTrue("test03d", fb1.isTrue());
		
		fb1 = new FauxBoolean("t");
		assertNotNull("test03e", fb1);
		assertTrue("test03f", fb1.isTrue());
		
		fb1 = new FauxBoolean("T");
		assertNotNull("test03g", fb1);
		assertTrue("test03h", fb1.isTrue());
		
		fb1 = new FauxBoolean("n");
		assertNotNull("test03i", fb1);
		assertFalse("test03j", fb1.isTrue());
		
		fb1 = new FauxBoolean("N");
		assertNotNull("test03k", fb1);
		assertFalse("test03m", fb1.isTrue());
		
		fb1 = new FauxBoolean("f");
		assertNotNull("test03n", fb1);
		assertFalse("test03o", fb1.isTrue());
		
		fb1 = new FauxBoolean("F");
		assertNotNull("test03p", fb1);
		assertFalse("test03q", fb1.isTrue());
		
		boolean exception_flag = false;
		try {
			fb1 = new FauxBoolean("x");
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}

		assertTrue("test03r", exception_flag);
		
		exception_flag = false;
		try {
			fb1 = new FauxBoolean((String) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}

		assertTrue("test03s", exception_flag);
	}

	/**
	 * ctor tests
	 */
	public void test04() {
		_log.info("test04");
		
		FauxBoolean fb1 = new FauxBoolean(true);
		assertNotNull("test04a", fb1);
		assertTrue("test04b", fb1.isTrue());
		
		FauxBoolean fb2 = new FauxBoolean(fb1);
		assertNotNull("test04c", fb2);
		assertTrue("test04d", fb2.isTrue());
		
		fb1 = new FauxBoolean(false);
		assertNotNull("test04e", fb1);
		assertFalse("test04f", fb1.isTrue());
		
		fb2 = new FauxBoolean(fb1);
		assertNotNull("test04g", fb2);
		assertFalse("test04h", fb2.isTrue());
		
		boolean exception_flag = false;
		try {
			fb2 = new FauxBoolean((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}

		assertTrue("test04i", exception_flag);
	}
	
	/**
	 * exercise field methods
	 */
	public void test05() {
		_log.info("test05");
		
		FauxBoolean fb1 = new FauxBoolean(true);
		assertNotNull("test05a", fb1);
		assertTrue("test05b", fb1.isTrue());
		
		FauxBoolean fb2 = new FauxBoolean(false);
		assertNotNull("test05c", fb2);
		assertFalse("test05d", fb2.isTrue());
		
		assertTrue("test05e", fb1.getBooleanValue().booleanValue());
		assertFalse("test05f", fb2.getBooleanValue().booleanValue());
		
		assertTrue("test05g", fb1.getStringValue().equals("T"));
		assertTrue("test05h", fb2.getStringValue().equals("F"));
		
		FauxBoolean fb3 = (FauxBoolean) fb1.clone();
		assertEquals("test05i", fb1.isTrue(), fb3.isTrue());
		fb3 = (FauxBoolean) fb2.clone();
		assertEquals("test05j", fb2.isTrue(), fb3.isTrue());
		
		assertEquals("test05k", 16003, fb1.hashCode());
		assertEquals("test05m", 16081, fb2.hashCode());
		
		assertFalse("test05n", fb1.equals(null));
		assertTrue("test05o", fb1.equals(fb1));
		assertFalse("test05p", fb1.equals(fb2));
		
		assertTrue("test05q", fb1.toString().equals("true"));
		assertTrue("test05r", fb2.toString().equals("false"));
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FauxBooleanTest.class);
}
