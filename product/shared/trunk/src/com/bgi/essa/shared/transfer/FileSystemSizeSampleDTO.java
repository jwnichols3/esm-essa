package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File size transfer object, employed to transfer file statistics.
 * 
 * @hibernate.class 
 *   table = "FILE_SYSTEM_SIZE_SAMPLE"
 *
 * @author coleguy
 */
public class FileSystemSizeSampleDTO extends AbstractSample implements Cloneable, Comparable<Object> {

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
	 * Percentage of allocated blocks
	 */
	private int _block_percentage;
	
	/**
	 * Return percentage of allocated blocks
	 * 
	 * @return percentage of allocated blocks
	 * 
	 * @hibernate.property
	 *   column="BLOCK_SAMPLE"
	 *   not-null="true"
	 */
	public int getBlockPercentage() {
		return(_block_percentage);
	}
	
	/**
	 * Define percentage of allocated blocks
	 * 
	 * @param arg fresh byte population
	 * @throws IllegalArgumentException if negative value
	 */
	public void setBlockPercentage(int arg) {
		if (arg < 0) {
			throw new IllegalArgumentException("negative block percentage");
		}
		
		_block_percentage = arg;
	}
	
	/**
	 * Percentage of allocated inodes
	 */
	private int _inode_percentage;
	
	/**
	 * Return percentage of allocated inodes
	 * 
	 * @return percentage of allocated inodes
	 * 
	 * @hibernate.property
	 *   column="INODE_SAMPLE"
	 *   not-null="true"
	 */
	public int getInodePercentage() {
		return(_inode_percentage);
	}
	
	/**
	 * Define percentage of inodes allocated
	 * 
	 * @param arg fresh inode percentage
	 * @throws IllegalArgumentException if negative value
	 */
	public void setInodePercentage(int arg) {
		if (arg < 0) {
			throw new IllegalArgumentException("negative inode percentage");
		}
		
		_inode_percentage = arg;
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
		String result = "file system size exists:" + _exists_flag;
		result += ":blocks:" + _block_percentage + ":inodes:" + _inode_percentage;
		result += super.toString();
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me file system size sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		FileSystemSizeSampleDTO dto = new FileSystemSizeSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setRuleRowId(rule_row_id.getLongKeyValue());
		dto.setTimeStamp(time_stamp);
		dto.setMatch(match_flag);
		dto.setSuppressed(suppress_flag);
		
		dto.setBlockPercentage(_block_percentage);
		dto.setInodePercentage(_inode_percentage);
		dto.setExists(_exists_flag);
		
		return(dto);
	}
	
	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("FileSystemSizeSampleDTO fix me/isReasonable");
		return(true);
	}
	
	/**
	 * Compare this object w/the specified object. Sort by observation time
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(Object arg) {
		ZuluTime temp = ((FileSystemSizeSampleDTO) arg).getTimeStamp();
		return(time_stamp.compareTo(temp));
	}
	
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 7897956233882450800L;
}