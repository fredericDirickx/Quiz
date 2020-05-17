<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 5/15/2020
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}\style.css"/>
    <title>Quiz Settings</title>
</head>
<body>

<div>
    <h1>Weclome, ${userName}</h1>

    <form action="${pageContext.request.contextPath}/quizStart" method="post">
        <input hidden name="userName" value="${userName}">
        <label name="addition">addition</label>
        <input name="addition" type="checkbox" value="true">
        <label name="subtraction">subtraction</label>
        <input name="subtraction" type="checkbox" value="true">
        <label name="multiplication">multiplication</label>
        <input name="multiplication" type="checkbox" value="true">
        <label name="division">division</label>
        <input name="division" type="checkbox" value="true"><br>
        <label name="amount">amount of questions</label>
        <input name="amount" type="number" value="10"><br>
        <label name="firstNumberLowerBound">first Number lower bound</label>
        <input name="firstNumberLowerBound" type="number" value="1"><br>
        <label name="firstNumberUpperBound">firstNumber Upper bound</label>
        <input name="firstNumberUpperBound" type="number" value="11"><br>
        <label name="secondNumberLowerBound">Second Number lower bound</label>
        <input name="secondNumberLowerBound" type="number" value="1"><br>
        <label name="secondNumberUpperBound">Second Number Upper bound</label>
        <input name="secondNumberUpperBound" type="number" value="11"><br>
        <button class="submitButton" type="submit">Push here</button>
    </form>
</div>

</body>
</html>
