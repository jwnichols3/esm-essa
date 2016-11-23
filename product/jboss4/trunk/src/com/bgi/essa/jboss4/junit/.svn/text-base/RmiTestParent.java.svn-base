package com.bgi.essa.jboss4.junit;

import java.util.Random;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.PingCtx;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * All RMI unit tests should extend from this class.
 * 
 * @author coleguy
 */
public class RmiTestParent extends TestCase {

	/**
	 * @param name
	 */
	public RmiTestParent(String name) {
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

	public TrimString getRandom() {
		return(new TrimString(Integer.toString(random.nextInt())));
	}
	
	/**
	 * Ensure RMI connectivity to JBoss.
	 * Call as first unit test.
	 */
	public void testPing() {
		_log.info("test ping");
		
		PingCtx ctx1 = new PingCtx();
		assertNotNull("tp_a", ctx1);
		
		ctx1.setFlag(false);
		assertFalse("tp_b", ctx1.isFlag());
		assertFalse("tp_c", ctx1.isSuccess());
		
		
		PingCtx ctx2 = null;
		try {
			ctx2 = (PingCtx) bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error(exception);
		}
		
		assertNotNull("tp_d", ctx2);
		assertTrue("tp_e", ctx2.isSuccess());
		assertTrue("tp_f", ctx2.isFlag());
	}
	
	/**
	 * Create a parent task for your unit testing pleasure.
	 * 
	 * @return populated TaskDTO
	 */
	public TaskDTO getNewParentTask() {
		TaskDTO dto1 = new TaskDTO();
		
		dto1.setName(getRandom());
		dto1.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		
		dto1.setNote(getRandom());
		dto1.setActive(true);
		
		int frequency = 0;
		while(frequency < ConstantsIf.MIN_SAMPLE_FREQUENCY) {
			frequency = random.nextInt(ConstantsIf.MAX_SAMPLE_FREQUENCY);
		}
		dto1.setFrequency(frequency);
		
		dto1.setRuleId(new TrimString(ConstantsIf.DEFAULT_RULE));
		
		TaskDTO dto2 = (TaskDTO) bd.saveOrUpdate(dto1);
		
		//must have default VPO
		VpoDTO vpo_dto = new VpoDTO();
		vpo_dto.setAppName(ApplicationName.ESM);
		vpo_dto.setFrequency(345);
		vpo_dto.setMessage(new TrimString("fresh message"));
		vpo_dto.setTaskId(dto2.getTaskId());
		vpo_dto.setRuleId(dto2.getRuleId());
		vpo_dto.setSeverity(Severity.CRITICAL);
		vpo_dto.setNote(getRandom());
		vpo_dto.setActive(true);
		
		bd.saveOrUpdate(vpo_dto);
		
		return(dto2);
	}
	
	/**
	 * Generate random positive integer
	 * 
	 * @return random positive integer
	 */
	public int randomPositiveInt() {
		int result = -1;

		while(result < 1) {
			result = random.nextInt();
		}
		
		return(result);
	}
	
	/**
	 * Generate random positive long
	 * 
	 * @return random positive long
	 */
	public long randomPositiveLong() {
		long result = -1;

		while(result < 1) {
			result = random.nextLong();
		}
		
		return(result);
	}
	
	/**
	 * Useful constant
	 */
	TrimString default_attribute = new TrimString(ConstantsIf.DEFAULT_ATTRIBUTE);
	
	/**
	 * Useful constant
	 */
	TrimString default_rule = new TrimString(ConstantsIf.DEFAULT_RULE);
	
	/**
	 * Random generator
	 */
	Random random = new Random();
	
	/**
	 * RMI handle
	 */
	BusinessDelegate bd = new BusinessDelegate();
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());	
}
