package com.bgi.essa.jboss4.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.LoadXmlCtx;

import com.bgi.essa.shared.exception.EssaException;

/**
 * Convert legacy configuration file
 * 
 * @author coleguy
 */
public class LegacyConfiguration {
	
	public void runner(String arg) throws Exception {
		if (arg == null) {
			//must search for candidates
			
			List<File> candidates = discoverCandidates();
			Iterator<File> ii = candidates.iterator();
			while(ii.hasNext()) {
				String buffer = convertConfiguration(ii.next());
				if (buffer != null) {
					writeToServer(buffer);
				}
			}
		} else {
			//convert specified candidate
			
			String buffer = convertConfiguration(new File(arg));
			if (buffer != null) {	
				writeToServer(buffer);
			}
		}
	}	
	
	private String convertConfiguration(File target) throws Exception {
		_log.info("convert:" + target);
		
		String temp = target.getName();
		
		if (temp.endsWith("filesys.dat")) {
			return(convertFileSys(target));
		} else if (temp.endsWith("fileage.dat")) {
			return(convertFileAge(target));
		} else if (temp.endsWith("process.dat")) {
			return(convertProcess(target));
		} else {
			_log.error("unknown file type:" + temp);
		}
		
		return(null);
	}
	
	private String convertFileAge(File target) throws FileNotFoundException, IOException {
		String action = null;
		String age_threshold = null;
		String app = null;
		String dir = null;
		String file = null;
		String sev = null;
		String message_age = "60";
		
		List<String> raw = readFile(target);
		Iterator<String> ii = raw.iterator();
		while (ii.hasNext()) {
			String candidate = ii.next();
			if (candidate.startsWith("action")) {
				action = getValue(candidate);
			} else if (candidate.startsWith("age_threshold")) {
				age_threshold = getValue(candidate);
			} else if (candidate.startsWith("app")) {
				app = getValue(candidate);
			} else if (candidate.startsWith("dir")) {
				dir = getValue(candidate);
			} else if (candidate.startsWith("file")) {
				file = getValue(candidate);
			} else if (candidate.startsWith("sev")) {
				sev = getValue(candidate);
			} else if (candidate.startsWith("message_age")) {
				message_age = getValue(candidate);
			}
		}
		
		StringBuilder sb = new StringBuilder("<essa_configuration><tasks><task>");
		sb.append("<name>converted</name>");
		sb.append("<match_rule>MATCH_ANY_RULE</match_rule>");
		sb.append("<sample_interval>30</sample_interval>");
		sb.append("<vpo>");
		sb.append("<application_name>" + app + "</application_name>");
		sb.append("<severity>" + sev + "</severity>");
		sb.append("<retry_interval>" + message_age + "</retry_interval>");
		sb.append("<actions>");
		sb.append("</actions>");
		sb.append("</vpo>");
		sb.append("<rules><rule>");
		sb.append("<file_age_monitor>");
		sb.append("<file>" + dir + file + "</file>");
		sb.append("<threshold>" + age_threshold + "</threshold>");
		sb.append("</file_age_monitor>");
		sb.append("</rule></rules>");
		sb.append("</task></tasks></essa_configuration>");
		return(sb.toString());
	}
	
	private String convertFileSys(File target) throws FileNotFoundException, IOException {
		String app = null;
		String filesys = null;
		String size = null;
		
		String action = null;
		String sev = "normal";
		String message_age = "60";
		
		List<String> raw = readFile(target);
		Iterator<String> ii = raw.iterator();
		while (ii.hasNext()) {
			String candidate = ii.next();
			if (candidate.startsWith("action")) {
				action = getValue(candidate);
			} else if (candidate.startsWith("app")) {
				app = getValue(candidate);
			} else if (candidate.startsWith("size")) {
				size = getValue(candidate);
			} else if (candidate.startsWith("filesys")) {
				filesys = getValue(candidate);
			} else if (candidate.startsWith("sev")) {
				sev = getValue(candidate);
			} else if (candidate.startsWith("message_age")) {
				message_age = getValue(candidate);
			}
		}
		
		StringBuilder sb = new StringBuilder("<essa_configuration><tasks><task>");
		sb.append("<name>converted</name>");
		sb.append("<match_rule>MATCH_ANY_RULE</match_rule>");
		sb.append("<sample_interval>30</sample_interval>");
		sb.append("<vpo>");
		sb.append("<application_name>" + app + "</application_name>");
		sb.append("<severity>" + sev + "</severity>");
		sb.append("<retry_interval>" + message_age + "</retry_interval>");
		sb.append("<actions>");
		sb.append("</actions>");
		sb.append("</vpo>");
		sb.append("<rules><rule>");
		sb.append("<file_system_size_monitor>");
		sb.append("<file_system>" + filesys + "</file_system>");
		sb.append("<block>" + size + "</block>");
		sb.append("<inode>100</inode>");
		sb.append("</file_syste_size_monitor>");
		sb.append("</rule></rules>");
		sb.append("</task></tasks></essa_configuration>");
		return(sb.toString());
	}
	
	private String convertProcess(File target) throws FileNotFoundException, IOException {
		String app = null;
		String pid = null;
		String process = null;
		
		String action = null;
		String sev = "normal";
		String message_age = "60";
		
		List<String> raw = readFile(target);
		Iterator<String> ii = raw.iterator();
		while (ii.hasNext()) {
			String candidate = ii.next();
			if (candidate.startsWith("action")) {
				action = getValue(candidate);
			} else if (candidate.startsWith("app")) {
				app = getValue(candidate);
			} else if (candidate.startsWith("pid")) {
				pid = getValue(candidate);
			} else if (candidate.startsWith("process")) {
				process = getValue(candidate);
			} else if (candidate.startsWith("sev")) {
				sev = getValue(candidate);
			} else if (candidate.startsWith("message_age")) {
				message_age = getValue(candidate);
			}
		}
		
		StringBuilder sb = new StringBuilder("<essa_configuration><tasks><task>");
		sb.append("<name>converted</name>");
		sb.append("<match_rule>MATCH_ANY_RULE</match_rule>");
		sb.append("<sample_interval>30</sample_interval>");
		sb.append("<vpo>");
		sb.append("<application_name>" + app + "</application_name>");
		sb.append("<severity>" + sev + "</severity>");
		sb.append("<retry_interval>" + message_age + "</retry_interval>");
		sb.append("<actions>");
		sb.append("</actions>");
		sb.append("</vpo>");
		sb.append("<rules><rule>");
		sb.append("<process_monitor>");
		sb.append("<target>" + process + "</target>");
		sb.append("</process_monitor>");
		sb.append("</rule></rules>");
		sb.append("</task></tasks></essa_configuration>");
		return(sb.toString());
	}
	
	private String getValue(String arg) {
		String[] tokens = arg.split("=");
		return(tokens[tokens.length-1]);
	}

	/**
	 * Read a file and return the contents
	 * 
	 * @param target
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private List<String> readFile(File target) throws FileNotFoundException, IOException {
		String buffer = null;
	
		ArrayList<String> list = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader(target));
		
		do {
			buffer = br.readLine();
			if (buffer != null) {
				if (buffer.startsWith("#")) {
					continue; //comment
				}
				
				String[] tokens = buffer.split(" ");
				for (int ii = 0; ii < tokens.length; ii++) {
					list.add(tokens[ii]);
				}
			}
		} while(buffer != null);
		
		br.close();
		
		return(list);
	}
	
	/**
	 * Visit each directory and test for magic configuration files.
	 * 
	 * @return list of candidate files
	 */
	private List<File> discoverCandidates() {
		ArrayList<File> candidates = new ArrayList<File>();
		
		ArrayList<File> directories = new ArrayList<File>();
		directories.add(new File("/"));
		
		for (int ii = 0; ii < directories.size(); ii++) {
			File current = directories.get(ii);
			File[] files = current.listFiles();
			if (files != null) {
				for (int jj = 0; jj < files.length; jj++) {	
					if (files[jj].isDirectory()) {
						directories.add(files[jj]);
					} else if (files[jj].isFile()) {
						String temp = files[jj].getName();
						if (temp.equals("filesys.dat")) {
							candidates.add(files[jj]);
						} else if (temp.equals("fileage.dat")) {
							candidates.add(files[jj]);
						} else if (temp.equals("process.dat")) {
							candidates.add(files[jj]);
						}
					}			
				}
			}
		}
		
		return(candidates);
	}
	
	/**
	 * Write XML to JBoss
	 * 
	 * @param arg
	 */
	public void writeToServer(String arg) throws EssaException {
		LoadXmlCtx ctx = new LoadXmlCtx();
		ctx.setCandidate(arg);
		
		System.out.println(arg);
		System.out.println("uncomment business delegate");
	//	BusinessDelegate bd = new BusinessDelegate();
	//	bd.serviceCommand(ctx);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("begin");
		
		LegacyConfiguration lc = new LegacyConfiguration();
		//lc.runner(null);

		//lc.runner("\\Documents and Settings\\coleguy\\workspace1\\vpo\\SSM\\etc\\linux\\fileage.dat");
		//lc.runner("\\Documents and Settings\\coleguy\\workspace1\\vpo\\SSM\\etc\\solaris\\fileage.dat");
		lc.runner("\\Documents and Settings\\coleguy\\workspace1\\vpo\\SSM\\etc\\linux\\filesys.dat");
		
		/*
		\Documents and Settings\coleguy\workspace1\vpo\SSM\etc\linux\filesys.dat
		\Documents and Settings\coleguy\workspace1\vpo\SSM\etc\solaris\fileage.dat
		\Documents and Settings\coleguy\workspace1\vpo\SSM\etc\solaris\filesys.dat
		\Documents and Settings\coleguy\workspace1\vpo\SSM\etc\windows\fileage.dat
		\Documents and Settings\coleguy\workspace1\vpo\SSM\etc\windows\filesys.dat
	*/
		
		System.out.println("end");
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
