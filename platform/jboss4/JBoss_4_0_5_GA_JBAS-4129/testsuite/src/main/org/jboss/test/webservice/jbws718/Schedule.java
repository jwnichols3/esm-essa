// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.webservice.jbws718;


public class Schedule {
    protected java.lang.String scheduleID;
    protected java.lang.String name;
    protected javax.xml.soap.SOAPElement definition;
    protected java.lang.String description;
    protected java.lang.String creator;
    protected java.util.Calendar nextRunTime;
    protected java.util.Calendar lastRunTime;
    protected boolean referencesPresent;
    protected org.jboss.test.webservice.jbws718.ScheduleStateEnum state;
    
    public Schedule() {
    }
    
    public Schedule(java.lang.String scheduleID, java.lang.String name, javax.xml.soap.SOAPElement definition, java.lang.String description, java.lang.String creator, java.util.Calendar nextRunTime, java.util.Calendar lastRunTime, boolean referencesPresent, org.jboss.test.webservice.jbws718.ScheduleStateEnum state) {
        this.scheduleID = scheduleID;
        this.name = name;
        this.definition = definition;
        this.description = description;
        this.creator = creator;
        this.nextRunTime = nextRunTime;
        this.lastRunTime = lastRunTime;
        this.referencesPresent = referencesPresent;
        this.state = state;
    }
    
    public java.lang.String getScheduleID() {
        return scheduleID;
    }
    
    public void setScheduleID(java.lang.String scheduleID) {
        this.scheduleID = scheduleID;
    }
    
    public java.lang.String getName() {
        return name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public javax.xml.soap.SOAPElement getDefinition() {
        return definition;
    }
    
    public void setDefinition(javax.xml.soap.SOAPElement definition) {
        this.definition = definition;
    }
    
    public java.lang.String getDescription() {
        return description;
    }
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    
    public java.lang.String getCreator() {
        return creator;
    }
    
    public void setCreator(java.lang.String creator) {
        this.creator = creator;
    }
    
    public java.util.Calendar getNextRunTime() {
        return nextRunTime;
    }
    
    public void setNextRunTime(java.util.Calendar nextRunTime) {
        this.nextRunTime = nextRunTime;
    }
    
    public java.util.Calendar getLastRunTime() {
        return lastRunTime;
    }
    
    public void setLastRunTime(java.util.Calendar lastRunTime) {
        this.lastRunTime = lastRunTime;
    }
    
    public boolean isReferencesPresent() {
        return referencesPresent;
    }
    
    public void setReferencesPresent(boolean referencesPresent) {
        this.referencesPresent = referencesPresent;
    }
    
    public org.jboss.test.webservice.jbws718.ScheduleStateEnum getState() {
        return state;
    }
    
    public void setState(org.jboss.test.webservice.jbws718.ScheduleStateEnum state) {
        this.state = state;
    }
}