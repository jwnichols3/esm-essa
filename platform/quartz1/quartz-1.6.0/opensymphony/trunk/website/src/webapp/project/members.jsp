<%@ taglib prefix="ww" uri="webwork" %>
<ww:push value="#attr.project">
<html>
    <head>
        <title>Development Team</title>
    </head>

    <body>

    <ww:if test="owners.length > 0">
    <h2>Project Leaders</h2>
    <ul>
    <ww:iterator value="owners">
        <li><ww:if test="email != null"><a href="mailto: <ww:property value="email"/>"></ww:if><ww:property value="name"/><ww:if test="email != null"></a></ww:if><ww:if test="role != null"> (<ww:property value="role"/>)</ww:if></li>
    </ww:iterator>
    </ul>
    </ww:if>

    <ww:if test="developers.length > 0">
    <h2>Developers</h2>
    <ul>
    <ww:iterator value="developers">
        <li><ww:if test="email != null"><a href="mailto: <ww:property value="email"/>"></ww:if><ww:property value="name"/><ww:if test="email != null"></a></ww:if><ww:if test="role != null"> (<ww:property value="role"/>)</ww:if></li>
    </ww:iterator>
    </ul>
    </ww:if>

    <ww:if test="contributors.length > 0">
    <h2>Contributors</h2>
    <ul>
    <ww:iterator value="contributors">
        <li><ww:if test="email != null"><a href="mailto: <ww:property value="email"/>"></ww:if><ww:property value="name"/><ww:if test="email != null"></a></ww:if><ww:if test="role != null"> (<ww:property value="role"/>)</ww:if></li>
    </ww:iterator>
    </ul>
    </ww:if>

    </body>
</html>
</ww:push>
