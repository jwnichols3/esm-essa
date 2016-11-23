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
package org.jboss.test.webservice.samples;


import junit.framework.Test;
import org.jboss.test.webservice.WebserviceTestBase;

import javax.naming.InitialContext;
import javax.xml.rpc.Service;

/**
 * Test access to the webservice via an application client
 *
 * @author Thomas.Diesler@jboss.org
 * @since 26-Apr-2004
 */
public class ClientSideApplTestCase extends WebserviceTestBase
{

   public ClientSideApplTestCase(String name)
   {
      super(name);
   }

   /** Deploy the test */
   public static Test suite() throws Exception
   {
      return getDeploySetup(ClientSideApplTestCase.class, "ws4ee-samples-server-jse.war, ws4ee-samples-server-ejb.jar, ws4ee-samples-client-appl.jar");
   }

   /** Test access to the EJB endpoint */
   public void testApplClientAccessEJB() throws Exception
   {
      InitialContext iniCtx = getClientContext();
      Service service = (Service)iniCtx.lookup("java:comp/env/service/OrganizationServiceEJB");
      Organization endpoint = (Organization)service.getPort(Organization.class);
      String info = endpoint.getContactInfo("mafia");
      assertEquals("The 'mafia' boss is currently out of office, please call again.", info);
   }

   /** Test access to the JSE endpoint */
   public void testApplClientAccessJSE() throws Exception
   {
      InitialContext iniCtx = getClientContext();
      OrganizationService service = (OrganizationService)iniCtx.lookup("java:comp/env/service/OrganizationServiceJSE");
      Organization endpoint = service.getOrganizationPort();
      String info = endpoint.getContactInfo("mafia");
      assertEquals("The 'mafia' boss is currently out of office, please call again.", info);
   }
}
