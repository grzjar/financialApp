<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%@include file="/WEB-INF/views/header.jsp" %>
<title>Financial Management</title>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="mx-auto">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/"><b>Financial Management</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logged/">Powrót do widoku użytkownika</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logged/show/${id}/createIncome">Dodaj przychód</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logged/show/${id}/createOutcome">Dodaj wydatek</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logged/show/${id}/show-all">Pokaż kategorie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Wyloguj</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</head>
<body>
<div class="text">Pojedyncze konto</div>
<div class="grid6">
        <div class="item2">Nazwa konta</div>
        <div class="item2">Data stworzenia</div>
        <div class="item2">Suma wpływów</div>
        <div class="item2">Suma wydatków</div>
        <div class="item2">Suma</div>
        <div class="item2">Waluta</div>
        <div><c:out value="${account.accountName}"/></div>
        <div><c:out value="${account.createdOn}"/></div>
        <div><c:out value="${account.sumIncome}"/></div>
        <div><c:out value="${account.sumOutcome}"/></div>
        <div><c:out value="${account.sum}"/></div>
        <div><c:out value="${account.currency}"/></div>
    </div>
</div>
<br>
<br>
<div class="grid4">
    <div class="item1">Przychody</div>
    <div class="item2">Kategoria</div>
    <div class="item2">Wartość</div>
    <div class="item2">Data stworzenia</div>
    <div class="item2">Akcja</div>

    <c:forEach items="${incomes}" var="income">
        <div><c:out value="${income.category}"/></div>
        <div><c:out value="${income.value}"/></div>
        <div><c:out value="${income.createdOn}"/></div>
        <div><a class="btn btn-primary" href="/logged/show/${id}/show-income/${income.id}" role="button">Pokaż</a>
            <a class="btn btn-primary" href="/logged/show/${id}/edit-income/${income.id}" role="button">Edytuj</a>
            <a class="btn btn-primary"  href="/logged/show/${id}/delete-income/${income.id}" role="button">Usuń</a></div>
    </c:forEach>
</div>
<br>
<br>
<div class="grid4">
    <div class="item1">Wydatki</div>

    <div class="item2">Kategoria</div>
    <div class="item2">Wartość</div>
    <div class="item2">Data stworzenia</div>
    <div class="item2">Akcja</div>

    <c:forEach items="${outcomes}" var="outcome">
        <div><c:out value="${outcome.category}"/></div>
        <div><c:out value="${outcome.value}"/></div>
        <div><c:out value="${outcome.createdOn}"/></div>
        <div><a class="btn btn-primary" href="/logged/show/${id}/show-outcome/${outcome.id}" role="button">Pokaż</a>
            <a class="btn btn-primary" href="/logged/show/${id}/edit-outcome/${outcome.id}" role="button">Edytuj</a>
            <a class="btn btn-primary" href="/logged/show/${id}/delete-outcome/${outcome.id}" role="button">Usuń</a></div>
    </c:forEach>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>