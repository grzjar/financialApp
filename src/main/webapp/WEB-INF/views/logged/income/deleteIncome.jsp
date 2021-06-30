<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuń przychód</title>
</head>

<body>
<div><a href="/logout">Wyloguj</a></div>
<form method="post" action="">
    <p>Czy usunąć pozycję: ${income.category}, ${income.description}?</p>
    <p>
        <input type="hidden" name="id" value="${income.id}"/>
        <a href="/logged/">Nie</a><button type="submit">Tak</button>
    </p>
</form>
</body>
</html>