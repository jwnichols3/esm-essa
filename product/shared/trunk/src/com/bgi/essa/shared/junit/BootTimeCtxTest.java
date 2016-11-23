package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.BootTimeCtx;

import com.bgi.essa.shared.primitive.LegalCmd;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;

/**
 * @author coleguy
 */
public class BootTimeCtxTest extends TestCase {

	/**
	 * @param name
	 */
	public BootTimeCtxTest(final String name) {
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
	 * AbstractDTO tests
	 */
	public void test01() {
		_log.info("test01");

		final BootTimeCtx ctx1 = new BootTimeCtx();
		assertNotNull("test01a", ctx1);
		assertTrue("test01b", ctx1.getCommand().equals(LegalCmd.BOOT_TIME_SAMPLE_CMD));
		
		/*
		ctx1.setPersist(false);
		assertFalse("test01c", ctx1.isPersist());
		ctx1.setPersist(true);
		assertTrue("test01d", ctx1.isPersist());
		
		ctx1.setEvaluate(false);
		assertFalse("test01e", ctx1.isEvaluate());
		ctx1.setEvaluate(true);
		assertTrue("test01f", ctx1.isEvaluate());
		*/
		final BootTimeSampleDTO dto1 = new BootTimeSampleDTO();
		assertNotNull("test01g", dto1);

		ctx1.setSample(dto1);
		assertNotNull("test01h", ctx1.getSample());
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(BootTimeCtxTest.class);
}
