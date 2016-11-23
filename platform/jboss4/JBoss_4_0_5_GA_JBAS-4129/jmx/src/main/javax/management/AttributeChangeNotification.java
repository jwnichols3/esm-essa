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
package javax.management;

/**
 * This is the mandated object for sending notifications of attribute
 * changes. The MBean may also send other types of notifications.
 * The MBean must implement the
 * {@link javax.management.NotificationBroadcaster} interface to send
 * this notification.<p>
 *
 * The following information is provided in addition to the that provided by
 * {@link javax.management.Notification Notification}.
 * The attribute's {@link #getAttributeName() name},
 * {@link #getAttributeType() type},
 * {@link #getOldValue() old value} and
 * {@link #getNewValue() new value}. <p>
 *
 * The notification type is "jmx.attribute.change", defined in the
 * static string {@link #ATTRIBUTE_CHANGE}.
 *
 * @see javax.management.AttributeChangeNotificationFilter
 *
 * @author  <a href="mailto:Adrian.Brock@HappeningTimes.com">Adrian Brock</a>.
 * @version $Revision: 57200 $
 *
 * <p><b>Revisions:</b>
 * <p><b>20020710 Adrian Brock:</b>
 * <ul>
 * <li> Serialization </li>
 * </ul>
 *
 */
public class AttributeChangeNotification
   extends Notification
{
   // Constants -----------------------------------------------------

   private static final long serialVersionUID = 535176054565814134L;
   /**
    * The AttributeChangeNotification notification type. It is
    * "jmx.attribute.change".
    */
   public static final String ATTRIBUTE_CHANGE = "jmx.attribute.change";

   // Attributes --------------------------------------------------------

   /**
    * The name of the attribute.
    */
   private String attributeName = null;

   /**
    * The type of the attribute.
    */
   private String attributeType = null;

   /**
    * The old value of the attribute.
    */
   private Object oldValue = null;

   /**
    * The new value of the attribute.
    */
   private Object newValue = null;

   // Static --------------------------------------------------------

   // Constructors --------------------------------------------------

   /**
    * Contruct a new attribute change notification.
    *
    * @param source the source of the notification.
    * @param sequenceNumber the instance of this notification.
    * @param timeStamp the time the notification was generated.
    * @param msg a human readable form of the change.
    * @param attributeName the name of the attribute.
    * @param attributeType the type of the attribute.
    * @param oldValue the old value of the attribute.
    * @param newValue the new value of the attribute.
    */
   public AttributeChangeNotification(Object source,
                                      long sequenceNumber,
                                      long timeStamp,
                                      String msg,
                                      String attributeName,
                                      String attributeType,
                                      Object oldValue,
                                      Object newValue)
   {
      super(ATTRIBUTE_CHANGE, source, sequenceNumber, timeStamp, msg);

      this.attributeName = attributeName;
      this.attributeType = attributeType;
      this.oldValue = oldValue;
      this.newValue = newValue;
   }


   // Public --------------------------------------------------------

   /**
    * Retrieves the name of the attribute.
    *
    * @return the name of the attribute.
    */
   public String getAttributeName()
   {
      return attributeName;
   }

   /**
    * Retrieves the type of the attribute.
    *
    * @return the type of the attribute.
    */
   public String getAttributeType()
   {
      return attributeType;
   }

   /**
    * Retrieves the old value of the attribute.
    *
    * @return the old value of the attribute.
    */
   public Object getOldValue()
   {
      return oldValue;
   }

   /**
    * Retrieves the new value of the attribute.
    *
    * @return the new value of the attribute.
    */
   public Object getNewValue()
   {
      return newValue;
   }

   /**
    * @return human readable string.
    */
   public String toString()
   {
      StringBuffer buffer = new StringBuffer(50);
      buffer.append(getClass().getName()).append(":");
      buffer.append(" source=").append(getSource());
      buffer.append(" seq-no=").append(getSequenceNumber());
      buffer.append(" time=").append(getTimeStamp());
      buffer.append(" message=").append(getMessage());
      buffer.append(" attributeName=").append(getAttributeName());
      buffer.append(" attributeType=").append(getAttributeType());
      buffer.append(" oldValue=").append(getOldValue());
      buffer.append(" newValue=").append(getNewValue());
      buffer.append(" notificationType=").append(getType());
      buffer.append(" userData=").append(getUserData());
      return buffer.toString();
   }

   // Overrides -----------------------------------------------------

   // Implementation ------------------------------------------------

   // Package protected ---------------------------------------------

   // Protected -----------------------------------------------------

   // Private -------------------------------------------------------

   // Inner classes -------------------------------------------------
}


