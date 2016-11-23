package test.hibernate30;
/**
 * @hibernate.class
 *  table="ITEMS"
 *  mutable="false"
 *  schema="SHOP"
 *  proxy="LineItem"
 * 
 * @author Administrator
 *
 */
public class LineItem extends Persistent {
	
	private Order order;
	private Product product;
	private int quantity;

	/**
	 * Constructor for LineItem.
	 */
	public LineItem() {
		super();
	}

	/**
	 * @hibernate.many-to-one access="property"
	 *                        class="test.hibernate30.Order"
	 *                        entity-name="ORDERS"
	 *                        column="ORDER_ID"
	 *                        not-null="true"
	 *                        unique="true"
	 *                        cascade="save-update"
	 *                        outer-join="true"
	 *                        fetch="join"
	 *                        update="true"
	 *                        insert="true"
	 *                        optimistic-lock="true"
	 *                        foreign-key="foreign key"
	 *                        property-ref="property ref"
	 *                        forumla="sql"
	 *                        index="index"
	 *                        lazy="true"
	 *                        node="xml node"
	 *                        embed-xml="true"
	 * @hibernate.column name="column1"
	 * @hibernate.column name="column2"
	 * @hibernate.meta attribute="meta1" value="value1"
	 * @hibernate.meta attribute="meta2" value="value2"
	 * @hibernate.formula "formula sql 1"
	 * @hibernate.formula "formula sql 2"
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 * @param order The order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @hibernate.property
	 *  column="AMOUNT"
	 *  not-null="true"
	 *  unique="false"
	 * Returns the quantity.
	 * @return int
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 * @param quantity The quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @hibernate.many-to-one
	 *  column="PRODUCT_ID"
	 *  outer-join="true"
	 *  not-null="true"
	 * @return Product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 * @param product The product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}
