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
                        <a class="nav-link active" aria-current="page" href="createCategory">Dodaj kategorię</a>
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
<div class="text">Wszystkie kategorie</div>
<div class="grid1">

    <div class="item2">Kategoria</div>

    <div><c:out value="${category.categoryName}"/></div>

</div>
</body>
</html>