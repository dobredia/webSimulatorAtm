<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Withdraw cash</title>
</head>
<body>
    <c:if test="${updateAccountSuccess}">
        <div>Operation Successful for IBAN: ${account.iban}</div>
    </c:if>
    <c:url var="update_balance_url" value="/account/${account.id}/withdrawCash"/>
    <form action="${update_balance_url}" method="post" >
        <label>Withdraw cash: </label>
        <input type="text"  name="balance1" />
        <input type="submit" value="submit"/>
    </form>
    <a href="/commands/${account.id}" >Back</a>
</body>
</html>
