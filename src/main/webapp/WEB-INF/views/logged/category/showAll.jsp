<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kategorie</title>
</head>
<body>
<div><a href="/logout">Wyloguj</a></div>

<div><a href="/">Powrót do strony głównej</a>, <a href="/logged/show/${id}/createIncome">Dodaj przychód</a>,
    <a href="/logged/show/${id}/createOutcome">Dodaj wydatek</a>, <a href="/logged/show/${id}/createCategory">Dodaj kategorię</a></div>

<table border="1">
    <thead>
    <th>Nazwa kategorii</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.categoryName}"/></td>
            <td><a href="/logged/show/${id}/show-category/${category.id}">Pokaż</a>
                <a href="/logged/show/${id}/edit-category/${category.id}">Edytuj</a>
                <a href="/logged/show/${id}/delete-category/${category.id}">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>