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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}\style.css"/>
    <title>quiz</title>
</head>
<body>
<p>Go For it, ${userName}</p>
<div>
    <form action="${pageContext.request.contextPath}/quizAdmin" method="post">
            <p>
                <label for="answer">${question}</label>
                <input  id="answer" name="answer" type="number">
                <input hidden name="index" value="${index}">

            </p>

        <button name="submitButton" type="submit">Finished!</button>
    </form>
</div>
</body>
</html>
