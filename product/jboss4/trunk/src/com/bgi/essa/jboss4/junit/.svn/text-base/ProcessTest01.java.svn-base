package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.transfer.ProcessDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * Exercise Process monitor
 * 
 * @author coleguy
 */
public class ProcessTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public ProcessTest01(String name) {
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
	 * 
	 */
	public void test01() {
		_log.info("test01");
		testPing();
	}
	
	/**
	 * Exercise rule and sample
	 */
	public void test02() {
		_log.info("test02");
		
		ProcessDTO dto1 = getProcess();
		assertNotNull("test02a", dto1);
		
		ProcessDTO dto2 = (ProcessDTO) _bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
	}

	/**
	 * Collect sample
	 */
	public void test03() {
		_log.info("test03");
		
		ProcessDTO dto1 = getProcess();
	
		ProcessDTO dto2 = (ProcessDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03a", dto2);
	}
	
	///////////////////
	
	private ProcessDTO getProcess() {
		ProcessDTO dto = new ProcessDTO();
		
		dto.setNote(getRandom());
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		return(dto);
	}
	
	private void testEquals(ProcessDTO dto1, ProcessDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(ProcessTest01.class);
}
