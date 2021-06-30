<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pojedynczy wydatek</title>
</head>
<body>
<div><a href="/logout">Wyloguj</a></div>

<div><a href="/logged">Powrót do strony głównej</a>, <a href="/logged/show/${id}/createIncome">Dodaj przychód</a>,
    <a href="/logged/show/${id}/createOutcome">Dodaj wydatek</a></div>

<table border="1">
    <thead>
    <th>Kategoria</th>
    <th>Wartość</th>
    <th>Waluta</th>
    <th>Data stworzenia</th>
    <th>Opis</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${outcome.category}"/></td>
        <td><c:out value="${outcome.value}"/></td>
        <td><c:out value="${outcome.currency}"/></td>
        <td><c:out value="${outcome.createdOn}"/></td>
        <td><c:out value="${outcome.description}"/></td>
    </tr>
    </tbody>

</table>

</body>
</html>