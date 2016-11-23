[#ftl]
<html>
<head>
    <title>OpenSymphony Dashboard</title>
</head>

<body>

Great! You are now logged in.

<b>Change your password</b>

[#if !actionMessages.empty]
    [#list actionMessages as msg]
        <b>${msg}</b>
    [/#list]
[/#if]

[@ww.form action="changePassword" method="post"]
    [@ww.password label="Password" name="password"/]
    [@ww.password label="Password (again)" name="passwordVerify"/]
    [@ww.submit value="Change Password"/]
[/@ww.form]

</body>
</html>