package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * File age transfer object.
 * 
 * @hibernate.class 
 *   table = "FILE_AGE_SAMPLE"
 * 
 * @author gsc
 */
public class FileAgeSampleDTO extends AbstractSample implements Cloneable, Comparable<Object> {

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
	 * File modification time
	 */
	private ZuluTime _modification_time = new ZuluTime();

	/**
	 * Modification time
	 * 
	 * @return modification time
	 * 
	 * @hibernate.property 
	 *   column="SAMPLE"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getModificationTime() {
		return(_modification_time);
	}

	/**
	 * Define modification time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg modification time
	 * @throws NullPointerException if null arg
	 */
	public void setModificationTime(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null modification time");
		}
	
		_modification_time = arg;
	}
	
	/**
	 * Triggering file name
	 */
	private TrimString _file_name = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the triggering file (if any)
	 * 
	 * @return triggering file
	 *
     * @hibernate.property
     *   column="FILE_NAME"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getFileName() {
		return(_file_name);
	}

	/**
	 * Define the first triggering file name
	 * 
	 * @param arg first triggering file name
	 * @throws NullPointerException if null arg
	 */
	public void setFileName(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null file name");
		}
		
		_file_name = new TrimString(arg);
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
		String result = "file age time observed:" + _modification_time.toString();
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me file age sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		FileAgeSampleDTO dto = new FileAgeSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setRuleRowId(rule_row_id.getLongKeyValue());
		dto.setTimeStamp(time_stamp);
		dto.setMatch(match_flag);
		dto.setSuppressed(suppress_flag);
		
		dto.setModificationTime(_modification_time);
		dto.setFileName(_file_name);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("FileAgeSampleDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object. Sort by observation time
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final ZuluTime temp = ((BootTimeSampleDTO) arg).getTimeStamp();
		return(time_stamp.compareTo(temp));
	}
	
	/**
	 * Generated serial version ID 
	 */
	private static final long serialVersionUID = 555367700092500039L;
}
