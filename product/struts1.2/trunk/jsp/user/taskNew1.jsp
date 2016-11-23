<!--
  Title: taskNew1.jsp
  Description: create a new task.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<h2><bean:message key="task.title.new"/></h2>

<html:errors/>

<html:form action="/user/taskInsertAction?action=insert" focus="name">
  <table width="0%" border="0">
    <tr>
      <td class="hdright"><bean:message key="task.form.name"/>:</td>
      <td class="input"><html:text property="name" size="30"/></td>
    </tr>
    
    <tr>
      <td class="hdright"><bean:message key="task.form.note"/>:</td>
      <td class="input"><html:textarea property="note" cols="50" rows="4"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
    </tr>
  </table>

  <html:hidden property="frequency"/>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
