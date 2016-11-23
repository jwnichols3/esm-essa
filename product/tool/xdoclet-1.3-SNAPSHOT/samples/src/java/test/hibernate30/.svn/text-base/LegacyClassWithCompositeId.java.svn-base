package test.hibernate30;

/**
 * @hibernate.class table="LEGACY"
 * @hibernate.composite-id element-id="comp_id"
 */
public class LegacyClassWithCompositeId {

    private int key1;
    
    private int key2;

    /**
     * @hibernate.key-property parent-element="comp_id"
     */
    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    /**
     * @hibernate.key-many-to-one parent-element="comp_id" class="RelatedClass"
     */
    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }
    
}
