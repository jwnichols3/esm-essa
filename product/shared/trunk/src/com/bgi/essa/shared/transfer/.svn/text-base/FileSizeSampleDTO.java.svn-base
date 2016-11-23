package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File size transfer object, employed to transfer file statistics.
 * 
 * @hibernate.class 
 *   table = "FILE_SIZE_SAMPLE"
 *
 * @author coleguy
 */
public class FileSizeSampleDTO extends AbstractSample implements Cloneable, Comparable<Object> {

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
	 * Total bytes consumed
	 */
	private long _storage_count;
	
	/**
	 * Return total bytes consumed
	 * 
	 * @return total bytes consumed
	 * 
	 * @hibernate.property
	 *   column="SAMPLE"
	 *   not-null="true"
	 */
	public long getBytePopulation() {
		return(_storage_count);
	}
	
	/**
	 * Define total bytes consumed
	 * 
	 * @param arg fresh byte population
	 * @throws IllegalArgumentException if negative value
	 */
	public void setBytePopulation(long arg) {
		if (arg < 0) {
			throw new IllegalArgumentException("negative byte population");
		}
		
		_storage_count = arg;
	}
	
	/**
	 * true, file existed at sample time
	 */
	private boolean _exists_flag = false;
	
	/**
	 * Return true, file existed at sample time
	 * 
	 * @return true, file existed at sample time
	 */
	public boolean getExists() {
		return(_exists_flag);
	}
	
	/**
	 * Return true, file existed at sample time
	 * 
	 * @return true, file existed at sample time
	 */
	public boolean isExists() {
		return(_exists_flag);
	}

	/**
	 * Define if file existed at sample time
	 * 
	 * @param arg true, file existed at sample time
	 */
	public void setExists(boolean arg) {
		_exists_flag = arg;
	}
		
	/**
	 * Return true, file exists
	 * 
	 * @return true, file exists
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
	public String toString() {
		String result = "file size exists:" + _exists_flag + ":bytes:" + _storage_count;
		result += super.toString();
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me file size sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		FileSizeSampleDTO dto = new FileSizeSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setRuleRowId(rule_row_id.getLongKeyValue());
		dto.setTimeStamp(time_stamp);
		dto.setMatch(match_flag);
		dto.setSuppressed(suppress_flag);
		
		dto.setBytePopulation(_storage_count);
		dto.setExists(_exists_flag);
		
		return(dto);
	}
	
	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("FileSizeSampleDTO fix me/isReasonable");
		return(true);
	}
	
	/**
	 * Compare this object w/the specified object. Sort by observation time
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(Object arg) {
		ZuluTime temp = ((FileSizeSampleDTO) arg).getTimeStamp();
		return(time_stamp.compareTo(temp));
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8613399024867637947L;
}
