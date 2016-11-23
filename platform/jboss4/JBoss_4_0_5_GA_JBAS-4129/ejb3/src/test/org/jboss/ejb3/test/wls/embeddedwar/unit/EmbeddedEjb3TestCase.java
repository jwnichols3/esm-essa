/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ejb3.test.wls.embeddedwar.unit;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;

import junit.framework.TestCase;

import org.jboss.ejb3.test.wls.embeddedwar.*;

/**
 * Comment
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 57207 $
 */
public class EmbeddedEjb3TestCase
   extends TestCase
{
   public static void main(String[] args) throws Exception
   {
      EmbeddedEjb3TestCase test = new EmbeddedEjb3TestCase();
      test.testEJBs();
      test.testEntityManager();
   }
   
   public EmbeddedEjb3TestCase()
   {
   }

   public void testEJBs() throws Exception
   {

      InitialContext ctx = getInitialContext();
      CustomerDAOLocal local = (CustomerDAOLocal) ctx.lookup("CustomerDAOBean/local");
      CustomerDAORemote remote = (CustomerDAORemote) ctx.lookup("CustomerDAOBean/remote");

      System.out.println("----------------------------------------------------------");
      System.out.println("This test scans the System Property java.class.path for all annotated EJB3 classes");
      System.out.print("    ");

      int id = local.createCustomer("Gavin");
      Customer cust = local.findCustomer(id);
      System.out.println("Successfully created and found Gavin from @Local interface");

      id = remote.createCustomer("Emmanuel");
      cust = remote.findCustomer(id);
      System.out.println("Successfully created and found Emmanuel from @Remote interface");
      System.out.println("----------------------------------------------------------");
   }

   public void testEntityManager() throws Exception
   {
      // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
      // Why aren't we using javax.persistence.Persistence?  Well, our persistence.xml file uses
      // jta-datasource which means that it is created by the EJB container/embedded JBoss.
      // using javax.persistence.Persistence will just cause us an error
      EntityManager em = (EntityManager) getInitialContext().lookup("java:/EntityManagers/custdb");

      // Obtain JBoss transaction
      TransactionManager tm = (TransactionManager) getInitialContext().lookup("java:/TransactionManager");

      tm.begin();

      Customer cust = new Customer();
      cust.setName("Bill");
      em.persist(cust);
      
      int id = cust.getId();

      System.out.println("created bill in DB with id: " + id);

      tm.commit();

      tm.begin();
      cust = em.find(Customer.class, id);
 
      tm.commit();
   }

   public static InitialContext getInitialContext() throws Exception
   {
      Hashtable props = getInitialContextProperties();
      return new InitialContext(props);
   }

   private static Hashtable getInitialContextProperties()
   {
      Hashtable props = new Hashtable();
 //     props.put("java.naming.factory.initial", "org.jnp.interfaces.LocalOnlyContextFactory");
 //     props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
      props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
      props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
      props.put("java.naming.provider.url", "jnp://localhost:1099");
      return props;
   }
}
