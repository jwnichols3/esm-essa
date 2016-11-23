package com.bgi.essa.struts1_2.user;

import java.io.InputStream;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.upload.FormFile;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.LoadXmlCtx;

import com.bgi.essa.struts1_2.EssaAction;
import com.bgi.essa.struts1_2.StrutsConstantsIf;

import com.bgi.essa.struts1_2.utility.XmlDump;

/**
 * @author coleguy
 */
public class AbstractConfigurationAction extends EssaAction {

	/**
	 * Write an uploaded file to /tmp
	 * 
	 * @param arg form
	 * @return true success
	 */
	boolean getXmlFile(ConfigurationForm arg) {
		StringBuilder sb = new StringBuilder();
		
		FormFile ff = arg.getRawItem();
		if (ff == null) {
			_log.error("empty form file");
			return(false);
		}
		
		int read_total = 0;
		int length = ff.getFileSize();
		byte[] bytez = new byte[StrutsConstantsIf.MAX_FILE_BUFFER];

		try {
			InputStream is = ff.getInputStream();
			
			do {
				int count = is.read(bytez, 0, StrutsConstantsIf.MAX_FILE_BUFFER);
				sb.append(new String(bytez, 0, count));
				read_total += count;
			} while(read_total < length);
		} catch(Exception exception) {
			_log.error("upload choke", exception);
			return(false);
		}
		
		LoadXmlCtx ctx = new LoadXmlCtx();
		ctx.setCandidate(sb.toString());
		
		try {
			bd.serviceCommand(ctx);
		} catch(Exception exception) {
			_log.error("xml parse failure");
			return(false);
		}
		
		return(true);
	}

	/**
	 * Dump the system configuration
	 * 
	 * @return list of string containing raw XML
	 */
	List<String> dumpAll() {
		XmlDump xml_dump = new XmlDump();
		return(xml_dump.dumpAllActiveTasks());
	}

	/**
	 * Raw XML to parse
	 */
	protected String _raw_xml;

	/**
	 * Handle to back end services
	 */
	protected final BusinessDelegate bd = new BusinessDelegate();
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}
