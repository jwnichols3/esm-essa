/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Home interface for Stateful.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface StatefulHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/Stateful";
   public static final String JNDI_NAME="Stateful";

   public test.interfaces.Stateful createWithParam(java.lang.String x)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public test.interfaces.Stateful create(java.lang.String x)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
