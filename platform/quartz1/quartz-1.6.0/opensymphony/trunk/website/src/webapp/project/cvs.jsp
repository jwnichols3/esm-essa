<%@ taglib prefix="ww" uri="webwork" %>
<html>
<head>
    <title>Source Repository</title>
</head>

<body>

<ww:push value="#attr.project">
    <ww:if test="!svn">
        <h2>Browsing CVS</h2>

        <ww:property value="name"/> CVS is hosted by java.net. You can view the source
        <a href="https://xwork.dev.java.net/source/browse/<ww:property value="id"/>/">here</a>.


        <h2>Anonymous Access</h2>

        java.net does not provide CVS access without first <a href="https://www.dev.java.net/servlets/Join">signing
        up</a>
        for a java.net user account. Once you have done this, you can get the source by doing the following:

        <div class="source">
            <pre>cvs -d :pserver:[username]@cvs.dev.java.net:/cvs login
cvs -d :pserver:[username]@cvs.dev.java.net:/cvs checkout <ww:property value="id"/></pre>
        </div>

        <h2>Developer Access</h2>

        Developers can check out CVS the same way as Anonymous Access. However, they cannot
        commit code until they are granted the <b>Developer</b> role in java.net.
        <p/>

        See <a href="contribute.action">How to Contribute</a> to learn how you can get
        involved with <ww:property value="id"/> and possibly gain developer access.

        <h2>Commit Messages</h2>

        You can monitor the CVS commit messages at the
        <a href="http://forums.opensymphony.com/forum.jspa?forumID=<ww:property value="forums.cvsId"/>"><ww:property
                value="name"/> CVS Forums</a>.
        Alternatively, if you prefer email notifications, you can
        <a href="http://<ww:property value="id"/>.dev.java.net/servlets/SummarizeList?listName=cvs">sign up</a> for the
        CVS mailing list.
    </ww:if>
    <ww:else>
        <h2>Browsing SVN</h2>

        You can view the <ww:property value="name"/> source
        <a href="http://svn.opensymphony.com/fisheye/viewrep/<ww:property value="id"/>/trunk">here</a>.

        <h2>Anonymous Access</h2>

        You can check out the source anonymously using the Subversion URL <b>http://svn.opensymphony.com/svn/<ww:property value="id"/>/trunk</b>
        You can get the source by doing the following:

        <div class="source">
            <pre>svn co http://svn.opensymphony.com/svn/<ww:property value="id"/>/trunk</pre>
        </div>

        <h2>Developer Access</h2>

        Developers can check use the Subversion URL <b>https://svn.opensymphony.com/svn/<ww:property value="id"/>/trunk</b>.

        See <a href="contribute.action">How to Contribute</a> to learn how you can get
        involved with <ww:property value="id"/> and possibly gain developer access.
    </ww:else>
</ww:push>
</body>
</html>
