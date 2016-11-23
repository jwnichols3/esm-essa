<!--
  Title: fileAgeAudit1.jsp
  Description: Display all file age rules.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="file_age.title.audit"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="file_age.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_age.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_age.column.rule_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_age.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_age.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_age.column.modified"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_age.column.file_name"/>
    </th>
   
    <th class="hdmiddle">
      <bean:message key="file_age.column.threshold"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_age.column.option"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_age.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_age.column.note"/>
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
        <bean:write name="ndx1" property="fileName"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="absThreshold"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="olderNewer"/>
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
