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
<h2>Witaj <c:out value="${user.firstname}"/></h2><br>
<div><a href="/logout">Wyloguj</a></div>
<div><a href="/logged/create">Utwórz konto</a></div>

<table border="1">
    <thead>
    <th>Nazwa konta</th>
    <th>Data stworzenia</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${accounts}" var="account">
    <tr>
        <td><c:out value="${account.accountName}"/></td>
        <td><c:out value="${account.createdOn}"/></td>
        <td><a href="/logged/show/${account.id}">Pokaż</a>
            <a href="/logged/edit?id=${account.id}">Edytuj</a>
            <a href="/logged/delete?id=${account.id}">Usuń</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>