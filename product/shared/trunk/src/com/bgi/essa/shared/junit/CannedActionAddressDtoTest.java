package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CannedActionAddressDTO;

/**
 * @author coleguy
 */
public class CannedActionAddressDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public CannedActionAddressDtoTest(String name) {
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
		parentTest01(new CannedActionAddressDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		CannedActionAddressDTO dto1 = getCannedActionAddressDTO();	
		CannedActionAddressDTO dto2 = (CannedActionAddressDTO) dto1.clone();
		parentTest02(dto1, dto2);
		testEqual(dto1, dto2);
	}
	
	private void testEqual(CannedActionAddressDTO dto1, CannedActionAddressDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
		assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getAddress().equals(dto2.getAddress()));
		assertTrue("te1i", dto1.getActionId().equals(dto2.getActionId()));
	}
	
	private CannedActionAddressDTO getCannedActionAddressDTO() {
		CannedActionAddressDTO dto1 = new CannedActionAddressDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		dto1.setAddress(new TrimString("fresh address"));
		dto1.setActionId(new TrimString("fresh action id"));
		
		return(dto1);
	}
}
