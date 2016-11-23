<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/xml" prefix="x" %>
<%-- Properties: title, meta.icon, meta.link --%>
<%-- Requires page.tabs content block containing set of <tab id=x href=y text=z/> --%>
<style type="text/css" media="all">@import "<%= request.getContextPath() %>/decorators/header/style.css";</style>

<x:parse var="tabs">
	<tabs>
		<decorator:getProperty property="page.tabs"/>
	</tabs>
</x:parse>

<decorator:usePage id="content"/>
<c:set var="activeTab"><%= content.getProperty("activeTab") %></c:set>

<div id="header">
	<div class="top"></div>
	<div class="body">
		<div class="logo"><a href="<%= request.getContextPath() %>"><img src="<%= request.getContextPath() %>/icons/sitemesh-big.gif" alt="&lt;SiteMesh&gt;" width="240" height="36" /></a></div>
		<div class="cutout">
			<decorator:body />
		</div>
	</div>
	<div class="bottom">
		<x:forEach var="tab" select="$tabs//tab">

			<%-- When tags go bad... --%>
			<x:set var="id" select="string(@id)" />
			<c:if test='${id==activeTab}'>
				<div class="tabActive">
			</c:if>
			<c:if test='${id!=activeTab}'>
				<div class="tabInactive">
			</c:if>

				<div class="left"></div>
				<div class="middle">
					<div class="text"><a href="<x:out select='@href'/>"><x:out select="@text"/></a></div>
				</div>
				<div class="right"></div>
			</div>
		</x:forEach>
	</div>
</div>

