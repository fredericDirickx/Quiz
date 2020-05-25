<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 5/14/2020
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styleQuiz.css"/>
    <title>quiz</title>
</head>
<body>
<div class="container">
    <p>Go For it, ${userName}</p>

    <div class="progressBarBackground">
        <div class="progressBar" style="width: ${progress}%">
            ${progress}%
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/quizAdmin" method="post">
        <input hidden name="index" value="${index}">
        <div class="row">
            <div class="col-25">
                <label for="answer">${question}</label>
            </div>
            <div class="col-75">
                <input id="answer" name="answer" type="number" autofocus>
            </div>
        </div>
        <div class="row">
            <div class="col-75">
                <button class="submitButton" name="submitButton" type="submit">${buttonText}</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
