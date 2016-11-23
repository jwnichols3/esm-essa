package com.bgi.essa.shared.transfer;

import java.util.List;

import com.bgi.essa.shared.primitive.FileSystem;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File sample transfer object, employed to capture available file systems
 * 
 * @hibernate.class 
 *   table = "FILE_SYSTEM_SAMPLE"
 *   
 * @author coleguy
 */
public class FileSystemSampleDTO extends AbstractDto implements Cloneable, Comparable<Object> {

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
	 * File system names
	 */
	private List<FileSystem> _candidates = null;
	
	/**
	 * Return file system names
	 * 
	 * @return file system names
	 */
	public List<FileSystem> getCandidates() {
		return(_candidates);
	}
	
	/**
	 * Define file system names
	 * 
	 * @param arg file system names
	 */
	public void setCandidates(final List<FileSystem> arg) {
		_candidates = arg;
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		final String result = "files systems:" + _time_stamp.toString() + ":" + _candidates.size();
		return(result);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me file system sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		final FileSystemSampleDTO dto = new FileSystemSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTimeStamp(_time_stamp);
		dto.setCandidates(_candidates);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("FileSystemSampleDTO fix me/isReasonable");
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
		
		return(id.equals(((FileSystemSampleDTO) arg).getRowId()));
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
	 * Compare this object w/the specified object. Sort by observation time
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final ZuluTime temp = ((FileSystemSampleDTO) arg).getTimeStamp();
		return(_time_stamp.compareTo(temp));
	}
	
	/**
	 * Generate serial version ID 
	 */
	private static final long serialVersionUID = 3711956830575238654L;
}
