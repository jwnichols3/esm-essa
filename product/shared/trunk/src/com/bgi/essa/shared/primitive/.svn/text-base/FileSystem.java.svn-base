package com.bgi.essa.shared.primitive;

import com.bgi.essa.shared.primitive.TrimString;

/**
 * File system attribute container
 * 
 * @author coleguy
 */
public class FileSystem implements Comparable<Object>, ValueTypeIf {
	
	/**
	 * ctor
	 * 
	 * @param arg0 device i.e. "/dev/rdsk/whatever"
	 * @param arg1 mount point i.e. "/var"
	 * @param arg2 file system type, i.e. "nfs"
	 */
	public FileSystem(TrimString arg0, TrimString arg1, TrimString arg2) {
		if (arg0 == null) {
			throw new NullPointerException("null device");
		}
		
		_device = arg0;
		
		if (arg1 == null) {
			throw new NullPointerException("null mount");
		}
		
		_mount = arg1;
		
		if (arg2 == null) {
			throw new NullPointerException("null file system type");
		}
		
		_type = arg2;
	}
	
	/**
	 * ctor
	 * 
	 * @param arg0 raw string from mnttab/mtab
	 * @param arg1 delimiter, either space or tab
	 */
	public FileSystem(TrimString arg0, String arg1) {
		String[] temp1 = arg0.getValue().split(arg1);
		
		_device = new TrimString(temp1[0]);
		_mount = new TrimString(temp1[1]);
		_type = new TrimString(temp1[2]);
	}

	/**
	 * Return device
	 * 
	 * @return device
	 */
	public TrimString getDevice() {
		return(_device);
	}

	/**
	 * Return mount point
	 * 
	 * @return file system mount point
	 */
	public TrimString getMountPoint() {
		return(_mount);
	}
	
	/**
	 * Return file system type
	 * 
	 * @return file system type
	 */
	public TrimString getFileSystemType() {
		return(_type);
	}
	

	/**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		return(new FileSystem(_device, _mount, _type));
	}

	/**
	 * Return hash code value for this object
	 * 
	 * @return hash code value for this object
	 */
	public int hashCode() {
		return(11 * _device.hashCode() * _mount.hashCode());
	}

	/**
	 * Return true if this object is not null and has equal content
	 * 
	 * @return true if this object is not null and has equal content
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return(false);
		}
		
		FileSystem temp = (FileSystem) arg;
		
		if (temp.getDevice().equals(_device)) {
			//empty
		} else {
			return(false);
		}
		
		if (temp.getMountPoint().equals(_mount)) {
			//empty
		} else {
			return(false);
		}
		
		if (temp.getFileSystemType().equals(_type)) {
			//empty
		} else {
			return(false);
		}
		
		return(true);
	}

	/**
	 * Compare this object w/the specified object, uses mount point for test
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(Object arg) {
		FileSystem temp = (FileSystem) arg;
		return(_mount.compareTo(temp.getMountPoint()));
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		return(_device + ":" + _mount + ":" + _type);
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
	 * Device, i.e. /dev/rdsk/whatever
	 */
	private TrimString _device = new TrimString("bogus");
	
	/**
	 * Mount point, i.e. "/var"
	 */
	private TrimString _mount = new TrimString("bogus");
	
	/**
	 * File system type, i.e. "nfs"
	 */
	private TrimString _type = new TrimString("bogus");
	
	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 8407704860926391213L;
}
