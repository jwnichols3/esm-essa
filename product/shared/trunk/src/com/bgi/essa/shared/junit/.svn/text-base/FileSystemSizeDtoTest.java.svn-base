package com.bgi.essa.shared.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSystemSizeDTO;

import junit.framework.TestCase;

/**
 * @author coleguy
 */
public class FileSystemSizeDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public FileSystemSizeDtoTest(String name) {
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

		FileSystemSizeDTO dto1 = new FileSystemSizeDTO();
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
		
		FileSystemSizeDTO dto1 = new FileSystemSizeDTO();
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
		// block size
		//
		dto1.setBlockThreshold(468);
		assertEquals("test02f", 468, dto1.getBlockThreshold());
		
		//
		// inode size
		//
		dto1.setInodeThreshold(123);
		assertEquals("test02g", 123, dto1.getInodeThreshold());
	}

	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSystemSizeDtoTest.class);
}
