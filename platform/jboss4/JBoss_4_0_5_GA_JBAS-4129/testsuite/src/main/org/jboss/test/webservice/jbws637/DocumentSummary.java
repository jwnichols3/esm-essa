// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.webservice.jbws637;


public class DocumentSummary {
    protected org.jboss.test.webservice.jbws637.Words[] misspelledWord;
    protected java.lang.String ver;
    protected java.lang.String body;
    protected int misspelledWordCount;
    
    public DocumentSummary() {
    }
    
    public DocumentSummary(org.jboss.test.webservice.jbws637.Words[] misspelledWord, java.lang.String ver, java.lang.String body, int misspelledWordCount) {
        this.misspelledWord = misspelledWord;
        this.ver = ver;
        this.body = body;
        this.misspelledWordCount = misspelledWordCount;
    }
    
    public org.jboss.test.webservice.jbws637.Words[] getMisspelledWord() {
        return misspelledWord;
    }
    
    public void setMisspelledWord(org.jboss.test.webservice.jbws637.Words[] misspelledWord) {
        this.misspelledWord = misspelledWord;
    }
    
    public java.lang.String getVer() {
        return ver;
    }
    
    public void setVer(java.lang.String ver) {
        this.ver = ver;
    }
    
    public java.lang.String getBody() {
        return body;
    }
    
    public void setBody(java.lang.String body) {
        this.body = body;
    }
    
    public int getMisspelledWordCount() {
        return misspelledWordCount;
    }
    
    public void setMisspelledWordCount(int misspelledWordCount) {
        this.misspelledWordCount = misspelledWordCount;
    }
}
