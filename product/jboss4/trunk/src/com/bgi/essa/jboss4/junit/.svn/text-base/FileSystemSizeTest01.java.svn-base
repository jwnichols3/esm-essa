package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.FileSystemSizeCtx;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSystemSizeDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeSampleDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class FileSystemSizeTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public FileSystemSizeTest01(String name) {
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
		
		FileSystemSizeDTO dto1 = getFileSystemSize();
		assertNotNull("test02a", dto1);
		
		FileSystemSizeDTO dto2 = (FileSystemSizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
				
		FileSystemSizeSampleDTO dto3 = getFileSystemSizeSample(dto2);
		FileSystemSizeSampleDTO dto4 = (FileSystemSizeSampleDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		testEquals(dto3, dto4);
	}
	
	
	/**
	 * Collect sample
	 */
	public void test03() {
		_log.info("test03");
		
		FileSystemSizeDTO dto1 = getFileSystemSize();
		dto1.setTarget(new TrimString("/opt"));
	
		FileSystemSizeDTO dto2 = (FileSystemSizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03a", dto2);
		
		FileSystemSizeCtx ctx1 = new FileSystemSizeCtx();
		assertNotNull("test03b", ctx1);
		
		ctx1.setRule(dto2);
		
		FileSystemSizeCtx ctx2 = null;
		try {
			ctx2 = (FileSystemSizeCtx) bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke:", exception);
		}
		assertNotNull("test03c", ctx2);
		assertTrue("test03d", ctx2.isSuccess());
		
		FileSystemSizeSampleDTO dto = (FileSystemSizeSampleDTO) ctx2.getSample();
		assertNotNull("test03e", dto);
		assertNotNull("test03f", dto.getTimeStamp());
		assertTrue("test03g", dto.isExists());
		
		_log.info("return:" + dto);
	}
	
	private FileSystemSizeDTO getFileSystemSize() {
		FileSystemSizeDTO dto = new FileSystemSizeDTO();
		
		dto.setNote(getRandom());
		
		dto.setTarget(getRandom());
		dto.setBlockThreshold(321);
		dto.setInodeThreshold(654);
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		return(dto);
	}
	
	private void testEquals(FileSystemSizeDTO dto1, FileSystemSizeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getTarget().equals(dto2.getTarget()));
		assertEquals("te1i", dto1.getBlockThreshold(), dto2.getBlockThreshold());
		assertEquals("te1j", dto1.getInodeThreshold(), dto2.getInodeThreshold());
	}
	
	private FileSystemSizeSampleDTO getFileSystemSizeSample(FileSystemSizeDTO arg) {
		System.out.println("task id:" + arg.getTaskId());
		System.out.println("rule id:" + arg.getRuleId());
		System.out.println("row id:" + arg.getRowId());
		
		FileSystemSizeSampleDTO dto = new FileSystemSizeSampleDTO();
		
		dto.setNote(getRandom());
		
		dto.setBlockPercentage(randomPositiveInt());
		dto.setInodePercentage(randomPositiveInt());
		dto.setExists(true);

		dto.setTaskId(arg.getTaskId());
		dto.setRuleId(arg.getRuleId());
		dto.setRuleRowId(arg.getRowId());
		dto.setMatch(true);
		dto.setSuppressed(true);

		return(dto);
	}
	
	private void testEquals(FileSystemSizeSampleDTO dto1, FileSystemSizeSampleDTO dto2) {
		assertNotNull("te2a", dto1);
		assertNotNull("te2b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te2c", dto1.getNote().equals(dto2.getNote()));
		
		assertEquals("te2d", dto1.getTaskId(), dto2.getTaskId());
		assertEquals("te2e", dto1.getRuleId(), dto2.getRuleId());
		assertEquals("te2f", dto1.getRuleRowId(), dto2.getRuleRowId());
		assertEquals("te2g", dto1.getMatch(), dto2.getMatch());
		assertEquals("te2h", dto1.getSuppressed(), dto2.getSuppressed());
		assertEquals("te2i", dto1.getBlockPercentage(), dto2.getBlockPercentage());
		assertEquals("te2j", dto1.getInodePercentage(), dto2.getInodePercentage());
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSizeTest01.class);
}
