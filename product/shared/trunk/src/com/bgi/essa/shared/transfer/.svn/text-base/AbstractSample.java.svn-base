package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.FauxBoolean;
import com.bgi.essa.shared.primitive.LongKey;
import com.bgi.essa.shared.primitive.TrimString;
import com.bgi.essa.shared.primitive.ZuluTime;

/**
 * Parent for "sampling" tables
 * 
 * @author coleguy
 */
public abstract class AbstractSample extends AbstractDto {
	
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
	 * Row ID of rule which tasked this sample
	 */
	LongKey rule_row_id = new LongKey(0L);
	
	/**
	 * Return rule row ID.
	 * 
	 * @return rule row ID
	 * 
	 * @hibernate.property
	 *   column="RULE_ROW_ID"
	 *   type="long"
	 *   not-null="true"
	 */
	public Long getRuleRowId() {
		return(rule_row_id.getLongKeyValue());
	}

	/**
	 * Define rule row id. Has to be Long arg to pacify Hibernate.
	 * 
	 * @param arg rule row id
	 */
	public void setRuleRowId(final Long arg) {
		if (arg == null) {
			System.out.println("AbstractDto.setRowId() null arg");
			rule_row_id = null;
		} else {
			rule_row_id = new LongKey(arg);
		}
	}
	
	/**
	 * Observation time
	 */
	ZuluTime time_stamp = new ZuluTime();

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
		return(time_stamp);
	}

	/**
	 * Define observation time.
	 * Copies value, does not retain pointer.
	 * 
	 * @param arg observation time
	 * @throws NullPointerException if null arg
	 */
	public void setTimeStamp(ZuluTime arg) {
		if (arg == null) {
			throw new NullPointerException("null time stamp");
		}
	
		time_stamp = arg;
	}

	/**
	 * True, this row matched a rule
	 */
	boolean match_flag = false;

	/**
	 * Return match flag
	 * 
	 * @return true, row matched a rule
	 */
	public boolean getMatch() {
		return(match_flag);
	}
	
	/**
	 * Return match flag
	 * 
	 * @return true, row matched a rule
	 */
	public boolean isMatch() {
		return(match_flag);
	}

	/**
	 * Define the match state.
	 * 
	 * @param arg true, this row matched a rule
	 */
	public void setMatch(boolean arg) {
		match_flag = arg;
	}
	
	/**
	 * Return match flag
	 * 
	 * @return match flag 
	 * 
	 * @hibernate.property
	 *   column="MATCHED"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxMatch() {
		return(new FauxBoolean(match_flag));
	}
	
	/**
	 * Define the match flag
	 * 
	 * @param arg fresh match flag
	 */
	public void setFauxMatch(FauxBoolean arg) {
		match_flag = arg.getBooleanValue().booleanValue();
	}
	
	/**
	 * True, alert was suppressed
	 */
	boolean suppress_flag = false;

	/**
	 * Return suppress flag
	 * 
	 * @return true, row suppressed a rule
	 */
	public boolean getSuppressed() {
		return(suppress_flag);
	}
	
	/**
	 * Return suppress flag
	 * 
	 * @return true, row suppressed a rule
	 */
	public boolean isSuppressed() {
		return(suppress_flag);
	}

	/**
	 * Define the suppress state.
	 * 
	 * @param arg true, this row suppressed a rule
	 */
	public void setSuppressed(boolean arg) {
		suppress_flag = arg;
	}
	
	/**
	 * Return suppress flag
	 * 
	 * @return suppress flag 
	 * 
	 * @hibernate.property
	 *   column="SUPPRESS"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.FauxBooleanUserType"
	 *   not-null="true"
	 */
	public FauxBoolean getFauxSuppressed() {
		return(new FauxBoolean(suppress_flag));
	}
	
	/**
	 * Define the suppress flag
	 * 
	 * @param arg fresh suppress flag
	 */
	public void setFauxSuppressed(FauxBoolean arg) {
		suppress_flag = arg.getBooleanValue().booleanValue();
	}
	
	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		String result = ":task:" + task_id + ":rule:" + rule_id + ":rule_row:" + rule_row_id;
		result += ":time_stamp:" + time_stamp + ":match:" + match_flag + ":suppress:" + suppress_flag;
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return("fix me abstract sample dto");
	}
}
