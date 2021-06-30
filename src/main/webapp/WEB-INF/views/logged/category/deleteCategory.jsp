<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuń kategorię</title>
</head>

<body>
<div><a href="/logout">Wyloguj</a></div>
<form method="post" action="">
    <p>Czy usunąć pozycję: ${category.categoryName}?</p>
    <p>
        <input type="hidden" name="id" value="${category.id}"/>
        <a href="/logged/">Nie</a><button type="submit">Tak</button>
    </p>
</form>
</body>
</html>