package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Define a directory size monitor rule.
 * 
 * @hibernate.class 
 *   table = "DIRECTORY_SIZE"
 *   
 * @author coleguy
 */
public class DirectorySizeDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * Target directory
	 */
	private TrimString _directory = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the target directory
	 * 
	 * @return target directory
	 *
     * @hibernate.property
     *   column="TARGET"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getTarget() {
		return(_directory);
	}

	/**
	 * Define the target directory
	 * 
	 * @param arg target directory
	 * @throws NullPointerException if null arg
	 */
	public void setTarget(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null directory");
		}
		
		_directory = new TrimString(arg);
	}
	
	/**
	 * Define the threshold type
	 */
	private SizeThreshold _threshold_type = SizeThreshold.FIXED_INCREASING;
	
	/**
	 * Return the threshold type
	 * 
	 * @return threshold type
	 *
     * @hibernate.property
     *   column="THRESHOLD_TYPE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.SizeThresholdUserType"
     *   not-null="true"
	 */
	public SizeThreshold getThresholdType() {
		return(_threshold_type);
	}
	
	/**
	 * Define size threshold
	 * 
	 * @param arg size threshold
	 * @throws NullPointerException if null arg
	 */
	public void setThresholdType(SizeThreshold arg) {
		if (arg == null) {
			throw new NullPointerException("null threshold type");
		}
		
		_threshold_type = arg;
	}
	
	/**
	 * Minimum threshold value
	 */
	private int _min_threshold;
	
	/**
	 * Return minimum threshold in KB
	 * 
	 * @return minimum threshold in KB
	 * 
	 * @hibernate.property
	 *   column="MIN_RANGE"
	 *   not-null=true
	 */
	public int getMinimumThreshold() {
		return(_min_threshold);
	}
	
	/**
	 * Define minimum threshold in KB
	 * 
	 * @param arg minimum threshold in KB
	 */
	public void setMinimumThreshold(int arg) {
		_min_threshold = arg;
	}
	
	/**
	 * Maximum threshold value
	 */
	private int _max_threshold;
	
	/**
	 * Return maximum threshold in KB
	 * 
	 * @return maximum threshold in KB
	 * 
	 * @hibernate.property
	 *   column="MAX_RANGE"
	 *   not-null=true
	 */
	public int getMaximumThreshold() {
		return(_max_threshold);
	}
	
	/**
	 * Define maximum threshold in KB
	 * 
	 * @param arg maximum threshold in KB
	 */
	public void setMaximumThreshold(int arg) {
		_max_threshold = arg;
	}

	/**
	 * True, visit all subdirectories, else this directory only.
	 */
	private boolean _recursive_flag = false;

	/**
	 * Return recursive flag
	 * 
	 * @return true, visit all subdirectories
	 */
	public boolean getRecursive() {
		return(_recursive_flag);
	}
	
	/**
	 * Return true, visit all subdirectories
	 * 
	 * @return true, visit all subdirectories
	 */
	public boolean isRecursive() {
		return(_recursive_flag);
	}

	/**
	 * Define if should visit subdirectories
	 * 
	 * @param arg true, should visit subdirectories
	 */
	public void setRecursive(boolean arg) {
		_recursive_flag = arg;
	}
	
	/**
	 * Return true, should visit subdirectories
	 * 
	 * @return recursive flag
	 * 
	 * @hibernate.property
	 *   column="RECURSIVE"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxRecursive() {
		return(new FauxBoolean(_recursive_flag));
	}
	
	/**
	 * Define recursive flag
	 * 
	 * @param arg recursive flag
	 */
	public void setFauxRecursive(FauxBoolean arg) {
		_recursive_flag = arg.getBooleanValue().booleanValue();
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "dirsize:" + _directory + ":type:" + _threshold_type;
		result += ":min:" + _min_threshold + ":max:" + _max_threshold;
		result += ":recurse:" + _recursive_flag;
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	@Override
	public String toXml() {
		return("fix me dirsizedto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		DirectorySizeDTO dto = new DirectorySizeDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setTarget(_directory);
		dto.setThresholdType(_threshold_type);
		dto.setMinimumThreshold(_min_threshold);
		dto.setMaximumThreshold(_max_threshold);
		dto.setRecursive(_recursive_flag);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("DirectorySizeDTO fix me/isReasonable");
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
		
		System.out.println("FIXME DirectorySizeDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -6111477996358050319L;
}
