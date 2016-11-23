<%@ taglib prefix="ww" uri="webwork" %>
<%@ page import="com.opensymphony.website.Project,
                 java.io.File"%>
<ww:push value="#attr.project">
<html>
    <head>
        <title>News</title>
    </head>

    <body><%
    Project project = (Project) request.getAttribute("project"); // TODO check if request can be retrieved from ww
    File blog = new File("/var/www/domains/opensymphony.com/blogs/htdocs/" + project.getId() + "/website.html");
    
    if (blog.exists()) { %> 
        <%= com.opensymphony.util.FileUtils.readFile(blog) %>
    <% } else { %>

        <ww:property value="name"/> news is under construction at the moment. In the meantime, please
        use the OpenSymphony <a href="/">news</a> to keep up with all OpenSymphony project releases.
        <p/>

        <a href="http://wiki.opensymphony.com/spaces/blogrss.action?key=OS"><img border="0" src="/images/rss.gif"/></a>
    	
    <% } %>
    </body>
</html>
</ww:push>
