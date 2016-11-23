package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.FileSampleDTO;

/**
 * Exercise FileSampleDTO
 * 
 * @author coleguy
 */
public class FileSampleDtoTest extends TestCase {

	/**
	 * @param name
	 */
	public FileSampleDtoTest(String name) {
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

		FileSampleDTO dto1 = new FileSampleDTO();
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
	 * FileSampleDTO tests
	 */
	public void test02() {
		_log.info("test02");

		FileSampleDTO dto1 = new FileSampleDTO();
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
		// file name test
		//
		dto1.setName(new TrimString("fresh name"));
		assertTrue("test02e", dto1.getName().equals("fresh name"));
		
		exception_flag = false;
		try {
			dto1.setName((TrimString) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02f", exception_flag);
		
		//
		// file exists flag
		//		
		dto1.setIsExists(_fb_true);
		assertTrue("test02g", dto1.getIsExists().equals(_fb_true));
		
		dto1.setIsExists(_fb_false);
		assertTrue("test02h", dto1.getIsExists().equals(_fb_false));
		
		exception_flag = false;
		try {
			dto1.setIsExists((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02i", exception_flag);
		
		//
		// is file flag
		//
		dto1.setIsFile(_fb_true);
		assertTrue("test02j", dto1.getIsFile().equals(_fb_true));
		
		dto1.setIsFile(_fb_false);
		assertTrue("test02k", dto1.getIsFile().equals(_fb_false));
		
		exception_flag = false;
		try {
			dto1.setIsFile((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02m", exception_flag);
		
		//
		// is directory flag
		//
		dto1.setIsDirectory(_fb_true);
		assertTrue("test02n", dto1.getIsDirectory().equals(_fb_true));
		
		dto1.setIsDirectory(_fb_false);
		assertTrue("test02o", dto1.getIsDirectory().equals(_fb_false));
		
		exception_flag = false;
		try {
			dto1.setIsDirectory((FauxBoolean) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02p", exception_flag);
		
		//
		// child population (files in a directory)
		//
		dto1.setChildPopulation(666);
		assertEquals("test02q", 666, dto1.getChildPopulation());
		
		//
		// file modification time
		//
		dto1.setFileModified(zt1);
		assertTrue("test02r", dto1.getFileModified().equals(zt1));
		
		exception_flag = false;
		try {
			dto1.setFileModified((ZuluTime) null);
		} catch(NullPointerException exception) {
			exception_flag = true;
		}
		assertTrue("test02s", exception_flag);
		
		//
		// file length
		//
		dto1.setLength(555);
		assertEquals("test02q", 555, dto1.getLength());
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
	private final Log _log = LogFactory.getLog(FileSampleDtoTest.class);
}
