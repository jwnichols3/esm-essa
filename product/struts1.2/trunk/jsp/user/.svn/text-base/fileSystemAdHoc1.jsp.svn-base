<!--
  Title: fileSystemAdHoc1.jsp
  Description: prepare for file system ad hoc command.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="file_system.adhoc.title"/></h2>

<html:errors/>

<html:form action="/user/fileSystemAdHocAction?action=adhoc" focus="persist">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="file_system.adhoc.persist"/>:</td>
      <td><html:checkbox property="persist"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="file_system.adhoc.evaluate"/>:</td>
      <td><html:checkbox property="evaluate"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="file_system.adhoc.note"/>:</td>
      <td><html:text property="note" size="50"/></td>
    </tr>

    <tr>
      <td><html:submit value="Submit"/></td>
    </tr>
  </table>
</html:form>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
