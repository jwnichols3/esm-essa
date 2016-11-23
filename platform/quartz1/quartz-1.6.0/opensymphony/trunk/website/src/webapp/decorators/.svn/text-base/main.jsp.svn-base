<%@ taglib prefix="ww" uri="webwork" %>
<%@ page import="java.net.URL,
                 com.opensymphony.website.Project,
                 java.util.Iterator,
                 com.opensymphony.website.Item,
                 java.util.HashMap,
                 com.opensymphony.xwork.ActionContext,
                 java.util.TreeMap,
                 java.util.ArrayList"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<%
Project project = (Project) request.getAttribute("project");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<decorator:usePage id="contentPage" />

<html>
<head>
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">

<!-- Start Google Analytics -->
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-131794-1";
urchinTracker();
</script>
<!-- End Google Analytics -->

<title><% if (project != null) { %><%= project.getName() %><% } else { %>OpenSymphony<% } %> - <decorator:title /></title>

    <style type="text/css">
    @import "/styles/main.css";
    @import "/styles/wiki.css";
    </style>

    <script>
    function onLoadFunc() {
        document.getElementById("content").style.minHeight = document.getElementById("menu").clientHeight + 'px';
    }

    function jumpToProject(select) {
        if ("none" != select.value) {
            window.location = "/" + select.value;
        }
    }
    </script>

    <decorator:head />
    <%

        if (contentPage.getProperty("page.rssLinks") != null) {
    %>
    <%= contentPage.getProperty("page.rssLinks") %>
    <%
        }
    %>

</head>

<body onload="onLoadFunc()">

<div id="wrap">

<div id="header">
<table border="0" width="100%">
<tbody>
<tr>
<td>
    <div id="logo">
        <a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath()%>/images/os-logo.gif" border=0></a>
    </div>
</td>
<%--
<td>
    <div id="sponsers">
<%
    int random = 2;
    String logo = null;
    String url = null;
    switch (random) {
        case 0:
            logo = "atlassian";
            url = "http://www.atlassian.com";
            break;
        case 1:
            logo = "jive";
            url = "http://www.jivesoftware.com";
            break;
        case 2:
            logo = "contegix";
            url = "http://www.contegix.com";
            break;
        case 3:
            logo = "formicary";
            url = "http://www.formicary.com";
            break;
        case 5:
            logo = "caucho";
            url = "http://www.caucho.com";
            break;
    }

    if (logo != null && url != null) {
%>
    <a href="<%= url %>"><img border="0" src="/images/<%= logo %>-sponsor.gif"/></a>
<%
    }
%>
    </div>
</td>
--%>
<td>

<script type="text/javascript"><!--
google_ad_client = "pub-6291771388053870";
google_ad_width = 728;
google_ad_height = 90;
google_ad_format = "728x90_as";
google_ad_type = "text_image";
google_ad_channel ="1072095954";
google_color_border = "336699";
google_color_bg = "FFFFFF";
google_color_link = "0000FF";
google_color_url = "008000";
google_color_text = "000000";
//--></script>
<script type="text/javascript"
  src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>

</td>
<td>

</td>
</tr>
</tbody>
</table>
</div>

<%--
<div id="ads">
    <script type="text/javascript"><!--
    google_ad_client = "pub-6291771388053870";
    google_ad_width = 728;
    google_ad_height = 90;
    google_ad_format = "728x90_as";
    google_ad_channel ="";
    google_color_border = "99CCFF";
    google_color_bg = "FFFFCC";
    google_color_link = "FF9900";
    google_color_url = "003399";
    google_color_text = "000000";
    //--></script>
    <script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
    </script>
</div>
--%>

<div id="content">
    <h1 class="first"><% if (project != null) { %><%= project.getName() %> - <% } %><decorator:title /></h1>

    <decorator:body />
</div>


<div id="menu">
<%
    if (project != null) {
%>
<div id="jumpTo">
<%
    ArrayList projects = new ArrayList();
    projects.add("WebWork");
    projects.add("Quartz");
    projects.add("OSCache");
    projects.add("OSWorkflow");
    projects.add("SiteMesh");
    projects.add("Compass");
    //projects.add("TestNG");
    projects.add("OGNL");
    projects.add("Tonic");
    projects.add("XWork");
    projects.add("OSUser");
    projects.add("PropertySet");
    projects.add("OSCore");
    projects.add("ClickStream");
    request.setAttribute("projects", projects);
%>
<ww:select theme="simple" name="jump" list="#attr.projects" listKey="top.toLowerCase()" headerKey="none" headerValue="Jump to..." onchange="jumpToProject(this)"/>
</div>
<div class="menuGroup">
    <h1><%= project.getName() %></h1>
    <ul>
        <li><a href="/<%= project.getId() %>/">About</a></li>
        <li><a href="/<%= project.getId() %>/news.action">News</a></li>
        <li><a href="/<%= project.getId() %>/changelog.action">Changelog</a></li>
    </ul>
</div>
<div class="menuGroup">
    <h1>Evaluating <%= project.getName() %></h1>
    <ul>
        <li><a href="/<%= project.getId() %>/license.action">License</a></li>
        <li><a href="/<%= project.getId() %>/download.action">Download</a></li>
        <%
        Item[] items = project.getEvaluating();
        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                Item item = items[i];
        %>
        <li><a href="<%= item.getAbsoluteUrl(project.getId()) %>"><%= item.getName() %></a></li>
        <%
            }
        }
        %>
    </ul>
</div>
<div class="menuGroup">
    <h1>Using <%= project.getName() %></h1>
    <ul>
        <%
            if (!project.getDocs().isCustomUrl()) {
        %>
        <li><a href="/<%= project.getId() %>/documentation.action">Documentation</a></li>
        <%
            } else {
        %>
        <li><a href="<%= project.getDocs().getUrl() %>">Documentation</a></li>
        <%
            }
        %>
        <%
        items = project.getDocs().getItems();
        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                Item item = items[i];
        %>
        <li><a href="<%= item.getAbsoluteUrl(project.getId()) %>"><%= item.getName() %></a></li>
        <%
            }
        }
        %>
        <li><a href="/<%= project.getId() %>/userForums.action">User Forums</a></li>
        <%
            if (!project.getDocs().isNoJavaDoc()) {
        %>
        <li><a href="/<%= project.getId() %>/api">JavaDoc</a></li>
        <%
            }
        %>
        <li><a href="/<%= project.getId() %>/reporting.action">Reporting Issues</a></li>
    </ul>
</div>
<div class="menuGroup">
    <h1>Developing <%= project.getName() %></h1>
    <ul>
        <li><a href="/<%= project.getId() %>/contribute.action">How to Contribute</a></li>
        <%
        if (project.getForums().getDevId() > 0) {
        %>
        <li><a href="/<%= project.getId() %>/devForums.action">Developer Forums</a></li>
        <%
        }
        %>
        <li><a href="/<%= project.getId() %>/members.action">Development Team</a></li>
        <li><a href="/<%= project.getId() %>/cvs.action">Source Repository</a></li>
    </ul>
</div>
<%
    } else {
%>
<div class="menuGroup">
    <h1>The Projects</h1>
    <ul>
        <%@ include file="projectList.jsp" %>
    </ul>
</div>
<div class="menuGroup">
    <h1>The Community</h1>
    <ul>
        <li><a href="/">Latest News</a></li>
        <li><a href="http://forums.opensymphony.com">Forums</a></li>
        <li><a href="http://wiki.opensymphony.com">Wiki</a></li>
        <li><a href="http://jira.opensymphony.com">Bug Tracker</a></li>
        <li><a href="http://opensymphony.dev.java.net">java.net</a></li>
    </ul>
</div>
<div class="menuGroup">
    <h1>The Team</h1>
    <ul>
        <li><a href="/team.jsp">Contacting</a></li>
        <li><a href="/involved.jsp">Getting Involved</a></li>
        <li><a href="/sponsors.jsp">Sponsors</a></li>
    </ul>
</div>
<%
    }
%>

<p/>

<script type="text/javascript"><!--
google_ad_client = "pub-6291771388053870";
google_ad_width = 120;
google_ad_height = 240;
google_ad_format = "120x240_as";
google_ad_type = "text_image";
google_ad_channel ="1072095954";
google_color_border = "336699";
google_color_bg = "FFFFFF";
google_color_link = "0000FF";
google_color_url = "008000";
google_color_text = "000000";
//--></script>
<script type="text/javascript"
  src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>

</div>

<div id="footer">
    <li><a href="http://forums.opensymphony.com">Forums</a></li>
    <li><a href="http://wiki.opensymphony.com">Wiki</a></li>
    <li><a href="http://jira.opensymphony.com">Bug Tracker</a></li>
    <li><a href="http://opensymphony.dev.java.net">java.net</a></li>
    <li><a href="/">Latest News</a></li>
    <li><a href="/team.jsp">Contacting</a></li>
    <li><a href="/involved.jsp">Getting Involved</a></li>
    <li class="last"><a href="/sponsors.jsp">Sponsors</a></li>


    <p/>

    Copyright 2000-2005 - <a href="/team.jsp">OpenSymphony</a>
</div>

</div>

</body>
</html>
