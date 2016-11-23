[#ftl]
<html>
<head>
    <title>Home</title>
</head>

<body>

[@ww.form action="resetPassword" method="post"]
    [@ww.textfield label="Username" name="username"/]
    [@ww.submit value="Reset"/]
[/@ww.form]

</body>
</html>