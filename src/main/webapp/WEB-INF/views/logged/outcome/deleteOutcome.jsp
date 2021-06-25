<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie wydatku</title>
</head>

<body>
<div><a href="/logout">Wyloguj</a></div>
<form method="post" action="">
    <p>Czy usunąć pozycję: ${outcome.category}, ${outcome.description}?</p>
    <p>
        <input type="hidden" name="id" value="${outcome.id}"/>
        <a href="/logged/logged">Nie</a><button type="submit">Tak</button>
    </p>
</form>
</body>
</html>