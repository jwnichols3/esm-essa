<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
    <html>
    <head>
        <title>Developer Forums</title>
    </head>

    <body>

    Developers meet and discuss project details at the <a
            href="http://forums.opensymphony.com/forum.jspa?forumID=<ww:property value="forums.devId"/>"><ww:property
            value="name"/> Developer Forums</a>. Anyone is invited to participate in these forums with
    development-related questions, ideas, and comments. These include:
    <ul>
        <li>Patches</li>
        <li>Feature requests</li>
        <li>Non user-facing questions (development related)</li>
        <li>Suggestions</li>
        <li>Offers for help</li>
    </ul>

    <p/>

    If your message to the team isn't development-related, but you still want the development team to see it, don't
    worry: the <a href="userForums.action">User Forums</a> is also monitored by the entire development team. And if you
    are unsure of where to post your message, use the <a href="userForums.action">User Forums</a> as it will offer the
    widest audience to provide feedback and help.

    <ww:if test="!noMailingLists">

        <h2>Mailing List</h2>

        <ww:set name="mail" value="'http://' + id + '.dev.java.net/servlets/SummarizeList?listName=dev'"/>
        <ww:if test="forums.devList != null">
            <ww:set name="mail" value="forums.devList"/>
        </ww:if>

        The development forums are also accessible as a mailing list (traffic to both the forums and the mailing lists
        are mirrored). You can sign up for the development mailing list <a href="<ww:property value="#mail"/>">here</a>.
        While we recommend that you use the forums, we will always support email access as well. However, we ask that
        you <b>send all emails in plain text format only</b> if you wish to use email access. This ensures the best
        possible experience for both mailing list members and forums members.
        <p/>

        Lastly, we encourage you to <b><a href="http://forums.opensymphony.com/account!default.jspa">sign up</a> for a
        forums account</b> even if you plan to use the mailing lists only. By regsitering with the forums and providing
        the same email address you use for the mailing lists in your forums account, this ensures that your posts will
        be saved against your account, allowing you to build up reward points and status within the <ww:property
            value="name"/> community.

    </ww:if>

    </body>
    </html>
</ww:push>