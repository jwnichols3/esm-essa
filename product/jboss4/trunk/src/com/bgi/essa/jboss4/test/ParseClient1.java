package com.bgi.essa.jboss4.test;

import java.io.BufferedReader;
import java.io.FileReader;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.LoadXmlCtx;

/**
 * @author coleguy
 */
public class ParseClient1 {
	
	/**
	 * Connectivity Test
	 * 
	 * @throws Exception
	 */
	public void runClient1() throws Exception {
		BusinessDelegate bd = new BusinessDelegate();
		boolean flag = bd.isPingTest(false);
		System.out.println("isPingTest(false) returns:" + flag);
	}

	public void runClient2() throws Exception {
		LoadXmlCtx ctx = new LoadXmlCtx();
		
		String temp = null;
		StringBuilder sb = new StringBuilder();
		
		//BufferedReader br = new BufferedReader(new FileReader("/tmp/empty_dump.xml"));	
		BufferedReader br = new BufferedReader(new FileReader("/tmp/full_dump.xml"));
		do {
			temp = br.readLine();
			if (temp != null) {
				sb.append(temp);
			}
		} while(temp != null);
		
		br.close();
		
		System.out.println(sb.toString());
		
		BusinessDelegate bd = new BusinessDelegate();
		
		ctx.setCandidate(sb.toString());
	
		bd.serviceCommand(ctx);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("begin");

		ParseClient1 pc1 = new ParseClient1();
		pc1.runClient1();
		pc1.runClient2();
		
		System.out.println("end");
	}
}
