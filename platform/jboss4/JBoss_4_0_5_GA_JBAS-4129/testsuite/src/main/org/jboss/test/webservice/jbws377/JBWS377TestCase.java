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
package org.jboss.test.webservice.jbws377;

import junit.framework.Test;
import org.jboss.test.webservice.WebserviceTestBase;

import javax.naming.InitialContext;
import javax.xml.rpc.Service;

/**
 * Document/Literal parameter wrapping with null values
 *
 * http://jira.jboss.com/jira/browse/JBWS-377
 *
 * @author Thomas.Diesler@jboss.org
 * @since 26-Aug-2005
 */
public class JBWS377TestCase extends WebserviceTestBase
{
   /** Construct the test case with a given name
    */
   public JBWS377TestCase(String name)
   {
      super(name);
   }

   /** Deploy the test */
   public static Test suite() throws Exception
   {
      return getDeploySetup(JBWS377TestCase.class, "ws4ee-jbws377.war, ws4ee-jbws377-client.jar");
   }

   public void testEndpointNotNull() throws Exception
   {
      InitialContext iniCtx = getClientContext();
      Service service = (Service)iniCtx.lookup("java:comp/env/service/HelloService");
      Hello hello = (Hello)service.getPort(Hello.class);

      UserType user = new UserType("kermit");
      String retObj = hello.echoStrings("str1", "str2", user);
      assertEquals("str1str2[value=kermit]", retObj);
   }

   public void testEndpointNull() throws Exception
   {
      InitialContext iniCtx = getClientContext();
      Service service = (Service)iniCtx.lookup("java:comp/env/service/HelloService");
      Hello hello = (Hello)service.getPort(Hello.class);

      String retObj = hello.echoStrings(null, "str2", null);
      assertEquals("nullstr2null", retObj);
   }
}
