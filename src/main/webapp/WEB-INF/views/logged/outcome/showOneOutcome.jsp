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
<div class="text">Pojedynczy wydatek</div>

<div class="grid5">
    <div class="item2">Kategoria</div>
    <div class="item2">Wartość</div>
    <div class="item2">Waluta</div>
    <div class="item2">Data stworzenia</div>
    <div class="item2">Opis</div>
    <div><c:out value="${outcome.category}"/></div>
    <div><c:out value="${outcome.value}"/></div>
    <div><c:out value="${outcome.currency}"/></div>
    <div><c:out value="${outcome.createdOn}"/></div>
    <div><c:out value="${outcome.description}"/></div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>