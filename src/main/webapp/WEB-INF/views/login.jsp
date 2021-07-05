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
<div class="text">Logowanie</div>
<div class="center">
<form method="post">
    <label class="form-label">Nazwa użytkownika:
        <input type="text" name="username" class="form-control" placeholder="Nazwa użytkownika"/>
    </label><br/>
    <label class="form-label">Hasło:
        <input type="password" name="password" class="form-control" placeholder="Hasło"/>
    </label><br/>
    <button type="submit">Zaloguj</button>
</form>
</div>
</body>
</html>