<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Login page</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="<c:url value="/resources/css/my-style.css"/>">
</head>
<body>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Sign in to continue</h1>
                <div class="account-wall">
                    <img class="profile-img"
                         src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                         alt="">
                    <form name="form" action="j_spring_security_check" method="post" class="form-signin">
                        <c:if test="${'true' eq logout}">
                            <div class="alert alert-info" role="alert">You've been logged out successfully.</div>
                        </c:if>

                        <c:if test="${'true' eq error}">
                            <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
                        </c:if>
                        <input type="text" name="username" class="form-control" placeholder="Username" required
                               autofocus>
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                        <label class="checkbox pull-left">
                            <input name="remember-me" id="rememberme" type="checkbox">
                            Remember me
                        </label>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Sign in
                        </button>
                    </form>
                </div>
                <a href="<c:url value="/registration"/>" class="text-center new-account">Create an account </a>
            </div>
        </div>
    </div>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
    <form:form id="logout" action="/logout" method="POST">
        <input type="hidden" value="Logout"/>
    </form:form>
    <div class="container">
        <div class="page header text-center">
            <span style="font-size: 22px; margin-top: 500px">Вы уже авторизированны</span>
            <div class="container-fluid">
                <a href="<c:url value="/main"/>"><span class="glyphicon glyphicon-home"></span> Вернуться на главную</a>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </c:if>
                <a style="cursor: pointer" onclick="document.forms['logout'].submit()"><span
                        class="glyphicon glyphicon-log-out"></span>
                    <span class="text-right">${pageContext.request.userPrincipal.name} | </span>
                    </span> Выйти </a>
            </div>
        </div>
    </div>
</sec:authorize>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
