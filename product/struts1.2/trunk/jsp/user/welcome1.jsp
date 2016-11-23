<!--
  Title: welcome1.jsp
  Description: splash page
  Development Environment: OS X 10.4.8, Tomcat 5.5.20, Struts 1.2.9
  Author: G.S. Cole (guycole at gmail dot com)
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<table width="0%" cellspacing="5" border="0">
  <tr>
    <td colspan="2"><h2><bean:message key="welcome.title"/></h2></td>
  </tr>

  <tr>
    <td>
      <% out.println("remote user:" + request.getRemoteUser()); %>
    </td>
  </tr>

  <tr>
    <td>
      <% out.println("remote IP:" + request.getRemoteAddr()); %>
    </td>
  </tr>

  <tr>
    <td>
      <% out.println("port:" + request.getServerPort()); %>
    </td>
  </tr>

  <tr>
    <td>
      <% out.println("server:" + request.getServerName()); %>
    </td>
  </tr>

  <tr>
    <td>
      <% out.println("auth type:" + request.getAuthType()); %>
    </td>
  </tr>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
