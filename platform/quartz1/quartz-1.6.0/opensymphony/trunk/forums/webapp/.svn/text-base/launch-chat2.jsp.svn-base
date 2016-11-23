<%@ page import="com.jivesoftware.forum.ForumFactory" %>
<%@ page import="com.jivesoftware.util.StringUtils" %>
<%@ page import="com.jivesoftware.webchat.ChatManager" %>
<%@ page import="com.jivesoftware.webchat.user.UserSession" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.jivesoftware.base.*"%>
<%!
    private boolean validChatID(String chatID, String chatroom) {
        if (chatID == null) {
            return false;
        }

        ChatManager chatManager = ChatManager.getInstance();
        UserSession userSession = chatManager.getUserSession(chatID);
        if (userSession == null || !userSession.isActive()) {
            return false;
        }

        try {
            userSession.getGroupChatSession(chatroom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
%>
<%
    String chatroom = request.getParameter("chatroom");
    String chatID = (String) session.getAttribute("chatID");
    AuthToken authToken = AuthFactory.getAuthToken(request, response);
    long userID = authToken.getUserID();
    User user = ForumFactory.getInstance(authToken).getUserManager().getUser(userID);
    String conferenceServer = "conference." + JiveGlobals.getJiveProperty("chat.server");
    String password = request.getParameter("password");
    if (password == null) {
        password = (String) session.getAttribute("chatPassword");
    }

    // validate password before trying to redirect
    try {
        AuthFactory.getAuthToken(user.getUsername(), password);
        session.setAttribute("chatPassword", password);
    } catch (UnauthorizedException e) {
        // uh! bad password given... send back to launch-chat.jsp
        session.setAttribute("chatPassword", null);
        response.sendRedirect("launch-chat.jsp?error=true");
        return;
    }

    chatroom = chatroom + "@" + conferenceServer;
    if (!validChatID(chatID, chatroom)) {
        com.jivesoftware.webchat.user.UserManager um = new com.jivesoftware.webchat.user.UserManager();
        chatID = StringUtils.randomString(8);
        Map errors = um.login(user.getUsername(), password, user.getUsername(), chatID);
        if (errors == null || errors.isEmpty()) {
            session.setAttribute("chatID", chatID);
        }
    }

    response.sendRedirect("groupchat/queue.jsp?roomName=" + chatroom + "&nickname=" + user.getUsername() + "&chatID=" + chatID);
%>