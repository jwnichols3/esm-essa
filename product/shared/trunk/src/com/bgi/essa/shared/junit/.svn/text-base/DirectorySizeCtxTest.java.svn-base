package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.DirectorySizeCtx;

import com.bgi.essa.shared.primitive.LegalCmd;

import com.bgi.essa.shared.transfer.DirectorySizeDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;

/**
 * @author coleguy
 */
public class DirectorySizeCtxTest extends TestCase {

	/**
	 * @param name
	 */
	public DirectorySizeCtxTest(final String name) {
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

		final DirectorySizeCtx ctx1 = new DirectorySizeCtx();
		assertNotNull("test01a", ctx1);
		assertTrue("test01b", ctx1.getCommand().equals(LegalCmd.DIR_SIZE_SAMPLE_CMD));
		
		/*
		ctx1.setPersist(false);
		assertFalse("test01c", ctx1.isPersist());
		ctx1.setPersist(true);
		assertTrue("test01d", ctx1.isPersist());
		
		ctx1.setEvaluate(false);
		assertFalse("test01e", ctx1.isEvaluate());
		ctx1.setEvaluate(true);
		assertTrue("test01f", ctx1.isEvaluate());
		
		ctx1.setRecursive(false);
		assertFalse("test01g", ctx1.isRecursive());
		ctx1.setRecursive(true);
		assertTrue("test01h", ctx1.isRecursive());
		*/
		
		DirectorySizeSampleDTO dto1 = new DirectorySizeSampleDTO();
		assertNotNull("test01i", dto1);

		ctx1.setSample(dto1);
		assertNotNull("test01j", ctx1.getSample());
		
		DirectorySizeDTO dto2 = new DirectorySizeDTO();
		assertNotNull("test01k", dto2);

		ctx1.setRule(dto2);
		assertNotNull("test01m", ctx1.getRule());
	}
	
	/**
	 * Remaining getters/setters
	 */
	public void test02() {
		_log.info("test02");

		final DirectorySizeCtx ctx1 = new DirectorySizeCtx();
		assertNotNull("test02a", ctx1);
	
		/*
		ctx1.setName(new TrimString("test name"));
		assertTrue("test02b", ctx1.getName().equals("test name"));
		*/
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(DirectorySizeCtxTest.class);
}
