/**
 * Created on 16-May-2005
 */
package test.hibernate21;

/**
 * @author galbrapa
 *
 */
public class Component2 extends AbstractComponent {
	
	private String component2Prop;

	/**
	 * @hibernate.property
	 * @return Returns the component2Prop.
	 */
	public String getComponent2Prop() {
		return component2Prop;
	}

	/**
	 * @param component2Prop The component2Prop to set.
	 */
	public void setComponent2Prop(String component2Prop) {
		this.component2Prop = component2Prop;
	}

	/**
	 * 
	 */
	public Component2() {
		super();
		// TODO Auto-generated constructor stub
	}

}
