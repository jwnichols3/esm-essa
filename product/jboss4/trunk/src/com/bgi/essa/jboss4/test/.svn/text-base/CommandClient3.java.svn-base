package com.bgi.essa.jboss4.test;

import java.util.List;

import com.bgi.essa.jboss4.client.BusinessDelegate;

//import com.bgi.essa.shared.command.FileSampleCtx;
//import com.bgi.essa.shared.command.BootTimeCtx;
//import com.bgi.essa.shared.command.JniStatVfsCtx;
import com.bgi.essa.shared.command.PingCtx;
import com.bgi.essa.shared.command.ScheduleDeleteCtx;
import com.bgi.essa.shared.command.ScheduleUpdateCtx;
import com.bgi.essa.shared.command.ScheduleUtilityCtx;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * @author coleguy
 */
public class CommandClient3 {

	public void runClient1() throws Exception {
		BusinessDelegate bd = new BusinessDelegate();
		
		ScheduleUtilityCtx utility = new ScheduleUtilityCtx();
		utility = (ScheduleUtilityCtx) bd.serviceCommand(utility);
		System.out.println("success:" + utility.isSuccess());
		System.out.println("scheduler:" + utility.getSchedulerName());
		
		List<TrimString> list = utility.getJobNames();
		System.out.println("job population:" + list.size());
		for (int ii = 0; ii < list.size(); ii++) {
			TrimString temp = (TrimString) list.get(ii);
			System.out.println(ii + ":" + temp);
		}
		
		ScheduleDeleteCtx delete1 = new ScheduleDeleteCtx();
		if (list.size() > 0) {
			delete1.setName((TrimString) list.get(0));
		} else {
			delete1.setName(new TrimString("bogus target"));
		}
	
		ScheduleDeleteCtx delete2 = (ScheduleDeleteCtx) bd.serviceCommand(delete1);
		System.out.println("success:" + delete2.isSuccess());
		
		ScheduleUpdateCtx update1 = new ScheduleUpdateCtx();
		update1.setName(new TrimString("testjob1"));
		
		PingCtx temp1 = new PingCtx();
		temp1.setFlag(false);
		
		update1.setJob(temp1);
		update1.setInterval(2);
		
		ScheduleUpdateCtx update2 = (ScheduleUpdateCtx) bd.serviceCommand(update1);
		System.out.println("success:" + update2.isSuccess());
		
		/*
		JniStatVfsCtx stat_vfs = new JniStatVfsCtx();
		stat_vfs.setName(new TrimString("/tmp"));
		
		ScheduleUpdateCtx update3 = new ScheduleUpdateCtx();
		update3.setName(new TrimString("testjob2"));
		update3.setJob(stat_vfs);
		update3.setInterval(3);
		
		ScheduleUpdateCtx update4 = (ScheduleUpdateCtx) bd.serviceCommand(update3);
		System.out.println("success:" + update4.isSuccess());
		
		ScheduleUpdateCtx update5 = new ScheduleUpdateCtx();
		update5.setName(new TrimString("testjob3"));
		update5.setJob(new BootTimeCtx());
		update5.setInterval(2);
		
		ScheduleUpdateCtx update6 = (ScheduleUpdateCtx) bd.serviceCommand(update5);
		System.out.println("success:" + update6.isSuccess());
		
		FileSampleCtx fs_ctx = new FileSampleCtx();
		fs_ctx.setName(new TrimString("/var/run/utmp"));
		
		ScheduleUpdateCtx update7 = new ScheduleUpdateCtx();
		update7.setName(new TrimString("testjob4"));
		update7.setJob(fs_ctx);
		update7.setInterval(2);
		
		ScheduleUpdateCtx update8 = (ScheduleUpdateCtx) bd.serviceCommand(update7);
		System.out.println("success:" + update8.isSuccess());
		*/
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("begin");

		final CommandClient3 cc3 = new CommandClient3();
		cc3.runClient1();
		
		System.out.println("end");
	}

}
