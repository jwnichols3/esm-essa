<!--
  Title: directorySizeAdHoc1.jsp
  Description: prepare for directory size ad hoc command.
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/WEB-INF/tags/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/struts-logic.tld" prefix="logic" %>

<h2><bean:message key="dir_size.adhoc.title"/></h2>
                   
<html:errors/>

<html:form action="/user/directorySizeAdHocInsertAction?action=adhoc" focus="persist">
  <table width="0%" border="5">
    <tr>
      <td align="right"><bean:message key="dir_size.adhoc.name"/>:</td>
      <td><html:text property="name" size="50"/></td>
    </tr>
    
    <tr>
      <td align="right"><bean:message key="dir_size.adhoc.recursive"/>:</td>
      <td><html:checkbox property="recursive"/></td>
    </tr>
    
    <tr>
      <td align="right"><bean:message key="dir_size.adhoc.persist"/>:</td>
      <td><html:checkbox property="persist"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="dir_size.adhoc.evaluate"/>:</td>
      <td><html:checkbox property="evaluate"/></td>
    </tr>

    <tr>
      <td align="right"><bean:message key="dir_size.adhoc.note"/>:</td>
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
