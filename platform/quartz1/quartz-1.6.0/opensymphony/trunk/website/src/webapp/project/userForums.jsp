<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
    <html>
    <head>
        <title>User Forums</title>
    </head>

    <body>

    Any <ww:property value="name"/>-related question can be submitted at the <a
            href="http://forums.opensymphony.com/forum.jspa?forumID=<ww:property value="forums.usersId"/>"><ww:property
            value="name"/> User Forums</a>. Anyone is invited to participate in these forums with user-related questions
    and comments. These include:
    <ul>
        <li>Bug reports</li>
        <li>"How to" questions</li>
        <li>Best practices</li>
        <li>Other questions not answered in the documentation</li>
    </ul>

    <p/>

    We highly encourage you to consult the documentation before posting any questions -- often your questions can be
    answered there. We also suggest searching the forums archives, as someone else has probably come across the same
    issue you are having.

    <ww:if test="!noMailingLists">

        <h2>Mailing List</h2>

        <ww:set name="mail" value="'http://' + id + '.dev.java.net/servlets/SummarizeList?listName=users'"/>
        <ww:if test="forums.usersList != null">
            <ww:set name="mail" value="forums.usersList"/>
        </ww:if>

        The user forums are also accessible as a mailing list (traffic to both the forums and the mailing lists are
        mirrored). You can sign up for the user mailing list <a href="<ww:property value="#mail"/>">here</a>. While we
        recommend that you use the forums, we will always support email access as well. However, we ask that you <b>send
        all emails in plain text format only</b> if you wish to use email access. This ensures the best possible
        experience for both mailing list members and forums members.
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