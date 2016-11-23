package test.hibernate30;

/**
 * @hibernate.mapping file="MammalMapping"
 */
public class Mammal extends Animal {

    boolean reallyHairy;

    public boolean isReallyHairy() {
        return reallyHairy;
    }

    public void setReallyHairy(boolean reallyHairy) {
        this.reallyHairy = reallyHairy;
    }

}
