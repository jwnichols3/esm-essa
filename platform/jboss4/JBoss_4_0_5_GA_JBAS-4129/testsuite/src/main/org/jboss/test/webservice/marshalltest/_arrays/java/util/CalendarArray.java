// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.2_01, build R40)
// Generated source version: 1.1.2

package org.jboss.test.webservice.marshalltest._arrays.java.util;


public class CalendarArray {
    private java.util.Calendar[] value;
    
    public CalendarArray() {
    }
    
    public CalendarArray(java.util.Calendar[] sourceArray) {
        value = sourceArray;
    }
    
    public void fromArray(java.util.Calendar[] sourceArray) {
        this.value = sourceArray;
    }
    
    public java.util.Calendar[] toArray() {
        return value;
    }
    
    public java.util.Calendar[] getValue() {
        return value;
    }
    
    public void setValue(java.util.Calendar[] value) {
        this.value = value;
    }
}