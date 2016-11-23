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
package org.jboss.test.web.servlets;           

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jboss.test.web.interfaces.ReferenceTest;
import org.jboss.test.web.interfaces.StatelessSession;
import org.jboss.test.web.interfaces.StatelessSessionHome;
import org.jboss.test.web.util.Util;

/** A servlet that accesses an EJB inside its init and destroy methods
to test web component startup ordering with respect to ebj components.

@author  Scott.Scott@jboss.org
@version $Revision: 57211 $
*/
public class EJBOnStartupServlet extends HttpServlet
{
   org.apache.log4j.Category log = org.apache.log4j.Category.getInstance(getClass());
   
    StatelessSessionHome home;

    public void init(ServletConfig config) throws ServletException
    {
        String param = config.getInitParameter("failOnError");
        boolean failOnError = true;
        if( param != null && Boolean.valueOf(param).booleanValue() == false )
            failOnError = false;
        try
        {
            // Access the Util.configureLog4j() method to test classpath resource
            URL propsURL = Util.configureLog4j();
            log.debug("log4j.properties = "+propsURL);
            // Access an EJB to see that they have been loaded first
            InitialContext ctx = new InitialContext();
            home = (StatelessSessionHome) ctx.lookup("java:comp/env/ejb/OptimizedEJB");
            log.debug("EJBOnStartupServlet is initialized");
        }
        catch(Exception e)
        {
            log.debug("failed", e);
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try
            {
               log.debug(Util.displayClassLoaders(loader));
            }
            catch(NamingException ne)
            {
               log.debug("failed", ne);
            }
            if( failOnError == true )
                throw new ServletException("Failed to init EJBOnStartupServlet", e);
        }
    }

    public void destroy()
    {
        try
        {
            InitialContext ctx = new InitialContext();
            StatelessSessionHome home = (StatelessSessionHome) ctx.lookup("java:comp/env/ejb/OptimizedEJB");
            log.debug("EJBOnStartupServlet is destroyed");
        }
        catch(Exception e)
        {
            log.debug("failed", e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        try
        {
            StatelessSession bean = home.create();
            bean.noop(new ReferenceTest(), true);
            bean.remove();
        }
        catch(Exception e)
        {
            throw new ServletException("Failed to call OptimizedEJB", e);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>EJBOnStartupServlet</title></head>");
        out.println("<body>Was initialized<br>");
        out.println("Tests passed<br>Time:"+Util.getTime()+"</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
