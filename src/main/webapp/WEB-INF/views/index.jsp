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
                        <a class="nav-link">Witaj na stronie aplikacji</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/"><b>Financial Management</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="https://github.com/grzjar/financialApp#readme">Opis aplikacji</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/create">Zarejestruj</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Zaloguj</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</head>
<body>
<div class="grid3-img">
    <div class="card" style="width: 18rem;">
        <img src="/images/stooq.jpg" class="card-img-top">
        <div class="card-body">
            <p class="card-text">Strona z notowaniami giełdowymi</p>
            <a href="https://stooq.com/" class="btn btn-primary">Idź do stooq.com</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img src="/images/ban.jpg" class="card-img-top">
        <div class="card-body">
            <p class="card-text">Portal finansowy</p>
            <a href="https://www.bankier.pl/" class="btn btn-primary">Idź do bankier.pl</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img src="/images/rm.jpg" class="card-img-top">
        <div class="card-body">
            <p class="card-text">Zakochaj się w Realu Madryt</p>
            <a href="https://www.realmadryt.pl/" class="btn btn-primary">Idź do RealMadryt.pl</a>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
