package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.CannedAction;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.CannedActionDTO;

/**
 * Exercise "canned action" support
 * 
 * @author coleguy
 */
public class CannedActionTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public CannedActionTest01(String name) {
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
	 * Insert new DTO then select and compare.
	 */
	public void test01() {
		_log.info("test01");
		
		CannedActionDTO dto1 = getNewCanned(default_rule, default_attribute);
		assertNotNull("test01a", dto1);

		CannedActionDTO dto2 = (CannedActionDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		CannedActionDTO dto3 = new CannedActionDTO();
		dto3.setRowId(dto2.getRowId());
		
		CannedActionDTO dto4 = (CannedActionDTO) bd.selectByRowId(dto3);
		assertNotNull(dto4);
		
		testEquals(dto1, dto4);
	}
	
	/**
	 * test insert and update of versioned table
	 */
	public void test02() {
		_log.info("test02");

		CannedActionDTO dto1 = getNewCanned(default_rule, default_attribute);
		assertNotNull("test02a", dto1);
		
		CannedActionDTO dto2 = (CannedActionDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		
		CannedActionDTO dto3 = (CannedActionDTO) dto2.clone();
	//	dto3.setActionId(getRandom());
		dto3.setAction(CannedAction.EMAILFYI);
		dto3.setNote(getRandom());
		
		CannedActionDTO dto4 = (CannedActionDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		assertEquals("test02d", 2L, dto4.getVersion());
		
		_log.info("original:" + dto2);
		_log.info("versioned:" + dto4);
		
		dto3.setNote(getRandom());
		dto4 = (CannedActionDTO) bd.saveOrUpdate(dto3);
		assertEquals(3L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (CannedActionDTO) bd.saveOrUpdate(dto3);
		assertEquals(4L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (CannedActionDTO) bd.saveOrUpdate(dto3);
		assertEquals(5L, dto4.getVersion());
	}
	
	/**
	 * Generate a CannedActionDTO, complete w/parent task
	 * 
	 * @param rule rule identifier
	 * @param action action identifier
	 * @return populated CannedActionDTO
	 */
	private CannedActionDTO getNewCanned(TrimString rule, TrimString action) {
		CannedActionDTO dto1 = new CannedActionDTO();

		dto1.setNote(getRandom());
		
		dto1.setActionId(action);
		dto1.setAction(CannedAction.EMAILFYI);
	
		dto1.setAddress(getRandom());
		dto1.setSubject(getRandom());
		
		TaskDTO task = getNewParentTask();
		dto1.setTaskId(task.getTaskId());
		dto1.setRuleId(rule);
		
		return(dto1);
	}
	
	/**
	 * Ensure "equal" classes
	 * 
	 * @param dto1 candidate1
	 * @param dto2 candidate2
	 */
	private void testEquals(CannedActionDTO dto1, CannedActionDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);
		
	//	assertEquals("te1c", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1d", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1e", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1f", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1g", dto1.getActionId().equals(dto2.getActionId()));
		assertTrue("te1h", dto1.getAction().equals(dto2.getAction()));
		
		assertTrue("te1i", dto1.getSubject().equals(dto2.getSubject()));
		assertTrue("te1j", dto1.getAddress().equals(dto2.getAddress()));
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
