<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        Welcome to login!
    </div>
    <c:if test="${!updateAccountSuccess}">
        Unauthorized
    </c:if>
    <c:url var="login" value="/login"/>
    <form action="${login}" method="post" >
        <label>card number: </label>
        <input type="text"  name="cardNumber"/>
        <label>password: </label>
        <input type="text"  name="pin"/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
