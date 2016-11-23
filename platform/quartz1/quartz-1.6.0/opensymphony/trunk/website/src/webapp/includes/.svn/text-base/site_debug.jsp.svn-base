<% if ( request.getParameter("debug") != null ) { %>
<font size="-2">
<p>
<b><u>Site Debugging</u></b><br>
<decorator:usePage id="debug_p" />
<b>Generation Time:</b> <%= System.currentTimeMillis() - start.getTime() %>ms<br>
<b>Decorator:</b> <%= request.getRequestURI() %><br>
<b>URI:</b> <%= debug_p.getRequest().getServletPath() %><br>
</font>
<% } %>