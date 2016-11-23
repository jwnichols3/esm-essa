<!--
  Title: bootTimeSample1.jsp
  Description: Display all boot time samples.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="boot_time.title.sample"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="boot_time.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="boot_time.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.rule_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.rule_row_id"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="boot_time.column.sample_time"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.boot_time"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.matched"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="boot_time.column.suppressed"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="boot_time.column.note"/>
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
        <bean:write name="ndx1" property="bootTime"/>
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
