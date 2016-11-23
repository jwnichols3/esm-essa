package com.bgi.essa.jboss4.varia;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jboss.varia.scheduler.Schedulable;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.EntityDeleteCtx;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.AbstractSample;
import com.bgi.essa.shared.transfer.BootTimeSampleDTO;
import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;
import com.bgi.essa.shared.transfer.DtoIf;
import com.bgi.essa.shared.transfer.FileAgeSampleDTO;
import com.bgi.essa.shared.transfer.FileSizeSampleDTO;
import com.bgi.essa.shared.transfer.FileSystemSizeSampleDTO;
import com.bgi.essa.shared.transfer.ProcessSampleDTO;

/**
 * Delete old sample rows
 * 
 * @author coleguy
 */
public class Pruner implements Schedulable {

	/**
	 * ctor 
	 * 
	 * @param arg 
	 */
	public Pruner(String arg) {
		_log.info("ctor:" + arg);
	}
	
	/**
	 * Varia schedule hook.  Invoked for each timer event.
	 * 
	 * @param now timestamp from varia
	 * @param remaining remaining iterations
	 */
	public void perform(Date now, long remaining) {
		_log.info(now + ":" + remaining);
		
		if (skip_one) {
			skip_one = false;
			return;
		}
		
		int counter = 0;
		BusinessDelegate bd = new BusinessDelegate();

		counter = reaper(new BootTimeSampleDTO(), bd);
//		_log.info("boot time sample:" + counter);
		counter = reaper(new DirectorySizeSampleDTO(), bd);
//		_log.info("directory size sample:" + counter);
		counter = reaper(new FileAgeSampleDTO(), bd);
//		_log.info("file age sample:" + counter);
		counter = reaper(new FileSizeSampleDTO(), bd);
//		_log.info("file size sample:" + counter);
		counter = reaper(new FileSystemSizeSampleDTO(), bd);
//		_log.info("file system size sample:" + counter);
		counter = reaper(new ProcessSampleDTO(), bd);
		_log.info("process sample:" + counter);
	}
	
	/**
	 * 
	 * @param arg
	 */
	private int reaper(DtoIf arg, BusinessDelegate bd) {
		int counter = 0;
		
		ZuluTime time_now = new ZuluTime();
		long threshold = time_now.getTimeInMillis() - DELTA;
		
		List<DtoIf> list = bd.selectAll(arg, SelectOption.SELECT_ACTIVE);
		Iterator<DtoIf> ii = list.iterator();
		while(ii.hasNext()) {
			++counter;
			
			try {	
				AbstractSample sample = (AbstractSample) ii.next();
				if (sample.getTimeStamp().getTimeInMillis() < threshold) {
					EntityDeleteCtx ctx = new EntityDeleteCtx();
					ctx.setCandidate(sample);
					bd.serviceCommand(ctx);
				}
			} catch(Exception exception) {
				_log.error("choke:", exception);
			}	
		}
		
		return(counter);
	}
	
	/**
	 * 
	 */
	private boolean skip_one = true;
	
	/**
	 * 24 hours in milliseconds
	 */
	private static final long DELTA = 24L * 60L * 60L * 1000L;
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(Pruner.class);
}
