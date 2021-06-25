<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj wydatek</title>
</head>

<body>
<div><a href="/logout">Wyloguj</a></div>
<form:form method="post" modelAttribute="outcome">
    <label>Kategoria:
        <form:input path="category"/>
    </label><br/>
    <label>Kwota:
        <form:input path="value"/>
    </label><br/>
    <label>Description:
        <form:input path="description"/>
    </label><br/>
    <form:hidden path="id"/>
    <form:button type="submit">Edytuj</form:button>
</form:form>
</body>
</html>