<%--
  - $RCSfile$
  - $Revision: 189 $
  - $Date: 2005-07-27 16:20:07 -0700 (Wed, 27 Jul 2005) $
  -
  - Copyright (C) 1999-2004 Jive Software. All rights reserved.
  -
  - This software is the proprietary information of Jive Software.  Use is subject to license terms.
--%>

<%@ page import="com.jivesoftware.forum.action.ForumAction,
                 com.jivesoftware.forum.util.SkinUtils,
                 java.util.Iterator,
                 com.jivesoftware.forum.*,
                 com.jivesoftware.base.*,
                 com.jivesoftware.forum.action.util.*,
                 com.jivesoftware.util.StringUtils,
                 com.jivesoftware.util.LocaleUtils,
                 com.jivesoftware.base.action.util.DateUtils,
                 com.jivesoftware.base.action.ActionUtils,
                 com.jivesoftware.base.PollManager,
                 com.jivesoftware.base.PollManagerFactory,
                 com.jivesoftware.base.Poll,
                 com.jivesoftware.base.action.rss.RSSActionSupport,
                 com.jivesoftware.forum.stats.ViewCountManager"
    contentType="text/html"
    errorPage="error.jsp"
%>
<%@ page import="com.jivesoftware.webchat.user.*"%>

<%@ taglib uri="webwork" prefix="ww" %>
<%@ taglib uri="jivetags" prefix="jive" %>

<%  // Get the action for this view.
    ForumAction action = (ForumAction)ActionUtils.getAction();
    Forum forum = action.getForum();
    boolean isGuest = action.isGuest();
    // Create a date util object for nice date formatting:
    DateUtils dateUtils = new DateUtils(request, action.getPageUser());
    // Root category in the system
    ForumCategory rootCategory = action.getForumFactory().getRootForumCategory();
%>

<head>
    <title><%= StringUtils.escapeHTMLTags(forum.getName()) %></title>

    <%  if (JiveGlobals.getJiveBooleanProperty("rss.enabled", true)) { %>
        <link rel="alternate" type="application/rss+xml" title="RSS"
         href="<%= RSSActionSupport.getDefaultBaseURL() %>/rss/rssmessages.jspa?forumID=<%= forum.getID() %>">
    <%  } %>
</head>


<div id="jive-forumpage">

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr valign="top">
    <td width="98%">

        <jsp:include page="breadcrumbs.jsp"  />

        <p class="jive-page-title">
        <%-- Forum: [forum name] --%>
        <ww:text name="'global.forum'" /><ww:text name="'global.colon'" /> <%= forum.getName() %>
        </p>

        <%-- [forum description] --%>
        <%  if (forum.getDescription() != null) { %>
            <p class="jive-description">
            <%= forum.getDescription() %>
            </p><br>
        <%  } %>

        <%  if (!isGuest && JiveGlobals.getJiveBooleanProperty("watches.enabled",true)) { %>

            <%  if (action.getForumFactory().getWatchManager().isWatched(action.getPageUser(), forum)) { %>

                <div class="jive-info-message">
                <table summary="Information" cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                    <tr valign="top">
                        <td width="1%" class="jive-icon">
                            <img src="images/info-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'global.info'" />">
                        </td>
                        <td width="99%" class="jive-icon-label">
                            <%-- You are watching this forum. To remove this watch, click "Stop Watching Forum" below. --%>
                            <ww:text name="'forum.watching_forum'" />
                            <%-- More watch options --%>
                            <a href="editwatches!default.jspa"><ww:text name="'global.watch_options'" /></a>
                        </td>
                    </tr>
                </tbody>
                </table>
                </div>

            <%  } %>

        <%  } %>

    </td>
    <td width="1%"><img src="images/blank.gif" width="10" height="1" border="0" alt=""></td>
    <td width="1%">

        <%@ include file="accountbox.jsp" %>

    </td>
</tr>
</table>

<div class="jive-buttons">
<table summary="Buttons" cellpadding="0" cellspacing="0" border="0">
<tr>
    <%  if (!"true".equals(forum.getProperty("jiveDisablePostLinks"))) { %>

            <td class="jive-icon">
                <a href="post!default.jspa?forumID=<%= forum.getID() %>"
                 ><img src="images/post-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'global.post_new_thread'" />"></a>
            </td>
            <td class="jive-icon-label">
                <%-- Post New thread --%>
                <a id="jive-post-thread" href="post!default.jspa?forumID=<%= forum.getID() %>"
                 ><ww:text name="'global.post_new_thread'" /></a>
            </td>

    <%  } %>

    <%  if (!isGuest && JiveGlobals.getJiveBooleanProperty("announcements.enabled",true)
                && action.getCanPostAnnounce(forum))
        {
    %>
        <td class="jive-icon">
            <a href="annpost!default.jspa?forumID=<%= forum.getID() %>"
             ><img src="images/announce-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'announce.postTitle'" />"></a>
        </td>
        <td class="jive-icon-label">
            <%-- Post Announcement --%>
            <a href="annpost!default.jspa?forumID=<%= forum.getID() %>"
             ><ww:text name="'announce.postTitle'" /></a>
        </td>

    <%  } %>

    <%  if (!isGuest && JiveGlobals.getJiveBooleanProperty("polls.enabled",true)
            && action.getCanCreatePoll(forum))
        {
    %>
        <td class="jive-icon">
            <a href="pollpost!default.jspa?forumID=<%= forum.getID() %>"
             ><img src="images/poll-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'polls.create'" />"></a>
        </td>
        <td class="jive-icon-label">
            <%-- Create Poll --%>
            <a href="pollpost!default.jspa?forumID=<%= forum.getID() %>"
             ><ww:text name="'polls.create'" /></a>
        </td>

    <%  } %>

    <%  if (!isGuest && JiveGlobals.getJiveBooleanProperty("watches.enabled",true)) { %>

        <td class="jive-icon">
            <%  boolean isWatching = action.getForumFactory().getWatchManager().isWatched(action.getPageUser(), forum);
                if (isWatching) {
            %>
                <a href="watches!remove.jspa?forumID=<%= forum.getID() %>"
                 ><img src="images/watch-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'forum.stop_watch'" />"></a>

            <%  } else { %>

                <a href="watches!add.jspa?forumID=<%= forum.getID() %>"
                 ><img src="images/watch-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'global.watch_forum'" />"></a>

            <%  } %>
        </td>
        <td class="jive-icon-label">

            <%  if (isWatching) { %>

                <%-- stop watching forum --%>
                <a href="watches!remove.jspa?forumID=<%= forum.getID() %>"
                 ><ww:text name="'forum.stop_watch'" /></a>

            <%  } else { %>

                <%-- Watch Forum --%>
                <a href="watches!add.jspa?forumID=<%= forum.getID() %>"
                 ><ww:text name="'global.watch_forum'" /></a>

            <%  } %>
        </td>

    <%  } %>

    <%  if (!isGuest && JiveGlobals.getJiveBooleanProperty("readTracker.enabled",true)) { %>

        <%  if (action.getForumFactory().getReadTracker().getUnreadThreadCount(action.getPageUser(),forum) > 0) { %>

            <td class="jive-icon">
                <%  if (action.getStart() == 0) { %>
                    <a href="markread.jspa?forumID=<%= forum.getID() %>"
                <%  } else { %>
                    <a href="markread.jspa?forumID=<%= forum.getID() %>&amp;start=<%= action.getStart() %>"
                <%  } %>
                 ><img src="images/markread-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'global.mark_all_threads_as_read'" />"
                 ></a>
            </td>
            <td class="jive-icon-label">
                <%-- Mark All threads as Read --%>
                <%  if (action.getStart() == 0) { %>
                    <a href="markread.jspa?forumID=<%= forum.getID() %>"
                <%  } else { %>
                    <a href="markread.jspa?forumID=<%= forum.getID() %>&amp;start=<%= action.getStart() %>"
                <%  } %>
                 ><ww:text name="'global.mark_all_threads_as_read'" /></a>
            </td>

        <%  } %>

    <%  } %>

    <td class="jive-icon">
        <a href="index.jspa"
         ><img src="images/arrow-left-16x16.gif" width="16" height="16" border="0" alt="<ww:text name="'global.go_back_to_category'" />"
         ></a>
    </td>
    <td class="jive-icon-label">

        <%  if (forum.getForumCategory().getParentCategory() == null
                    || forum.getForumCategory().getParentCategory().getID() == rootCategory.getID())
            {
        %>
            <%-- Back to Forum List --%>
            <a href="index.jsp?categoryID=1"><ww:text name="'forum.forum_list'" /></a>

        <%  } else { %>

            <%-- Back to Category --%>
            <a href="category.jspa?categoryID=<%= forum.getForumCategory().getID() %>"
             ><ww:text name="'global.go_back_to_category'" /></a>

        <%  } %>

    </td>
</tr>
</table>
</div>

<br>

<input type="hidden" name="dateRange" value="last90days">

<%  // Get a paginator for this action. Since the action implements Pageable, just pass
    // in the action object to the Paginator constructor
    Paginator paginator = new Paginator(action);
%>

<table cellpadding="3" cellspacing="0" border="0" width="100%">
<tr valign="top">
    <td>

        <%@ include file="foruminfo.jspf" %>

        <jive:cache id="paginator">

        <%  if (paginator.getNumPages() > 1) { %>
            -
            <span class="nobreak">
            <ww:text name="'global.pages'" /><ww:text name="'global.colon'" />
            <%=  LocaleUtils.getLocalizedNumber(paginator.getNumPages(), action.getLocale()) %> -

                <span class="jive-paginator">
                [
                <%  if (paginator.getPreviousPage()) { %>
                    <%-- Previous --%>
                    <a href="forum.jspa?forumID=<%= forum.getID() %>&amp;start=<%= paginator.getPreviousPageStart() %>"
                     ><ww:text name="'global.previous'" /></a> |
                <%  } %>

                <%  Page[] pages = paginator.getPages(5);
                    for (int i=0; i<pages.length; i++) {
                %>
                    <%  if (pages[i] == null) { %>
                        <ww:text name="'global.elipse'" />
                    <%  } else { %>
                        <a href="forum.jspa?forumID=<%= forum.getID() %>&amp;start=<%= pages[i].getStart() %>"
                         class="<%= ((paginator.getStart()==pages[i].getStart())?"jive-current":"") %>"
                         ><%= pages[i].getNumber() %></a>
                     <% } %>
                <%  } %>

                <%  if (paginator.getNextPage()) { %>
                    <%-- Next --%>
                    | <a href="forum.jspa?forumID=<%= forum.getID() %>&amp;start=<%= paginator.getNextPageStart() %>"
                     ><ww:text name="'global.next'" /></a>
                <%  } %>
                ]
                </span>
            </span>
        <%  } %>

        </jive:cache>

    </td>
</tr>
</table>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tbody>
<tr valign="top">
    <td width="99%">

        <div class="jive-thread-list">
        <div class="jive-table">
        <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th class="jive-first" colspan="3">
                    <div class="jive-forum-name">
                    <%-- thread --%>
                    <ww:text name="'global.thread'" />
                    </div>
                </th>
                <th class="jive-author">
                    <%-- Author --%>
                    <nobr>
                    <ww:text name="'global.author'" />
                    &nbsp;
                    </nobr>
                </th>

                <%  if (ViewCountManager.isViewCountsEnabled()) { %>

                    <th class="jive-view-count">
                        <%-- Views --%>
                        <nobr>
                        <ww:text name="'global.views'" />
                        &nbsp;
                        </nobr>
                    </th>

                <%  } %>

                <th class="jive-msg-count">
                    <%-- Replies --%>
                    <ww:text name="'global.replies'" />
                </th>
                <th class="jive-last" nowrap>
                    <div class="jive-date">
                    <%-- Last Post --%>
                    <ww:text name="'global.last_post'" />
                    </div>
                </th>
            </tr>
        </thead>

        <%-- Print all forums in the current category --%>

        <tbody>

        <%  Iterator threads = action.getThreads();
            boolean isModerator = action.isModerator(forum);
            boolean annEnabled = JiveGlobals.getJiveBooleanProperty("announcements.enabled",true);
            Iterator announcements = action.getAnnouncements();
            if (!threads.hasNext() && (annEnabled && !announcements.hasNext())) {
        %>
            <tr>
                <td class="jive-first-last" colspan="7">
                    <%-- No threads in this forum or filter. --%>
                    <ww:text name="'global.no_threads_in_forum_or_filter'" />
                </td>
            </tr>

        <%  } %>

        <%  int status = 0; %>

        <%  if (annEnabled && paginator.getPageIndex() == 0) {
                while (announcements.hasNext()) {
                    Announcement announcement = (Announcement)announcements.next();
        %>
            <%@ include file="announcement-row.jspf" %>

        <%      }
            }
        %>

        <%  boolean showForumColumn = false;
            boolean shortLastPost = false;
            RewardManager rewardManager = null;
            boolean rewardsEnabled = "true".equals(JiveGlobals.getJiveProperty("rewards.enabled"));
            if (rewardsEnabled) {
                rewardManager = action.getForumFactory().getRewardManager();
            }
            WatchManager watchManager = null;
            boolean watchesEnabled = JiveGlobals.getJiveBooleanProperty("watches.enabled",true);
            if (watchesEnabled) {
                watchManager = action.getForumFactory().getWatchManager();
            }
            while (threads.hasNext()) {
                ForumThread thread = (ForumThread)threads.next();
        %>
            <%@ include file="thread-row.jsp" %>

        <%  } %>

        </tbody>
        </table>
        </div>
        </div>

        <table cellpadding="3" cellspacing="0" border="0" width="100%">
        <tr>
            <td width="99%"><jive:cache id="paginator" /></td>
            <td width="1%">

                <%  if (JiveGlobals.getJiveBooleanProperty("rss.enabled", true)) { %>

                    <a href="rss.jspa?feed=rss/rssmessages.jspa?forumID=<%= forum.getID() %>"
                     ><img src="images/rss-24x16.gif" width="24" height="16" border="0" alt="<ww:text name="'global.rss_message'" />" vspace="2"></a>

                <%  } else { %>

                    &nbsp;

                <%  } %>

            </td>
        </tr>
        </table>

        <%-- Icon Legend --%>
        <%  boolean showAllLegendIcons = true; %>
        <%@ include file="icon-legend.jspf" %>

    </td>
    <td width="1%">

        <% if (JiveGlobals.getJiveBooleanProperty("search.enabled", true)) { %>

            <form action="search.jspa" id="jive-searchform">
            <div class="jive-portlet-box">
            <table cellpadding="3" cellspacing="0" border="0" width="200">
            <thead>
                <tr>
                    <th colspan="2">
                    	<%-- Search Forum --%>
                        <ww:text name="'global.search_forum'" />
                    </th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td width="99%" class="jive-search-form">

                    <input type="hidden" name="objID" value="f<%= forum.getID() %>">
                    <input type="text" name="q" value="" size="20" maxlength="100" id="q01" accesskey="s"
                         title="<ww:text name="'global.search_forum'" /> (ALT+S)" style="width:100%">

                </td>
                <td width="1%" class="jive-search-form">
                    <input type="submit" value="<ww:text name="'global.go'" />">
                </td>
            </tr>
            </tbody>
            </table>
            </div>
            </form>

        <%  } %>

        <%
            if (forum.getProperty("chatroom") != null) {
        %>
        <jsp:include page="/chat-portlet.jsp">
            <jsp:param name="chatroom" value="<%= forum.getProperty("chatroom") %>"/>
        </jsp:include>
        <%
            }
        %>


        <jsp:include page="status-level-leaders.jspa">
            <jsp:param name="forumID" value="<%= String.valueOf(forum.getID()) %>"/>
        </jsp:include>

        <%  if (JiveGlobals.getJiveBooleanProperty("polls.enabled",true)) { %>

            <%  PollManager pollManager = PollManagerFactory.getInstance();
                int numPolls = pollManager.getActivePollCount(JiveConstants.FORUM, forum.getID());
                if (numPolls > 0) {
                    // Get the latest Poll:
                    Iterator polls = pollManager.getActivePolls(JiveConstants.FORUM, forum.getID());
                    Poll poll = (Poll)polls.next();
                    boolean hasVoted = false;
                    if (action.getPageUser() != null) {
                        hasVoted = poll.hasUserVoted(action.getPageUser());
                    }
            %>
                <form action="pollvote.jspa">
                <input type="hidden" name="pollID" value="<%= poll.getID() %>">

                <div class="jive-portlet-box">
                <table cellpadding="3" cellspacing="0" border="0" width="200">
                <thead>
                    <tr>
                        <th colspan="3">
                            <%-- Latest Forum Poll --%>
                            <ww:text name="'polls.latest_forum_poll'" />
                        </th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td width="1%" valign="top">
                        <a href="poll.jspa?pollID=<%= poll.getID() %>"
                         ><img src="images/poll-16x16.gif" alt="" border="0" height="16" width="16"></a>
                    </td>
                    <td width="99%" colspan="2">
                        <b><%= poll.getName() %></b>
                        <br>
                        <%-- Votes: --%>
                        <ww:text name="'polls.votes'" /><ww:text name="'global.colon'" />
                        <%= LocaleUtils.getLocalizedNumber(poll.getVoteCount(),action.getLocale()) %>
                    </td>
                </tr>

                <%  // Show poll results if the user is a guest or if the page user has already
                    // voted.
                    if (isGuest || hasVoted) {
                %>

                    <tr>
                        <td colspan="3" width="100%">
                            <table cellpadding="2" cellspacing="0" border="0" width="100%">

                            <%  // Print options
                                for (int i=0; i<poll.getOptionCount(); i++) {
                                    double percent = (poll.getVoteCount() == 0 ? 0.0 :
                                        ((double)poll.getVoteCount(i)/(double)poll.getVoteCount())*100.0);
                            %>
                                <tr>
                                    <td width="1%" align="right" valign="top">
                                        <%= (int)percent %>%
                                    </td>
                                    <td width="99%">
                                        <span class="jive-description">
                                        <%= StringUtils.escapeHTMLTags(poll.getOption(i)) %>
                                        </span><br>
                                        <%  if (percent > 0.0) { %>
                                            <div>
                                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                            <tr>
                                                <td>
                                                    <img src="images/poll-bar-16x16.gif" height="8" width="<%= (int) percent %>%" border="1" alt="<%= (int)percent %>%">
                                                </td>
                                            </tr>
                                            </table>
                                            </div>
                                        <%  } %>
                                    </td>
                                </tr>

                            <%  } %>

                            </table>
                        </td>
                    </tr>

                <%  } else if (!isGuest && !hasVoted) { %>

                    <%  // Print options
                        for (int i=0; i<poll.getOptionCount(); i++) {
                            String option = poll.getOption(i);
                    %>
                        <tr>
                            <td width="1%">&nbsp;</td>
                            <td width="1%">
                                <input type="radio" name="option" value="<%= i %>" id="jive-vote-<%= i %>">
                            </td>
                            <td width="98%" style="padding-top:4px;">
                                <label for="jive-vote-<%= i %>"><%= option %></label>
                            </td>
                        </tr>

                    <%  } %>

                    <tr>
                        <td width="1%">
                            &nbsp;
                        </td>
                        <td width="99%" colspan="2">
                        	<%-- Vote! --%>
                            <input type="submit" name="vote" value="<ww:text name="'polls.voteButton'" />">
                            <%  if (numPolls > 1) { %>
                            	<%-- More Polls --%>
                                <input type="submit" name="more" value="<ww:text name="'polls.morePollsButton'" />"
                                 onclick="location.href='polls.jspa?forumID=<%= forum.getID() %>'; return false;">
                            <%  } %>
                        </td>
                    </tr>

                <%  } %>

                <tr>
                    <td width="1%">
                        &nbsp;
                    </td>
                    <td width="99%" colspan="2" align="right">
                    	<%-- Full Results --%>
                        <a href="poll.jspa?pollID=<%= poll.getID() %>"><ww:text name="'polls.fullResults'" /></a>

                        <%  if (!isGuest && action.getCanCreatePoll(forum)) { %>

							<%-- Edit --%>
                            - <a href="polledit!default.jspa?pollID=<%= poll.getID() %>"><ww:text name="'global.edit'" /></a>
                            <%-- Post New --%>
                            - <a href="pollpost!default.jspa?forumID=<%= forum.getID() %>"><ww:text name="'global.post_new'" /></a>

                        <%  } %>
                    </td>
                </tr>
                </tbody>
                </table>
                </div>

                </form>

            <%  } %>

        <%  } %>

        <%
            // Show popular threads
            Iterator popularThreads = forum.getPopularThreads();
        %>

        <%  if (popularThreads.hasNext()) { %>

            <div class="jive-portlet-box">
            <table cellpadding="3" cellspacing="0" border="0" width="200">
            <thead>
                <tr>
                    <th colspan="2">
                    	<%-- Popular Forum Threads --%>
						<ww:text name="'popularthreads.popular_discussions'"/>
                    </th>
                </tr>
            </thead>
            <tbody>

            <%  while (popularThreads.hasNext()) {
                    ForumThread popThread = (ForumThread)popularThreads.next();
                    String display = popThread.getName();
                    if (display.length() > 24) {
                        display = StringUtils.chopAtWord(display, 24) + "...";
                    }
                    ForumMessage lastThreadPost = popThread.getLatestMessage();
                    String userdisplay = (!lastThreadPost.isAnonymous() ? lastThreadPost.getUser().getUsername() : null);
                    if (userdisplay == null && lastThreadPost.isAnonymous()) {
                        Guest guest = new Guest();
                        guest.setMessage(lastThreadPost);
                        userdisplay = guest.getDisplay();
                    }
            %>
                <tr>
                    <td width="1%">
                        <img src="images/post-16x16.gif" alt="" border="0" height="16" width="16">
                    </td>
                    <td width="99%">
                        <a href="thread.jspa?threadID=<%= popThread.getID() %>"><%= display %></a>
                        <br>
                        <%-- replies: xxx --%>
                        <ww:text name="'global.replies'"/>: <%= LocaleUtils.getLocalizedNumber(popThread.getMessageCount()-1) %>
                        <br>
						<ww:text name="'global.last_post_by'">
							<ww:param>
                        	<%  if (!lastThreadPost.isAnonymous()) { %>

                            	<a href="profile.jspa?userID=<%= lastThreadPost.getUser().getID() %>"
                                 title="<%= StringUtils.escapeHTMLTags(SkinUtils.getDisplayName(lastThreadPost.getUser())) %>"
                            	 ><%= StringUtils.escapeHTMLTags(StringUtils.chop(SkinUtils.getDisplayName(lastThreadPost.getUser()),15)) %></a>

                        	<%  } else { %>

                            	<%= StringUtils.escapeHTMLTags(StringUtils.chop(userdisplay,15)) %>

                        	<%  } %>
                        	</ww:param>
                       	</ww:text>

                        <br>
                        <%-- at: xxx --%>
						<ww:text name="'global.last_post_at'">
							<ww:param>
								<%= dateUtils.formatDate(popThread.getModificationDate()) %>
							</ww:param>
						</ww:text>
                    </td>
                </tr>

            <%  } %>

            <%  if (JiveGlobals.getJiveBooleanProperty("rss.enabled", true)) { %>

                <tr>
                    <td colspan="2" align="right">
                    	<%-- RSS --%>
                        <a href="rss.jspa?feed=rss/rsspopularthreads.jspa?forumID=<%= forum.getID() %>"
                         ><img src="images/rss-24x16.gif" border="0" alt="" /></a>
                    </td>
                </tr>

            <%  } %>

            </tbody>
            </table>
            </div>

        <%  } %>

    </td>
</tr>
</tbody>
</table>

</div>