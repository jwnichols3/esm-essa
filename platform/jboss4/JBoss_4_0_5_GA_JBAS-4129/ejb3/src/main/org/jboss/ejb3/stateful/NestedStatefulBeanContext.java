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
package org.jboss.ejb3.stateful;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import javax.persistence.EntityManager;
import org.jboss.aop.metadata.SimpleMetaData;
import org.jboss.ejb3.Ejb3Registry;
import org.jboss.serial.io.MarshalledObject;

/**
 * Comment
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 57207 $
 */
public class NestedStatefulBeanContext extends StatefulBeanContext
{
   public void writeExternal(ObjectOutput out) throws IOException
   {
      out.writeUTF(getContainer().getObjectName().getCanonicalName());
      out.writeObject(id);
      out.writeObject(metadata);
      out.writeObject(bean);
      out.writeObject(persistenceContexts);
      out.writeObject(interceptorInstances);
      out.writeObject(contains);
   }

   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
   {
      containerName = in.readUTF();
      id = in.readObject();
      metadata = (SimpleMetaData) in.readObject();
      bean = in.readObject();
      persistenceContexts = (HashMap<String, EntityManager>)  in.readObject();
      interceptorInstances = (HashMap<Class, Object>)in.readObject();
      beanMO = (MarshalledObject) in.readObject();
   }

}