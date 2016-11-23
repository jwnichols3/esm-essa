<!--
  Title: layout4.jsp
  Description: standard layout 4, render a menu w/links
-->

<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ page import="java.util.Iterator" %>

<tiles:importAttribute />

<table>
  <logic:present name="title">

  <tr>
    <th colspan=2>
      <div align="left"><strong><tiles:getAsString name="title"/></strong></div>
    </th>
  </tr>

  </logic:present>

  <%-- iterate on items list --%>
  <logic:iterate id="item" name="items" type="org.apache.struts.tiles.beans.MenuItem" >
    <%  // Add site url if link start with "/"
      String link = item.getLink();
      if(link.startsWith("/") ) link = request.getContextPath() + link; 
    %>

    <tr>
      <td width="10" valign="top" >
      </td>

      <td valign="top"  >
        <font size="-1">
          <a href="<%=link%>">
            <logic:notPresent name="item" property="icon">
              <%=item.getValue()%>
            </logic:notPresent>

            <logic:present name="item" property="icon">
              <%  // Add site url if link start with "/"
                String icon = item.getIcon();
                if(icon.startsWith("/") ) icon = request.getContextPath() + icon;
              %>

              <img src='<%=request.getContextPath()%> <bean:write name="item" property="icon" scope="page"/>' alt='<bean:write name="item" property="tooltip" scope="page" ignore="true"/>' />
            </logic:present>
          </a>
        </font>
      </td>
    </tr>
  </logic:iterate>
</table>

<!--
#;;; Local Variables: ***
#;;; mode:html ***
#;;; End: ***
-->
