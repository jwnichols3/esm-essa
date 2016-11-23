package test.hibernate30;

/**
 * @hibernate.class table="PEOPLE"
 */
public class Person {

	private Long addressId;
	private String name;
	private String street;
	private String city;
	private Human human;
	
	/**
	 * @hibernate.id generator-class="assigned" type="string"
	 */
	public Long getAddressId() {
		return this.addressId;
	}
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * @hibernate.property
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @hibernate.join table="ADDRESS"
	 *                 schema="THINGS"
	 *                 catalog="CAT"
	 *                 subselect="sql subselect"
	 *                 fetch="select"
	 *                 inverse="false"
	 *                 optional="true"
	 * @hibernate.key column="ADDRESS_ID"
	 *                property-ref="property ref"
	 *                foreign-key="foreign key"
	 *                on-delete="noaction"
	 *                not-null="true"
	 *                update="true"
	 *                unique="true"
	 * @hibernate.property column="STREET"
	 */
	public String getStreet() {
		return this.street;
	}
	
	public void setString(String street) {
		this.street = street;
	}
	
	/**
	 * @hibernate.join table="ADDRESS"
	 * @hibernate.key element-id="key2"
	 * @hibernate.column name="ADDRESS_ID" parent-element="key2"
	 * @hibernate.column name="DO_NOT_GENERATE" parent-element="not-specified"
	 * @hibernate.column name="GENERIC_COLUMN" 
	 * @hibernate.property column="CITY"
	 */
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @hibernate.one-to-one formula="formula sql"
	 *                       access="property"
	 *                       class="test.hibernate30.Human"
	 *                       entity-name="HUMANS"
	 *                       cascade="delete"
	 *                       outer-join="true"
	 *                       fetch="join"
	 *                       constrained="false"
	 *                       foreign-key="ID"
	 *                       property-ref="prop ref"
	 *                       lazy="true"
	 *                       node="person"
	 *                       embed-xml="true"
	 * @hibernate.meta attribute="attribute" value="value"
	 */
	public Human getHuman() {
		return this.human;
	}
	
	public void setHuman(Human human) {
		this.human = human;
	}

}
