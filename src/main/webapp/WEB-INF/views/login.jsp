<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zaloguj użytkownika</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <label>Username:
        <form:input path="username"/>
    </label><br/>
    <label>Hasło:
        <form:password path="password"/>
    </label><br/>
    <form:button type="submit">Zaloguj</form:button>
</form:form>
</body>
</html>