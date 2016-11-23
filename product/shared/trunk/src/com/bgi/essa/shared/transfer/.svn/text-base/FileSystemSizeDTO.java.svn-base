package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Define a file system size monitor rule.
 * 
 * @hibernate.class 
 *   table = "FILE_SYSTEM_SIZE"
 *   
 * @author coleguy
 */
public class FileSystemSizeDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * Return the target file system
	 * 
	 * @return target file system
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
	 * Define the target file system
	 * 
	 * @param arg target file system
	 * @throws NullPointerException if null arg
	 */
	public void setTarget(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null file");
		}
		
		_file = new TrimString(arg);
	}
	
	/**
	 * block threshold value as a percentage (from full)
	 */
	private int _block_threshold;
	
	/**
	 * Return block threshold as a percentage (from full)
	 * 
	 * @return block threshold as a percentage (from full)
	 * 
	 * @hibernate.property
	 *   column="BLOCK_THRESHOLD"
	 *   not-null=true
	 */
	public int getBlockThreshold() {
		return(_block_threshold);
	}
	
	/**
	 * Define block threshold (as a percentage from full)
	 * 
	 * @param arg block threshold (as a percentage from full)
	 */
	public void setBlockThreshold(int arg) {
		_block_threshold = arg;
	}
	
	/**
	 * inode threshold value as a percentage (from full)
	 */
	private int _inode_threshold;
	
	/**
	 * Return inode threshold (as a percentage from full)
	 * 
	 * @return inode threshold (as a percentage from full)
	 * 
	 * @hibernate.property
	 *   column="INODE_THRESHOLD"
	 *   not-null=true
	 */
	public int getInodeThreshold() {
		return(_inode_threshold);
	}
	
	/**
	 * Define inode threshold (as a percentage from full)
	 * 
	 * @param arg inode threshold (as a percentage from full)
	 */
	public void setInodeThreshold(int arg) {
		_inode_threshold = arg;
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "dirsize:" + _file;
		result += ":block:" + _block_threshold + ":inode:" + _inode_threshold;
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me file system size dto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		FileSystemSizeDTO dto = new FileSystemSizeDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setTarget(_file);
		dto.setBlockThreshold(_block_threshold);
		dto.setInodeThreshold(_inode_threshold);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("FileSystemSizeDTO fix me/isReasonable");
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
		
		System.out.println("FIXME FileSystemSizeDTO.compareTo");
		return(0);
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -3887616659003631193L;
}
