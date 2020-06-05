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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styleQuizBlack.css"/>
    <title>Quiz Settings</title>
</head>
<body>
<div class="container">
    <h1>Welcome, ${userName}</h1>

    <form action="${pageContext.request.contextPath}/quizSettingsServlet" method="post">

        <input hidden name="userName" value="${userName}">

        <fieldset class="checkBoxes">
            <label class="checkmarkContainer">+
                <input name="addition" type="checkbox" value="true">
                <span class="checkMark"></span>
            </label>

            <label class="checkmarkContainer">-
                <input name="substraction" type="checkbox" value="true">
                <span class="checkMark"></span>
            </label>
            <label class="checkmarkContainer">x
                <input name="multiplication" type="checkbox" checked="checked" value="true">
                <span class="checkMark"></span>
            </label>
            <label class="checkmarkContainer">/
                <input name="division" type="checkbox" value="true">
                <span class="checkMark"></span>
            </label>
            <label class="checkmarkContainer">shuffle
                <input name="shuffle" type="checkbox" value="true">
                <span class="checkMark"></span>
            </label>
        </fieldset>

        <div class="row">
            <div class="col-25">
                <label>amount of questions</label>
            </div>
            <div class="col-75">
                <input name="amount" type="number" value="100">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label>first Number lower bound</label>
            </div>
            <div class="col-75">
                <input name="firstNumberLowerBound" type="number" value="2">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label>firstNumber Upper bound</label>
            </div>
            <div class="col-75">
                <input name="firstNumberUpperBound" type="number" value="9">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label>Second Number lower bound</label>
            </div>
            <div class="col-75">
                <input name="secondNumberLowerBound" type="number" value="2">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label>Second Number Upper bound</label>
            </div>
            <div class="col-75">
                <input name="secondNumberUpperBound" type="number" value="9">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
            <button class="submitButton" type="submit">Push here</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
