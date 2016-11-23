/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Local home interface for Account.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface AccountLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/AccountLocal";
   public static final String JNDI_NAME="AccountLocal";

   public test.interfaces.AccountLocal create(test.interfaces.AccountValue data)
      throws javax.ejb.CreateException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public java.util.Collection findByOwner(test.interfaces.Customer owner)
      throws javax.ejb.FinderException;

   public java.util.Collection findLargeAccounts(int balance)
      throws javax.ejb.FinderException;

   public test.interfaces.AccountLocal findByPrimaryKey(test.interfaces.AccountPK pk)
      throws javax.ejb.FinderException;

}
