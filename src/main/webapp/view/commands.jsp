
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of commands</title>
    <script src="${pageContext.request.contextPath}/static/js/commands.js"></script>
</head>
<body>
<a href="/account/${account.id}/balance">view available balance</a>
<div>withdraw cash</div>
<div>deposit cash</div>
<div>change card PIN</div>
<div>logoff user</div>
</body>
</html>
