package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.BootTimeCtx;

import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * Exercise BootTime monitor
 * 
 * @author coleguy
 */
public class BootTimeTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public BootTimeTest01(String name) {
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
		
		BootTimeDTO dto1 = getBootTime();
		assertNotNull("test02a", dto1);
		
		BootTimeDTO dto2 = (BootTimeDTO) _bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
				
		BootTimeSampleDTO dto3 = getBootTimeSample(dto2);
		BootTimeSampleDTO dto4 = (BootTimeSampleDTO) _bd.saveOrUpdate(dto3);
		assertNotNull("test02c", dto4);
		testEquals(dto3, dto4);
	}

	/**
	 * Collect sample
	 */
	public void test03() {
		_log.info("test03");
		
		BootTimeDTO dto1 = getBootTime();
	
		BootTimeDTO dto2 = (BootTimeDTO) bd.saveOrUpdate(dto1);
		assertNotNull("test03a", dto2);
		
		BootTimeCtx ctx1 = new BootTimeCtx();
		assertNotNull("test03b", ctx1);
		
		ctx1.setRule(dto2);
		
		BootTimeCtx ctx2 = null;
		try {
			ctx2 = (BootTimeCtx) bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke:", exception);
		}
		assertNotNull("test03c", ctx2);
		assertTrue("test03d", ctx2.isSuccess());
		
		BootTimeSampleDTO dto = (BootTimeSampleDTO) ctx2.getSample();
		assertNotNull("test03e", dto);
		assertNotNull("test03f", dto.getTimeStamp());
		assertNotNull("test03g", dto.getBootTime());
		
		_log.info("return:" + dto);
	}
	
	///////////////////
	
	private BootTimeDTO getBootTime() {
		BootTimeDTO dto = new BootTimeDTO();
		
		dto.setNote(getRandom());
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		return(dto);
	}
	
	private void testEquals(BootTimeDTO dto1, BootTimeDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
	//	assertEquals("te1e", dto1.getTaskId(), dto2.getTaskId());
	//	assertEquals("te1f", dto1.getRuleId(), dto2.getRuleId());
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
	}
	
	private BootTimeSampleDTO getBootTimeSample(BootTimeDTO arg) {
		System.out.println("task id:" + arg.getTaskId());
		System.out.println("rule id:" + arg.getRuleId());
		System.out.println("row id:" + arg.getRowId());
		
		BootTimeSampleDTO dto = new BootTimeSampleDTO();
		dto.setTaskId(arg.getTaskId());
		dto.setRuleId(arg.getRuleId());
		dto.setRuleRowId(arg.getRowId());
		
		dto.setNote(getRandom());
		dto.setBootTime(new ZuluTime());

		return(dto);
	}
	
	private void testEquals(BootTimeSampleDTO dto1, BootTimeSampleDTO dto2) {
		assertNotNull("te2a", dto1);
		assertNotNull("te2b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

		assertTrue("te2c", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te2d", dto1.getBootTime().equals(dto2.getBootTime()));
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(BootTimeTest01.class);
}
