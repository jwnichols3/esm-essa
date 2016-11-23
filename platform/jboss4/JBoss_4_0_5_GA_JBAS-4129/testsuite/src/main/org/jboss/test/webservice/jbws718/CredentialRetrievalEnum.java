// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.webservice.jbws718;


import java.util.Map;
import java.util.HashMap;

public class CredentialRetrievalEnum {
    private java.lang.String value;
    private static java.util.Map valueMap = new HashMap();
    public static final java.lang.String _PromptString = "Prompt";
    public static final java.lang.String _StoreString = "Store";
    public static final java.lang.String _IntegratedString = "Integrated";
    public static final java.lang.String _NoneString = "None";
    
    public static final java.lang.String _Prompt = new java.lang.String(_PromptString);
    public static final java.lang.String _Store = new java.lang.String(_StoreString);
    public static final java.lang.String _Integrated = new java.lang.String(_IntegratedString);
    public static final java.lang.String _None = new java.lang.String(_NoneString);
    
    public static final CredentialRetrievalEnum Prompt = new CredentialRetrievalEnum(_Prompt);
    public static final CredentialRetrievalEnum Store = new CredentialRetrievalEnum(_Store);
    public static final CredentialRetrievalEnum Integrated = new CredentialRetrievalEnum(_Integrated);
    public static final CredentialRetrievalEnum None = new CredentialRetrievalEnum(_None);
    
    protected CredentialRetrievalEnum(java.lang.String value) {
        this.value = value;
        valueMap.put(this.toString(), this);
    }
    
    public java.lang.String getValue() {
        return value;
    }
    
    public static CredentialRetrievalEnum fromValue(java.lang.String value)
        throws java.lang.IllegalStateException {
        if (Prompt.value.equals(value)) {
            return Prompt;
        } else if (Store.value.equals(value)) {
            return Store;
        } else if (Integrated.value.equals(value)) {
            return Integrated;
        } else if (None.value.equals(value)) {
            return None;
        }
        throw new java.lang.IllegalArgumentException();
    }
    
    public static CredentialRetrievalEnum fromString(java.lang.String value)
        throws java.lang.IllegalStateException {
        CredentialRetrievalEnum ret = (CredentialRetrievalEnum)valueMap.get(value);
        if (ret != null) {
            return ret;
        }
        if (value.equals(_PromptString)) {
            return Prompt;
        } else if (value.equals(_StoreString)) {
            return Store;
        } else if (value.equals(_IntegratedString)) {
            return Integrated;
        } else if (value.equals(_NoneString)) {
            return None;
        }
        throw new IllegalArgumentException();
    }
    
    public java.lang.String toString() {
        return value.toString();
    }
    
    private java.lang.Object readResolve()
        throws java.io.ObjectStreamException {
        return fromValue(getValue());
    }
    
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CredentialRetrievalEnum)) {
            return false;
        }
        return ((CredentialRetrievalEnum)obj).value.equals(value);
    }
    
    public int hashCode() {
        return value.hashCode();
    }
}
