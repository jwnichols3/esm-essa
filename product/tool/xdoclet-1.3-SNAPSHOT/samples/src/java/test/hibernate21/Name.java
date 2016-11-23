package test.hibernate21;


/**
 * @author Administrator
 * @struts.form include-all="true"
 *  extends="org.apache.struts.validator.ValidatorForm"
 */
public class Name {
    private String first;
    private char initial;
    private String last;
    private Address address;

    /**
     * @hibernate.property
     *  column="FIRST_NAME"
     * Returns the first.
     * @return String
     */
    public String getFirst() {
        return first;
    }

    /**
     * @hibernate.property
     * @hibernate.column
     *  name="INITIAL"
     *  sql-type="VARCHAR(1)"
     *  not-null="true"
     * Returns the initial.
     * @return char
     */
    public char getInitial() {
        return initial;
    }

    /**
     * @hibernate.property
     *  column="LIST_NAME"
     * @return String
     */
    public String getLast() {
        return last;
    }

    /**
     * Sets the first.
     * @param first The first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * Sets the initial.
     * @param initial The initial to set
     */
    public void setInitial(char initial) {
        this.initial = initial;
    }

    /**
     * Sets the last.
     * @param last The last to set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * For testing generated nested validation rules.
     * @struts.validator
     * @return
     */
    public Address getAddress() {
        return address;
    }
    
    /**
     * For testing generated nested validation rules.
     * @spring.validator
     * @return
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
