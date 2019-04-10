<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- \\Bootstrap Library -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/general.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Bootstrap Library// -->


<head>
    <title> IA SYSTEM  </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

</head>


<body>

<%--<c:url value="/logout" var="logoutUrl" />--%>
<%--<!-- csrt for log out-->--%>
<%--<form action="${logoutUrl}" method="post" id="logoutForm">--%>
    <%--<input type="hidden"--%>
           <%--name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}" />--%>
<%--</form>--%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/" style="background-color:#767acb; color:#f3f3f3"> Sistema IA </a>
        </div>


        <ul class="nav navbar-nav">
            <li><a href="/banco-casos"> Banco de Casos </a></li>
        </ul>


    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">