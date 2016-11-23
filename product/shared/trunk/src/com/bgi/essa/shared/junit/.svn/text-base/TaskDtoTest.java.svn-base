package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * Exercise TaskDTO
 * 
 * @author coleguy
 */
public class TaskDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public TaskDtoTest(String name) {
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
	
	public void test01() {
		System.out.println("test01");
		
		parentTest01(new TaskDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		TaskDTO dto1 = getTaskDTO();	
		TaskDTO dto2 = (TaskDTO) dto1.clone();
		parentTest02(dto1, dto2);
		
		testEqual(dto1, dto2);
	}
	
	public void test03() {
		System.out.println("test03");
		
		TaskDTO dto1 = getTaskDTO();
		
		dto1.setName(new TrimString("update"));
		assertTrue("test03a", dto1.getName().equals("update"));
		
		boolean exception_flag = false;
		try {
			dto1.setName((TrimString) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03b", exception_flag);
		
		dto1.setMatchAll(true);
		assertTrue("test03c", dto1.isMatchAll());
		assertTrue("test03d", dto1.getMatchAll());
		assertTrue("test03e", dto1.getFauxMatchAll().isTrue());
		
		dto1.setMatchAll(false);
		assertFalse("test03f", dto1.isMatchAll());
		assertFalse("test03g", dto1.getMatchAll());
		assertFalse("test03h", dto1.getFauxMatchAll().isTrue());
		
		dto1.setFrequency(123);
		assertEquals("test03i", 123, dto1.getFrequency());
		
		exception_flag = false;
		try {
			dto1.setFrequency(-1);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03j", exception_flag);
		
		exception_flag = false;
		try {
			dto1.setFrequency(ConstantsIf.MAX_SAMPLE_FREQUENCY+1);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03k", exception_flag);
	}
	
	private void testEqual(TaskDTO dto1, TaskDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getName().equals(dto2.getName()));
		assertEquals("te1i", dto1.getMatchAll(), dto2.getMatchAll());
		
		assertEquals("te1j", dto1.getFrequency(), dto2.getFrequency());
	}
	
	private TaskDTO getTaskDTO() {
		TaskDTO dto1 = new TaskDTO();
		dto1.setName(new TrimString("fresh name"));
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		dto1.setRowId(new Long(456));
		dto1.setMatchAll(true);
		dto1.setFrequency(66);
		return(dto1);
	}
}
