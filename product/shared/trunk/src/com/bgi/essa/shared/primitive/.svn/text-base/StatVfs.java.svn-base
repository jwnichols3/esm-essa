package com.bgi.essa.shared.primitive;

import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * Container for StatVfs results
 * 
 * @author gsc
 */
public final class StatVfs implements Comparable<Object>, ValueTypeIf {

	private TrimString _name;
	
	public TrimString getName() {
		return(_name);
	}
	
	public void setName(TrimString arg) {
		_name = arg;
	}
	
	private ZuluTime _time = new ZuluTime();
	
	public ZuluTime getTimeHack() {
		return(_time);
	}
	
	public void setTimeHack(ZuluTime arg) {
		_time = arg;
	}

	// file system block size
	private long _f_bsize;

	public long getBlockSize() {
		return(_f_bsize);
	}

	public void setBlockSize(long arg) {
		_f_bsize = arg;
	}

	// fragment size
	private long _f_frsize;

	public long getFragmentSize() {
		return(_f_frsize);
	}

	public void setFragmentSize(long arg) {
		_f_frsize = arg;
	}

	// size of fs in f_frsize units
	private long _f_blocks;

	public long getFileSystemBlocks() {
		return(_f_blocks);
	}

	public void setFileSystemBlocks(long arg) {
		_f_blocks = arg;
	}

	// free block population
	private long _f_bfree;

	public long getFreeBlocks() {
		return(_f_bfree);
	}

	public void setFreeBlocks(long arg) {
		_f_bfree = arg;
	}

	// free block population for non-root
	private long _f_bavail;

	public long getNonRootFreeBlocks() {
		return(_f_bavail);
	}

	public void setNonRootFreeBlocks(long arg) {
		_f_bavail = arg;
	}

	// inode population
	private long _f_files;

	public long getInodes() {
		return(_f_files);
	}

	public void setInodes(long arg) {
		_f_files = arg;
	}

	// free inode population
	private long _f_ffree;

	public long getFreeInodes() {
		return(_f_ffree);
	}

	public void setFreeInodes(long arg) {
		_f_ffree = arg;
	}

	// free inode population for non-root
	private long _f_avail;

	public long getNonRootFreeInodes() {
		return(_f_avail);
	}

	public void setNonRootFreeInodes(long arg) {
		_f_avail = arg;
	}

	// file system identifier
	private long _f_fsid;

	public long getFileSystemIdentifier() {
		return(_f_fsid);
	}

	public void setFileSystemIdentifier(long arg) {
		_f_fsid = arg;
	}

	// mount flags
	private long _f_flag;

	public long getMountFlags() {
		return(_f_flag);
	}

	public void setMountFlags(long arg) {
		_f_flag = arg;
	}

	// maximum filename length
	private long _f_namemax;

	public long getMaxFileNameLength() {
		return(_f_namemax);
	}

	public void setMaxFileNameLength(long arg) {
		_f_namemax = arg;
	}

	public void setValues(String arg) {
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
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		StatVfs result = new StatVfs();
		result.setName(_name);
		result.setTimeHack(_time);
		result.setBlockSize(_f_bsize);
		result.setFragmentSize(_f_frsize);
		result.setFileSystemBlocks(_f_blocks);
		result.setFreeBlocks(_f_bfree);
		result.setNonRootFreeBlocks(_f_bavail);
		result.setInodes(_f_files);
		result.setFreeInodes(_f_ffree);
		result.setNonRootFreeInodes(_f_avail);
		result.setFileSystemIdentifier(_f_fsid);
		result.setMountFlags(_f_flag);
		result.setMaxFileNameLength(_f_namemax);
		return(result);
	}

	/**
	 * Return hash code value for this object
	 * 
	 * @return hash code value for this object
	 */
	public int hashCode() {
		return(11 * _name.hashCode() * _time.hashCode());
	}

	/**
	 * Return true if this object is not null and has equal content
	 * 
	 * @return true if this object is not null and has equal content
	 * @throws ClassCastException if arg cannot be casy
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return(false);
		}
		
		StatVfs temp = (StatVfs) arg;
		TrimString temp_name = temp.getName();
		ZuluTime temp_time = temp.getTimeHack();
		
		if (temp_name.equals(_name)) {
			if (temp_time.equals(_time)) {
				return(true);
			}
		}
		
		return(false);
	}

	/**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(Object arg) {
		StatVfs temp = (StatVfs) arg;
		return(_time.compareTo(temp.getTimeHack()));
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		return(_name + ":" + _f_bsize + ":" + _f_frsize + ":" + _f_blocks + ":" + _f_bfree + ":" + _f_bavail + ":" + _f_files + ":" + _f_ffree + ":" + _f_avail);
	}
	
	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return(toString());
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param tag xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if tag is null
	 */
	public String toXml(String tag) {
		if (tag == null) {
			throw new NullPointerException("null XML tag");
		}
		
		return("<" + tag + ">" + toXml() + "</" + tag + ">");
	}
	
	/**
	 * Generated serial ID 
	 */
	private static final long serialVersionUID = -4137521632293150071L;
}