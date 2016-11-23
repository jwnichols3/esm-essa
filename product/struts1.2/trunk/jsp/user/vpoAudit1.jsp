<!--
  Title: vpoAudit1.jsp
  Description: Display selected VPO rules.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="vpo.title.audit"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="vpo.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="vpo.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="vpo.column.rule_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="vpo.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="vpo.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="vpo.column.modified"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="vpo.column.app_name"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="vpo.column.severity"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="vpo.column.retry"/>
    </th>
       
    <th class="hdmiddle">
      <bean:message key="vpo.column.source"/>
    </th>
       
    <th class="hdmiddle">
      <bean:message key="vpo.column.message"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="vpo.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="vpo.column.note"/>
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
        <bean:write name="ndx1" property="appName"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="severity"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="frequency"/>
      </td>
      
      <td class="fine">
        <logic:notEqual name="ndx1" property="sourceHost" value="EMPTY_STRING">
          <bean:write name="ndx1" property="sourceHost"/>
        </logic:notEqual>
      </td>
      
      <td class="fine">
        <logic:notEqual name="ndx1" property="message" value="EMPTY_STRING">
          <bean:write name="ndx1" property="message"/>
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
