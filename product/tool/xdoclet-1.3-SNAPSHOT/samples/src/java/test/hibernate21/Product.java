package test.hibernate21;import java.math.BigDecimal;import java.util.Map;/** * @hibernate.class *  table="PRODUCTS" *  discriminator-value="null" *  dynamic-update="true" *   * @hibernate.discriminator *  column="PRODUCT_TYPE" *  type="string" *  length="16" *  not-null="false" *   * @hibernate.jcs-cache *  usage="read-only" *  * @author Administrator */public class Product extends Persistent implements Updateable {		private String description;	private String code;	private BigDecimal price;	private byte[] image;	private String updateComment;	private Map parts;	/**	 * Constructor for Product.	 */	public Product() {		super();	}	/**	 * @hibernate.property	 *  length="512"	 * @return String	 */	public String getDescription() {		return description;	}	/**	 * Sets the name.	 * @param name The name to set	 */	public void setDescription(String name) {		this.description = name;	}	/**	 * @hibernate.property	 *  length="16"	 *  unique="true"	 *  update="false"	 * @return String	 */	public String getCode() {		return code;	}	/**	 * Sets the code.	 * @param code The code to set	 */	public void setCode(String code) {		this.code = code;	}	/**	 * @hibernate.property	 *  length="4096"	 * Returns the image.	 * @return byte[]	 */	public byte[] getImage() {		return image;	}	/**	 * @hibernate.property	 * Returns the price.	 * @return BigDecimal	 */	public BigDecimal getPrice() {		return price;	}	/**	 * Sets the image.	 * @param image The image to set	 */	public void setImage(byte[] image) {		this.image = image;	}	/**	 * Sets the price.	 * @param price The price to set	 */	public void setPrice(BigDecimal price) {		this.price = price;	}	public String getUpdateComment() {		return updateComment;	}	public void setUpdateComment(String string) {		updateComment = string;	}		/**	 * @hibernate.map	 * @hibernate.collection-key column="product_id"	 * @hibernate.collection-composite-index class="test.hibernate21.PartId"	 * @hibernate.collection-one-to-many class="test.hibernate21.Part"	 */	public Map getParts() {		return this.parts;	}		public void setParts(Map parts) {		this.parts = parts;	}	}