<!--
  Title: taskBrowse1.jsp
  Description: Display tasks.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="task.title.browse"/></h2>

<table width="0%" border="1">
  <tr> 
    <th class="hdmiddle" colspan="2">
      <bean:message key="option.generic"/>
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
          <bean:message key="edit.generic"/>
        </html:link>
      </td>
      
      <td class="fine">
        <html:link page="/user/taskPrepAction.do?action=edit" paramId="key" paramName="ndx1" paramProperty="rowId">
          <bean:message key="audit.generic"/>
        </html:link>
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
