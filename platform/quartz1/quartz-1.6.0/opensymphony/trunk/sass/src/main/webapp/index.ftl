[#ftl]
<html>
<head>
    <title>Home</title>
</head>

<body>

[@ww.form action="login" method="post"]
    [@ww.textfield label="Username" name="username"/]
    [@ww.password label="Password" name="password"/]
    [@ww.checkbox label="Remember me" name="remember"/]
    [@ww.submit value="Login"/]
[/@ww.form]
<p/>

... or <a href="create!input.action">create an account</a>.
<p/>

... or <a href="resetPassword!input.action">forgot your password</a>?

</body>
</html>