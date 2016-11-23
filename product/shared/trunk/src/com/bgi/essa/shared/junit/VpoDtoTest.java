package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class VpoDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public VpoDtoTest(String name) {
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
	
	public void test01() {
		System.out.println("test01");
		
		parentTest01(new VpoDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		VpoDTO dto1 = getVpoDTO();	
		VpoDTO dto2 = (VpoDTO) dto1.clone();
		parentTest02(dto1, dto2);
		
		testEqual(dto1, dto2);
	}
	
	public void test03() {
		System.out.println("test03");
		
		VpoDTO dto1 = getVpoDTO();
		
		dto1.setAppName(ApplicationName.ORACLE);
		assertTrue("test03a", dto1.getAppName().equals(ApplicationName.ORACLE));
		
		boolean exception_flag = false;
		try {
			dto1.setAppName((ApplicationName) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03b", exception_flag);
		
		dto1.setSeverity(Severity.MAJOR);
		assertTrue("test03c", dto1.getSeverity().equals(Severity.MAJOR));
		
		exception_flag = false;
		try {
			dto1.setSeverity((Severity) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03d", exception_flag);
		
		dto1.setFrequency(1234);
		assertEquals("test03e", 1234, dto1.getFrequency());
		
		exception_flag = false;
		try {
			dto1.setFrequency(-1);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03f", exception_flag);
		
		exception_flag = false;
		try {
			dto1.setFrequency(ConstantsIf.MAX_RETRY_FREQUENCY+1);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03g", exception_flag);
		
		dto1.setMessage(new TrimString("update"));
		assertTrue("test03h", dto1.getMessage().equals("update"));
		
		exception_flag = false;
		try {
			dto1.setMessage((TrimString) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03i", exception_flag);
	}

	private void testEqual(VpoDTO dto1, VpoDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getAppName().equals(dto2.getAppName()));
		assertEquals("te1i", dto1.getSeverity(), dto2.getSeverity());
		assertTrue("te1j", dto1.getMessage().equals(dto2.getMessage()));
		assertEquals("te1k", dto1.getFrequency(), dto2.getFrequency());
	}
	
	private VpoDTO getVpoDTO() {
		VpoDTO dto1 = new VpoDTO();
		dto1.setAppName(ApplicationName.TRADEFLOOR);
		dto1.setSeverity(Severity.CRITICAL);
		dto1.setFrequency(1234);
		dto1.setMessage(new TrimString("fresh message"));
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		return(dto1);
	}
}