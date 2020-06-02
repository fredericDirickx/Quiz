<%--
  Created by IntelliJ IDEA.
  User: Frederic
  Date: 5/16/2020
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styleQuizBlack.css"/>
    <title>quiz report</title>
</head>
<body>
<div class="container">
    <p>Great Job, ${userName}</p>
    <table>
        <tr>
            <th>question</th>
            <th>your Answer</th>
            <th>correct</th>
            <th>result</th>
            <th>time</th>
        </tr>
        <c:forEach items="${questionList}" varStatus="status">
            <tr>
                <td>
                        ${questionList[status.index]}
                </td>
                <td>
                        ${answerList[status.index]}
                </td>
                <td>
                        ${correctAnswerList[status.index]}
                </td>
                <td style="color: ${colorList[status.index]}">
                        ${isCorrectList[status.index]}
                </td>
                <td>
                        ${durationList[status.index]}
                </td>

            </tr>
        </c:forEach>
    </table>
    <table>
        <th>
            TOTAL
        </th>
        <tr>
            <td>
                you have ${wrongAnswers} mistakes
            </td>
        </tr>
        <tr>
            <td>
                your score : ${scorePercentage} %
            </td>
        </tr>
        <tr>
            <td>
                you did it in : ${totalDuration}
            </td>
        </tr>
    </table>

    <br>
    <div class="reportButtonsDiv">
        <form action="${pageContext.request.contextPath}/quizSettingsServlet">
            <div class="row">
                <div class="col-25">
            <button class="submitButton" name="submitButton" type="submit" >new game</button>
                </div>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/goodbye">
            <div class="row">
                <div class="col-25">
            <button class="submitButton" name="submitButton" type="submit">logoff</button>
                </div>
            </div>
        </form>
    </div>
</div>

</div>
</body>
</html>
