<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie konta</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć konto ${account.accountName} (id = ${account.id})?</p>
    <p>
        <input type="hidden" name="id" value="${account.id}"/>
        <a href="/logged/logged">Nie</a><button type="submit">Tak</button>
    </p>
</form>
</body>
</html>