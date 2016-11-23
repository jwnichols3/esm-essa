<!--
  Title: fileAdHoc1.jsp
  Description: prepare for ad hoc file test command.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="file.adhoc.title"/></h2>

<html:errors/>

<html:form action="/user/fileAdHocInsertAction?action=adhoc" focus="persist">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="file.adhoc.name"/>:</td>
      <td><html:text property="name" size="50"/></td>
    </tr>
    
    <tr>
      <td align="right"><bean:message key="file.adhoc.persist"/>:</td>
      <td><html:checkbox property="persist"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="file.adhoc.evaluate"/>:</td>
      <td><html:checkbox property="evaluate"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="file.adhoc.note"/>:</td>
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
