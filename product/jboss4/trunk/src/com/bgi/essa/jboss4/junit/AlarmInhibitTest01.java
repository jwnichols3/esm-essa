package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.primitive.Day;
import com.bgi.essa.shared.primitive.Hour;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * @author coleguy
 */
public class AlarmInhibitTest01 extends RmiTestParent {

	/**
	 * @param name
	 */
	public AlarmInhibitTest01(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.jboss4.junit.RmiTestParent#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see com.bgi.essa.jboss4.junit.RmiTestParent#tearDown()
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
		
		AlarmInhibitDTO dto1 = getAlarmInhibit();
		assertNotNull("test02a", dto1);
		
		AlarmInhibitDTO dto2 = (AlarmInhibitDTO) _bd.saveOrUpdate(dto1);
		assertNotNull("test02b", dto2);
		testEquals(dto1, dto2);
		
		AlarmInhibitDTO dto3 = new AlarmInhibitDTO();
		assertNotNull("test02c", dto3);
		
		dto3.setRowId(dto2.getRowId());
		
		AlarmInhibitDTO dto4 = (AlarmInhibitDTO) bd.selectByRowId(dto3);
		assertNotNull("test02d", dto4);
		
		testEquals(dto1, dto4);
	}
	
	///////////////////
	
	private AlarmInhibitDTO getAlarmInhibit() {
		AlarmInhibitDTO dto = new AlarmInhibitDTO();
		
		dto.setNote(getRandom());
		
		TaskDTO task = getNewParentTask();
		dto.setTaskId(task.getTaskId());
		
		dto.setDay(Day.MON);
		dto.setStart(Hour.H04);
		dto.setStop(Hour.H06);
		
		return(dto);
	}
	
	private void testEquals(AlarmInhibitDTO dto1, AlarmInhibitDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);

	//	assertEquals("te1c", dto1.isActive(), dto2.isActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
	//	assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
	//	assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getDay().equals(dto2.getDay()));
		assertTrue("te1i", dto1.getStart().equals(dto2.getStart()));
		assertTrue("te1j", dto1.getStop().equals(dto2.getStop()));
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(AlarmInhibitTest01.class);
}
