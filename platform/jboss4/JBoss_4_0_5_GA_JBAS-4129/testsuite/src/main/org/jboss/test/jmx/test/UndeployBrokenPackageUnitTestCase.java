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
package org.jboss.test.jmx.test;

import java.io.File;
import javax.management.ObjectName;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.test.JBossTestCase;
import org.jboss.test.jmx.eardeployment.a.interfaces.SessionA;
import org.jboss.test.jmx.eardeployment.a.interfaces.SessionAHome;
import org.jboss.test.jmx.eardeployment.b.interfaces.SessionB;
import org.jboss.test.jmx.eardeployment.b.interfaces.SessionBHome;
import org.jboss.deployment.DeploymentException;
import org.jboss.deployment.IncompleteDeploymentException;
import org.jboss.util.file.Files;

/** Tests of reployment of bad deployment packages
 *
 * @author <a href="mailto:d_jencks@users.sourceforge.net">David Jencks</a>
 * @author Scott.Stark@jboss.org
 * @version $Revision: 57211 $
 */

public class UndeployBrokenPackageUnitTestCase extends JBossTestCase 
{
   public UndeployBrokenPackageUnitTestCase(String name)
   {
      super(name);
   }

   public void testBrokenPackageRedeployment() throws Exception
   {
      getLog().info("+++ testBrokenPackageRedeployment");
      String testPackage = "undeploybroken.jar";
      String missingDatasource = "test-service.xml";
      ObjectName entityAName = new ObjectName("jboss.j2ee:service=EJB,jndiName=EntityA");
      ObjectName entityBName = new ObjectName("jboss.j2ee:service=EJB,jndiName=EntityB");
      getLog().info("testPackage is : " + testPackage);
      try 
      {
         try 
         {
            deploy(testPackage);
            fail("test package " + testPackage + " deployed successfully without needed datasource!");
         }
         catch (IncompleteDeploymentException e)
         {
            log.info("caught exception as expected", e);
         } // end of try-catch
         undeploy(testPackage);
         getLog().info("Undeployed testPackage");
         deploy(missingDatasource);
         getLog().info("Deployed missing datasource");
         deploy(testPackage);
      }
      finally
      {
         try 
         {
            undeploy(testPackage);
         }
         catch (Throwable e)
         {
         } // end of try-catch
         try 
         {
            undeploy(missingDatasource);
         }
         catch (Throwable e)
         {
         } // end of try-catch
         
      } // end of try-catch
      try 
      {
         getInitialContext().lookup("EntityA");
         fail("EntityA found after undeployment");
      }
      catch (NamingException e)
      {
         log.info("caught exception as expected", e);
      } // end of try-catch
      try 
      {
         getInitialContext().lookup("EntityB");
         fail("EntityB found after undeployment");
      }
      catch (NamingException e)
      {
         log.info("caught exception as expected", e);
      } // end of try-catch
      assertTrue("EntityA mbean is registered!", !getServer().isRegistered(entityAName));
      assertTrue("EntityB mbean is registered!", !getServer().isRegistered(entityBName));

   }

   /** Deploy an ejb that has an invalid ejb-jar.xml descriptor and then
    reploy a valid version after undeploying the invalid jar.
    */
   public void testBadEjbRedeployment() throws Exception
   {
      getLog().info("+++ testBadEjbRedeployment");
      String testPackage = "ejbredeploy.jar";
      // Move the bad jar into ejbredeploy.jar
      String deployDir = System.getProperty("jbosstest.deploy.dir");
      File thejar = new File(deployDir, "ejbredeploy.jar");
      File badjar = new File(deployDir, "ejbredeploy-bad.jar");
      File goodjar = new File(deployDir, "ejbredeploy-good.jar");

      thejar.delete();
      Files.copy(badjar, thejar);
      getLog().info("Deploying testPackage: " + testPackage);
      try 
      {
         deploy(testPackage);
         fail("test package " + testPackage + " deployed successfully with bad descriptor!");
      }
      catch (DeploymentException e)
      {
         log.info("caught exception as expected", e);
      }
      undeploy(testPackage);
      getLog().info("Undeployed bad testPackage");

      thejar.delete();
      Files.copy(goodjar, thejar);
      getLog().info("Redeploying testPackage: " + testPackage);
      deploy(testPackage);
      Object home = getInitialContext().lookup("EntityA");
      getLog().info("Found EntityA home");
      undeploy(testPackage);
   }

   /** Deploy an ejb that has an invalid ejb-jar.xml descriptor and then
    deploy a completely unrelated service to test that the failed deployment
    does not prevent deployment of the unrelated service.
    */
   public void testBadSideAffects() throws Exception
   {
      getLog().info("+++ testBadSideAffects");
      getLog().info("Deploying testPackage: ejbredeploy-bad.jar");
      try
      {
         deploy("ejbredeploy-bad.jar");
         fail("test package deployed successfully with bad descriptor!");
      }
      catch (DeploymentException e)
      {
         log.info("caught exception as expected", e);
      }

      try
      {
         getLog().info("Deploying testPackage: test-service.xml");
         deploy("test-service.xml");
         getLog().info("Deployed test-service.xml");
         ObjectName serviceName = new ObjectName("jboss.test:service=TestService,test=jmx");
         assertTrue("test-service.xml mbean is registered", getServer().isRegistered(serviceName));
      }
      finally
      {
         try
         {
            undeploy("test-service.xml");
         }
         catch(Throwable t)
         {
         }
         try
         {
            undeploy("ejbredeploy-bad.jar");
         }
         catch(Throwable t)
         {
         }
      }
   }

}// UndeployBrokenPackageUnitTestCase

