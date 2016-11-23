<!--
  Title: processSample1.jsp
  Description: Display process samples.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="process.title.sample"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="process.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.rule_id"/>
    </th>
        
    <th class="hdmiddle">
      <bean:message key="process.column.rule_row_id"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.sample_time"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.pid"/>
    </th>   
     
    <th class="hdmiddle">
      <bean:message key="process.column.target"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.population"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.cpu_time"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.exists"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.rule_match"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.suppress"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.note"/>
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
        <bean:write name="ndx1" property="pid"/>
      </td>
            
      <td class="fine">
        <logic:notEqual name="ndx1" property="name" value="EMPTY_STRING">
          <bean:write name="ndx1" property="name"/>
        </logic:notEqual>
      </td> 
           
      <td class="fine">
        <bean:write name="ndx1" property="population"/>
      </td>
            
      <td class="fine">
        <bean:write name="ndx1" property="cpuTime"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="exists"/>
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
