<!--
  Title: layout1.jsp
  Description: standard layout 1, AKA classic layout
-->

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<html:html locale="true">
  <head>
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/stylesheet1.css" type="text/css">
    <title><tiles:getAsString name="title"/></title>
    <html:base/>
  </head>

  <body>
    <table border="0" width="100%" cellspacing="5">
      <tr>
        <td colspan="2">
          <tiles:insert attribute="header"/>
        </td>
      </tr>

      <tr>
        <td width="140" valign="top">
          <tiles:insert attribute="menu"/>
        </td>

        <td valign="top" align="left">
          <tiles:insert attribute="body"/>
        </td>
      </tr>

      <tr>
        <td colspan="2">
          <tiles:insert attribute="footer"/>
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
