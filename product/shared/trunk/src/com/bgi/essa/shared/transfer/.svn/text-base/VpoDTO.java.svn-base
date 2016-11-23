package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ApplicationName;
import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.Severity;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * VPO message arguments.  Each task has a default VPO message arguments.
 * Rules have optional VPO arguments which can override the defaults.
 * 
 * @hibernate.class 
 *   table = "VPO"
 * 
 * @author coleguy
 */
public class VpoDTO extends AbstractVersioned implements Cloneable, Comparable<Object> {

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
	@Override
	public Long getRowId() {
		return(id.getLongKeyValue());
	}

	/**
	 * Application name, maps to message group
	 */
	private ApplicationName _app_name = ApplicationName.ALARMPOINT;

	/**
	 * Return the application name (message group)
	 * 
	 * @return application name
	 * 
	 * @hibernate.property 
	 *   column="APP_NAME"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.ApplicationNameUserType"
	 *   not-null="true"
	 */
	public ApplicationName getAppName() {
		return(_app_name);
	}

	/**
	 * Define the task name
	 * 
	 * @param arg task name
	 * @throws NullPointerException if null arg
	 */
	public void setAppName(ApplicationName arg) {
		if (arg == null) {
			throw new NullPointerException("null app name");
		}

		_app_name = arg;
	}
	
	/**
	 * Message severity
	 */
	private Severity _severity = Severity.NORMAL;

	/**
	 * Return the message severity
	 * 
	 * @return message severity
	 * 
	 * @hibernate.property 
	 *   column="SEVERITY"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.SeverityUserType"
	 *   not-null="true"
	 */
	public Severity getSeverity() {
		return(_severity);
	}

	/**
	 * Define the message severity
	 * 
	 * @param arg message severity
	 * @throws NullPointerException if null arg
	 */
	public void setSeverity(Severity arg) {
		if (arg == null) {
			throw new NullPointerException("null severity");
		}

		_severity = arg;
	}
	
	/**
	 * Message retry rate in minutes
	 */
	private int _frequency = ConstantsIf.MAX_RETRY_FREQUENCY;

	/**
	 * Return the message retry rate in minutes
	 * 
	 * @return message retry rate in minutes
	 * 
	 * @hibernate.property 
	 *   column="FREQUENCY" 
	 *   not-null="true"
	 */
	public int getFrequency() {
		return(_frequency);
	}

	/**
	 * Define the sample rate in seconds
	 * 
	 * @param arg sample rate in seconds
	 * @throws IllegalArgumentException if stupid value
	 */
	public void setFrequency(int arg) {
		if ((arg < ConstantsIf.MIN_RETRY_FREQUENCY) || (arg > ConstantsIf.MAX_RETRY_FREQUENCY)) {
			throw new IllegalArgumentException("bad retry frequency");
		}

		_frequency = arg;
	}
	
	/**
	 * Optional message
	 */
	private TrimString _message = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Optional message boilerplate
	 * 
	 * @return message
	 * 
	 * @hibernate.property 
	 *   column="MESSAGE"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getMessage() {
		return(_message);
	}

	/**
	 * Define the message
	 * 
	 * @param arg message
	 * @throws NullPointerException if null arg
	 */
	public void setMessage(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null message");
		}

		_message = new TrimString(arg);
	}
	
	/**
	 * Optional "source host" - some configuration files reside on 
	 * shared file systems and the appropriate host name is not 
	 * obvious.  This value sorts out which host should respond
	 */
	private TrimString _source = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Optional source host
	 * 
	 * @return source host
	 * 
	 * @hibernate.property 
	 *   column="SOURCE_HOST"
	 *   type="com.bgi.essa.jboss4.orm.hibernate3.TrimStringUserType"
	 *   not-null="true"
	 */
	public TrimString getSourceHost() {
		return(_source);
	}

	/**
	 * Define optional source host
	 * 
	 * @param arg source host
	 * @throws NullPointerException if null arg
	 */
	public void setSourceHost(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null source host");
		}

		_source = new TrimString(arg);
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		String result = "vpo:" + _app_name + ":" + _severity + ":" + _frequency + ":" + _message;
		result += super.toString();
		return(result);
	}

	/**
	 * Return object state as a XML formatted string
	 * 
	 * @return object state as a XML formatted string
	 */
	@Override
	public String toXml() {
		return("fix me vpodto");
	}

	/**
	 * Create a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		final VpoDTO dto = new VpoDTO();

		dto.setRowId(id.getLongKeyValue());
		dto.setActive(active_flag);
		dto.setNote(note);

		dto.setTaskId(task_id);
		dto.setRuleId(rule_id);
		dto.setVersion(version);

		dto.setAppName(_app_name);
		dto.setSeverity(_severity);
		dto.setFrequency(_frequency);
		dto.setMessage(_message);

		return(dto);
	}

	/**
	 * Return true if class contents are superficially valid
	 * 
	 * @return true if class contents are reasonble
	 */
	public boolean isReasonable() {
		System.out.println("VpoDTO fix me/isReasonable");
		return(true);
	}

	/**
	 * Compare this object w/the specified object. Sort by app_name
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final ApplicationName temp = ((VpoDTO) arg).getAppName();
		return(_app_name.toString().compareTo(temp.toString()));
	}

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -702358744632752922L;
}
