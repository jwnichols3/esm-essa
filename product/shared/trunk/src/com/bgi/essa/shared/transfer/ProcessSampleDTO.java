package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Process sample transfer object
 * 
 * @hibernate.class 
 *   table = "PROCESS_SAMPLE"
 * 
 * @author gsc
 */
public class ProcessSampleDTO extends AbstractSample implements Cloneable, Comparable<Object> {

	/**
	 * Return row ID.
	 * 
	 * @return row ID
	 * 
	 * @hibernate.id
	 *   name="ID"
	 *   type="long" 
	 *   column="ID"
	 *   generator-class="native"
	 */
	public Long getRowId() {
		return(id.getLongKeyValue());
	}

	/**
	 * Observed PID
	 */
	private int _pid;
	
	/**
	 * Return observed PID
	 * 
	 * @return observed PID
	 * 
	 * @hibernate.property
	 *   column="PID"
	 *   not-null="true"
	 */
	public int getPid() {
		return(_pid);
	}
	
	/**
	 * Define observed PID
	 * 
	 * @param arg fresh PID
	 */
	public void setPid(int arg) {
		_pid = arg;
	}
	
	/**
	 * Observed process name
	 */
	private TrimString _name = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return process name
	 * 
	 * @return process name
	 * 
	 * @hibernate.property
	 *   column="NAME"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getName() {
		return(_name);
	}

	/**
	 * Define process name
	 * 
	 * @param arg process name
	 */
	public void setName(TrimString arg) {
		_name = arg;
	}	
	
	/**
	 * Observed population
	 */
	private int _population;
	
	/**
	 * Return observed population
	 * 
	 * @return observed population
	 * 
	 * @hibernate.property
	 *   column="POPULATION"
	 *   not-null="true"
	 */
	public int getPopulation() {
		return(_population);
	}
	
	/**
	 * Define observed population
	 * 
	 * @param arg population
	 */
	public void setPopulation(int arg) {
		_population = arg;
	}
	
	/**
	 * CPU time in seconds
	 */
	private int _cpu_time;
	
	/**
	 * Return consumed CPU time
	 * 
	 * @return consumed CPU time
	 * 
	 * @hibernate.property
	 *   column="CPU_TIME"
	 *   not-null="true"
	 */
	public int getCpuTime() {
		return(_cpu_time);
	}
	
	/**
	 * Define consumed CPU time
	 * 
	 * @param arg consumed CPU time
	 */
	public void setCpuTime(int arg) {
		_cpu_time = arg;
	}
	
	/**
	 * true, lock file existed at sample time
	 */
	private boolean _exists_flag = false;
	
	/**
	 * Return true, lock file existed at sample time
	 * 
	 * @return true, lock file existed at sample time
	 */
	public boolean getExists() {
		return(_exists_flag);
	}
	
	/**
	 * Return true, lock file existed at sample time
	 * 
	 * @return true, lock file existed at sample time
	 */
	public boolean isExists() {
		return(_exists_flag);
	}

	/**
	 * Define if lock file existed at sample time
	 * 
	 * @param arg true, lock file existed at sample time
	 */
	public void setExists(boolean arg) {
		_exists_flag = arg;
	}
		
	/**
	 * Return true, lock file exists
	 * 
	 * @return true, lock file exists
	 * 
	 * @hibernate.property
	 *   column="EXIST"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxExists() {
		return(new FauxBoolean(_exists_flag));
	}
	
	/**
	 * Define if directory existed at sample time
	 * 
	 * @param arg true, directory existed
	 * @throws NullPointerException if null arg
	 */
	public void setFauxExists(FauxBoolean arg) {
		if (arg == null) {
			throw new NullPointerException("null faux exists");
		}
		
		_exists_flag = arg.getBooleanValue().booleanValue();
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "process:" + _name + ":" + _pid;
		result += ":exists:" + _exists_flag;
		result += ":population:" + _population;
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me process sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		ProcessSampleDTO dto = new ProcessSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setRuleRowId(rule_row_id.getLongKeyValue());
		dto.setTimeStamp(time_stamp);
		dto.setMatch(match_flag);
		dto.setSuppressed(suppress_flag);
		
		dto.setPid(_pid);
		dto.setName(_name);
		dto.setPopulation(_population);
		dto.setCpuTime(_cpu_time);
		dto.setExists(_exists_flag);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("ProcessSampleDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object. Sort by file name
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		/*
		final TrimString temp = ((FileSampleDTO) arg).getName();
		return(_name.getValue().compareToIgnoreCase(temp.getValue()));
		*/
		return(0);
	}

	/**
	 * Generated version ID
	 */
	private static final long serialVersionUID = -4852520798950615286L;
}
