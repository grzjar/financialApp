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
                        <a class="nav-link" href="/logout">Wyloguj</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</head>
<body>
<div class="text">Edycja przychodu</div>
<div class="center">
<form:form method="post" modelAttribute="income">
    <label class="form-label">Kategoria:
        <form:select path="category">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${categories}"/>
        </form:select> lub <a class="btn btn-primary" href="/logged/show/${id}/createCategory" role="button">Dodaj kategorię</a>.
    </label><br/>
    <label class="form-label">Kwota:
        <form:input path="value"/>
    </label><br/>
    <label class="form-label">Opis:
        <form:input path="description"/>
    </label><br/>
    <form:hidden path="id"/>
    <form:button class="btn btn-primary" type="submit">Edytuj</form:button>
</form:form>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>