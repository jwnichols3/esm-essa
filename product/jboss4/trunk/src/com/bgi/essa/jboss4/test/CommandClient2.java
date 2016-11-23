package com.bgi.essa.jboss4.test;

import java.util.Random;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.FileSampleCtx;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * //type comment//
 * 
 * @author gsc
 */
public class CommandClient2 {

	/**
	 * Exercise RMI service (select, insert, update, delete test)
	 * 
	 * @throws Exception
	 */
	public void runClient1() throws Exception {
		final BusinessDelegate bd = new BusinessDelegate();

		// ///////////////////////////////////
		
		final FileSampleCtx fs_ctx1 = new FileSampleCtx();
		fs_ctx1.setName(new TrimString("/etc/passwd"));
		//fs_ctx1.setPersist(true);
		
		final FileSampleCtx fs_ctx2 = (FileSampleCtx) bd.serviceCommand(fs_ctx1);
		System.out.println(fs_ctx1);
		System.out.println(fs_ctx2);
		System.out.println(fs_ctx2.getSample().toString());
		
		// ///////////////////////////////////
		
		/*
		JniStatVfsCtx stat_ctx1 = new JniStatVfsCtx();
		stat_ctx1.setName(new TrimString("/opt"));
		JniStatVfsCtx stat_ctx2 = (JniStatVfsCtx) bd.serviceCommand(stat_ctx1);
		System.out.println(stat_ctx1);
		System.out.println(stat_ctx2);
		System.out.println(stat_ctx2.getResult());
		*/
		
		// ///////////////////////////////////
		
		/*
		JniBootTimeCtx boot_ctx1 = new JniBootTimeCtx();
		JniBootTimeCtx boot_ctx2 = (JniBootTimeCtx) bd.serviceCommand(boot_ctx1);
		System.out.println(boot_ctx1);
		System.out.println(boot_ctx2);
		System.out.println(boot_ctx2.getResult());
		*/
		
		// ///////////////////////////////////
		
		/*
		FileSystemCtx system1 = new FileSystemCtx();
		system1 = (FileSystemCtx) bd.serviceCommand(system1);
		FileSystem[] resultz = system1.getResults();
		for (int ii = 0; ii < resultz.length; ii++) {
			System.out.println(ii + "::" + resultz[ii]);
		}
		*/
		
		// ///////////////////////////////////
		
		/*
		AirportDTO airport = new AirportDTO();
		airport.setIata(new TrimString(Integer.toString(_random.nextInt())));
		airport.setCity(new TrimString(Integer.toString(_random.nextInt())));
		airport.setName(new TrimString(Integer.toString(_random.nextInt())));
		System.out.println(airport);

		EntityUpdateCtx euc1 = new EntityUpdateCtx();
		euc1.setCandidate(airport);

		EntityUpdateCtx euc2 = (EntityUpdateCtx) bd.serviceCommand(euc1);
		System.out.println("insert:" + euc2.getCandidate());
		*/
	}

	/**
	 * Exercise RMI service (command test)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		System.out.println("begin");

		final CommandClient2 cc2 = new CommandClient2();
		cc2.runClient1();

		System.out.println("end");
	}

	Random _random = new Random();
}
