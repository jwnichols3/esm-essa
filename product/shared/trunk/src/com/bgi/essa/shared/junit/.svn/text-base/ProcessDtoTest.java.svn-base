package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.ProcessOption;
import com.bgi.essa.shared.primitive.ProcessThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.ProcessDTO;

/**
 * @author coleguy
 */
public class ProcessDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public ProcessDtoTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.shared.junit.DtoTestParent#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.shared.junit.DtoTestParent#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test01() {
		System.out.println("test01");
		
		parentTest01(new ProcessDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		ProcessDTO dto1 = getProcessDTO();	
		ProcessDTO dto2 = (ProcessDTO) dto1.clone();
		parentTest02(dto1, dto2);
		
		testEqual(dto1, dto2);
	}
	
	private void testEqual(ProcessDTO dto1, ProcessDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
		assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getTarget().equals(dto2.getTarget()));
		assertTrue("te1i", dto1.getOptionType().equals(dto2.getOptionType()));
		assertTrue("te1j", dto1.getThresholdType().equals(dto2.getThresholdType()));
		
		assertEquals("te1k", dto1.getMinimumPopulation(), dto2.getMinimumPopulation());
		assertEquals("te1m", dto1.getMaximumPopulation(), dto2.getMaximumPopulation());
		assertEquals("te1n", dto1.getMaximumTime(), dto2.getMaximumTime());
	}
	
	private ProcessDTO getProcessDTO() {
		ProcessDTO dto1 = new ProcessDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		dto1.setTarget(new TrimString("target"));
		dto1.setOptionType(ProcessOption.LOCK_FILE);
		dto1.setThresholdType(ProcessThreshold.ALWAYS_RUN);
		dto1.setMaximumPopulation(321);
		dto1.setMinimumPopulation(123);
		dto1.setMinimumPopulation(111);
		
		return(dto1);
	}
}
