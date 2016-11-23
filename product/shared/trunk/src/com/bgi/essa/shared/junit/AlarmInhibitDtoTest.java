package com.bgi.essa.shared.junit;

import com.bgi.essa.shared.primitive.Day;
import com.bgi.essa.shared.primitive.Hour;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AlarmInhibitDTO;

/**
 * @author coleguy
 */
public class AlarmInhibitDtoTest extends DtoTestParent {

	/**
	 * @param name
	 */
	public AlarmInhibitDtoTest(String name) {
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
		
		parentTest01(new AlarmInhibitDTO());
	}
	
	public void test02() {
		System.out.println("test02");
		
		AlarmInhibitDTO dto1 = getAlarmInhibitDTO();	
		AlarmInhibitDTO dto2 = (AlarmInhibitDTO) dto1.clone();
		parentTest02(dto1, dto2);
		
		testEqual(dto1, dto2);
	}
	
	public void test03() {
		System.out.println("test03");
		
		ZuluTime time1 = new ZuluTime(2003, 2, 3, 4, 5); //monday
		System.out.println(time1);
		System.out.println(time1.getDayOfWeek());
			
		AlarmInhibitDTO dto1 = getAlarmInhibitDTO();
		dto1.setStart(Hour.H01);
		dto1.setStop(Hour.H02);
		dto1.setDay(Day.FRI);
		//no match, window before sample
		assertFalse("test03a", dto1.testInhibit(time1));
		
		dto1.setStart(Hour.H08);
		dto1.setStop(Hour.H10);
		dto1.setDay(Day.FRI);
		//no match, window after sample
		assertFalse("test03b", dto1.testInhibit(time1));
	
		dto1.setStart(Hour.H01);
		dto1.setStop(Hour.H10);
		dto1.setDay(Day.FRI);
		//no match, bad day
		assertFalse("test03c", dto1.testInhibit(time1));
		
		dto1.setStart(Hour.H20);
		dto1.setStop(Hour.H04);
		dto1.setDay(Day.FRI);
		//no match, bad hours w/midnight wrap
		assertFalse("test03d", dto1.testInhibit(time1));
		
		dto1.setStart(Hour.H20);
		dto1.setStop(Hour.H05);
		dto1.setDay(Day.SUN);
		//Match, good hours w/midnight wrap
		assertTrue("test03e", dto1.testInhibit(time1));
	}
	
	private void testEqual(AlarmInhibitDTO dto1, AlarmInhibitDTO dto2) {
		assertNotNull("te1a", dto1);
		assertNotNull("te1b", dto2);
		
		assertEquals("te1c", dto1.getActive(), dto2.getActive());
		assertTrue("te1d", dto1.getNote().equals(dto2.getNote()));
		
		assertTrue("te1e", dto1.getTaskId().equals(dto2.getTaskId()));
		assertTrue("te1f", dto1.getRuleId().equals(dto2.getRuleId()));
		assertEquals("te1g", dto1.getVersion(), dto2.getVersion());
		
		assertTrue("te1h", dto1.getDay().equals(dto2.getDay()));
		assertTrue("te1i", dto1.getStart().equals(dto2.getStart()));
		assertTrue("te1j", dto1.getStop().equals(dto2.getStop()));
	}
	
	private AlarmInhibitDTO getAlarmInhibitDTO() {
		AlarmInhibitDTO dto1 = new AlarmInhibitDTO();
		
		dto1.setTaskId(new TrimString("fresh task id"));
		dto1.setRuleId(new TrimString("fresh rule id"));
		dto1.setVersion(345);
		
		dto1.setRowId(new Long(456));
		
		dto1.setDay(Day.FRI);
		dto1.setStart(Hour.H01);
		dto1.setStart(Hour.H03);
		
		return(dto1);
	}
}
