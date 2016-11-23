<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<style type="text/css" media="all">@import "<%= request.getContextPath() %>/decorators/quote/style.css";</style>

<table class="quote">
	<tr>
		<td style="vertical-align: top;"><img src="<%= request.getContextPath() %>/decorators/quote/start.gif" alt="" width="32" height="26" /></td>
		<td><decorator:body /></td>
		<td style="vertical-align: bottom;"><img src="<%= request.getContextPath() %>/decorators/quote/end.gif" alt="" width="32" height="26" /></td>
	</tr>
</table>
