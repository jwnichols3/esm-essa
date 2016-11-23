<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%-- Properties: title --%>

<style type="text/css" media="all">@import "<%= request.getContextPath() %>/decorators/panel/style.css";</style>
<div class="panelDark">
	<div class="top">
		<div class="title"><decorator:title/></div>
	</div>
	<div class="body">
<!--		<div class="subheading"><decorator:getProperty property="meta.subtitle" /></div>-->
		<div class="textEmpty">
			<decorator:body />
		</div>
	</div>
	<div class="bottom"></div>
</div>

