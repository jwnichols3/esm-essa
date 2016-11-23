<%@ page import="com.jivesoftware.util.StringUtils"%>
<%@ page import="java.util.List"%>
<%@ page import="com.opensymphony.forums.chat.ChatMonitor"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.jivesoftware.forum.StatusLevelManager"%>
<%@ page import="com.jivesoftware.forum.ForumFactory"%>
<%@ page import="com.jivesoftware.forum.StatusLevel"%>
<%@ page import="com.jivesoftware.base.*"%>
<%@ page import="com.jivesoftware.forum.util.SkinUtils"%><div class="jive-portlet-box">
<%
    String chatroom = request.getParameter("chatroom");
    String frameName = "frame" + StringUtils.randomString(2);
%>
<table cellpadding="3" cellspacing="0" border="0" width="200">
<thead>
    <tr>
        <th colspan="2">
            Chatting now (<a href="javascript:launchWin('<%= frameName %>','launch-chat.jsp?chatroom=<%= chatroom %>',678,496);">Join!</a>)
        </th>
    </tr>
</thead>
<tbody>
<%
    List users = ChatMonitor.getMonitor().getUsersInRoom(chatroom);
    AuthToken authToken = null;
    try {
        authToken = AuthFactory.getAuthToken(request, response);
    } catch (UnauthorizedException e) {
        authToken = AuthFactory.getAnonymousAuthToken();
    }
    ForumFactory ff = ForumFactory.getInstance(authToken);
    UserManager um = ff.getUserManager();
    StatusLevelManager slm = ff.getStatusLevelManager();
    for (Iterator iterator = users.iterator(); iterator.hasNext();) {
        String username = (String) iterator.next();
        StatusLevel level = null;
        User user = null;
        int points = 0;
        try {
            user = um.getUser(username);
            level = slm.getStatusLevel(user);
            points = slm.getPointLevel(user);
        } catch (UserNotFoundException e) {
        }%>
    <tr>
        <td width="1%">
                    <%  if (level != null) { %>
                <img src="<%= level.getImagePath() %>" border="0" title="<%= StringUtils.escapeHTMLTags(level.getName()) %>" alt="" />
                    <%  } else { %>
                &nbsp;
                    <%  } %>
        </td>
        <td width="99%">
            <a href="profile.jspa?userID=<%= user.getID() %>"
             title="<%= StringUtils.escapeHTMLTags(SkinUtils.getDisplayName(user)) %>"
             ><%= StringUtils.escapeHTMLTags(StringUtils.chop(SkinUtils.getDisplayName(user),15)) %></a>
            (<%= points %>)
        </td>
    </tr>
<%
    }
%>
</tbody>
</table>
</div>
