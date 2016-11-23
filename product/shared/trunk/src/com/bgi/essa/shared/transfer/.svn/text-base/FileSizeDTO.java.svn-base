package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.SizeThreshold;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Define a file size monitor rule.
 * 
 * @hibernate.class 
 *   table = "FILE_SIZE"
 *   
 * @author coleguy
 */
public class FileSizeDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * Target file
	 */
	private TrimString _file = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the target file
	 * 
	 * @return target file
	 *
     * @hibernate.property
     *   column="TARGET"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getTarget() {
		return(_file);
	}

	/**
	 * Define the target file
	 * 
	 * @param arg target file
	 * @throws NullPointerException if null arg
	 */
	public void setTarget(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null file");
		}
		
		_file = new TrimString(arg);
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
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "filesize:" + _file + ":type:" + _threshold_type;
		result += ":min:" + _min_threshold + ":max:" + _max_threshold;
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
		return("fix me filesizedto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		FileSizeDTO dto = new FileSizeDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setTarget(_file);
		dto.setThresholdType(_threshold_type);
		dto.setMinimumThreshold(_min_threshold);
		dto.setMaximumThreshold(_max_threshold);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("FileSizeDTO fix me/isReasonable");
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
		
		System.out.println("FIXME FileSizeDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 7315545817709069933L;
}
