package com.bgi.essa.jboss4.jmx;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.FileSystem;
import com.bgi.essa.shared.primitive.ProcessSample;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

import com.bgi.essa.shared.transfer.FileSampleDTO;
import com.bgi.essa.shared.transfer.FileSystemSampleDTO;
import com.bgi.essa.shared.transfer.StatVfsDTO;

/**
 * Facade abstracting JMX based system instrumentation.
 * 
 * @author coleguy
 */
public class JmxFacade {

	/**
	 * JNDI call to instrument factory for instrumentation
	 * 
	 * @return FileWrapper or null if problem
	 */
	public JniStub getJniStub() {
		try {
			javax.naming.Context context = new javax.naming.InitialContext();
			InstrumentFactory factory = (InstrumentFactory) context.lookup(ConstantsIf.INSTRUMENT_FACTORY);
			return(factory.getJniStub());
		} catch(Exception exception) {
			_log.error("instrument factory failure", exception);
		}
		
		return(null);
	}

	/**
	 * JNDI call to instrument factory for instrumentation
	 * 
	 * @return FileWrapper or null if problem
	 */
	public FileWrapper getFileWrapper() {
		try {
			javax.naming.Context context = new javax.naming.InitialContext();
			InstrumentFactory factory = (InstrumentFactory) context.lookup(ConstantsIf.INSTRUMENT_FACTORY);
			return(factory.getFileWrapper());
		} catch(Exception exception) {
			_log.error("instrument factory failure", exception);
		}
		
		return(null);
	}
	
	/**
	 * Return a file sample
	 * 
	 * @param arg fully qualified file name of target
	 * @return file statistics or null if problem
	 */
	public FileSampleDTO getFileSample(TrimString arg) {
		FileWrapper fw = getFileWrapper();
		if (fw == null) {
		}
		
		FileSampleDTO dto = new FileSampleDTO();
		dto.setName(arg);
		
		if (fw.exists(arg)) {
			dto.setIsExists(new FauxBoolean(true));
			dto.setIsFile(new FauxBoolean(fw.isFile(arg)));
			dto.setLength(fw.length(arg));
			dto.setFileModified(new ZuluTime(fw.lastModified(arg)));
					
			if (fw.isDirectory(arg)) {
				dto.setIsDirectory(new FauxBoolean(true));
				String[] children = fw.list(arg);
				dto.setChildPopulation(children.length);
			} else {
				dto.setIsDirectory(new FauxBoolean(false));
				dto.setChildPopulation(0);
			}
		} else {
			dto.setIsExists(new FauxBoolean(false));
		}
		
		return(dto);
	}
	
	/**
	 * JNDI call to instrument factory for instrumentation
	 * 
	 * @return TextFileReader or null if problem
	 */
	public TextFileReader getTextFileReader() {
		try {
			javax.naming.Context context = new javax.naming.InitialContext();
			InstrumentFactory factory = (InstrumentFactory) context.lookup(ConstantsIf.INSTRUMENT_FACTORY);
			return(factory.getTextFileReader());
		} catch(Exception exception) {
			_log.error("instrument factory failure", exception);
		}
		
		return(null);
	}
	
	/**
	 * Read a text file and return the contents as a string array
	 * 
	 * @param arg fully qualified file name
	 * @return contents as string array, might be empty but never null
	 */
	public String[] getTextFile(TrimString arg) {
		TextFileReader tfr = getTextFileReader();
		return(tfr.readFile(arg.getValue()));
	}
	
	/**
	 * Discover file systems on this system
	 * 
	 * @return array of file systems.
	 */
	public FileSystemSampleDTO getFileSystems() {
		String delimiter = "\t";
		TrimString linux_file = new TrimString("/etc/mtab");
		TrimString solaris_file = new TrimString("/etc/mnttab");

		String[] candidates = null;
		FileWrapper fw = getFileWrapper();
		if (fw.exists(solaris_file)) {
			candidates = getTextFile(solaris_file);
		} else if (fw.exists(linux_file)) {
			delimiter = " ";
			candidates = getTextFile(linux_file);
		} else {
			_log.error("unable to discover file systems");
			return(new FileSystemSampleDTO());
		}

		ArrayList<FileSystem> results = new ArrayList<FileSystem>();
		for (int ii = 0; ii < candidates.length; ii++) {
			results.add(new FileSystem(new TrimString(candidates[ii]), delimiter));
		}
		
		FileSystemSampleDTO dto = new FileSystemSampleDTO();
		dto.setCandidates(results);
		
		return(dto);
	}
	
	/**
	 * Return system boot time
	 * 
	 * @return boot time
	 */
	public ZuluTime getBootTime() {
		JniStub js = getJniStub();
		return(new ZuluTime(js.getBootTime()));
	}
	
	/**
	 * Return file system statistics
	 * 
	 * @param arg file system name
	 * @return file system statistics
	 */
	public StatVfsDTO getFileSystem(TrimString arg) {
		JniStub js = getJniStub();
		String temp = js.getStatVfs(arg.getValue());
		
		StatVfsDTO dto = new StatVfsDTO();
		dto.setName(arg);
		dto.parse(temp);
		
		return(dto);
	}
	
	/**
	 * Return a list of processes known to the system
	 * 
	 * @return list of processes known to the system
	 */
	public List<ProcessSample> getProcesses() {
		ArrayList<ProcessSample> result = new ArrayList<ProcessSample>();
		
		JniStub js = getJniStub();
		String temp1 = js.getProcesses();
		String[] temp2 = temp1.split(":");
		for (int ii = 0; ii < temp2.length; ii++) {
			if (temp2[ii].length() > 1) {
				try {
					ProcessSample temp3 = new ProcessSample(temp2[ii]);
					result.add(temp3);
				} catch(Exception exception) {
					_log.error("bad process sample:" + temp2[ii]);
				}
			}
		}
		
		return(result);
	}
	
	/**
	 * Invoke a native (external) process
	 * 
	 * @param command target command, can be full path 
	 * @param args command arguments, can be empty but not null
	 * @return true success else failure
	 */
	public boolean executeNativeProcess(String command, List<String> args) {
		_log.info("XXX XXX XXX executeNativeProcess XXX XXX XXX");
		_log.info(command);
		
		StringBuilder sb = new StringBuilder(command);
		
		Iterator<String> ii = args.iterator();
		while(ii.hasNext()) {
			sb.append(" " + ii.next());
		}
		
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec(sb.toString());
		} catch(Exception exception) {
			_log.error("choke", exception);
			return(false);
		}
		
		_log.info(sb.toString());
		
		return(true);
	}
	
	/**
	 * Logger
	 */
	private final Log _log = LogFactory.getLog(JmxFacade.class);
}
