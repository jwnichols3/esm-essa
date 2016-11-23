package test.hibernate;

/**
 * demonstrate composite ID referenced by interface
 *
 * @author                    ko5tik ( Konstantin Pribluda )
 * @hibernate.class
 */
public class CompositeIdEntity
{

 	private ICompositeId _id;
	private String _foo;
	/**
     * @hibernate.id generator-class="assigned" type="test.hibernate.CompositeId"
	 */
	public ICompositeId getId() {
		return _id;
	}

	public void setId(ICompositeId id) {
		_id = id;
	}

	public String getFoo() {
		return _foo;
	}
    /**
     * foo value
     *
     * @return               String
     * @hibernate.property
     */

	public void setFoo(String foo) {
		_foo = foo;
	}

}

