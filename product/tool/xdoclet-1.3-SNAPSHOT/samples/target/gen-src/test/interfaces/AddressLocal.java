/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Local interface for Address.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface AddressLocal
   extends javax.ejb.EJBLocalObject
{

   public test.interfaces.AddressValue getAddressValue(  ) ;

   public void setAddressValue( test.interfaces.AddressValue v ) ;

   /**
    * Check to see if read-only is set for jboss
    * @return     */
   public int getReadOnly(  ) ;

   /**
    * The creation-date of the entity. This field is purely to track when this entity was created, and should be set in ejbCreate (<code>setCreationDate(new Date());</code>. It is not included in the value object. <p>We use the qualified name here because XDoclet doesn't copy imports from base classes into the generated interfaces.</p>
    */
   public java.util.Date getCreationDate(  ) ;

   public void setCreationDate( java.util.Date creationDate ) ;

}
