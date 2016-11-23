/*
 * Generated by XDoclet - Do not edit!
 */
package test.bea.cmr;

/**
 * CMP layer for Subscriber.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public abstract class SubscriberCMP
   extends test.bea.cmr.SubscriberBean
   implements javax.ejb.EntityBean
{

   public test.bea.cmr.SubscriberData getData()
   {
      test.bea.cmr.SubscriberData dataHolder = null;
      try
      {
         dataHolder = new test.bea.cmr.SubscriberData();

         dataHolder.setBoid( getBoid() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void ejbLoad() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbLoad();
   }

   public void ejbStore() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
         super.ejbStore();
   }

   public void ejbActivate() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbActivate();
   }

   public void ejbPassivate() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbPassivate();

   }

   public void setEntityContext(javax.ejb.EntityContext ctx) throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.EJBException, java.rmi.RemoteException, javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

 /* Value Objects BEGIN */

/* Value Objects END */

   public abstract java.lang.String getBoid() ;

   public abstract void setBoid( java.lang.String boid ) ;

}
