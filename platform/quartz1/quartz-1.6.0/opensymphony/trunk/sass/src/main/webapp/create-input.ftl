[#ftl]
<html>
<head>
    <title>Create an account</title>
</head>

<body>

[@ww.form action="create" method="post"]
    [@ww.textfield label="Username" name="user.username"/]
    [@ww.textfield label="Email" name="user.email"/]
    [@ww.textfield label="Name" name="user.name"/]
    [@ww.password label="Password" name="password"/]
    [@ww.password label="Password (again)" name="passwordVerify"/]
    [@ww.submit value="Create Account"/]
[/@ww.form]

</body>
</html>