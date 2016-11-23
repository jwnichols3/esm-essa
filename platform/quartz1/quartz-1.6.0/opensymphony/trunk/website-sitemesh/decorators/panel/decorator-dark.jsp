<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%-- Properties: title, meta.subtitle, meta.icon, meta.link, page.footer --%>

<style type="text/css" media="all">@import "<%= request.getContextPath() %>/decorators/panel/style.css";</style>
<div class="panelDark">
	<div class="top">
		<div class="title"><decorator:title/></div>
	</div>
	<div class="body">
		<div class="icon"><a href="<decorator:getProperty property='meta.link' />"><img src="<decorator:getProperty property='meta.icon' />" alt="" /></a></div>
		<div class="subheading"><decorator:getProperty property="meta.subtitle" /></div>
		<div class="text">
			<decorator:body />
		</div>
		<div class="footer"><decorator:getProperty property="page.footer" /></div>
	</div>
	<div class="bottom"></div>
</div>

