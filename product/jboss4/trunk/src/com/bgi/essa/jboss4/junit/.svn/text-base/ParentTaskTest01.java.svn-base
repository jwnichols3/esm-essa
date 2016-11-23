package com.bgi.essa.jboss4.junit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.ParentTaskCtx;

import com.bgi.essa.shared.primitive.FileAgeOption;
import com.bgi.essa.shared.primitive.SizeThreshold;

import com.bgi.essa.shared.transfer.BootTimeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.FileAgeDTO;
import com.bgi.essa.shared.transfer.TaskDTO;

/**
 * Exercise task and subordinate DTO
 * 
 * @author coleguy
 */
public class ParentTaskTest01 extends RmiTestParent {
	
	public ParentTaskTest01(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test0() {
		testPing();
	}
	
	/**
	 * Test insert and select.
	 */
	public void test01() {
		_log.info("test01");
		
		TaskDTO task_dto = getNewParentTask();
		assertNotNull("test01a", task_dto);
		
		createNewBootTime(task_dto);
		createNewFileAge(task_dto);
		createNewDirectorySize(task_dto);
		
		ParentTaskCtx ctx = new ParentTaskCtx();
		ctx.setCandidate(task_dto);
		
		try {
			ctx = (ParentTaskCtx) bd.serviceCommand(ctx);
		} catch(Exception exception) {
			_log.error("choke", exception);
		}
		
		assertTrue("test01b", ctx.isSuccess());
		
		System.out.println(ctx.getDefaultVpo());

		assertNotNull("test01c", ctx.getBootTimeList());
		assertEquals("test01d", 1, ctx.getBootTimeList().size());
		
		assertNotNull("test01e", ctx.getDirectorySizeList());
		assertEquals("test01f", 1, ctx.getDirectorySizeList().size());
		
		assertNotNull("test01g", ctx.getFileAgeList());
		assertEquals("test01h", 1, ctx.getFileAgeList().size());
	
	}
	
	private void createNewBootTime(TaskDTO task) {
		BootTimeDTO dto1 = new BootTimeDTO();
		dto1.setNote(getRandom());
		dto1.setTaskId(task.getTaskId());
		bd.saveOrUpdate(dto1);
	}
	
	private void createNewFileAge(TaskDTO task) {
		FileAgeDTO dto1 = new FileAgeDTO();
		dto1.setNote(getRandom());
		dto1.setDirectory(getRandom());
		dto1.setFileAgeOption(FileAgeOption.AT_LEAST_ONE);
		dto1.setFileName(getRandom());
		dto1.setTaskId(task.getTaskId());
		bd.saveOrUpdate(dto1);
	}
	
	private void createNewDirectorySize(TaskDTO task) {
		DirectorySizeDTO dto1 = new DirectorySizeDTO();
		dto1.setNote(getRandom());
		dto1.setTaskId(task.getTaskId());
		
		dto1.setTarget(getRandom());
		dto1.setThresholdType(SizeThreshold.RANGE_EXCLUSIVE);
		dto1.setMinimumThreshold(456);
		dto1.setMaximumThreshold(789);
		dto1.setRecursive(true);
		
		bd.saveOrUpdate(dto1);
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
