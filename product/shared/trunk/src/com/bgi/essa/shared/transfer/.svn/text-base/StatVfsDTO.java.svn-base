package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File system transfer object, employed to capture file system statistics
 * 
 * @hibernate.class 
 *   table = "FILE_SYSTEM_SAMPLE"
 *   
 * @author coleguy
 */
public class StatVfsDTO extends AbstractDto implements Cloneable, Comparable<Object> {

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
	 * Observation time
	 */
	private ZuluTime _time_stamp = new ZuluTime();

	/**
	 * Observation time
	 * 
	 * @return observation time
	 * 
	 * @hibernate.property 
	 *   column="TIME_STAMP"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getTimeStamp() {
		return(_time_stamp);
	}

	/**
	 * Define observation time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg observation time
	 * @throws NullPointerException if null arg
	 */
	public void setTimeStamp(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null time stamp");
		}
	
		_time_stamp = arg;
	}
	
	/**
	 * File system name, i.e. "/tmp"
	 */
	private TrimString _name = new TrimString("bogus");

	/**
	 * File system name, i.e. "/tmp"
	 * 
	 * @return file system name
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
	 * Define file system name, i.e. "/tmp" 
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg file system name
	 * @throws NullPointerException if null arg
	 */
	public void setName(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
	
		_name = new TrimString(arg);
	}
	
	/**
	 * file system block size
	 */
	private long _f_bsize;

	/**
	 * File system block size
	 * 
	 * @return file system block size
	 * 
	 * @hibernate.property 
	 *   column="BLOCK_SIZE"
	 *   not-null="true"
	 */
	public long getBlockSize() {
		return(_f_bsize);
	}
	
	/**
	 * Define file system block size 
	 * 
	 * @param arg file system block size
	 */
	public void setBlockSize(long arg) {
		_f_bsize = arg;
	}
	
	/**
	 * fragment size
	 */
	private long _f_frsize;

	/**
	 * File system fragment size
	 * 
	 * @return file system fragment size
	 * 
	 * @hibernate.property 
	 *   column="FRAGMENT_SIZE"
	 *   not-null="true"
	 */
	public long getFragmentSize() {
		return(_f_frsize);
	}
	
	/**
	 * Define file system fragment size 
	 * 
	 * @param arg file system fragment size
	 */
	public void setFragmentSize(long arg) {
		_f_frsize = arg;
	}
	
	/**
	 * size of fs in f_frsize units
	 */
	private long _f_blocks;

	/**
	 * File system blocks
	 * 
	 * @return file system blocks population
	 * 
	 * @hibernate.property 
	 *   column="BLOCKS"
	 *   not-null="true"
	 */
	public long getFileSystemBlocks() {
		return(_f_blocks);
	}
	
	/**
	 * Define file system blocks population 
	 * 
	 * @param arg file system blocks population
	 */
	public void setFileSystemBlocks(long arg) {
		_f_blocks = arg;
	}

	/**
	 * free block population
	 */
	private long _f_bfree;
	
	/**
	 * Free blocks
	 * 
	 * @return free blocks population
	 * 
	 * @hibernate.property 
	 *   column="FREE_BLOCKS"
	 *   not-null="true"
	 */
	public long getFreeBlocks() {
		return(_f_bfree);
	}
	
	/**
	 * Define free blocks population 
	 * 
	 * @param arg free blocks population
	 */
	public void setFreeBlocks(long arg) {
		_f_bfree = arg;
	}

	/**
	 * free block population for non-root
	 */
	private long _f_bavail;
	
	/**
	 * Free blocks for non-root
	 * 
	 * @return free blocks population for non-root
	 * 
	 * @hibernate.property 
	 *   column="NON_ROOT_FREE_BLOCKS"
	 *   not-null="true"
	 */
	public long getNonRootFreeBlocks() {
		return(_f_bavail);
	}
	
	/**
	 * Define free blocks population for non-root 
	 * 
	 * @param arg free blocks population for non-root
	 */
	public void setNonRootFreeBlocks(long arg) {
		_f_bavail = arg;
	}

	/**
	 * inode population
	 */
	private long _f_files;

	/**
	 * Inode population
	 * 
	 * @return inode population
	 * 
	 * @hibernate.property 
	 *   column="INODES"
	 *   not-null="true"
	 */
	public long getInodes() {
		return(_f_files);
	}

	/**
	 * Define inode population
	 * 
	 * @param arg inode population
	 */
	public void setInodes(long arg) {
		_f_files = arg;
	}
	
	/**
	 * free inode population
	 */
	private long _f_ffree;

	/**
	 * Free inode population
	 * 
	 * @return free inode population
	 * 
	 * @hibernate.property 
	 *   column="FREE_INODES"
	 *   not-null="true"
	 */
	public long getFreeInodes() {
		return(_f_ffree);
	}

	/**
	 * Define free inode population
	 * 
	 * @param arg free inode population
	 */
	public void setFreeInodes(long arg) {
		_f_ffree = arg;
	}
	
	/**
	 * free inode population for non-root
	 */
	private long _f_avail;

	/**
	 * Free non-root inode population
	 * 
	 * @return free non-root inode population
	 * 
	 * @hibernate.property 
	 *   column="NON_ROOT_FREE_INODES"
	 *   not-null="true"
	 */
	public long getNonRootFreeInodes() {
		return(_f_avail);
	}

	/**
	 * Define free non-root inode population
	 * 
	 * @param arg free non-root inode population
	 */
	public void setNonRootFreeInodes(long arg) {
		_f_avail = arg;
	}
	
	/**
	 * file system identifier
	 */
	private long _f_fsid;
	
	/**
	 * File system identifier
	 * 
	 * @return file system identifier
	 * 
	 * @hibernate.property 
	 *   column="IDENTIFIER"
	 *   not-null="true"
	 */
	public long getFileSystemIdentifier() {
		return(_f_fsid);
	}

	/**
	 * Define file system identifier
	 * 
	 * @param arg file system identifier
	 */
	public void setFileSystemIdentifier(long arg) {
		_f_fsid = arg;
	}

	/**
	 * mount flags
	 */
	private long _f_flag;

	/**
	 * Return mount flags
	 * 
	 * @return mount flags
	 * 
	 * @hibernate.property 
	 *   column="MOUNT_FLAGS"
	 *   not-null="true"
	 */
	public long getMountFlags() {
		return(_f_flag);
	}

	/**
	 * Define mount flags
	 * 
	 * @param arg mount flags
	 */
	public void setMountFlags(long arg) {
		_f_flag = arg;
	}
	
	/**
	 * Parse a space delimited string from JNI
	 * 
	 * @param arg space delimited string containing file system statistics
	 */
	public void parse(String arg) {
		String[] argz = arg.split(" ");
		for(int ii = 0; ii < argz.length; ii++) {
			switch(ii) {
			case 0:
				_f_bsize = Long.parseLong(argz[ii]);
				break;
			case 1:
				_f_frsize = Long.parseLong(argz[ii]);
				break;
			case 2:
				_f_blocks = Long.parseLong(argz[ii]);
				break;
			case 3:
				_f_bfree = Long.parseLong(argz[ii]);
				break;
			case 4:
				_f_bavail = Long.parseLong(argz[ii]);
				break;
			case 5:
				_f_files = Long.parseLong(argz[ii]);
				break;
			case 6:
				_f_ffree = Long.parseLong(argz[ii]);
				break;
			case 7:
				_f_avail = Long.parseLong(argz[ii]);
				break;
			}
		}
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = id + ":fs:" + _name;
		result += ":time:" + _time_stamp.toString();
		result += ":block size:" + _f_bsize;
		result += ":frag size:" + _f_frsize;
		result += ":blocks:" + _f_blocks;
		result += ":free:" + _f_bfree;
		result += ":nr free:" + _f_bavail;
		result += ":inodes:" + _f_files;
		result += ":free:" + _f_ffree;
		result += ":nr free:" + _f_avail;
		result += ":id:" + _f_fsid;
		result += ":flags:" + _f_flag;
		
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me statvfsdto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		final StatVfsDTO dto = new StatVfsDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTimeStamp(_time_stamp);
		dto.setName(_name);
		dto.setBlockSize(_f_bsize);
		dto.setFragmentSize(_f_frsize);
		dto.setFileSystemBlocks(_f_blocks);
		dto.setFreeBlocks(_f_bfree);
		dto.setNonRootFreeBlocks(_f_bavail);
		dto.setInodes(_f_files);
		dto.setFreeInodes(_f_ffree);
		dto.setNonRootFreeInodes(_f_avail);
		dto.setFileSystemIdentifier(_f_fsid);
		dto.setMountFlags(_f_flag);
		
		return(dto);
	}
	
	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("FileSystemDTO fix me/isReasonable");
		return(true);
	}
	
	/**
	 * Return true if row id match
	 * 
	 * @param arg test candidate
	 * @return true if values match
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}
		
		return(id.equals(((StatVfsDTO) arg).getRowId()));
	}

	/**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
		return(id.hashCode());
	}
	
	/**
	 * Compare this object w/the specified object. Sort by file name
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final TrimString temp = ((StatVfsDTO) arg).getName();
		return(_name.getValue().compareToIgnoreCase(temp.getValue()));
	}
	
	/**
	 * Eclipse generated serial ID
	 */
	private static final long serialVersionUID = -7307230696095738827L;
}
