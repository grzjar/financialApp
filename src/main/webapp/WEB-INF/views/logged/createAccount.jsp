<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stwórz konto</title>
</head>
<body>
<form:form method="post" modelAttribute="account">
    <label>Nazwa konta:
        <form:input path="accountName"/>
    </label><br/>
    <label>Wartość konta:
        <form:input path="accountValue"/>
    </label><br/>
    <form:button type="submit">Dodaj</form:button>
</form:form>
</body>
</html>