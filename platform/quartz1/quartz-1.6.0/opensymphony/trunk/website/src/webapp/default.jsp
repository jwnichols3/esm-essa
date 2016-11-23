<%@ page import="org.jdom.input.SAXBuilder,
                 org.jdom.Element,
                 java.net.URL,
                 java.util.List,
                 java.text.SimpleDateFormat,
                 java.util.Iterator,
                 java.util.Date"%>
<%@ taglib uri="cache" prefix="cache" %>
<html>
    <head>
        <title>Welcome To OpenSymphony</title>
    </head>

    <body>
        OpenSymphony is an Open Source project dedicated to providing enterprise class J2EE components. Our components
        aim to stress simplicity, integration, pluggability and specification compliance. Please see the individual
        projects for more information.

		<hr/>
		
		<%= com.opensymphony.util.FileUtils.readFile(new java.io.File("/var/www/domains/opensymphony.com/blogs/htdocs/opensymphony/website.html")) %>

    </body>
</html>


