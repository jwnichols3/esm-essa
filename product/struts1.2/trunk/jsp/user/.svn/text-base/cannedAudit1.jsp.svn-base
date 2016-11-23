<!--
  Title: cannedAudit1.jsp
  Description: Display selected "canned action" attributes.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="canned.title.audit"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="canned.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="canned.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="canned.column.rule_id"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="canned.column.action_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="canned.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="canned.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="canned.column.modified"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="canned.column.action"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="canned.column.subject"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="canned.column.address"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="canned.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="canned.column.note"/>
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
        <bean:write name="ndx1" property="actionId"/>
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
        <bean:write name="ndx1" property="action"/>
      </td>
      
      <td class="fine">
        <logic:notEqual name="ndx1" property="subject" value="EMPTY_STRING">
          <bean:write name="ndx1" property="subject"/>
        </logic:notEqual>
      </td>
      
      <td class="fine">
        <logic:notEqual name="ndx1" property="address" value="EMPTY_STRING">
          <bean:write name="ndx1" property="address"/>
        </logic:notEqual>
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
