<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>SiteMesh</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<style type="text/css" media="all">@import "<%= request.getContextPath() %>/decorators/style.css";</style>
		<decorator:head />
	</head>
	<body>
		<div id="main">

			<page:applyDecorator name="header" page="/panels/opensymphony.jsp">
				<page:param name="activeTab">intro</page:param>
			</page:applyDecorator>

			<div id="columnCenter">
				<decorator:body />
			</div>

			<div id="columnRight">

				<table class="quickLinks">
					<tr>
						<td>
							<a href="<%= request.getContextPath() %>/usersguide/"><img src="<%= request.getContextPath() %>/icons/book.gif" alt="" width="45" height="47" /><br /></a>
							<a href="<%= request.getContextPath() %>/usersguide/">Users' Guide</a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/usersguide/forums.jsp"><img src="<%= request.getContextPath() %>/icons/q-and-a.gif" alt="" width="47" height="47" /><br /></a>
							<a href="<%= request.getContextPath() %>/usersguide/forums.jsp">Forums</a>
						</td>
					</tr>
				</table>

				<page:applyDecorator name="panel-dark" page="/panels/download-now.jsp"/>
				<page:applyDecorator name="panel-light" page="/panels/latest-news.jsp"/>
				<page:applyDecorator name="panel-light" page="/panels/featured.jsp"/>

			</div>

			<jsp:include page="includes/banner-ad.jsp"/>

		</div>
	</body>
</html>