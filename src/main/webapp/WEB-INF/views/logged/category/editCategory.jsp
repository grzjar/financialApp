<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edytuj kategorię</title>
</head>

<body>
<div><a href="/logout">Wyloguj</a></div>
<form:form method="post" modelAttribute="category">
    <label>Nazwa kategorii:
        <form:input path="categoryName"/>
    </label><br/>
    <form:hidden path="id"/>
    <form:button type="submit">Edytuj</form:button>
</form:form>
</body>
</html>