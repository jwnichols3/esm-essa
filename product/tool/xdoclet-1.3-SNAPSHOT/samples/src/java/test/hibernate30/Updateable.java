package test.hibernate30;

public interface Updateable {
	
	/**
	 * @hibernate.property
	 *  column="LAST_UPDATED_BY"
	 */
	public String getUpdateComment();
}