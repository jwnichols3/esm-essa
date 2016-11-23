<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
<html>
    <head>
        <title>Downloads</title>
        <style type="text/css">
             .release {
             }
             .releaseName {
                 font-weight: bold;
             }
        </style>
    </head>

    <body>
        <div id="releases">
        <ww:iterator value="releases">
            <div class="release">
            <span class="releaseName">Version <ww:property value="version"/></span>
            <ul>
                <li>Date: <ww:property value="date"/></li>
                <li><a href="<ww:property value="jiraUrl"/>/secure/ReleaseNote.jspa?projectId=<ww:property value="[1].jiraId"/>&styleName=Html&version=<ww:property value="jiraId"/>">Changelog</a></li>
                <li>Downloads:
                <ww:iterator value="downloads" status="i">
                    <a href="<ww:property value="url"/>"><ww:property value="name"/></a>
                    <ww:if test="!#i.last">
                    ;
                    </ww:if>
                </ww:iterator>
                </li>
            </ul>
            </div>
        </ww:iterator>
        </div>
    </body>
</html>
</ww:push>
