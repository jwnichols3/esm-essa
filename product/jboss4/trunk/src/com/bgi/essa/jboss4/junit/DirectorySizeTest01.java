package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.DirectorySizeCtx;

import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class DirectorySizeTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public DirectorySizeTest01(final String name) {
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
		
		DirectorySizeDTO dto1 = getDirectorySize();
		assertNotNull("test02a", dto1);
		
		DirectorySizeDTO dto2 = (DirectorySizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
				
		DirectorySizeSampleDTO dto3 = getDirectorySizeSample(dto2);
		DirectorySizeSampleDTO dto4 = (DirectorySizeSampleDTO) bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		testEquals(dto3, dto4);
	}
	
	/**
	 * Collect sample
	 */
	public void test03() {
		_log.info("test03");
		
		DirectorySizeDTO dto1 = getDirectorySize();
		dto1.setTarget(new TrimString("/etc"));
	
		DirectorySizeDTO dto2 = (DirectorySizeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03a", dto2);
		
		DirectorySizeCtx ctx1 = new DirectorySizeCtx();
		assertNotNull("test03a", ctx1);
		
		ctx1.setRule(dto2);
		
		DirectorySizeCtx ctx2 = null;
		try {
			ctx2 = (DirectorySizeCtx) bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke:", exception);
		}
		assertNotNull("test03b", ctx2);
		assertTrue("test03c", ctx2.isSuccess());
		
		DirectorySizeSampleDTO dto = (DirectorySizeSampleDTO) ctx2.getSample();
		assertNotNull("test03d", dto);
		assertNotNull("test03e", dto.getTimeStamp());
		assertTrue("test03f", dto.isExists());
		
		_log.info("return:" + dto);
	}
	
	private DirectorySizeDTO getDirectorySize() {
		DirectorySizeDTO dto = new DirectorySizeDTO();
		
		dto.setNote(getRandom());
		
		dto.setTarget(getRandom());
		dto.setThresholdType(SizeThreshold.RANGE_EXCLUSIVE);
		dto.setMinimumThreshold(321);
		dto.setMaximumThreshold(654);
		dto.setRecursive(true);
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		return(dto);
	}
	
	private void testEquals(DirectorySizeDTO dto1, DirectorySizeDTO dto2) {
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
		assertEquals("te1m", dto1.getRecursive(), dto2.getRecursive());
	}
	
	private DirectorySizeSampleDTO getDirectorySizeSample(DirectorySizeDTO arg) {
		System.out.println("task id:" + arg.getTaskId());
		System.out.println("rule id:" + arg.getRuleId());
		System.out.println("row id:" + arg.getRowId());
		
		DirectorySizeSampleDTO dto = new DirectorySizeSampleDTO();
		
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
	
	private void testEquals(DirectorySizeSampleDTO dto1, DirectorySizeSampleDTO dto2) {
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
	private final Log _log = LogFactory.getLog(DirectorySizeTest01.class);
}
