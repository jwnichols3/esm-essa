// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.webservice.jbws718;


public class LogonUser {
    protected java.lang.String userName;
    protected java.lang.String password;
    protected java.lang.String authority;
    
    public LogonUser() {
    }
    
    public LogonUser(java.lang.String userName, java.lang.String password, java.lang.String authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }
    
    public java.lang.String getUserName() {
        return userName;
    }
    
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
    
    public java.lang.String getPassword() {
        return password;
    }
    
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    
    public java.lang.String getAuthority() {
        return authority;
    }
    
    public void setAuthority(java.lang.String authority) {
        this.authority = authority;
    }
}