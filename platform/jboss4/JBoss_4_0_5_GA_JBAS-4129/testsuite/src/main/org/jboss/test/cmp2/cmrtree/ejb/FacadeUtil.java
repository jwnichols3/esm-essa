/*
 * Generated file - Do not edit!
 */
package org.jboss.test.cmp2.cmrtree.ejb;

/**
 * Utility class for Facade.
 */
public class FacadeUtil
{
   /** Cached remote home (EJBHome). Uses lazy loading to obtain its value (loaded by getHome() methods). */
   private static FacadeHome cachedRemoteHome = null;

   // Home interface lookup methods

   /**
    * Obtain remote home interface from default initial context
    * @return Home interface for Facade. Lookup using JNDI_NAME
    */
   public static FacadeHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) {
         // Obtain initial context
         javax.naming.InitialContext initialContext = new javax.naming.InitialContext();
         try {
            Object objRef = initialContext.lookup( FacadeHome.JNDI_NAME);
            cachedRemoteHome = ( FacadeHome) javax.rmi.PortableRemoteObject.narrow(objRef, org.jboss.test.cmp2.cmrtree.ejb.FacadeHome.class);
         } finally {
            initialContext.close();
         }
      }
      return cachedRemoteHome;
   }

   /**
    * Obtain remote home interface from parameterised initial context
    * @param environment Parameters to use for creating initial context
    * @return Home interface for Facade. Lookup using JNDI_NAME
    */
   public static FacadeHome getHome( java.util.Hashtable environment ) throws javax.naming.NamingException
   {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         Object objRef = initialContext.lookup(FacadeHome.JNDI_NAME);
         return ( FacadeHome) javax.rmi.PortableRemoteObject.narrow(objRef, FacadeHome.class);
      } finally {
         initialContext.close();
      }
   }

}