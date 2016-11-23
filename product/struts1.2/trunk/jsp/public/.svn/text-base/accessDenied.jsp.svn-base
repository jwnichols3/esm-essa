<!--
  Title: accessDenied.jsp
  Description: access error handler
  Development Environment: OS X 10.4.8, Tomcat 5.5.20, Struts 1.2.9
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page errorPage="/jsp/public/genericFailure.jsp" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
  <head>
    <title><bean:message key="error.access.denied.title"/></title>
    <html:base/>
  </head>

  <body bgcolor="white">
    <table width="0%" border="0">
      <tr>
        <td><h2><bean:message key="error.access.denied"/></h2></td>
      </tr>

      <tr>
        <td>
          <html:link page="/jsp/public/logon1.jsp">
            <bean:message key="error.access.denied.retry"/>
          </html:link>
        </td>
      </tr>
    </table>
  </body>
</html:html>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
