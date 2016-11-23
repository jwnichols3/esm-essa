package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;
import com.bgi.essa.shared.transfer.TaskDTO;
/**
 * @author coleguy
 */
public class CmaTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public CmaTest01(String name) {
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
	
	public void test0() {
		testPing();
	}
	
	/**
	 * Test insert and select.
	 */
	public void test01() {
		_log.info("test01");
		
		CustomMessageAttributeDTO dto1 = getNewCma();
		assertNotNull("test01a", dto1);

		CustomMessageAttributeDTO dto2 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		CustomMessageAttributeDTO dto3 = new CustomMessageAttributeDTO();
		dto3.setRowId(dto2.getRowId());
		
		CustomMessageAttributeDTO dto4 = (CustomMessageAttributeDTO) bd.selectByRowId(dto3);
		assertNotNull(dto4);
		
		testEquals(dto1, dto4);
	}
	
	/**
	 * test insert and update of versioned table
	 */
	public void test02() {
		_log.info("test02");

		CustomMessageAttributeDTO dto1 = getNewCma();
		assertNotNull("test02a", dto1);
		
		CustomMessageAttributeDTO dto2 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		
		CustomMessageAttributeDTO dto3 = (CustomMessageAttributeDTO) dto2.clone();
		dto3.setKey(getRandom());
		dto3.setValue(getRandom());
		dto3.setNote(getRandom());
		
		CustomMessageAttributeDTO dto4 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		assertEquals("test02d", 2L, dto4.getVersion());
		
		_log.info("original:" + dto2);
		_log.info("versioned:" + dto4);
		
		dto3.setNote(getRandom());
		dto4 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto3);
		assertEquals(3L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto3);
		assertEquals(4L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (CustomMessageAttributeDTO) bd.saveOrUpdate(dto3);
		assertEquals(5L, dto4.getVersion());
	}
	
	private CustomMessageAttributeDTO getNewCma() {
		CustomMessageAttributeDTO dto1 = new CustomMessageAttributeDTO();

		dto1.setKey(getRandom());
		dto1.setValue(getRandom());
		dto1.setNote(getRandom());

		TaskDTO task = getNewParentTask();
		dto1.setTaskId(task.getTaskId());
		dto1.setRuleId(getRandom());
		
		return(dto1);
	}
	
	private void testEquals(CustomMessageAttributeDTO dto1, CustomMessageAttributeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);
	
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
	
		assertTrue("te1h", dto1.getKey().equals(dto2.getKey()));
		assertTrue("te1i", dto1.getValue().equals(dto2.getValue()));
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
