<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<%@ page import="java.util.*" %>
<html>
<head>
<title>OpenSymphony - <decorator:title /></title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/api-css.txt">
<decorator:head />
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" cellpadding=5 cellspacing=0 border=0><tr><td>

					<decorator:body />
	</td></tr></table>

	<%@ include file="/includes/global_navbar_bottom.jsp" %>

	<center>
	<font size="-2" face="Verdana, Sans-Serif">
	Copyright 2000-2004 - <a href="<%=request.getContextPath()%>/team.jsp">The Team</a> - <a href="<%=request.getContextPath()%>/contact.jsp">Contact Us &amp Mailing Lists</a>
	</font>
	</center>
	</body>
</html>
