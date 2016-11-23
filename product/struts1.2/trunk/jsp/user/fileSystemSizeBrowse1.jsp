<!--
  Title: fileSystemSizeBrowse1.jsp
  Description: Display boot time rules.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="boot_time.title.browse"/></h2>

<table width="0%" border="1">
  <tr>
    <th class="hdmiddle">
      <bean:message key="task.column.key"/>
    </th>
    
    <th class="hdmiddle">
      <bean:message key="task.column.task_id"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="task.column.name"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="task.column.match_all"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="task.column.active"/>
    </th>

    <th class="hdmiddle">
      <bean:message key="task.column.note"/>
    </th>
  </tr>
 
  <logic:iterate id="ndx1" name="task_list">
    <tr>
      <td class="fine">
        <html:link page="/user/taskPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
          <bean:write name="ndx1" property="rowId"/>
        </html:link>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="taskId"/>
      </td>
 
      <td class="fine">
        <bean:write name="ndx1" property="name"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="matchAll"/>
      </td>
      
      <td class="fine">
        <bean:write name="ndx1" property="active"/>
      </td>

      <td class="fine">
        <bean:write name="ndx1" property="note"/>
      </td>
    </tr>
  </logic:iterate>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
