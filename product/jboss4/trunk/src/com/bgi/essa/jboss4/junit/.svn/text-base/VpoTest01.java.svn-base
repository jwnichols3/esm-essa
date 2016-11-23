package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Severity;

import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class VpoTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public VpoTest01(String name) {
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
		
		VpoDTO dto1 = getNewVpo();
		assertNotNull("test01a", dto1);

		VpoDTO dto2 = (VpoDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		VpoDTO dto3 = new VpoDTO();
		dto3.setRowId(dto2.getRowId());
		
		VpoDTO dto4 = (VpoDTO) bd.selectByRowId(dto3);
		assertNotNull(dto4);
		
		testEquals(dto1, dto4);
	}
	
	/**
	 * test insert and update of versioned table
	 */
	public void test02() {
		_log.info("test02");

		VpoDTO dto1 = getNewVpo();
		assertNotNull("test02a", dto1);
		
		VpoDTO dto2 = (VpoDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		
		VpoDTO dto3 = (VpoDTO) dto2.clone();
		dto3.setMessage(getRandom());
		dto3.setSourceHost(getRandom());
		dto3.setNote(getRandom());
		
		VpoDTO dto4 = (VpoDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		assertEquals("test02d", 2L, dto4.getVersion());
		
		_log.info("original:" + dto2);
		_log.info("versioned:" + dto4);
		
		dto3.setNote(getRandom());
		dto4 = (VpoDTO) bd.saveOrUpdate(dto3);
		assertEquals(3L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (VpoDTO) bd.saveOrUpdate(dto3);
		assertEquals(4L, dto4.getVersion());
		
		dto3.setNote(getRandom());
		dto4 = (VpoDTO) bd.saveOrUpdate(dto3);
		assertEquals(5L, dto4.getVersion());
	}
	
	private VpoDTO getNewVpo() {
		VpoDTO dto1 = new VpoDTO();
		
		dto1.setAppName(ApplicationName.APP_DESK);
		dto1.setMessage(getRandom());
		dto1.setNote(getRandom());
		dto1.setSeverity(Severity.MAJOR);
		
		int frequency = 0;
		while(frequency < ConstantsIf.MIN_RETRY_FREQUENCY) {
			frequency = random.nextInt(ConstantsIf.MAX_RETRY_FREQUENCY);
		}
		dto1.setFrequency(frequency);
		
		TaskDTO task = getNewParentTask();
		dto1.setTaskId(task.getTaskId());
		dto1.setRuleId(getRandom());
		
		return(dto1);
	}
	
	private void testEquals(VpoDTO dto1, VpoDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);
		
		assertTrue("te1c", dto1.getAppName().equals(dto2.getAppName()));
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertEquals("te1h", dto1.getFrequency(), dto2.getFrequency());
		assertTrue("te1i", dto1.getMessage().equals(dto2.getMessage()));
		assertTrue("te1j", dto1.getSeverity().equals(dto2.getSeverity()));
		assertTrue("te1k", dto1.getSourceHost().equals(dto2.getSourceHost()));
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
