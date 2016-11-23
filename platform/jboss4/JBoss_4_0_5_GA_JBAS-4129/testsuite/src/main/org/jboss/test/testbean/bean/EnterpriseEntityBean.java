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
package org.jboss.test.testbean.bean;

import java.rmi.*;
import javax.ejb.*;

import org.jboss.test.testbean.interfaces.EnterpriseEntityHome;
import org.jboss.test.testbean.interfaces.EnterpriseEntity;

/**
 * @author Marc Fleury
 */ 
public class EnterpriseEntityBean implements EntityBean {
   org.apache.log4j.Category log = org.apache.log4j.Category.getInstance(getClass());
  private EntityContext entityContext;
  public String name;
  public int otherField = 0;
                                                            

  public String ejbCreate(String name) throws RemoteException, CreateException {

       log.debug("EntityBean.ejbCreate("+name+") called");
       this.name = name;
	   return null;
  }

  public String ejbCreateMETHOD(String name) throws RemoteException, CreateException {

       log.debug("EntityBean.ejbCreateMETHOD("+name+") called");
       this.name = name;
	   return null;
  }

  public void ejbPostCreate(String name) throws RemoteException, CreateException {

       log.debug("EntityBean.ejbPostCreate("+name+") called");
	   
	   EJBObject ejbObject = entityContext.getEJBObject();
	   
	   if (ejbObject == null) {
		   log.debug("******************************* NULL EJBOBJECT in ejbPostCreate");
	   }
	   else {
			log.debug("&&&&&&&&&&&&&&&& EJBObject found in ejbPostCreate id is "+ejbObject.getPrimaryKey());   
	   }

  }

  public void ejbPostCreateMETHOD(String name) throws RemoteException, CreateException {

       log.debug("EntityBean.ejbPostCreateMETHOD("+name+") called");
	   
	   EJBObject ejbObject = entityContext.getEJBObject();
	   
	   if (ejbObject == null) {
		   log.debug("******************************* NULL EJBOBJECT in ejbPostCreateMETHOD");
	   }
	   else {
			log.debug("&&&&&&&&&&&&&&&& EJBObject found in ejbPostCreateMETHOD id is "+ejbObject.getPrimaryKey());   
	   }

  }

  public void ejbActivate() throws RemoteException {
    log.debug("EntityBean.ejbActivate() called");
  }

  public void ejbLoad() throws RemoteException {
   log.debug("EntityBean.ejbLoad() called");
  }

  public void ejbPassivate() throws RemoteException {

     log.debug("EntityBean.ejbPassivate() called");
  }

  public void ejbRemove() throws RemoteException, RemoveException {
   log.debug("EntityBean.ejbRemove() called "+hashCode());
  }

  public void ejbStore() throws RemoteException {
	  
   log.debug("EntityBean.ejbStore() called "+hashCode());
  }

  public String callBusinessMethodA() {

     log.debug("EntityBean.callBusinessMethodA() called");
     return "EntityBean.callBusinessMethodA() called, my primaryKey is "+
            entityContext.getPrimaryKey().toString();
  }
  
  public String callBusinessMethodB() {

     log.debug("EntityBean.callBusinessMethodB() called");
     
	 EJBObject ejbObject = entityContext.getEJBObject();
	 
	 if (ejbObject == null) 
	 	return "NULL EJBOBJECT";
	 
	 else 
	 	return ejbObject.toString();
  }
  
  
   public String callBusinessMethodB(String words) {
    
	  log.debug("EntityBean.callBusinessMethodB(String) called");
     
	 EJBObject ejbObject = entityContext.getEJBObject();
	 
	 if (ejbObject == null) 
	 	return "NULL EJBOBJECT";
	 
	 else 
	 	return ejbObject.toString()+ " words "+words;
  
	}
  public void setOtherField(int value) {
      
    log.debug("EntityBean.setOtherField("+value+")");
    otherField = value;
  }
  
  public int getOtherField() {
     log.debug("EntityBean.getOtherField() called");
     return otherField;
 }
  
  public EnterpriseEntity createEntity(String newName) throws RemoteException {

    log.debug("EntityBean.createEntity() called");
    EnterpriseEntity newBean;
    try{
		EJBObject ejbObject = entityContext.getEJBObject();
		if (ejbObject == null) 
		log.debug("************************** NULL EJBOBJECT");
		else
        log.debug("************************** OK EJBOBJECT");
		
		EnterpriseEntityHome home = (EnterpriseEntityHome)entityContext.getEJBObject().getEJBHome();
	    newBean = (EnterpriseEntity)home.create(newName);

    
	}catch(Exception e)
    {
		log.debug("failed", e);
        throw new RemoteException("create entity did not work check messages");   
    }
     
     return newBean;
  }
  
  public void setEntityContext(EntityContext context) throws RemoteException {
     log.debug("EntityBean.setSessionContext() called");
     entityContext = context;
  }

  public void unsetEntityContext() throws RemoteException {
     log.debug("EntityBean.unsetSessionContext() called");
    entityContext = null;
  }
}
