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
                </ul>
            </div>
        </div>
    </div>
</nav>
</head>
<body>
<div class="text">Tworzenie użytkownika</div>
<div class="center">
<form:form method="post" modelAttribute="user">
    <label class="form-label">Imię:
        <form:input class="form-control" path="firstname" placeholder="Podaj imię"/>
    </label><br/>
    <label class="form-label">Nazwisko:
        <form:input class="form-control" path="lastname" placeholder="Podaj nazwisko"/>
    </label><br/>
    <label class="form-label">Nazwa użytkownika:
        <form:input class="form-control" path="username" placeholder="Podaj nazwę użytkownika"/>
    </label><br/>
    <label class="form-label">Hasło:
        <form:password class="form-control" path="password" placeholder="Podaj hasło"/>
    </label><br/>
    <form:button type="submit">Dodaj</form:button>
</form:form>
</div>
</body>
</html>