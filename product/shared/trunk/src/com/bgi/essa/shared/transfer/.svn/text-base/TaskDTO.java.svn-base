package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Task/Rule
 * 
 * @hibernate.class
 *   table = "TASK"
 * 
 * @author coleguy
 */
public class TaskDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * Operator assigned task name.  Convenience only, not used by system.
	 */
	private TrimString _name = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the task name
	 * 
	 * @return task name
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
	 * Define the task name
	 * 
	 * @param arg task name
	 * @throws NullPointerException if null arg
	 */
	public void setName(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
		
		_name = new TrimString(arg);
	}
	
	/**
	 * Sample rate in seconds
	 */
	private int _frequency = ConstantsIf.MIN_SAMPLE_FREQUENCY;

	/**
	 * Return the sample rate in seconds
	 * 
	 * @return sample rate in seconds
	 *
     * @hibernate.property
     *   column="FREQUENCY"
     *   not-null="true"
	 */
	public int getFrequency() {
		return(_frequency);
	}

	/**
	 * Define the sample rate in seconds
	 * 
	 * @param arg sample rate in seconds
	 * @throws IllegalArgumentException if stupid value
	 */
	public void setFrequency(int arg) {
		if ((arg < ConstantsIf.MIN_SAMPLE_FREQUENCY) || (arg > ConstantsIf.MAX_SAMPLE_FREQUENCY)) {
			throw new IllegalArgumentException("bad sample frequency");
		}

		_frequency = arg;
	}

	/**
	 * True, this task must match all rules
	 */
	private boolean _match_all_flag = false;

	/**
	 * Return match all flag
	 * 
	 * @return true, all rules must match, else only one (AND vs OR)
	 */
	public boolean getMatchAll() {
		return(_match_all_flag);
	}
	
	/**
	 * Return match all flag
	 * 
	 * @return true, all rules must match
	 */
	public boolean isMatchAll() {
		return(_match_all_flag);
	}

	/**
	 * Define if "match all" or "match one".
	 * 
	 * @param arg true, all rules must match
	 */
	public void setMatchAll(final boolean arg) {
		_match_all_flag = arg;
	}
	
	/**
	 * Return "match all" flag
	 * 
	 * @return "match all" flag 
	 * 
	 * @hibernate.property
	 *   column="MATCH_ALL"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxMatchAll() {
		return(new FauxBoolean(_match_all_flag));
	}
	
	/**
	 * Define the "match all" state
	 * 
	 * @param arg "match all" state
	 */
	public void setFauxMatchAll(FauxBoolean arg) {
		_match_all_flag = arg.getBooleanValue().booleanValue();
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "task:" + _name.getValue() + ":" + _match_all_flag;
		result += super.toString();
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me taskdto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		final TaskDTO dto = new TaskDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setName(_name);
		dto.setMatchAll(_match_all_flag);
		dto.setFrequency(_frequency);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("TaskDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object. Sort by name
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final TrimString temp = ((TaskDTO) arg).getName();
		return(_name.compareTo(temp));
	}
	
	/**
	 * Generated serial version ID 
	 */
	private static final long serialVersionUID = 5913422131585018910L;
}
