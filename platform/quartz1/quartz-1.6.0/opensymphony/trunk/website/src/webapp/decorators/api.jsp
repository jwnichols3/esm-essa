<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<%@ page import="java.util.*" %>
<html>
<head>
<title>OpenSymphony - <decorator:title /></title>
<link rel="stylesheet" href="/styles/api.css">
<decorator:head />

<!-- Start Google Analytics -->
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-131794-1";
urchinTracker();
</script>
<!-- End Google Analytics -->

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" cellpadding=5 cellspacing=0 border=0><tr><td>

					<decorator:body />
	</td></tr></table>

	<%@ include file="/includes/global_navbar_bottom.jsp" %>

	<center>
	<font size="-2" face="Verdana, Sans-Serif">
	Copyright 2000-2005 - <a href="http://www.opensymphony.com">OpenSymphony</a>
	</font>
	</center>
	</body>
</html>
