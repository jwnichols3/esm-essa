/*
 * Generated by XDoclet - Do not edit!
 */
package test.bea.cmr;

/**
 * Local home interface for Subscriber.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public interface SubscriberLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/SubscriberLocal";
   public static final String JNDI_NAME="de.razeman.xdoclet.test.weblogic.ejb.relation.local.SubscriberLocalHome";

   public test.bea.cmr.SubscriberLocal create(java.lang.String boid)
      throws javax.ejb.CreateException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public test.bea.cmr.SubscriberLocal findByPrimaryKey(java.lang.String pk)
      throws javax.ejb.FinderException;

}