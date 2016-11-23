<%@ page import="com.jivesoftware.base.AuthFactory" %>
<%@ page import="com.jivesoftware.base.UnauthorizedException" %><%
    if (session.getAttribute("chatPassword") != null) {
        response.sendRedirect("launch-chat2.jsp?chatroom=" + request.getParameter("chatroom"));
        return;
    }

    boolean authenticated = false;
    try {
        AuthFactory.getAuthToken(request, response);
        authenticated = true;
    } catch (UnauthorizedException e) {
    }
%>
<html>
<head>
    <title>Verify Password</title>
</head>

<body>
<%
    if (authenticated) {
        if (request.getParameter("error") != null) {
%>
<font color="red">The password you entered is invalid, please try again.</font>
<hr/>
<%
    }
%>

Please verify your identify by re-entering your password:
<p/>

<form action="launch-chat2.jsp" method="post">
    <input type="hidden" name="chatroom" value="<%= request.getParameter("chatroom") %>"/>
    <input type="password" name="password"/>
    <input type="submit" value="Chat Now"/>
</form>
<%
    } else {
%>
<font color="red">We're sorry, chat is only available for registered users.</font>
<%
    }
%>
</body>
</html>