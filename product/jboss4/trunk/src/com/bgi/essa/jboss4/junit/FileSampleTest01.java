package com.bgi.essa.jboss4.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.EntitySelectByRowIdCtx;
import com.bgi.essa.shared.command.FileSampleCtx;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.FileSampleDTO;

/**
 * Exercise FileSampleCtx
 * 
 * @author coleguy
 */
public class FileSampleTest01 extends TestCase {

	/**
	 * @param name
	 */
	public FileSampleTest01(String name) {
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
	 * Test using live directory
	 */
	public void test01() {
		_log.info("test01");
		
		FileSampleCtx ctx1 = new FileSampleCtx();
		assertNotNull("test01a", ctx1);
	
	//	ctx1.setPersist(false);
		ctx1.setName(new TrimString("/etc"));
		
		FileSampleCtx ctx2 = null;
		try {
			ctx2 = (FileSampleCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test01b", ctx2);
		assertTrue("test01c", ctx2.isSuccess());
		
		FileSampleDTO dto = (FileSampleDTO) ctx2.getSample();
		assertNotNull("test01d", dto);
		assertNotNull("test01e", dto.getTimeStamp());
		assertTrue("test01f", dto.getName().equals("/etc"));
		assertTrue("test01g", dto.getIsExists().isTrue());
		assertFalse("test01h", dto.getIsFile().isTrue());
		assertTrue("test01i", dto.getIsDirectory().isTrue());
		assertNotNull("test01j", dto.getFileModified());
	}
	
	/**
	 * Test using live file
	 */
	public void test02() {
		_log.info("test02");
		
		FileSampleCtx ctx1 = new FileSampleCtx();
		assertNotNull("test02a", ctx1);
	
	//	ctx1.setPersist(false);
		ctx1.setName(new TrimString("/etc/passwd"));
		
		FileSampleCtx ctx2 = null;
		try {
			ctx2 = (FileSampleCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test02b", ctx2);
		assertTrue("test02c", ctx2.isSuccess());
		
		FileSampleDTO dto = (FileSampleDTO) ctx2.getSample();
		assertNotNull("test02d", dto);
		assertNotNull("test02e", dto.getTimeStamp());
		assertTrue("test02f", dto.getName().equals("/etc/passwd"));
		assertTrue("test02g", dto.getIsExists().isTrue());
		assertTrue("test02h", dto.getIsFile().isTrue());
		assertFalse("test02i", dto.getIsDirectory().isTrue());
		assertEquals("test02j", 0, dto.getChildPopulation());
		assertNotNull("test02k", dto.getFileModified());
	}
	
	/**
	 * Test using bad file
	 */
	public void test03() {
		_log.info("test03");
		
		FileSampleCtx ctx1 = new FileSampleCtx();
		assertNotNull("test03a", ctx1);
	
	//	ctx1.setPersist(false);
		ctx1.setName(new TrimString("/obviously/bad/file/name"));
		
		FileSampleCtx ctx2 = null;
		try {
			ctx2 = (FileSampleCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test03b", ctx2);
		assertTrue("test03c", ctx2.isSuccess());

		FileSampleDTO dto = (FileSampleDTO) ctx2.getSample();
		assertNotNull("test03d", dto);
		assertNotNull("test03e", dto.getTimeStamp());
		assertTrue("test03f", dto.getName().equals("/obviously/bad/file/name"));
		assertFalse("test03g", dto.getIsExists().isTrue());
		assertFalse("test03h", dto.getIsFile().isTrue());
		assertFalse("test03i", dto.getIsDirectory().isTrue());
		assertEquals("test03j", 0, dto.getChildPopulation());
		assertNotNull("test03k", dto.getFileModified());
	}
	
	/**
	 * Test using live file w/persistance
	 * Ensure stored database row matches sample
	 */
	public void test04() {
		_log.info("test04");
		
		FileSampleCtx ctx1 = new FileSampleCtx();
		assertNotNull("test04a", ctx1);
	/*
		ctx1.setPersist(true);
		ctx1.setEvaluate(true);
		*/
		ctx1.setName(new TrimString("/etc/passwd"));
		
		FileSampleCtx ctx2 = null;
		try {
			ctx2 = (FileSampleCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test04b", ctx2);
		assertTrue("test04c", ctx2.isSuccess());
		
		//
		// dto1 to contain sample as reported and stored in Derby
		//
		FileSampleDTO dto1 = (FileSampleDTO) ctx2.getSample();
		assertNotNull("test04d", dto1);
		
		_log.info("fresh file sample dto1:" + dto1.toString());
		
		//
		// select same row for comparison
		//
		FileSampleDTO dto2 = new FileSampleDTO();
		dto2.setRowId(dto1.getRowId());
		
		EntitySelectByRowIdCtx ctx3 = new EntitySelectByRowIdCtx();
		ctx3.setCandidate(dto2);
		
		EntitySelectByRowIdCtx ctx4 = null;
		try {
			ctx4 = (EntitySelectByRowIdCtx) _bd.serviceCommand(ctx3);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test04e", ctx4);
		assertTrue("test04f", ctx4.isSuccess());
		
		//
		// dto3 contains retrieved Derby row
		// 
		//FileSampleDTO dto3 = (FileSampleDTO) ctx4.getResult();
		/*
		assertNotNull("test04g", dto3);
		
		_log.info("retrieved row dto3:" + dto3.toString());
		
		assertEquals("test04h", dto1.getRowId(), dto3.getRowId());
		assertEquals("test04i", dto1.isActive(), dto3.isActive());
		assertTrue("test04j", dto1.getNote().equals(dto3.getNote()));
		
		assertTrue("test04k", dto1.getTimeStamp().equals(dto3.getTimeStamp()));		
		assertTrue("test04m", dto1.getName().equals(dto3.getName()));
		assertTrue("test04n", dto1.getIsExists().equals(dto3.getIsExists()));
		assertTrue("test04o", dto1.getIsFile().equals(dto3.getIsFile()));
		assertTrue("test04p", dto1.getIsDirectory().equals(dto3.getIsDirectory()));
		assertEquals("test04q", dto1.getChildPopulation(), dto3.getChildPopulation());
		assertTrue("test04r", dto1.getFileModified().equals(dto3.getFileModified()));
		assertEquals("test04s", dto1.getLength(), dto3.getLength());
		assertEquals("test04t", dto1.getActive(), dto3.getActive());
		assertTrue("test04u", dto1.getNote().equals(dto3.getNote()));
		*/
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(FileSampleTest01.class);
}
