package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.FileAgeOption;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Define a directory age monitor/rule.
 * 
 * @hibernate.class 
 *   table = "DIRECTORY_AGE"
 *   
 * @author linden
 */
public class DirectoryAgeDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	 * Target directory
	 */
	private TrimString _directory = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the target directory
	 * 
	 * @return target directory
	 *
     * @hibernate.property
     *   column="DIRECTORY"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getDirectory() {
		return(_directory);
	}

	/**
	 * Define the target directory
	 * 
	 * @param arg target directory
	 * @throws NullPointerException if null arg
	 */
	public void setDirectory(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null directory");
		}
		
		_directory = new TrimString(arg);
	}

	/**
	 * Target directory name
	 */
	private TrimString _directory_name = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the target directory name
	 * 
	 * @return target directory name
	 *
     * @hibernate.property
     *   column="DIRECTORY_NAME"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getDirectoryName() {

		return(_directory_name);
	}

	/**
	 * Define the target directory name
	 * 
	 * @param arg target directory name
	 * @throws NullPointerException if null arg
	 */
	public void setDirectoryName(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null directory name");
		}
		
		_directory_name = new TrimString(arg);
	}
	
	/**
	 * Sample type
	 */
	private FileAgeOption _option = FileAgeOption.ALL;

	/**
	 * Return the directory age option
	 * 
	 * @return directory age option
	 *
     * @hibernate.property
     *   column="AGE_TYPE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.FileAgeOptionUserType"
     *   not-null="true"
	 */
	public FileAgeOption getFileAgeOption() {
		return(_option);
	}

	/**
	 * Define directory age option
	 * 
	 * @param arg directory age option
	 * @throws NullPointerException if null arg
	 */
	public void setFileAgeOption(FileAgeOption arg) {
		if (arg == null) {
			throw new NullPointerException("null directory age option");
		}
		
		_option = arg;
	}

	/**
	 * age threshold in minutes
	 */
	private int _threshold;

	/**
	 * Return the age threshold in minutes
	 * 
	 * @return age threshold in minutes
	 *
     * @hibernate.property
     *   column="THRESHOLD"
     *   not-null="true"
	 */
	public int getThreshold() {
		return(_threshold);
	}

	/**
	 * Define the size threshold in minutes
	 * 
	 * @param arg sample size threshold in minute
	 */
	public void setThreshold(int arg) {
		_threshold = arg;
	}
	
	/**
	 * Convenience method for struts DirectoryAge pages
	 * 
	 * @return older/newer string
	 */
	public String getOlderNewer() {
		if (_threshold < 0) {
			return("Newer");
		}
		
		return("Older");
	}
	
	/**
	 * Convenience method for struts pages
	 * 
	 * @return threshold as a positive valued string
	 */
	public String getAbsThreshold() {
		return(Integer.toString(Math.abs(_threshold)));
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "directoryage:" + _directory + ":" + _directory_name + ":" + _threshold + ":" + _option + ":" + super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me directoryagedto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		final DirectoryAgeDTO dto = new DirectoryAgeDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);
		
		dto.setDirectory(_directory);
		dto.setDirectoryName(_directory_name);
		dto.setFileAgeOption(_option);
		dto.setThreshold(_threshold);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("DirectoryAgeDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		System.out.println("FIXME DirectoryAgeDTO.compareTO");
		return(0);
		
		/*
		final ApplicationName temp = ((VpoDTO) arg).getAppName();
		return(_app_name.toString().compareTo(temp.toString()));
		*/
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -1976504397676679240L;
}
