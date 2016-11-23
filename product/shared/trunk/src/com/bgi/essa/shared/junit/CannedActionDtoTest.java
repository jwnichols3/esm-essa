package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.CannedAction;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CannedActionDTO;

/**
 * @author coleguy
 */
public class CannedActionDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public CannedActionDtoTest(String name) {
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
		parentTest01(new CannedActionDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		CannedActionDTO dto1 = getCannedActionDTO();	
		CannedActionDTO dto2 = (CannedActionDTO) dto1.clone();
		parentTest02(dto1, dto2);
		testEqual(dto1, dto2);
	}
	
	private void testEqual(CannedActionDTO dto1, CannedActionDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
		assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getAction().equals(dto2.getAction()));
		assertTrue("te1i", dto1.getActionId().equals(dto2.getActionId()));
	}
	
	private CannedActionDTO getCannedActionDTO() {
		CannedActionDTO dto1 = new CannedActionDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		dto1.setAction(CannedAction.COMFORT);
		dto1.setActionId(new TrimString("fresh action id"));
		
		return(dto1);
	}
}
