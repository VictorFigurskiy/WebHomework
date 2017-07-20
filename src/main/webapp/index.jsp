<%--
  Created by IntelliJ IDEA.
  User: Sonikb
  Date: 18.07.2017
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Привет!)</h1>
<h1 align="center">Добро пожаловать!</h1>
<form action="servlet" method="get">
    <p align="center"><input type="submit" value="Поехали..."></p>
</form>

Auth form:<br>
<form action="" method="post">
    <p>Login:<br>
        <input type="text" name="j_username"/>
    </p>
    <p>Password:<br>
        <input type="password" name="j_password"/>
    </p>
    <p>
        <input type="submit" />
    </p>
</form>

</body>
</html>
