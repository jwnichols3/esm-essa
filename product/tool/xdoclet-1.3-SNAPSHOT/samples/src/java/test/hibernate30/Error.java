package test.hibernate30;

/**
 * @hibernate.class table="error"
 */
public class Error extends OIDObject {
	protected String message;

	protected String description;

	protected String errorMode;

	protected String type;
	
	protected Object any;

	/**
	 * @hibernate.property column="error_message" not-null="true"
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String m) {
		message = m;
	}

	/**
	 * @hibernate.property column="description"
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		description = desc;
	}

	/**
	 * @hibernate.property column="errormode" not-null="true"
	 */
	public String getErrorMode() {
		return errorMode;
	}

	public void setErrorMode(String errorMode) {
		this.errorMode = errorMode;
	}

	/**
	 * @hibernate.property column="error_type" not-null="true"
	 */
	public String getType() {
		return type;
	}

	public void setType(String newType) {
		type = newType;
	}

	/**
	 * @hibernate.any id-type="long" meta-type="string" access="property"
	 *                insert="false" update="false" cascade="none"
	 *                index="myindex" optimistic-lock="false" lazy="true"
	 *                node="any"
	 * @hibernate.meta-value value="PRODUCTS" class="test.hibernate30.Product"
	 * @hibernate.meta-value value="REPTILES" class="test.hibernate30.Reptile"
	 * @hibernate.column name="TABLE_NAME"
	 * @hibernate.column name="ROW_ID"
	 */
	public Object getAny() {
		return any;
	}

	public void setAny(Object any) {
		this.any = any;
	}

}
