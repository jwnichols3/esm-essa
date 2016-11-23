<!--
  Title: bootTimeAdHoc1.jsp
  Description: prepare for boot time ad hoc command.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="boot_time.adhoc.title"/></h2>

<html:errors/>

<html:form action="/user/bootTimeAdHocAction?action=adhoc" focus="persist">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="boot_time.adhoc.persist"/>:</td>
      <td><html:checkbox property="persist"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="boot_time.adhoc.evaluate"/>:</td>
      <td><html:checkbox property="evaluate"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="boot_time.adhoc.note"/>:</td>
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
