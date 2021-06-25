<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Financial Management</title>
</head>
<body>

<h2>Witaj na stronie aplikacji <h1>Financial Management</h1></h2><br>


<table border="1">
    <thead>
    <th>Readme</th>
    <th>Rejestracja</th>
    <th>Logowanie</th>
    <th>Wylogowanie</th>
    </thead>

    <tbody>
    <tr>
        <td><a href="https://github.com/grzjar/bookAPI#bookapi">Opis aplikacji</a></td>
        <td><a href="/create">Rejestracja</a></td>
        <td><a href="/login">Zaloguj</a></td>
        <td><a href="/logout">Wyloguj</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>