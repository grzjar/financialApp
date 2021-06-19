<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj konto</title>
</head>
<body>
<form:form method="post" modelAttribute="account">
    <label>Nazwa konta:
        <form:input path="accountName"/>
    </label><br/>
    <form:hidden path="id"/>
    <form:button type="submit">Edytuj</form:button>
</form:form>
</body>
</html>