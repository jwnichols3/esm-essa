<%--
  - $RCSfile$
  - $Revision: 189 $
  - $Date: 2005-07-27 16:20:07 -0700 (Wed, 27 Jul 2005) $
  -
  - Copyright (C) 2002-2003 Jive Software. All rights reserved.
  -
  - This software is the proprietary information of Jive Software. Use is subject to license terms.
--%>

<%@ page import="com.jivesoftware.forum.util.SkinUtils,
                 com.jivesoftware.base.JiveGlobals,
                 com.jivesoftware.util.TimerFilter"
    contentType="text/html"
%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%@ taglib uri="jivetags" prefix="jive" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title><%= SkinUtils.getCommunityName() %>: <decorator:title default="" /></title>
        <meta http-equiv="content-type" content="text/html; charset=<%= JiveGlobals.getCharacterEncoding() %>">
        <script language="JavaScript" type="text/javascript" src="<%= request.getContextPath() %>/groupchat/common.js"></script>
        <link rel="stylesheet" type="text/css" href="style.jsp">
		<decorator:head />
	</head>
    <body>

    <%  String header = JiveGlobals.getJiveProperty("skin.default.headerHTML");
        boolean useDefaultHeaderHTML = JiveGlobals.getJiveBooleanProperty("skin.default.useDefaultHeaderHTML", false);
        if (header != null && !"".equals(header) && !useDefaultHeaderHTML) {
    %>
        <%= header %>

    <%  } else { %>

        <table cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
            <tr>
                <td width="1%"><a href="index.jspa"><img src="templates/default/images/header-left.gif" width="199" height="38" border="0" alt="Community Forums"></a></td>
                <td width="98%"><img src="templates/default/images/header-stretch.gif" width="100%" height="38" border="0" alt=""></td>
                <td width="1%"><img src="templates/default/images/header-right.gif" width="5" height="38" border="0" alt=""></td>
            </tr>
        </tbody>
        </table>

    <%  } %>

    <br>

<decorator:body />

    <br><br>

    <%  String footer = JiveGlobals.getJiveProperty("skin.default.footerHTML");
        boolean useDefaultFooterHTML = JiveGlobals.getJiveBooleanProperty("skin.default.useDefaultFooterHTML", false);
        if (footer != null && !"".equals(footer) && !useDefaultFooterHTML) {
    %>
        <%= footer %>

    <%  } else { %>

        <table id="jive-footer" cellpadding="6" cellspacing="0" border="0" width="100%">
        <tr>
            <td>
                <%-- Forum Home --%>
                <a href="index.jspa"><jive:i18n key="global.forum_home" /></a>
                |
                <%-- Login --%>
                <a href="login!default.jspa"><jive:i18n key="loginbox.login_register" /></a>

                <%  if (JiveGlobals.getJiveBooleanProperty("skin.default.newAccountCreationEnabled",true)) { %>
                    |
                    <%-- create account --%>
                    <a href="account!default.jspa"><jive:i18n key="global.create_account" /></a>
                <%  } %>
                |
                <%-- Help --%>
                <a href="help.jspa"><jive:i18n key="global.help" /></a>

                <%  if (JiveGlobals.getJiveBooleanProperty("search.enabled", true)) { %>
                |
                <%-- Search --%>
                <a href="search!default.jspa"><jive:i18n key="global.search" /></a>
                <%  } %>

                <br>
                <%-- Powered by Jive Software --%>
                <a href="http://www.jivesoftware.com/poweredby/" target="_blank"><jive:i18n key="footer.powered_by" /></a>
            </td>
        </tr>
        </table>

    <%  } %>

    <%
        // Get the timer from the request as an attribute if it exists:
        TimerFilter.Timer timer
                = (TimerFilter.Timer)request.getAttribute(TimerFilter.DEFAULT_TIMER_ATTRIBUTE);
        if (timer != null) {
            timer.stop();
    %>

        <p class="jive-timer">
        Page rendered in <%= timer.getTime() %>ms.
        </p>

    <%  } %>

</body>
</html>