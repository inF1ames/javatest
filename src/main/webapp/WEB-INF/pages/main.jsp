<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/my-style.css"/>">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>

<form:form id="logout" action="/logout" method="POST">
    <input type="hidden" value="Logout"/>
</form:form>
<div class="container-fluid">
    <div class="page-header text-centred">
        <div class="container">
            <div class="text-center">
                <form:form method="GET" action="/getWeekend">
                    Начальная дата: <input type="date" name="startDate">
                    Конечная дата: <input type="date" name="endDate">
                    <p><strong>${error}</strong></p>
                    <input type="submit" value="Отправить">
                </form:form>
                <h5>Количество выходных дней: ${amountOfWeekends}</h5>
            </div>
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

<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
