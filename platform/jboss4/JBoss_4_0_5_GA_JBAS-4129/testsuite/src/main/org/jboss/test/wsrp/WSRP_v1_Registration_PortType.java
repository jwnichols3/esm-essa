// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.wsrp;

import org.jboss.test.wsrp.core.*; 

public interface WSRP_v1_Registration_PortType extends java.rmi.Remote
{
   public RegistrationContext register(RegistrationData register) throws
      MissingParametersFault, OperationFailedFault, java.rmi.RemoteException;

   public ReturnAny deregister(RegistrationContext deregister) throws
      OperationFailedFault, InvalidRegistrationFault, java.rmi.RemoteException;

   public RegistrationState modifyRegistration(ModifyRegistration modifyRegistration) throws
      MissingParametersFault, OperationFailedFault, InvalidRegistrationFault, java.rmi.RemoteException;
}