package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.LongKey;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Common support for DTO classes.
 * <p>
 * You do not assign "id" - this will be generated for you when you insert/update/select.
 * <p>
 * If "id" is null, then this is a fresh new row and it will be inserted and 
 * given a new row "id".
 * <p> 
 * If "id" is NOT null, then this is an existing row which needs to be updated.
 * 
 * @author gsc
 */
public abstract class AbstractDto implements DtoIf {

	/**
	 * Database key
	 */
	LongKey id = new LongKey(0L);
	
	/**
	 * Return row ID.
	 * 
	 * @return row ID
	 */
	public abstract Long getRowId();

	/**
	 * Define database row id. Has to be Long arg to pacify Hibernate.
	 * 
	 * @param arg database row id
	 */
	public void setRowId(final Long arg) {
		if (arg == null) {
			System.out.println("AbstractDto.setRowId() null arg");
			id = null;
		} else {
			id = new LongKey(arg);
		}
	}

	/**
	 * True, this row entry is active.
	 * Specific meaning depends upon associated table.
	 */
	boolean active_flag = false;

	/**
	 * Return active flag
	 * 
	 * @return true, row is active
	 */
	public boolean getActive() {
		return(active_flag);
	}
	
	/**
	 * Return active flag
	 * 
	 * @return true, row is active
	 */
	public boolean isActive() {
		return(active_flag);
	}

	/**
	 * Define the active state.
	 * 
	 * @param arg true, this row entry is active
	 */
	public void setActive(final boolean arg) {
		active_flag = arg;
	}
	
	/**
	 * Return active flag
	 * 
	 * @return active flag 
	 * 
	 * @hibernate.property
	 *   column="ACTIVE"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxActive() {
		return(new FauxBoolean(active_flag));
	}
	
	/**
	 * Define the active state
	 * 
	 * @param arg fresh active state
	 */
	public void setFauxActive(FauxBoolean arg) {
		active_flag = arg.getBooleanValue().booleanValue();
	}

	/**
	 * Default note value "No Note"
	 */
	public static final String DEFAULT_NOTE = "No Note";

	/**
	 * free form note regarding this row
	 */
	TrimString note = new TrimString(DEFAULT_NOTE);

	/**
	 * Return the free form note.
	 * 
	 * @return free form note regarding this row
	 *
     * @hibernate.property
     *   column="NOTE"
     *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
     *   not-null="true"
	 */
	public TrimString getNote() {
		return(note);
	}

	/**
	 * Define the free form note.
	 * 
	 * @param arg free form note.
	 * @throws NullPointerException if null arg
	 */
	public void setNote(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null note");
		}
		
		note = new TrimString(arg);
	}

	/**
	 * Return object state as a String
	 * 
	 * @see java.lang.Object
	 * @return object state as a String
	 */
	public String toString() {
		return(":id:" + id + ":active:" + active_flag + ":note:" + note);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<active>" + active_flag + "</active>");
		sb.append("<note>" + note.toXml() + "</note>");
		return(sb.toString());
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

		return(id.equals(((AbstractDto) arg).getRowId()));
	}

	/**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
		return(id.hashCode());
	}
}
