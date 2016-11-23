<%@ page import="java.net.URL"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<decorator:usePage id="contentPage" />

<html>
<head>

<title>OpenSymphony - <decorator:title /></title>

<%--<link rel="stylesheet" href="/styles/main-css.txt">--%>
    <meta name="MSSmartTagsPreventParsing" content="true" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <style type="text/css" media="screen">@import "<%=request.getContextPath()%>/styles/global.css";</style>
    <% if ("wide".equalsIgnoreCase(contentPage.getProperty("meta.sidebar.type"))) { %>
        <style type="text/css" media="screen">@import "<%=request.getContextPath()%>/styles/twocolumns-wide.css";</style>
    <% } else { %>
        <style type="text/css" media="screen">@import "<%=request.getContextPath()%>/styles/twocolumns.css";</style>
    <% } %>
    <script type="text/javascript"> </script> <!-- FOUC hack: http://www.bluerobot.com/web/css/fouc.asp -->

<decorator:head />

</head>

<body>
	<%@ include file="/includes/global_header.jsp" %>

<table border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding: 0px 20px 20px 20px" width="100%" >

<h2 class="pagetitle"><decorator:title /></h2>

<decorator:body />

<div id="footertext">
    <%@ include file="/includes/global_navbar_links.jsp" %>
    <p>
    Copyright 2000-2005 - <a href="<%=request.getContextPath()%>/team.jsp">The Team</a> - <a href="<%=request.getContextPath()%>/contact.jsp">Contact Us &amp Mailing Lists</a>
</div>

</td><td valign="top" width="300" style="border-left: 1px dotted #999999;" >

<%
  String contextPath = request.getContextPath();
  String uri = request.getRequestURI();
  String nav = uri.substring(contextPath.length(), uri.lastIndexOf('/')) + "/navpanel.jsp";
  RequestDispatcher dispatcher = request.getRequestDispatcher(nav);
%>
<% if (dispatcher!=null ) { %>
    <div id="sidebar">
        <jsp:include page="<%=nav%>" />
<p />
        <a href="http://www.formicary.net"><img src="<%=request.getContextPath()%>/images/formicary-sponsor.gif" border=0 align=right></a>
	<a href="http://www.contegix.com"><img src="<%=request.getContextPath()%>/images/contegix.png" border=0 align=right></a>


    </div>
<% } %>

</td></tr>
</table>

</body>
</html>
