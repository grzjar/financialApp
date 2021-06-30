<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pojedyncza kategoria</title>
</head>
<body>
<div><a href="/logout">Wyloguj</a></div>

<div><a href="/logged">Powrót do strony głównej</a>

<table border="1">
    <thead>
    <th>Kategoria</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${category.categoryName}"/></td>
    </tr>
    </tbody>

</table>

</body>
</html>