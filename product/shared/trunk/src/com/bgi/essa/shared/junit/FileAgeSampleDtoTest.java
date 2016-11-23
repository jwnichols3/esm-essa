package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.FileAgeSampleDTO;

/**
 * @author coleguy
 */
public class FileAgeSampleDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public FileAgeSampleDtoTest(final String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * AbstractDTO tests
	 */
	public void test01() {
		_log.info("test01");

		FileAgeSampleDTO dto1 = new FileAgeSampleDTO();
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
		
		FileAgeSampleDTO dto1 = new FileAgeSampleDTO();
		assertNotNull("test02a", dto1);
		
		//
		// time stamp tests
		//
		ZuluTime zt1 = new ZuluTime();
		assertNotNull("test02b", zt1);
		
		dto1.setModificationTime(zt1);
		assertTrue("test02c", dto1.getModificationTime().equals(zt1));
		
		boolean exception_flag = false;
		try {
			dto1.setModificationTime((ZuluTime) null);
		} catch(final NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02d", exception_flag);
		
		//
		// file name test
		//
		dto1.setFileName(new TrimString("big bogus"));
		assertTrue("test02e", dto1.getFileName().equals("big bogus"));
		
		exception_flag = false;
		try {
			dto1.setFileName((TrimString) null);
		} catch(final NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02f", exception_flag);
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileAgeSampleDtoTest.class);
}
