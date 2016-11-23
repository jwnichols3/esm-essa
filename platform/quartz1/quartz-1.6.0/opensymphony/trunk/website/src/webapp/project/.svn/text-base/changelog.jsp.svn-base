<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
<html>
    <head>
        <title>Changelog</title>
    </head>

    <body>

    The <ww:property value="name"/> change log for issues for all versions can be found
    <a href="<ww:property value="jiraUrl"/>/browse/<ww:property value="jiraName"/>?report=com.atlassian.jira.plugin.system.project:changelog-panel">here</a>.
    In addition to this complete list, you can view the changes for each version:
    <p/>

    <ul>
    <ww:iterator value="releases">
        <li><a href="<ww:property value="jiraUrl"/>/secure/IssueNavigator.jspa?reset=true&pid=<ww:property value="[1].jiraId"/>&fixfor=<ww:property value="jiraId"/>">Version <ww:property value="version"/></a></li>
    </ww:iterator>
    </ul>
    <p/>

    In addition to the issue changes, you may also wish to check out the <a href="documentation.action">Documentation</a>.
    Often important changes are found in the release notes and change logs there.

    </body>
</html>
</ww:push>