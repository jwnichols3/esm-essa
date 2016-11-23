package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.FileSizeCtx;

import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSizeDTO;
import com.bgi.essa.shared.transfer.FileSizeSampleDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class FileSizeTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public FileSizeTest01(String name) {
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
		
		FileSizeDTO dto1 = getFileSize();
		assertNotNull("test02a", dto1);
		
		FileSizeDTO dto2 = (FileSizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
				
		FileSizeSampleDTO dto3 = getFileSizeSample(dto2);
		FileSizeSampleDTO dto4 = (FileSizeSampleDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		testEquals(dto3, dto4);
	}
	
	
	/**
	 * Collect sample
	 */
	public void test03() {
		_log.info("test03");
		
		FileSizeDTO dto1 = getFileSize();
		dto1.setTarget(new TrimString("/etc/passwd"));
	
		FileSizeDTO dto2 = (FileSizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03a", dto2);
		
		FileSizeCtx ctx1 = new FileSizeCtx();
		assertNotNull("test03b", ctx1);
		
		ctx1.setRule(dto2);
		
		FileSizeCtx ctx2 = null;
		try {
			ctx2 = (FileSizeCtx) bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke:", exception);
		}
		assertNotNull("test03c", ctx2);
		assertTrue("test03d", ctx2.isSuccess());
		
		FileSizeSampleDTO dto = (FileSizeSampleDTO) ctx2.getSample();
		assertNotNull("test03e", dto);
		assertNotNull("test03f", dto.getTimeStamp());
		assertTrue("test03g", dto.isExists());
		
		_log.info("return:" + dto);
	}
	
	private FileSizeDTO getFileSize() {
		FileSizeDTO dto = new FileSizeDTO();
		
		dto.setNote(getRandom());
		
		dto.setTarget(getRandom());
		dto.setThresholdType(SizeThreshold.RANGE_EXCLUSIVE);
		dto.setMinimumThreshold(321);
		dto.setMaximumThreshold(654);
		//dto.setDeltaThreshold(111);
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		return(dto);
	}
	
	private void testEquals(FileSizeDTO dto1, FileSizeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getTarget().equals(dto2.getTarget()));
		assertTrue("te1i", dto1.getThresholdType().equals(dto2.getThresholdType()));
		assertEquals("te1j", dto1.getMinimumThreshold(), dto2.getMinimumThreshold());
		assertEquals("te1k", dto1.getMaximumThreshold(), dto2.getMaximumThreshold());
	//	assertEquals("te1m", dto1.getDeltaThreshold(), dto2.getDeltaThreshold());
	}
	
	private FileSizeSampleDTO getFileSizeSample(FileSizeDTO arg) {
		System.out.println("task id:" + arg.getTaskId());
		System.out.println("rule id:" + arg.getRuleId());
		System.out.println("row id:" + arg.getRowId());
		
		FileSizeSampleDTO dto = new FileSizeSampleDTO();
		
		dto.setNote(getRandom());
		
		dto.setBytePopulation(randomPositiveLong());
		dto.setExists(true);

		dto.setTaskId(arg.getTaskId());
		dto.setRuleId(arg.getRuleId());
		dto.setRuleRowId(arg.getRowId());
		dto.setMatch(true);
		dto.setSuppressed(true);

		return(dto);
	}
	
	private void testEquals(FileSizeSampleDTO dto1, FileSizeSampleDTO dto2) {
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
		assertEquals("te2i", dto1.getBytePopulation(), dto2.getBytePopulation());
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSizeTest01.class);
}
