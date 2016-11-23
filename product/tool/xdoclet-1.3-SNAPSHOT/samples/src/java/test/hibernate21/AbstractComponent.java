/**
 * Created on 16-May-2005
 */
package test.hibernate21;

/**
 * @author galbrapa
 *
 */
public abstract class AbstractComponent {
	
	private String commonProp;

	/**
	 * @hibernate.property
	 * @return Returns the commonProp.
	 */
	public String getCommonProp() {
		return commonProp;
	}

	/**
	 * @param commonProp The commonProp to set.
	 */
	public void setCommonProp(String commonProp) {
		this.commonProp = commonProp;
	}

	/**
	 * 
	 */
	public AbstractComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

}
