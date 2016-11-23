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
package org.jboss.ejb3.stateless;

import java.lang.reflect.InvocationTargetException;
import org.jboss.annotation.ejb.Clustered;
import org.jboss.annotation.ejb.RemoteBinding;
import org.jboss.aop.Advisor;
import org.jboss.aop.AspectManager;
import org.jboss.aop.advice.AdviceStack;
import org.jboss.aspects.remoting.FamilyWrapper;
import org.jboss.ejb3.JBossProxy;
import org.jboss.ejb3.ProxyFactoryHelper;
import org.jboss.ejb3.remoting.RemoteProxyFactory;
import org.jboss.ha.framework.interfaces.ClusteringTargetsRepository;
import org.jboss.ha.framework.interfaces.HAPartition;
import org.jboss.ha.framework.interfaces.LoadBalancePolicy;
import org.jboss.ha.framework.interfaces.RandomRobin;
import org.jboss.ha.framework.server.HATarget;
import org.jboss.remoting.InvokerLocator;


/**
 * Comment
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 57207 $
 */
public class StatelessClusterProxyFactory extends BaseStatelessProxyFactory implements RemoteProxyFactory
{
   private RemoteBinding binding;
   private InvokerLocator locator;
   private HATarget hatarget;
   private String proxyFamilyName;
   private LoadBalancePolicy lbPolicy;
   private FamilyWrapper wrapper;

   public void setRemoteBinding(RemoteBinding binding)
   {
      this.binding = binding;
   }

   protected Class[] getInterfaces()
   {
      Class[] remoteInterfaces = ProxyFactoryHelper.getRemoteInterfaces(container);
      Class[] interfaces = new Class[remoteInterfaces.length + 1];
      System.arraycopy(remoteInterfaces, 0, interfaces, 0, remoteInterfaces.length);
      interfaces[remoteInterfaces.length] = JBossProxy.class;
      return interfaces;
   }

   protected void initializeJndiName()
   {
      jndiName = ProxyFactoryHelper.getRemoteJndiName(container, binding);
   }

   public void start() throws Exception
   {
      String clientBindUrl = ProxyFactoryHelper.getClientBindUrl(binding);
      locator = new InvokerLocator(clientBindUrl);
      Clustered clustered = (Clustered) advisor.resolveAnnotation(Clustered.class);
      if (clustered == null) throw new RuntimeException("Could not find @Clustered annotation.  Cannot deploy.");
      String partitionName = clustered.partition();
      proxyFamilyName = container.getEjbName() + locator.getProtocol() + partitionName;
      HAPartition partition = (HAPartition) container.getInitialContext().lookup("/HAPartition/" + partitionName);
      hatarget = new HATarget(partition, proxyFamilyName, locator, HATarget.ENABLE_INVOCATIONS);
      ClusteringTargetsRepository.initTarget(proxyFamilyName, hatarget.getReplicants());
      ((StatelessContainer) container).getClusterFamilies().put(proxyFamilyName, hatarget);
      if (clustered.loadBalancePolicy() == null || clustered.loadBalancePolicy().equals(LoadBalancePolicy.class))
      {
         lbPolicy = new RandomRobin();
      }
      else
      {
         lbPolicy = (LoadBalancePolicy) clustered.loadBalancePolicy().newInstance();
      }
      wrapper = new FamilyWrapper(proxyFamilyName, hatarget.getReplicants());
      super.start();
   }

   public void stop() throws Exception
   {
      super.stop();
      hatarget.destroy();
      ((StatelessContainer) container).getClusterFamilies().remove(proxyFamilyName);
   }

   public Object createProxy()
   {
//      try
      {
         Object containerId = container.getObjectName().getCanonicalName();
         String stackName = "ClusteredStatelessSessionClientInterceptors";
         if (binding.interceptorStack() != null && !binding.interceptorStack().equals(""))
         {
            stackName = binding.interceptorStack();
         }
         AdviceStack stack = AspectManager.instance().getAdviceStack(stackName);
         /*
         Object[] args = {new StatelessClusteredProxy(containerId, stack.createInterceptors((Advisor) container, null), wrapper, lbPolicy)};
         return proxyConstructor.newInstance(args);
         */
         return constructProxy(new StatelessClusteredProxy(containerId, stack.createInterceptors((Advisor) container, null), wrapper, lbPolicy));
      }
      /*
      catch (InstantiationException e)
      {
         throw new RuntimeException(e);  //To change body of catch statement use Options | File Templates.
      }
      catch (IllegalAccessException e)
      {
         throw new RuntimeException(e);  //To change body of catch statement use Options | File Templates.
      }
      catch (IllegalArgumentException e)
      {
         throw new RuntimeException(e);  //To change body of catch statement use Options | File Templates.
      }
      catch (InvocationTargetException e)
      {
         throw new RuntimeException(e.getTargetException());  //To change body of catch statement use Options | File Templates.
      }
      */
   }

   protected StatelessHandleImpl getHandle()
   {
      StatelessHandleImpl handle = new StatelessHandleImpl();
      RemoteBinding remoteBinding = (RemoteBinding)advisor.resolveAnnotation(RemoteBinding.class);
      if (remoteBinding != null)
         handle.jndiName = remoteBinding.jndiBinding();
 
      return handle;
   }
}
