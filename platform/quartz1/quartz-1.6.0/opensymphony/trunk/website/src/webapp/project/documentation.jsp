<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
<html>
    <head>
        <title>Documentation</title>
    </head>

    <body>

    <h2>Latest documentation</h2>
    You can always find the documentation for the latest release by following this link:
    <p/>
    <ul>
        <a href="<ww:property value="docs.url"/>"><b><ww:property value="name"/> <ww:if test="releases.length > 0">version <ww:property value="releases[0].version"/></ww:if> docs</b></a>
    </ul>

    <ww:if test="!docs.doesNotUseWiki">
    <p/>

    <h2>In-progress documentation</h2>
    This documentation is generated for every release from the content in the
    <a href="http://wiki.opensymphony.com/display/<ww:property value="confluenceName"/>"><ww:property value="name"/> wiki</a>.
    <p/>

    The docs are found on the wiki starting
    at the <a href="http://wiki.opensymphony.com/display/<ww:property value="confluenceName"/>/Documentation"><b>Documentation</b></a>
    node and include all children. They are exported as HTML and PDF and then made available in the release
    download as well as on this website (in the link above).

    <h2>Getting involved</h2>
    If you wish to get involved with <ww:property value="name"/>, you can do so by working with the developers
    in the forums on where documentation can be improved. Once you have talked with the team and have a plan for
    what documetnation work you are going to do, you'll need an account on the wiki. The wiki uses the same
    authentication that the bug tracker does, so just <a href="<ww:property value="jiraUrl"/>/secure/Signup!default.jspa">sign up</a> for an account there. Then you can start making changes
    to the documentation, starting at the Documentation node. In summary:
    <ol>
        <li>Work with the development team on where you wish to write documentation</li>
        <li><a href="<ww:property value="jiraUrl"/>/secure/Signup!default.jspa">Get</a> a bug tracker/wiki account</li>
        <li>Write documentation, making sure that all new pages are children of <a href="http://wiki.opensymphony.com/display/<ww:property value="confluenceName"/>/Documentation">Documentation</a></li>
    </ol>

    </ww:if>

    </body>
</html>
</ww:push>