package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;

import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class TaskTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public TaskTest01(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.jboss4.junit.RmiTestParent#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.jboss4.junit.RmiTestParent#tearDown()
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
		
		TaskDTO dto1 = getNewTask();
		assertNotNull("test01a", dto1);

		TaskDTO dto2 = (TaskDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		TaskDTO dto3 = new TaskDTO();
		dto3.setRowId(dto2.getRowId());
		
		TaskDTO dto4 = (TaskDTO) bd.selectByRowId(dto3);
		assertNotNull(dto4);
		
		testEquals(dto1, dto4);
	}
	
	/**
	 * test insert and update of versioned table
	 */
	public void test02() {
		_log.info("test02");

		TaskDTO dto1 = getNewTask();
		assertNotNull("test01a", dto1);

		TaskDTO dto2 = (TaskDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		TaskDTO dto3 = (TaskDTO) dto2.clone();
		dto3.setNote(getRandom());
		
		TaskDTO dto4 = (TaskDTO) bd.saveOrUpdate(dto3);
		assertNotNull(dto4);
		assertEquals(2L, dto4.getVersion());
		
		_log.info("original:" + dto2);
		_log.info("versioned:" + dto4);
		
		dto3.setNote(getRandom());
		dto4 = (TaskDTO) bd.saveOrUpdate(dto3);
		assertEquals(3L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (TaskDTO) bd.saveOrUpdate(dto3);
		assertEquals(4L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (TaskDTO) bd.saveOrUpdate(dto3);
		assertEquals(5L, dto4.getVersion());
	}
	
	/**
	 * 
	 */
	public void test03() {
		_log.info("test03");

		TaskDTO dto1 = getNewTask();
		assertNotNull("test03a", dto1);

		TaskDTO dto2 = (TaskDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03b", dto2);
		
		dto2.setMatchAll(true);
		dto2 = (TaskDTO) bd.saveOrUpdate(dto2);
		assertNotNull("test03c", dto2);
		assertTrue("test03d", dto2.isMatchAll());
		
		dto2.setMatchAll(false);
		dto2 = (TaskDTO) bd.saveOrUpdate(dto2);
		assertNotNull("test03d", dto2);
		assertFalse("test03e", dto2.isMatchAll());
	}
	
	private TaskDTO getNewTask() {
		TaskDTO dto1 = new TaskDTO();
		
		dto1.setName(getRandom());
		dto1.setNote(getRandom());
		
		int frequency = 0;
		while(frequency < ConstantsIf.MIN_SAMPLE_FREQUENCY) {
			frequency = random.nextInt(ConstantsIf.MAX_SAMPLE_FREQUENCY);
		}
		dto1.setFrequency(frequency);
		
		return(dto1);
	}
	
	private void testEquals(TaskDTO dto1, TaskDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);
		
		assertTrue("te1c", dto1.getName().equals(dto2.getName()));
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getVersion(), dto2.getVersion());
		
		assertEquals("te1g", dto1.getFrequency(), dto2.getFrequency());
		assertEquals("te1h", dto1.isMatchAll(), dto2.isMatchAll());
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
