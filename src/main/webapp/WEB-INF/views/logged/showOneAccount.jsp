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
<%--Do zrobienia--%>
<h2>Witaj nazwaUżytkownika</h2><br>

<div>Tu mają się też wyświetlać wszystkie wydatki/przychody per konto</div>

<div><a href="/logged/">Powrót do strony głównej</a></div>

<table border="1">
    <thead>
    <th>Nazwa konta</th>
    <th>Wartość</th>
    <th>Data stworzenia</th>
    <th>Ostatnia aktualizacja</th>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${account.accountName}"/></td>
            <td><c:out value="${account.accountValue}"/></td>
            <td><c:out value="${account.createdOn}"/></td>
            <td><c:out value="${account.updatedOn}"/></td>
        </tr>
    </tbody>
</table>
</body>
</html>