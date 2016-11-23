package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * System uptime transfer object.
 * 
 * @hibernate.class 
 *   table = "BOOT_TIME_SAMPLE"
 * 
 * @author gsc
 */
public class BootTimeSampleDTO extends AbstractSample implements Cloneable, Comparable<Object> {

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
	 * Boot time
	 */
	private ZuluTime _boot_time = new ZuluTime();

	/**
	 * Boot time
	 * 
	 * @return boot time
	 * 
	 * @hibernate.property 
	 *   column="BOOT_TIME"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getBootTime() {
		return(_boot_time);
	}

	/**
	 * Define observation time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg observation time
	 * @throws NullPointerException if null arg
	 */
	public void setBootTime(final ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null boot time");
		}
	
		_boot_time = arg;
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = "boot time observed:" + _boot_time.toString();
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me uptime sample dto");
	}
	
	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
		BootTimeSampleDTO dto = new BootTimeSampleDTO();
		
		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);
		
		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setRuleRowId(rule_row_id.getLongKeyValue());
		dto.setTimeStamp(time_stamp);
		dto.setMatch(match_flag);
		dto.setSuppressed(suppress_flag);
		
		dto.setBootTime(_boot_time);
		
		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonable
	 */
	public boolean isReasonable() {
		System.out.println("BootTimeSampleDTO fix me/isReasonable");
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
	private static final long serialVersionUID = -6617424080996695308L;
}
