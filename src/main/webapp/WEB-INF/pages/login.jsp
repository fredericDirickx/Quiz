<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 5/15/2020
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styleQuizBlack.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Login</title>
</head>
<body>

<div class="container">
    <h1>Hello arithmetician ${wrongPassWord}</h1>

    <form action="${pageContext.request.contextPath}/login" method="post">

        <div class="row">
            <div class="col-25">
                <label name="userName">Enter login name : </label>
            </div>
            <div class="col-75">
                <input type="text" name="userName">
            </div>
        </div>


        <div class="row">
            <div class="col-25">
                <label name="userName">password : </label>
            </div>
            <div class="col-75">
                <input type="text" name="passWord">
            </div>
        </div>


        <div class="row">
            <div class="userInput">
                <button class="submitButton" type="submit">Push here</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
