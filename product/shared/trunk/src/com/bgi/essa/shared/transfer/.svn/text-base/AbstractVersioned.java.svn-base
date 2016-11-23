package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * Parent for "versioned" tables.
 * <p>
 * You do not assign any of these values (task id, rule id, version).
 * They will be assigned for you when you insert/update/select.
 * <p>
 * task_id marks rows by task, a task can have zero to many rules.  
 * <p>
 * rule_id marks rows by rule, a rule can have zero to many attributes (like VPO).
 * <p>
 * version indicates the order rules were updated (audit trail). 
 * <p>
 * the most current version of a row will be "active true"
 * 
 * @author coleguy
 */
public abstract class AbstractVersioned extends AbstractDto {

	/**
	 * task identifier
	 */
	TrimString task_id;

	/**
	 * Return task identifier
	 * 
	 * @return task identifier
	 * 
	 * @hibernate.property
	 *   column="TASK_ID"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getTaskId() {
		return(task_id);
	}

	/**
	 * Define task identifier
	 * 
	 * @param arg task identifier
	 */
	public void setTaskId(TrimString arg) {
		task_id = arg;
	}	
	
	/**
	 * rule identifier
	 */
	TrimString rule_id;

	/**
	 * Return rule identifier
	 * 
	 * @return rule identifier
	 * 
	 * @hibernate.property
	 *   column="RULE_ID"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getRuleId() {
		return(rule_id);
	}

	/**
	 * Define rule identifier
	 * 
	 * @param arg rule identifier
	 */
	public void setRuleId(TrimString arg) {
		rule_id = arg;
	}	
	
	/**
	 * version
	 */
	long version;

	/**
	 * Return version.
	 * 
	 * @return version
	 * 
	 * @hibernate.property
	 *   column="VERSION"
	 *   not-null="true"
	 */
	public long getVersion() {
		return(version);
	}

	/**
	 * Define database row id. Has to be Long arg to pacify Hibernate.
	 * 
	 * @param arg database row id
	 */
	public void setVersion(long arg) {
		version = arg;
	}	
		
	/**
	 * Creation time
	 */
	private ZuluTime _creation = new ZuluTime();

	/**
	 * Creation time
	 * 
	 * @return creation time
	 * 
	 * @hibernate.property 
	 *   column="CREATED"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getCreation() {
		return(_creation);
	}

	/**
	 * Define creation time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg creation time
	 * @throws NullPointerException if null arg
	 */
	public void setCreation(ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null creation time");
		}
	
		_creation = arg;
	}
	
	/**
	 * Modification time
	 */
	private ZuluTime _modified = new ZuluTime();

	/**
	 * Modification time
	 * 
	 * @return modification time
	 * 
	 * @hibernate.property 
	 *   column="MODIFIED"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ZuluTimeUserType"
	 *   not-null="true"
	 */
	public ZuluTime getModified() {
		return(_modified);
	}

	/**
	 * Define modification time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg modification time
	 * @throws NullPointerException if null arg
	 */
	public void setModified(ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null modification time");
		}
	
		_modified = arg;
	}
	
	/**
	 * Return class state as a String
	 * 
	 * @see java.lang.Object
	 * @return class state as a String
	 */
	public String toString() {
		return(":task:" + task_id + ":rule:" + rule_id + ":version:" + version + super.toString());
	}
}
