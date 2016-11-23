package com.bgi.essa.jboss4.junit;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.EntitySelectByRowIdCtx;
import com.bgi.essa.shared.command.JniStatVfsCtx;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.StatVfsDTO;

/**
 * Exercise FileSystemCtx
 * 
 * @author coleguy
 */
public class StatVfsTest01 extends TestCase {

	/**
	 * @param name
	 */
	public StatVfsTest01(String name) {
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
	 * Test using live file system
	 */
	public void test01() {
		_log.info("test01");
		
		JniStatVfsCtx ctx1 = new JniStatVfsCtx();
		assertNotNull("test01a", ctx1);
		
		//ctx1.setPersist(false);
		ctx1.setName(new TrimString("/"));
		
		JniStatVfsCtx ctx2 = null;
		try {
			ctx2 = (JniStatVfsCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test01b", ctx2);
		assertTrue("test01c", ctx2.isSuccess());
		
		StatVfsDTO dto = (StatVfsDTO) ctx2.getSample();
		assertNotNull("test01d", dto);
		assertNotNull("test01e", dto.getTimeStamp());
		assertTrue("test01f", dto.getName().equals("/"));
	}
	
	/**
	 * Test using live file system.
	 * Persist to database, ensure stored row matches sample
	 */
	public void test02() {
		_log.info("test02");
		
		JniStatVfsCtx ctx1 = new JniStatVfsCtx();
		assertNotNull("test02a", ctx1);
		
		/*
		ctx1.setPersist(true);
		ctx1.setEvaluate(true);
		*/
		ctx1.setName(new TrimString("/"));
		
		JniStatVfsCtx ctx2 = null;
		try {
			ctx2 = (JniStatVfsCtx) _bd.serviceCommand(ctx1);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test02b", ctx2);
		assertTrue("test02c", ctx2.isSuccess());
		
		//
		// dto1 to contain sample as reported and stored in Derby
		//
		StatVfsDTO dto1 = (StatVfsDTO) ctx2.getSample();
		assertNotNull("test02d", dto1);
		
		//
		// select same row for comparison
		//
		StatVfsDTO dto2 = new StatVfsDTO();
		dto2.setRowId(dto1.getRowId());
		
		EntitySelectByRowIdCtx ctx3 = new EntitySelectByRowIdCtx();
		ctx3.setCandidate(dto2);
		
		EntitySelectByRowIdCtx ctx4 = null;
		try {
			ctx4 = (EntitySelectByRowIdCtx) _bd.serviceCommand(ctx3);
		} catch(Exception exception) {
			_log.error("choke:", exception);
		}
		
		assertNotNull("test02e", ctx4);
		assertTrue("test02f", ctx4.isSuccess());
		
		//
		// dto3 contains retrieved Derby row
		// 
		//StatVfsDTO dto3 = (StatVfsDTO) ctx4.getResult();
		/*
		assertNotNull("test02g", dto3);
		
		_log.info("retrieved row dto3:" + dto3.toString());
		
		assertEquals("test02h", dto1.getRowId(), dto3.getRowId());
		assertEquals("test02i", dto1.isActive(), dto3.isActive());
		assertTrue("test02j", dto1.getNote().equals(dto3.getNote()));
		
		assertTrue("test02k", dto1.getTimeStamp().equals(dto3.getTimeStamp()));		
		assertTrue("test02m", dto1.getName().equals(dto3.getName()));
		assertEquals("test02n", dto1.getBlockSize(), dto3.getBlockSize());
		assertEquals("test02o", dto1.getFragmentSize(), dto3.getFragmentSize());
		assertEquals("test02p", dto1.getFileSystemBlocks(), dto3.getFileSystemBlocks());
		assertEquals("test02q", dto1.getFreeBlocks(), dto3.getFreeBlocks());
		assertEquals("test02r", dto1.getNonRootFreeBlocks(), dto3.getNonRootFreeBlocks());
		assertEquals("test02s", dto1.getInodes(), dto3.getInodes());
		assertEquals("test02t", dto1.getFreeInodes(), dto3.getFreeInodes());
		assertEquals("test02u", dto1.getNonRootFreeInodes(), dto3.getNonRootFreeInodes());
		assertEquals("test02v", dto1.getFileSystemIdentifier(), dto3.getFileSystemIdentifier());
		assertEquals("test02w", dto1.getMountFlags(), dto3.getMountFlags());
		*/
	}
	
	/**
	 * RMI Handle
	 */
	private BusinessDelegate _bd = new BusinessDelegate();
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(StatVfsTest01.class);
}
