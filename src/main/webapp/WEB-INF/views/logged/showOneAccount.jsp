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
<div><a href="/logout">Wyloguj</a></div>

<div><a href="/">Powrót do strony głównej</a>, <a href="/logged/show/${id}/createIncome">Dodaj przychód</a>,
<a href="/logged/show/${id}/createOutcome">Dodaj wydatek</a></div>

<table border="1">
    <thead>
    <th>Nazwa konta</th>
    <th>Wartość</th>
    <th>Waluta</th>
    <th>Data stworzenia</th>
    <th>Ostatnia aktualizacja</th>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${account.accountName}"/></td>
            <td><c:out value="${account.accountValue}"/></td>
            <td><c:out value="${account.currency}"/></td>
            <td><c:out value="${account.createdOn}"/></td>
            <td><c:out value="${account.updatedOn}"/></td>
        </tr>
    </tbody>

</table>
<br>
<br>
<table border="1">
    <thead>
    <th>Kategoria</th>
    <th>Wartość</th>
    <th>Data stworzenia</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${incomes}" var="income">
        <tr>
            <td><c:out value="${income.category}"/></td>
            <td><c:out value="${income.value}"/></td>
            <td><c:out value="${income.createdOn}"/></td>
            <td><a href="/logged/show/${id}/show-income/${income.id}">Pokaż</a>
                <a href="/logged/show/${id}/edit-income/${income.id}">Edytuj</a>
                <a href="/logged/show/${id}/delete-income/${income.id}">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<table border="1">
    <thead>
    <th>Kategoria</th>
    <th>Wartość</th>
    <th>Data stworzenia</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${outcomes}" var="outcome">
        <tr>
            <td><c:out value="${outcome.category}"/></td>
            <td><c:out value="${outcome.value}"/></td>
            <td><c:out value="${outcome.createdOn}"/></td>
            <td><a href="/logged/show/${id}/show-outcome/${outcome.id}">Pokaż</a>
                <a href="/logged/show/${id}/edit-outcome/${outcome.id}">Edytuj</a>
                <a href="/logged/show/${id}/delete-outcome/${outcome.id}">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>