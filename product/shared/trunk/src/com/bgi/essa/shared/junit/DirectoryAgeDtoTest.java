package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.FileAgeOption;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DirectoryAgeDTO;

/**
 * @author linden
 */
public class DirectoryAgeDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public DirectoryAgeDtoTest(String name) {
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
		
		parentTest01(new DirectoryAgeDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		DirectoryAgeDTO dto1 = getDirectoryAgeDTO();	
		DirectoryAgeDTO dto2 = (DirectoryAgeDTO) dto1.clone();
		parentTest02(dto1, dto2);
		
		testEqual(dto1, dto2);
	}
	
	public void test03() {
		System.out.println("test03");
		
		DirectoryAgeDTO dto1 = getDirectoryAgeDTO();
		
		dto1.setDirectory(new TrimString("directory"));
		assertTrue("test03a", dto1.getDirectory().equals("directory"));
		
		boolean exception_flag = false;
		try {
			dto1.setDirectory((TrimString) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03b", exception_flag);
		
		dto1.setDirectoryName(new TrimString("directory name"));
		assertTrue("test03c", dto1.getDirectoryName().equals("directory name"));
		
		exception_flag = false;
		try {
			dto1.setDirectoryName((TrimString) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03d", exception_flag);
		
		dto1.setFileAgeOption(FileAgeOption.SINGLE);
		assertTrue("test03e", dto1.getFileAgeOption().equals(FileAgeOption.SINGLE));
		
		exception_flag = false;
		try {
			dto1.setFileAgeOption((FileAgeOption) null);
		} catch(Exception exception) {
			exception_flag = true;
		}
		assertTrue("test03f", exception_flag);
	
		dto1.setThreshold(12345);
		assertEquals("test03g", 12345, dto1.getThreshold());
	}
	
	private void testEqual(DirectoryAgeDTO dto1, DirectoryAgeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getDirectory().equals(dto2.getDirectory()));
		assertTrue("te1i", dto1.getDirectoryName().equals(dto2.getDirectoryName()));
		assertTrue("te1j", dto1.getFileAgeOption().equals(dto2.getFileAgeOption()));
		assertEquals("te1k", dto1.getThreshold(), dto2.getThreshold());
	}
	
	private DirectoryAgeDTO getDirectoryAgeDTO() {
		DirectoryAgeDTO dto1 = new DirectoryAgeDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		dto1.setNote(new TrimString("xxx fresh note xxx"));
		
		dto1.setDirectory(new TrimString("fresh directory"));
		dto1.setDirectoryName(new TrimString("fresh directory name"));
		dto1.setFileAgeOption(FileAgeOption.AT_LEAST_ONE);
		dto1.setThreshold(666);
		
		return(dto1);
	}
}
