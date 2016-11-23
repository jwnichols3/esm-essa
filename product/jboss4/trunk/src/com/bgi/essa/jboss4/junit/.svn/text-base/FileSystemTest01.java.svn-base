package com.bgi.essa.jboss4.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.FileSystemCtx;

//import com.bgi.essa.shared.primitive.TrimString;

//import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;
import com.bgi.essa.shared.transfer.FileSystemSampleDTO;

/**
 * @author coleguy
 */
public class FileSystemTest01 extends TestCase {

	/**
	 * @param name
	 */
	public FileSystemTest01(String name) {
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
	
	/**
	 *
	 */
	public void test01() {
		_log.info("test01");
		
		final FileSystemCtx ctx1 = new FileSystemCtx();
		assertNotNull("test01a", ctx1);
		
		/*
		ctx1.setPersist(false);
		ctx1.setEvaluate(false);
		*/
		
		FileSystemCtx ctx2 = null;
		try {
			ctx2 = (FileSystemCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke:", exception);
		}
	
		assertNotNull("test01b", ctx2);
		assertTrue("test01c", ctx2.isSuccess());
		
		final FileSystemSampleDTO dto = (FileSystemSampleDTO) ctx2.getSample();
		assertNotNull("test01d", dto);
		assertNotNull("test01e", dto.getTimeStamp());
		assertNotNull("test01f", dto.getCandidates());
		
		_log.info("sample:" + dto.toString());
	}

	/**
	 * RMI Handle
	 */
	private final BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSystemTest01.class);
}
