package test.hibernate30;

import java.util.Set;

/**
 * @hibernate.class
 *     table="ANIMALS"
 *     dynamic-update="true"
 * 
 * @hibernate.discriminator column="disc"
 * 	   not-null="true"
 *     force="false"
 * 
 * @hibernate.sql-query
 *     element-id = "query1"
 *     name = "custom-query-1"
 *     flush-mode = "never"
 *     cacheable = "true"
 *     cache-region = "queries"
 *     fetch-size = "10"
 *     timeout = "5"
 *     callable = "true"
 *     value = "select scalar from table"
 *   
 *     @hibernate.return-scalar
 *         parent-element = "query1"
 *         column = "scalar_column"
 *         type = "int"
 *   
 *     @hibernate.synchronize
 *         parent-element = "query1"
 *         table = "table"
 *   
 * @hibernate.sql-query
 *     element-id = "query2"
 *     name = "custom-query-2"
 *     value = "select object from table"
 *   
 *     @hibernate.return
 *         element-id = "query2-return"
 *         parent-element="query2"
 *         alias = "alias"
 *         entity-name = "entity-name"
 *         class = "class"
 *         lock-mode = "none"
 *         
 *         @hibernate.return-discriminator
 *             parent-element="query2-return"
 *             column = "discriminator_column"
 *             
 *         @hibernate.return-property
 *             element-id = "query2-property1"
 *             parent-element = "query2-return"
 *             name = "property1"
 *             column = "column"
 *             
 *         @hibernate.return-property
 *             element-id = "query2-property2"
 *             parent-element = "query2-return"
 *             name = "property2"
 *             
 *             @hibernate.return-column
 *                 parent-element = "query2-property2"
 *                 name = "column1"
 *                 
 *             @hibernate.return-column
 *                 parent-element = "query2-property2"
 *                 name = "column2"
 *                 
 * @hibernate.sql-query
 *     element-id = "query3"
 *     name = "custom-query-3"
 *     value = "select join"
 *     
 *     @hibernate.return-join
 *         parent-element = "query3"
 *         alias = "alias"
 *         property = "property"
 *         lock-mode = "none"
 *         
 *     @hibernate.load-collection
 *         parent-element = "query3"
 *         alias = "alias"
 *         role = "role"
 *         lock-mode = "none"
 *         
 * @hibernate.query-list
 *     name="querylist1"
 *     query-ref="queryref1"
 *              
 * @hibernate.query-list
 *     name="querylist2"
 *     query-ref="queryref2"
 */
public class Animal extends Persistent {
	
	private Set prey;
	private char sex;

	/**
	 * Constructor for Animal.
	 */
	public Animal() {
		super();
	}

	/**
	 * @hibernate.set access="property"
	 *                table="PREDATOR_PREY"
	 *                schema="schema"
	 *                catalog="catalog"
	 *                subselect="subselect sql"
	 *                lazy="true"
	 *                sort="natural"
	 *                inverse="false"
	 *                cascase="all-delete-orphan"
	 *                order-by="PREY_ID"
	 *                where="sql"
	 *                batch-size="10"
	 *                outer-join="auto"
	 *                fetch="subselect"
	 *                persister="persistClass"
	 *                collection-type="collection-type"
	 *                check="check sql"
	 *                optimistic-lock="true"
	 *                node="animal"
	 *                embed-xml="true"
	 *                
	 * @hibernate.collection-key column="PREDATOR_ID"
	 * 
	 * @hibernate.collection-many-to-many column="PREY_ID"
	 */
	public Set getPrey() {
		return prey;
	}

	/**
	 * Sets the prey.
	 * @param prey The prey to set
	 */
	public void setPrey(Set prey) {
		this.prey = prey;
	}

	/**
	 * @hibernate.property
	 *  not-null="true"
	 *  optimistic-lock="false"
	 * Returns the sex.
	 * @return char
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 * @param sex The sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

}
