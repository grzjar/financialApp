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
                        <a class="nav-link active" aria-current="page">Witaj <c:out value="${user.firstname}"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/"><b>Financial Management</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="https://github.com/grzjar/financialApp#readme">Opis aplikacji</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logged/create">Utwórz konto finansowe</a>
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
    <div class="text">Konta</div>
    <div class="grid3">
        <div class="item2">Nazwa konta</div>
        <div class="item2">Data stworzenia</div>
        <div class="item2">Akcja</div>

        <c:forEach items="${accounts}" var="account">

                <div><c:out value="${account.accountName}"/></div>
                <div><c:out value="${account.createdOn}"/></div>
                <div><a href="/logged/show/${account.id}">Pokaż</a>
                    <a href="/logged/edit?id=${account.id}">Edytuj</a>
                    <a href="/logged/delete?id=${account.id}">Usuń</a></div>

        </c:forEach>

    </div>
</body>
</html>