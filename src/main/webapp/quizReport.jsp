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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}\style.css"/>
    <title>quiz report</title>
</head>
<body>
<p>Great Job, ${userName}</p>
<c:forEach items="${reportList}" var="line">
    <p>${line}</p>
</c:forEach>

</body>
</html>
