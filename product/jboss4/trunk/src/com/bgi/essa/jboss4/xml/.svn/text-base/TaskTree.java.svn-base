package com.bgi.essa.jboss4.xml;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.TaskDTO;
import com.bgi.essa.shared.transfer.VpoDTO;

/**
 * @author coleguy
 */
public class TaskTree {
	
	public TaskTree() {
		System.out.println("task tree ctor");
	}
	
	private String _name;
	
	public String getName() {
		return(_name);
	}
	
	public void setName(String arg) {
		_name = arg;
	}
	
	private String _match_rule;
	
	public String getMatchRule() {
		return(_match_rule);
	}
	
	public void setMatchRule(String arg) {
		_match_rule = arg;
	}
	
	private String _sample_interval;
	
	public String getSampleInterval() {
		return(_sample_interval);
	}
	
	public void setSampleInterval(String arg) {
		_sample_interval = arg;
	}
	
	private String _note;
	
	public String getNote() {
		return(_note);
	}
	
	public void setNote(String arg) {
		_note = arg;
	}
	
	private VpoTree _default_vpo;
	
	public VpoTree getDefaultVpo() {
		return(_default_vpo);
	}
	
	public void setDefaultVpo(VpoTree arg) {
		_default_vpo = arg;
	}

	private List<RawAlarmInhibit> _inhibit_list = new ArrayList<RawAlarmInhibit>();
	
	/**
	 * Return collected alarm inhibit windows
	 * 
	 * @return collected alarm inhibit windows
	 */
	public List<RawAlarmInhibit> getAlarmInhibit() {
		return(_inhibit_list);
	}
	
	/**
	 * Add new inhibit window 
	 * 
	 * @param arg fresh inhibit window
	 */
	public void addAlarmInhibit(RawAlarmInhibit arg) {
		System.out.println("alarm inhibit add");
		_inhibit_list.add(arg);
	}

	private List<RawCma> _cma_list = new ArrayList<RawCma>();
	
	/**
	 * Return collected CMA
	 * 
	 * @return collected CMA
	 */
	public List<RawCma> getCma() {
		return(_cma_list);
	}
	
	/**
	 * Add new CMA 
	 * 
	 * @param arg fresh CMA
	 */
	public void addCma(RawCma arg) {
		System.out.println("cma add");
		_cma_list.add(arg);
	}

	private List<AbstractRule> _rule_list = new ArrayList<AbstractRule>();
	
	/**
	 * Return collected rules
	 * 
	 * @return collected rules
	 */
	public List<AbstractRule> getRule() {
		return(_rule_list);
	}
	
	/**
	 * Add new CMA 
	 * 
	 * @param arg fresh CMA
	 */
	public void addRule(AbstractRule arg) {
		System.out.println("rule add:" + arg);
		_rule_list.add(arg);
	}
	
	/**
	 * Return bare TaskDTO ready for DB insertion
	 * 
	 * @return bare TaskDTO ready for DB insertion
	 */
	public TaskDTO getTaskDto() {
		TaskDTO dto = new TaskDTO();
		
		if (_name == null) {
			_name = ConstantsIf.EMPTY_STRING;
		} 
		
		//
		dto.setName(new TrimString(_name));
		
		int temp = 0;
		
		try {
			temp = Integer.parseInt(_sample_interval);
		} catch(Exception exception) {
			_log.error("bad sample interval");
		}
		
		if (temp < ConstantsIf.MIN_SAMPLE_FREQUENCY) {
			temp = ConstantsIf.MIN_SAMPLE_FREQUENCY;
		}
		
		//
		dto.setFrequency(temp);
		
		if (_match_rule == null) {
			dto.setMatchAll(false);
		} else if (_match_rule.equals("MATCH_ANY_RULE")) {
			dto.setMatchAll(false);
		} else {
			dto.setMatchAll(true);
		}
		
		//		
		dto.setActive(true);
		
		return(dto);
	}
	
	/**
	 * Return default VPO
	 * 
	 * @return default VPO
	 */
	public VpoDTO getVpoDto() {
		VpoDTO dto = new VpoDTO();
		
		if (_default_vpo == null) {
			_log.error("no default VPO");
		} else {
			dto = _default_vpo.getVpoDto();
		}
		
		return(dto);
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}