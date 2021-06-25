<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zaloguj użytkownika</title>
</head>
<body>
<form method="post">
    <label>Username:
        <input type="text" name="username" placeholder="username"/>
    </label><br/>
    <label>Hasło:
        <input type="password" name="password" placeholder="password"/>
    </label><br/>
    <button type="submit">Zaloguj</button>
</form>
</body>
</html>