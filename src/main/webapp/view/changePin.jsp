
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change PIN</title>
</head>
<body>
<div>
    Welcome to Change PIN!
</div>

<c:if test="${!updateAccountSuccess}">
    Unauthorized
</c:if>

<c:url var="changePin" value="/changePin"/>
<form action="${changePin}" method="post" >
    <label>new Pin: </label>
    <label>
        <input type="text"  name="newPin"/>
    </label>
    <input type="submit" value="submit"/>
</form>
<a href="/home" >Back</a>
</body>
</html>
