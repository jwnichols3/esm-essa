package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.ProcessOption;
import com.bgi.essa.shared.primitive.ProcessThreshold;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Define a process monitor rule.
 * 
 * @hibernate.class 
 *   table = "PROCESS"
 *   
 * @author coleguy
 */
public class ProcessDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	@Override
	public Long getRowId() {
		return(id.getLongKeyValue());
	}
	
	/**
	 * Target
	 */
	private TrimString _target = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the target
	 * 
	 * @return target
	 *
     * @hibernate.property
     *   column="TARGET"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getTarget() {
		return(_target);
	}

	/**
	 * Define the target
	 * 
	 * @param arg target
	 * @throws NullPointerException if null arg
	 */
	public void setTarget(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null target");
		}
		
		_target = new TrimString(arg);
	}
	
	/**
	 * Define the option type
	 */
	private ProcessOption _option_type = ProcessOption.PROCESS_NAME;
	
	/**
	 * Return the option type
	 * 
	 * @return option type
	 *
     * @hibernate.property
     *   column="OPTION_TYPE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.ProcessOptionUserType"
     *   not-null="true"
	 */
	public ProcessOption getOptionType() {
		return(_option_type);
	}
	
	/**
	 * Define process option
	 * 
	 * @param arg process option
	 * @throws NullPointerException if null arg
	 */
	public void setOptionType(ProcessOption arg) {
		if (arg == null) {
			throw new NullPointerException("null option type");
		}
		
		_option_type = arg;
	}
	
	/**
	 * Define the threshold type
	 */
	private ProcessThreshold _threshold_type = ProcessThreshold.ALWAYS_RUN;
	
	/**
	 * Return the threshold type
	 * 
	 * @return threshold type
	 *
     * @hibernate.property
     *   column="THRESHOLD_TYPE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.ProcessThresholdUserType"
     *   not-null="true"
	 */
	public ProcessThreshold getThresholdType() {
		return(_threshold_type);
	}
	
	/**
	 * Define process threshold
	 * 
	 * @param arg process threshold
	 * @throws NullPointerException if null arg
	 */
	public void setThresholdType(ProcessThreshold arg) {
		if (arg == null) {
			throw new NullPointerException("null threshold type");
		}
		
		_threshold_type = arg;
	}
	
	/**
	 * Minimum population
	 */
	private int _min_population;
	
	/**
	 * Return minimum population
	 * 
	 * @return minimum population
	 * 
	 * @hibernate.property
	 *   column="MIN_POPULATION"
	 *   not-null=true
	 */
	public int getMinimumPopulation() {
		return(_min_population);
	}
	
	/**
	 * Define minimum population
	 * 
	 * @param arg minimum population
	 */
	public void setMinimumPopulation(int arg) {
		_min_population = arg;
	}
	
	/**
	 * Maximum population value
	 */
	private int _max_population;
	
	/**
	 * Return maximum population
	 * 
	 * @return maximum population
	 * 
	 * @hibernate.property
	 *   column="MAX_POPULATION"
	 *   not-null=true
	 */
	public int getMaximumPopulation() {
		return(_max_population);
	}
	
	/**
	 * Define maximum population
	 * 
	 * @param arg maximum population
	 */
	public void setMaximumPopulation(int arg) {
		_max_population = arg;
	}

	/**
	 * Maximum time value (minutes)
	 */
	private int _max_cpu_time;
	
	/**
	 * Return maximum CPU time
	 * 
	 * @return maximum CPU time
	 * 
	 * @hibernate.property
	 *   column="MAX_TIME"
	 *   not-null=true
	 */
	public int getMaximumTime() {
		return(_max_cpu_time);
	}
	
	/**
	 * Define maximum CPU time
	 * 
	 * @param arg maximum CPU time
	 */
	public void setMaximumTime(int arg) {
		_max_cpu_time = arg;
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "process:" + super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	@Override
	public String toXml() {
		return("fix me process dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		final ProcessDTO dto = new ProcessDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);

		dto.setTarget(_target);
		dto.setOptionType(_option_type);
		dto.setThresholdType(_threshold_type);
		dto.setMinimumPopulation(_min_population);
		dto.setMaximumPopulation(_max_population);
		dto.setMaximumTime(_max_cpu_time);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("ProcessDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		/*
		final ApplicationName temp = ((VpoDTO) arg).getAppName();
		return(_app_name.toString().compareTo(temp.toString()));
		*/
		System.out.println("FIXME ProcessDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 7724836731724623053L;
}
