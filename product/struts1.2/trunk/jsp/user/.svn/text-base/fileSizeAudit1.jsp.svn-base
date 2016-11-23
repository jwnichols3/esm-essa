<!--
  Title: fileSizeAudit1.jsp
  Description: Display all file age rules.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="file_size.title.audit"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="file_size.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_size.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_size.column.rule_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_size.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_size.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_size.column.modified"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_size.column.target"/>
    </th>
 
    <th class="hdmiddle">
      <bean:message key="file_size.column.option"/>
    </th>
  
    <th class="hdmiddle">
      <bean:message key="file_size.column.min_threshold"/>
    </th>
      
    <th class="hdmiddle">
      <bean:message key="file_size.column.max_threshold"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="file_size.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="file_size.column.note"/>
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
        <bean:write name="ndx1" property="target"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="thresholdType"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="minimumThreshold"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="maximumThreshold"/>
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
