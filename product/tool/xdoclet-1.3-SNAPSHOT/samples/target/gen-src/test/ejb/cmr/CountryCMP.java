/*
 * Generated by XDoclet - Do not edit!
 */
package test.ejb.cmr;

/**
 * CMP layer for Country.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public abstract class CountryCMP
   extends test.ejb.cmr.CountryBean
   implements javax.ejb.EntityBean
{

   public test.ejb.cmr.CountryData getData()
   {
      test.ejb.cmr.CountryData dataHolder = null;
      try
      {
         dataHolder = new test.ejb.cmr.CountryData();

         dataHolder.setCountryId( getCountryId() );
         dataHolder.setOwnerIdFk( getOwnerIdFk() );
         dataHolder.setName( getName() );

      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void ejbLoad() 
   {
      super.ejbLoad();
   }

   public void ejbStore() 
   {
         super.ejbStore();
   }

   public void ejbActivate() 
   {
      super.ejbActivate();
   }

   public void ejbPassivate() 
   {
      super.ejbPassivate();

   }

   public void setEntityContext(javax.ejb.EntityContext ctx) 
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() 
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

 /* Value Objects BEGIN */

/* Value Objects END */

   public abstract java.lang.Integer getCountryId() ;

   public abstract void setCountryId( java.lang.Integer countryId ) ;

   public abstract java.lang.Integer getOwnerIdFk() ;

   public abstract void setOwnerIdFk( java.lang.Integer ownerIdFk ) ;

   public abstract java.lang.String getName() ;

   public abstract void setName( java.lang.String name ) ;

}
