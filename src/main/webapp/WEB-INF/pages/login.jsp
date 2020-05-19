<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 5/15/2020
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}\style.css"/>
    <title>Login</title>
</head>
<body>
<div>
    <h1>Hello Guest ${wrongPassWord}</h1>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label name="userName">Give a login name : </label>
        <input type="text" name="userName"><br>
        <label name="userName">password : </label>
        <input type="text" name="passWord">
        <button class="submitButton" type="submit">Push here</button>

    </form>
</div>
</body>
</html>
