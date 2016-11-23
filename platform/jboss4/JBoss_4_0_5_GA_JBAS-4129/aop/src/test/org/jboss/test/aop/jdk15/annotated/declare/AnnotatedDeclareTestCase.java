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
package org.jboss.test.aop.jdk15.annotated.declare;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


/**
 *
 * @author <a href="mailto:kabir.khan@jboss.org">Kabir Khan</a>
 * @version $Revision: 57185 $
 */
public class AnnotatedDeclareTestCase extends TestCase
{
   public static void main(String[] args)
   {
      TestRunner.run(suite());
   }

   public static Test suite()
   {
      TestSuite suite = new TestSuite("AnnotatedDeclareTestCase");
      suite.addTestSuite(AnnotatedDeclareTestCase.class);
      return suite;
   }

   public AnnotatedDeclareTestCase(String name)
   {
      super(name);
   }

   protected void setUp() throws Exception
   {
   }
   
   public void testLoadtimeAnnotatedDeclare()throws Exception
   {
      System.out.println("*** testLoadtimeAnnotatedDeclare");
      SystemOutDecorator out = null;
      try
      {
         out = SystemOutDecorator.initialise();
         POJO pojo = new POJO();
         pojo.someMethod();
         ArrayList actual = out.getWarnings();
         assertEquals("Wrong number of warnings generated", 1, actual.size());
         String s = (String)actual.get(0);
         assertTrue("Warning does not end with the expected \"Expected annotated warning\"", s.endsWith("Expected annotated warning\n"));
      } 
      finally
      {
         out.kill();         
      }
   }

}
