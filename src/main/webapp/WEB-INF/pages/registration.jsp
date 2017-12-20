<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>

<html>
<head>
    <sec:csrfMetaTags/>
    <title>Registration page</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href='<c:url value="/resources/css/my-style.css"/>'>

</head>

<body>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center register-title">Create an account</h1>
                <form:form method="POST" commandName="userForm" class="form-signup">
                    <div class="account-wall">
                        <img class="profile-img"
                             src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                             alt="">
                        <div class="form-signup">
                            <spring:bind path="username">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input path="username" type="text" class="form-control" placeholder="Username"
                                                autofocus="true"/>
                                    <span class="error"><form:errors path="username"/></span>
                                </div>
                            </spring:bind>

                            <spring:bind path="password">
                                <form:input path="password" type="password" class="form-control"
                                            placeholder="Password"/>
                                <span class="error"><form:errors path="password"/></span>
                            </spring:bind>

                            <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign up</button>
                        </div>
                    </div>
                </form:form>
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
            <span style="font-size: 22px; margin-top: 500px">Вы уже зарегистрированны</span>
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