package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.AbstractDto;

import junit.framework.TestCase;

/**
 * Parent for all DTO test classes
 * 
 * @author coleguy
 */
public class DtoTestParent extends TestCase {

	/**
	 * @param name
	 */
	public DtoTestParent(String name) {
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
	 * Pacifier, JUnit wants to see at least one test in the file
	 */
	public void testPacifier() {
		System.out.println("test pacifier");
	}
	
	/**
	 * AbstractDTO tests
	 */
	public void parentTest01(AbstractDto dto1) {
		System.out.println("parentTest01");
		
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
	 * Verify equality
	 * 
	 * @param dto1
	 * @param dto2
	 */
	public void parentTest02(AbstractDto dto1, AbstractDto dto2) {
		System.out.println("parentTest02");
		
		assertNotNull("test02a", dto1);
		assertNotNull("test02b", dto2);
		
		assertEquals("test02c", dto1.hashCode(), dto2.hashCode());
		
		assertTrue("test02d", dto1.equals(dto2));
		assertTrue("test02e", dto2.equals(dto1));
	}
}
