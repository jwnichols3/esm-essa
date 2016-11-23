package com.bgi.essa.shared.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSizeDTO;

import junit.framework.TestCase;

/**
 * @author coleguy
 */
public class FileSizeDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public FileSizeDtoTest(String name) {
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

		FileSizeDTO dto1 = new FileSizeDTO();
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
		
		FileSizeDTO dto1 = new FileSizeDTO();
		assertNotNull("test02a", dto1);
		
		//
		// file name test
		//
		dto1.setTarget(new TrimString("fresh file"));
		assertTrue("test02b", dto1.getTarget().equals("fresh file"));
		
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
		dto1.setMinimumThreshold(468);
		assertEquals("test02f", 468, dto1.getMinimumThreshold());
		
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
		dto1.setMaximumThreshold(789);
		assertEquals("test02i", 789, dto1.getMaximumThreshold());
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSizeDtoTest.class);
}
