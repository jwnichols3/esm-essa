/**
 * Created on 16-May-2005
 */
package test.hibernate21;

/**
 * @author galbrapa
 *
 */
public class Component1 extends AbstractComponent {
	
	private String component1Prop;

	/**
	 * @hibernate.property
	 * @return Returns the component1Prop.
	 */
	public String getComponent1Prop() {
		return component1Prop;
	}

	/**
	 * @param component1Prop The component1Prop to set.
	 */
	public void setComponent1Prop(String component1Prop) {
		this.component1Prop = component1Prop;
	}

	/**
	 * 
	 */
	public Component1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
