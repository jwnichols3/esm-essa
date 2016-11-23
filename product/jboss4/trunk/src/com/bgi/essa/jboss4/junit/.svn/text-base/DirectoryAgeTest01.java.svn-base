package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.FileAgeOption;

import com.bgi.essa.shared.transfer.DirectoryAgeDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class DirectoryAgeTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public DirectoryAgeTest01(String name) {
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

	/**
	 * Test insert and select.
	 */
	public void test01() {
		_log.info("test01");
		
		DirectoryAgeDTO dto1 = getNewDirectoryAge();
		assertNotNull("test01a", dto1);

		DirectoryAgeDTO dto2 = (DirectoryAgeDTO) bd.saveOrUpdate(dto1);
		assertNotNull(dto2);
		
		DirectoryAgeDTO dto3 = new DirectoryAgeDTO();
		dto3.setRowId(dto2.getRowId());
		
		DirectoryAgeDTO dto4 = (DirectoryAgeDTO) bd.selectByRowId(dto3);
		assertNotNull(dto4);
		
		testEquals(dto1, dto4);
	}
	
	/**
	 * test insert and update of versioned table
	 */
	public void test02() {
		_log.info("test02");

		DirectoryAgeDTO dto1 = getNewDirectoryAge();
		assertNotNull("test02a", dto1);
		
		DirectoryAgeDTO dto2 = (DirectoryAgeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		
		DirectoryAgeDTO dto3 = (DirectoryAgeDTO) dto2.clone();
		dto3.setNote(getRandom());
		
		DirectoryAgeDTO dto4 = (DirectoryAgeDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		assertEquals("test02d", 2L, dto4.getVersion());
		assertTrue("test02e", dto4.getTaskId().equals(dto2.getTaskId()));
		assertTrue("test02f", dto4.getRuleId().equals(dto2.getRuleId()));
		
		_log.info("original:" + dto2);
		_log.info("versioned:" + dto4);
		
		dto3.setNote(getRandom());
		dto4 = (DirectoryAgeDTO) bd.saveOrUpdate(dto3);
		assertEquals("test02g", 3L, dto4.getVersion());
		assertTrue("test02h", dto4.getTaskId().equals(dto2.getTaskId()));
		assertTrue("test02i", dto4.getRuleId().equals(dto2.getRuleId()));
		
		dto3.setNote(getRandom());
		dto4 = (DirectoryAgeDTO) bd.saveOrUpdate(dto3);
		assertEquals("test02j", 4L, dto4.getVersion());
		assertTrue("test02k", dto4.getTaskId().equals(dto2.getTaskId()));
		assertTrue("test02m", dto4.getRuleId().equals(dto2.getRuleId()));
		
		dto3.setNote(getRandom());
		dto4 = (DirectoryAgeDTO) bd.saveOrUpdate(dto3);
		assertEquals("test02n", 5L, dto4.getVersion());
		assertTrue("test02o", dto4.getTaskId().equals(dto2.getTaskId()));
		assertTrue("test02p", dto4.getRuleId().equals(dto2.getRuleId()));
	}
	
	private DirectoryAgeDTO getNewDirectoryAge() {
		DirectoryAgeDTO dto1 = new DirectoryAgeDTO();
		
		dto1.setNote(getRandom());
		
		dto1.setDirectory(getRandom());
		dto1.setFileAgeOption(FileAgeOption.AT_LEAST_ONE);
		
		TaskDTO task = getNewParentTask();
		dto1.setTaskId(task.getTaskId());
		
		return(dto1);
	}
	
	private void testEquals(DirectoryAgeDTO dto1, DirectoryAgeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1i", dto1.getFileAgeOption().equals(dto2.getFileAgeOption()));
	}

    public void testInvoke() {
        DirectoryAgeDTO dto = getNewDirectoryAge();

        _log.info ( "Directory found: " + dto.getDirectory().toString() );
    }
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
