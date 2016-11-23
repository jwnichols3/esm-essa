package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;

/**
 * @author coleguy
 */
public class DirectorySizeSampleDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public DirectorySizeSampleDtoTest(String name) {
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
	 * AbstractDTO tests
	 */
	public void test01() {
		_log.info("test01");

		DirectorySizeSampleDTO dto1 = new DirectorySizeSampleDTO();
		assertNotNull("test01a", dto1);
		
		dto1.setRowId(new Long(246));
		assertEquals("test01b", 246L, dto1.getRowId().longValue());
		
		dto1.setActive(true);
		assertTrue("test01c", dto1.getActive());
		assertTrue("test01d", dto1.isActive());
		assertTrue("test01e", dto1.getFauxActive().isTrue());
		
		dto1.setActive(false);
		assertFalse("test01f", dto1.getActive());
		assertFalse("test01g", dto1.isActive());
		assertFalse("test01h", dto1.getFauxActive().isTrue());
		
		dto1.setFauxActive(new FauxBoolean(true));
		assertTrue("test01i", dto1.getActive());
		assertTrue("test01j", dto1.isActive());
		assertTrue("test01k", dto1.getFauxActive().isTrue());
		
		dto1.setFauxActive(new FauxBoolean(false));
		assertFalse("test01m", dto1.getActive());
		assertFalse("test01n", dto1.isActive());
		assertFalse("test01o", dto1.getFauxActive().isTrue());
		
		dto1.setNote(new TrimString("fresh note"));
		assertTrue("test01p", dto1.getNote().getValue().equals("fresh note"));
	}
	
	/**
	 * Exercise remaining getters/setters
	 */
	public void test02() {
		_log.info("test02");
		
		DirectorySizeSampleDTO dto1 = new DirectorySizeSampleDTO();
		assertNotNull("test02a", dto1);
		
		//
		// time stamp tests
		//
		ZuluTime zt1 = new ZuluTime();
		assertNotNull("test02b", zt1);
		
		dto1.setTimeStamp(zt1);
		assertTrue("test02c", dto1.getTimeStamp().equals(zt1));
		
		boolean exception_flag = false;
		try {
			dto1.setTimeStamp((ZuluTime) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02d", exception_flag);
		
		//
		// directory exists flag
		//		
		dto1.setFauxExists(_fb_true);
		assertTrue("test02g", dto1.getFauxExists().equals(_fb_true));
		
		dto1.setFauxExists(_fb_false);
		assertTrue("test02h", dto1.getFauxExists().equals(_fb_false));
		
		exception_flag = false;
		try {
			dto1.setFauxExists((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02i", exception_flag);
		
		//
		// storage population
		//
		dto1.setBytePopulation(123);
		assertEquals("test02u", 123, dto1.getBytePopulation());
		
		dto1.setBytePopulation(234);
		assertEquals("test02v", 234, dto1.getBytePopulation());
		
		exception_flag = false;
		try {
			dto1.setBytePopulation(-1);
		} catch(IllegalArgumentException exception) {
			exception_flag = true;
		}
		assertTrue("test02w", exception_flag);
	}

	/**
	 * Faux True
	 */
	private FauxBoolean _fb_true = new FauxBoolean(true);
	
	/**
	 * Faux False
	 */
	private FauxBoolean _fb_false = new FauxBoolean(false);

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(DirectorySizeSampleDtoTest.class);
}
