package com.bgi.essa.shared.transfer;

/**
 *  Defines an alert that has been sent.
 *
 *  @hibernate.class
 *    table = "ALERT_RECORDS"
 *
 *  @author linden
 */
public class AlertRecordDTO extends AbstractDto implements Cloneable
{
    protected String Severity     = null;
    protected String MessageGroup = null;
    protected String MessageText  = null;
    protected String Object       = null;
    protected String Application  = null;
    protected Long   TimeStamp    = null;

    /**
     *  Return row ID.
     *
     *  return row ID
     *
     *  @hibernate.id
     *    name="ID"
     *    type="long"
     *    column="ID"
     *    generate-class="native"
     */
    @Override
    public Long getRowId()
    {
        return ( id.getLongKeyValue() );
    }

    public void setSeverity ( String severity )
    {
        Severity = severity;
    }

    public String getSeverity()
    {
        return Severity;
    }

    public void setMessageGroup ( String message_group )
    {
        MessageGroup = message_group;
    }

    public String getMessageGroup()
    {
        return MessageGroup;
    }

    public void setMessageText ( String message_text )
    {
        MessageText = message_text;
    }

    public String getMessageText()
    {
        return MessageText;
    }

    public void setObject ( String object )
    {
        Object = object;
    }

    public String getObject()
    {
        return Object;
    }

    public void setApplication ( String application )
    {
        Application = application;
    }

    public String getApplication()
    {
        return Application;
    }

    public void setTimeStamp ( Long time_stamp )
    {
        TimeStamp = time_stamp;
    }

    public Long getTimeStamp()
    {
        return TimeStamp;
    }

    public Object clone()
    {
        final AlertRecordDTO dto = new AlertRecordDTO();
        dto.setRowId        ( id.getLongKeyValue() );
        dto.setSeverity     ( Severity             );
        dto.setMessageGroup ( MessageGroup         );
        dto.setMessageText  ( MessageText          );
        dto.setObject       ( Object               );
        dto.setApplication  ( Application          );
        dto.setTimeStamp    ( TimeStamp            );

        return dto;
    }

    public boolean isReasonable()
    {
        System.out.println ( "AlertRecordTO fix me/isReasonable" );

        return true;
    }
};
