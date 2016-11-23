<%@ page import="org.jdom.input.SAXBuilder,
                 org.jdom.Element,
                 java.net.URL,
                 java.util.List,
                 java.text.SimpleDateFormat,
                 java.util.Iterator,
                 java.util.Date"%>
<%@ taglib uri="/oscache" prefix="cache" %>
<html>
    <head>
        <title>Welcome To OpenSymphony</title>
        <meta name="sidebar.type" content="wide">
    </head>

    <body>
        <p>
            OpenSymphony is an Open Source project dedicated to providing
            enterprise class J2EE components. Our components aim to stress
            simplicity, integration, pluggability and specification compliance.
        </p>

        <p>See <a href="whatis.html">What Is OpenSymphony?</a> and the
        <a href="components.html">OpenSymphony Components</a> for more detail.</p>

        <h3>Contribute</h3>
        <p>
            We love people who contribute.
            Software, development time, testing time, code, praise or abuse - we don't care.
        </p>
        <p>
            If you think you can help out, why not <a href="/contact.jsp">contact us</a> today.
        </p>

        <h3>Latest News</h3>

        <cache:cache key="news" scope="application" >

        <%
            try {
            SAXBuilder s = new SAXBuilder(false);
            Element root = s.build(new URL("http://wiki.opensymphony.com/spaces/blogrss.action?key=OS")).getRootElement();
            List children = root.getChild("channel").getChildren("item");
            int i = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat outSdf = new SimpleDateFormat("EEEEEE MMMMM dd, yyyy");
            int displace = "http://wiki.opensymphony.com//display/OS/".length();
            for (Iterator iterator = children.iterator(); iterator.hasNext() && i < 7; i++) {
                Element item = (Element) iterator.next();
                String link = item.getChildText("link");
                String substring = link.substring(displace, displace + 10);
                Date date = sdf.parse(substring);

                if (date.after(new Date(2004 - 1900, 0, 1))) {
        %>
            <div class="day"><%= outSdf.format(date) %></div>
            <a href="<%= link %>"><h4><%= item.getChildText("title") %></h4></a>
            <div class="item">
                <%= item.getChildText("description") %>
            </div>
        <%
                }
            }
            } catch (Exception e) {
        %>
            <cache:usecached />
        <%
            }
        %>

        </cache:cache>

    </body>
</html>


