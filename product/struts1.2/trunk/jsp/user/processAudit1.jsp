<!--
  Title: processAudit1.jsp
  Description: Display all process rules.
  Legalise: Copyright (C) 2007 Digital Burro, INC.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="process.title.audit"/></h2>

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
      <bean:message key="process.column.version"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.created"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.modified"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.option"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.target"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.threshold"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.min_pop"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.max_pop"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="process.column.max_time"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="process.column.note"/>
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
        <bean:write name="ndx1" property="optionType"/>
      </td>
            
      <td class="fine">
        <bean:write name="ndx1" property="target"/>
      </td>
            
      <td class="fine">
        <bean:write name="ndx1" property="thresholdType"/>
      </td>
                 
      <td class="fine">
        <bean:write name="ndx1" property="minimumPopulation"/>
      </td>
                 
      <td class="fine">
        <bean:write name="ndx1" property="maximumPopulation"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="maximumTime"/>
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
