package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File sample transfer object, employed to capture file statistics.
 * 
 * @hibernate.class 
 *   table = "FILE_SAMPLE"
 * 
 * @author gsc
 */
public class FileSampleDTO extends AbstractDto implements Cloneable, Comparable<Object> {
	
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
	 * File name, i.e. "/etc/passwd"
	 */
	private TrimString _name = new TrimString("bogus");

	/**
	 * File name, i.e. "/etc/passwd"
	 * 
	 * @return file name
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
	 * Define file name, i.e. "/etc/passwd" 
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg file name
	 * @throws NullPointerException if null arg
	 */
	public void setName(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null name");
		}
	
		_name = new TrimString(arg);
	}
	
	/**
	 * true, file exists
	 */
	private FauxBoolean _is_exists = new FauxBoolean(false);
		
	/**
	 * Return true, file exists
	 * 
	 * @return true, file exists
	 * 
	 * @hibernate.property
	 *   column="IS_EXIST"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getIsExists() {
		return(_is_exists);
	}
	
	/**
	 * Define if this is a file
	 * 
	 * @param arg true, this is a file
	 * @throws NullPointerException if null arg
	 */
	public void setIsExists(final FauxBoolean arg) {
		if (arg == null) {
			throw new NullPointerException("null is exists");
		}
	
		_is_exists = new FauxBoolean(arg);
	}
	
	/**
	 * true, this is a file
	 */
	private FauxBoolean _is_file = new FauxBoolean(false);
		
	/**
	 * Return true, this is a file
	 * 
	 * @return true, this is a file
	 * 
	 * @hibernate.property
	 *   column="IS_FILE"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getIsFile() {
		return(_is_file);
	}
	
	/**
	 * Define if this is a file
	 * 
	 * @param arg true, this is a file
	 * @throws NullPointerException if null arg
	 */
	public void setIsFile(final FauxBoolean arg) {
		if (arg == null) {
			throw new NullPointerException("null is file");
		}
	
		_is_file = new FauxBoolean(arg);
	}

	/**
	 * true, this is a directory
	 */
	private FauxBoolean _is_directory = new FauxBoolean(false);
		
	/**
	 * Return true, this is a directory
	 * 
	 * @return true, this is a directory
	 * 
	 * @hibernate.property
	 *   column="IS_DIRECTORY"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getIsDirectory() {
		return(_is_directory);
	}
	
	/**
	 * Define if this is a directory
	 * 
	 * @param arg true, this is a file
	 * @throws NullPointerException if null arg
	 */
	public void setIsDirectory(final FauxBoolean arg) {
		if (arg == null) {
			throw new NullPointerException("null is directory");
		}
	
		_is_directory = new FauxBoolean(arg);
	}

	/**
	 * Contains the quantity of files within directory
	 */
	private int _population = 0;

	/**
	 * Return quantity of files within directory
	 * 
	 * @return quantity of files within directory
	 * 
	 * @hibernate.property
	 *   column="CHILD_POPULATION"
	 *   not-null="true"
	 */
	public int getChildPopulation() {
		return(_population);
	}

	/**
	 * Define quantity of files within directory
	 * 
	 * @param arg quantity of files within directory
	 */
	public void setChildPopulation(final int arg) {
		_population = arg;
	}
	
	/**
	 * File modified time
	 */
	private ZuluTime _modified = new ZuluTime();

	/**
	 * File modified time
	 * 
	 * @return file modified time
	 * 
	 * @hibernate.property 
	 *   column="MODIFIED"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getFileModified() {
		return(_modified);
	}

	/**
	 * Define file modified
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg file modified time
	 * @throws NullPointerException if null arg
	 */
	public void setFileModified(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null modified time");
		}
	
		_modified = arg;
	}

	/**
	 * File length
	 */
	private long _length = 0;

	/**
	 * Return file length in bytes
	 * 
	 * @return file length in bytes
	 * 
	 * @hibernate.property
	 *   column="LENGTH"
	 *   not-null="true"
	 */
	public long getLength() {
		return(_length);
	}

	/**
	 * Return file length in bytes
	 * 
	 * @param arg file length in bytes
	 */
	public void setLength(final long arg) {
		_length = arg;
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = id + ":file:" + _name;
		result += ":time:" + _time_stamp.toString();
		result += ":exists:" + _is_exists.toString();
		result += ":file:" + _is_file.toString();
		result += ":directory:" + _is_directory.toString();
		result += ":population:" + _population;
		result += ":modified:" + _modified.toString();
		result += ":length:" + _length;

		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me filesampledto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		final FileSampleDTO dto = new FileSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTimeStamp(_time_stamp);
		dto.setName(_name);
		dto.setIsExists(_is_exists);
		dto.setIsFile(_is_file);
		dto.setIsDirectory(_is_directory);
		dto.setChildPopulation(_population);
		dto.setFileModified(_modified);
		dto.setLength(_length);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("FileSampleDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Return true if row id match
	 * 
	 * @param arg test candidate
	 * @return true if values match
	 * @throws ClassCastException if arg cannot be cast
	 */
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}
		
		return(id.equals(((FileSampleDTO) arg).getRowId()));
	}

	/**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
	@Override
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
		final TrimString temp = ((FileSampleDTO) arg).getName();
		return(_name.getValue().compareToIgnoreCase(temp.getValue()));
	}

	/**
	 * Generated version ID
	 */
	private static final long serialVersionUID = 2136483679869146796L;
}