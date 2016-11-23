package com.bgi.essa.shared.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.command.FileSystemCtx;

import com.bgi.essa.shared.primitive.LegalCmd;

import com.bgi.essa.shared.transfer.FileSystemSampleDTO;

/**
 * @author coleguy
 */
public class FileSystemCtxTest extends TestCase {

	/**
	 * @param name
	 */
	public FileSystemCtxTest(final String name) {
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

		final FileSystemCtx ctx1 = new FileSystemCtx();
		assertNotNull("test01a", ctx1);
		assertTrue("test01b", ctx1.getCommand().equals(LegalCmd.FILE_SYSTEM_SAMPLE_CMD));
		
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
		
		final FileSystemSampleDTO dto1 = new FileSystemSampleDTO();
		assertNotNull("test01g", dto1);

		ctx1.setSample(dto1);
		assertNotNull("test01h", ctx1.getSample());
	}

    public void test02() {
        _log.info ( "test02" );

        
    }
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(BootTimeCtxTest.class);
}
