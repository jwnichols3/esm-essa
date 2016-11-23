package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;

/**
 * @author coleguy
 */
public class DirectorySizeDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public DirectorySizeDtoTest(String name) {
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

		DirectorySizeDTO dto1 = new DirectorySizeDTO();
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
		
		DirectorySizeDTO dto1 = new DirectorySizeDTO();
		assertNotNull("test02a", dto1);
		
		//
		// directory name test
		//
		dto1.setTarget(new TrimString("fresh directory"));
		assertTrue("test02b", dto1.getTarget().equals("fresh directory"));
		
		boolean exception_flag = false;
		try {
			dto1.setTarget((TrimString) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02c", exception_flag);
		
		//
		// size threshold
		//
		dto1.setThresholdType(SizeThreshold.GROWTH_NONE);
		assertTrue("test02d", dto1.getThresholdType().equals(SizeThreshold.GROWTH_NONE));
		
		exception_flag = false;
		try {
			dto1.setThresholdType((SizeThreshold) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02e", exception_flag);
		
		//
		// fixed size
		//
		//dto1.setFixedThreshold(468);
		//assertEquals("test02f", 468, dto1.getFixedThreshold());
		
		//
		// min size
		//
		dto1.setMinimumThreshold(123);
		assertEquals("test02g", 123, dto1.getMinimumThreshold());
		
		//
		// max size
		//
		dto1.setMaximumThreshold(456);
		assertEquals("test02h", 456, dto1.getMaximumThreshold());
		
		//
		// growth size
		//
		//dto1.setDeltaThreshold(789);
		//assertEquals("test02i", 789, dto1.getDeltaThreshold());
		
		//
		// recursion flag
		//		
		dto1.setFauxRecursive(_fb_true);
		assertTrue("test02j", dto1.getFauxRecursive().equals(_fb_true));
		
		dto1.setFauxRecursive(_fb_false);
		assertTrue("test02k", dto1.getFauxRecursive().equals(_fb_false));
		
		exception_flag = false;
		try {
			dto1.setFauxRecursive((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02m", exception_flag);
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
	private final Log _log = LogFactory.getLog(DirectorySizeDtoTest.class);
}
