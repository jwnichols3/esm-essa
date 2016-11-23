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
package org.jboss.test.naming.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * InternalNamingClassReplacementUnitTestCase.java
 * This test runs each test in EjbLingUnitTestCase twice, redeploying the ear in
 * between runs.  The purpose is to see if an application can be reloaded
 * after use of jndi, and have the lookups work properly.  The local interface 
 * lookups are very likely to work since what is bound in jndi is a reference.
 * The remote bindings were serialized proxies when this test was written and
 * once the class was bound once it appeared to stay bound for the 
 * lifetime of the server.
 *
 * Created: Wed Apr 17 09:34:15 2002
 *
 * @author <a href="mailto:d_jencks@users.sourceforge.net">David Jencks</a>
 * @author Scott.Stark@jboss.org
 * @version $Revision: 57211 $
 */
public class InternalNamingClassReplacementUnitTestCase
   extends EjbLinkUnitTestCase 
{
   public InternalNamingClassReplacementUnitTestCase(String name) 
   {
      super(name);
   }
   
   /**
    * Describe <code>suite</code> method here.
    *  This is supposed to hide the deploy setup in the superclass so we can deploy twice
    * @return a <code>Test</code> value
    * @exception Exception if an error occurs
    */
   public static Test suite() throws Exception
   {
      TestSuite suite = new TestSuite();  
      suite.addTest(new TestSuite(InternalNamingClassReplacementUnitTestCase.class));
      return suite;
   }

   public void testEjbLinkNamed() throws Exception
   {
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkNamed();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkNamed();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
      
   }

   public void testEjbLinkRelative() throws Exception
   {
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkRelative();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkRelative();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
   }

   public void testEjbLinkLocalNamed() throws Exception
   {
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkLocalNamed();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkLocalNamed();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
   }

   public void testEjbLinkLocalRelative() throws Exception
   {
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkLocalRelative();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
      try 
      {
         deploy("naming.ear");
         super.testEjbLinkLocalRelative();
      }
      finally
      {
         undeploy("naming.ear");
      } // end of try-finally
   }


    public void testEjbNoLink() throws Exception
    {
        try
        {
            deploy("naming.ear");
            super.testEjbNoLink();
        }
        finally
        {
            undeploy("naming.ear");
        }

        try
        {
            deploy("naming.ear");
            super.testEjbNoLink();
        }
        finally
        {
            undeploy("naming.ear");
        }
    }

    public void testEjbNoLinkLocal() throws Exception
    {       
        try
        {
            deploy("naming.ear");
            super.testEjbNoLinkLocal();
        }
        finally
        {
            undeploy("naming.ear");
        }

        try
        {
            deploy("naming.ear");
            super.testEjbNoLinkLocal();
        }
        finally
        {
            undeploy("naming.ear");
        }
    }

   public void testEjbNames() throws Exception
   {
      try
      {
          deploy("naming.ear");
          super.testEjbNames();
      }
      finally
      {
          undeploy("naming.ear");
      }
   
      try
      {
          deploy("naming.ear");
          super.testEjbNames();
      }
      finally
      {
          undeploy("naming.ear");
      }
   }

}
