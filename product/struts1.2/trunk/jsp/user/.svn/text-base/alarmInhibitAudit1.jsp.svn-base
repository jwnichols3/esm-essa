<!--
  Title: alarmInhibitAudit1.jsp
  Description: Display selected "alarm inhibit" rules.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="alarm_inhibit.title.audit"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.rule_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.modified"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.day"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.start"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.stop"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="alarm_inhibit.column.note"/>
    </th>
  </tr>
 
  <logic:iterate id="ndx1" name="audit_list">
    <tr>
      <td class="fine">
        <bean:write name="ndx1" property="rowId"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="taskId"/>
      </td>
     
      <td class="fine">
        <bean:write name="ndx1" property="ruleId"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="version"/>
      </td>
          
      <td class="fine">
        <bean:write name="ndx1" property="creation"/>
      </td>
            
      <td class="fine">
        <bean:write name="ndx1" property="modified"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="day"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="start"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="stop"/>
      </td>
    
      <td class="fine">
        <bean:write name="ndx1" property="active"/>
      </td>

      <td class="fine">
        <logic:notEqual name="ndx1" property="note" value="EMPTY_STRING">
          <bean:write name="ndx1" property="note"/>
        </logic:notEqual>
      </td>
    </tr>
  </logic:iterate>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
