package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.CustomMessageAttributeDTO;

/**
 * @author coleguy
 */
public class CustomMessageAttributeDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public CustomMessageAttributeDtoTest(String name) {
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
		parentTest01(new CustomMessageAttributeDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		CustomMessageAttributeDTO dto1 = getCmaDTO();	
		CustomMessageAttributeDTO dto2 = (CustomMessageAttributeDTO) dto1.clone();
		parentTest02(dto1, dto2);
		testEqual(dto1, dto2);
	}
	
	private void testEqual(CustomMessageAttributeDTO dto1, CustomMessageAttributeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
		assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getKey().equals(dto2.getKey()));
		assertTrue("te1i", dto1.getValue().equals(dto2.getValue()));
	}
	
	private CustomMessageAttributeDTO getCmaDTO() {
		CustomMessageAttributeDTO dto1 = new CustomMessageAttributeDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		dto1.setKey(new TrimString("fresh key"));
		dto1.setValue(new TrimString("fresh value"));
		
		return(dto1);
	}
}
