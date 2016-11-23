package test.hibernate30;

/**
 * @hibernate.class
 *
 * @hibernate.filter name="filter1" condition="condition att" value="condition value"
 *
 * @hibernate.filter name="filter2" condition="condition att" value="condition value"
 */
public class Customer {
    
    private PhoneNumber dayPhone;
    
    private PhoneNumber nightPhone;
    
    /**
     * @hibernate.component class="test.hibernate30.PhoneNumber" prefix="day_"
     */
    public PhoneNumber getDayPhone() {
        return dayPhone;
    }
    
    public void setDayPhone(PhoneNumber phone) {
        dayPhone = phone;
    }
    
    /**
     * @hibernate.component class="test.hibernate30.PhoneNumber" prefix="night_"
     */
    public PhoneNumber getNightPhone() {
        return nightPhone;
    }
    
    public void setNightPhone(PhoneNumber phone) {
        nightPhone = phone;
    }
    
}
