/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Local home interface for Address.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface AddressLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/AddressLocal";
   public static final String JNDI_NAME="AddressLocal";

   public test.interfaces.AddressLocal create(test.interfaces.AddressValue v)
      throws javax.ejb.CreateException;

   public java.util.Collection findByStreet(java.lang.String street)
      throws javax.ejb.FinderException;

   public java.util.Collection findByCity(java.lang.String city)
      throws javax.ejb.FinderException;

   public java.util.Collection findByOwner(test.interfaces.Customer owner)
      throws javax.ejb.FinderException;

   public test.interfaces.AddressLocal findByPrimaryKey(java.lang.String pk)
      throws javax.ejb.FinderException;

}
