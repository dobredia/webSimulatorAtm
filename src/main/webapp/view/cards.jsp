<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cards</title>
</head>
<body>
<div>
    <c:forEach items="${cards}" var="card">
        <div>${card.cardNumber}</div><a href="/cards/${card.cardNumber}">${card.pin}</a>
        <div>${card.pin}</div>
        <br>
    </c:forEach>
</div>
</body>
</html>
