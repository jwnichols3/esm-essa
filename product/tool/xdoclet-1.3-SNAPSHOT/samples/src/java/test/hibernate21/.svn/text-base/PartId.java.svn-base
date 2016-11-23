/**
 * Created on 13-May-2005
 */
package test.hibernate21;

import java.io.Serializable;

public class PartId implements Serializable {
	
	private Product product;
	
	private Integer componentNumber;

	/**
	 * @hibernate.many-to-one class="test.hibernate21.Product"
	 * @hibernate.column name="part_id" 
	 */
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @hibernate.property 
	 * @hibernate.column name="component_num" 
	 */
	public Integer getComponentNumber() {
		return componentNumber;
	}

	public void setComponentNumber(Integer componentNumber) {
		this.componentNumber = componentNumber;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof PartId)) return false;
		PartId other = (PartId) obj;
		if (!this.product.equals(other.product)) return false;
		return this.componentNumber.equals(other.componentNumber);
	}
	
	
}
