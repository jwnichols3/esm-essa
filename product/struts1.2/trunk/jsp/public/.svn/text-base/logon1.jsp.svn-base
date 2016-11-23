<!--
  Title: logon1.jsp
  Description: logon page, uses tomcat security, no tiles
  Development Environment: OS X 10.4.8, Tomcat 5.5.20, Struts 1.2.9
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:xhtml/>

<html>
  <head>
    <title><bean:message key="logon.title"/></title>
    <link rel="stylesheet" type="text/css" href="/css/stylesheet1.css"/>
  </head>

  <html:errors/>

  <h2><bean:message key="logon.title"/></h2>

  <form method="POST" action='<%= response.encodeURL("j_security_check") %>' >
    <table width="0%" cellspacing="5" border="2">
      <tr>
        <td colspan="2"><H3><bean:message key="logon.prompt1"/></H3></td>
      </tr>

      <tr>
        <td align="right">
          <bean:message key="logon.user"/>:
        </td>
        <td align="left">
          <input type="text" name="j_username">
        </td>
      </tr>

      <tr>
        <td align="right">
          <bean:message key="logon.password"/>:
        </td>

        <td align="left">
          <input type="password" name="j_password">
        </td>
      </tr>

      <tr>
        <td align="right"><input type="submit" value="Log In"></td>
        <td align="left"><input type="reset"></td>
      </tr>
    </table>
  </form>
</html>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
