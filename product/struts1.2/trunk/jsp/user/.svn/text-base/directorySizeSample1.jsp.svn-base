<!--
  Title: directorySizeSample1.jsp
  Description: Display all directory size samples.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="directory_size.title.sample"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="directory_size.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="directory_size.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="directory_size.column.rule_id"/>
    </th>
        
    <th class="hdmiddle">
      <bean:message key="directory_size.column.rule_row_id"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="directory_size.column.sample_time"/>
    </th>
 
    <th class="hdmiddle">
      <bean:message key="directory_size.column.exists"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="directory_size.column.bytes"/>
    </th>
            
    <th class="hdmiddle">
      <bean:message key="directory_size.column.rule_match"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="directory_size.column.suppress"/>
    </th>
 
    <th class="hdmiddle">
      <bean:message key="directory_size.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="directory_size.column.note"/>
    </th>
  </tr>
 
  <logic:iterate id="ndx1" name="sample_list">
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
        <bean:write name="ndx1" property="ruleRowId"/>
      </td>
          
      <td class="fine">
        <bean:write name="ndx1" property="timeStamp"/>
      </td>
            
      <td class="fine">
        <bean:write name="ndx1" property="exists"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="bytePopulation"/>
      </td>
     
      <td class="fine">
        <bean:write name="ndx1" property="match"/>
      </td>
     
      <td class="fine">
        <bean:write name="ndx1" property="suppressed"/>
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
