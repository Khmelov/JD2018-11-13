<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <!-- Основное содержимое -->
    <div class="page-header">
        <h1>Все товары</h1>
    </div>

    <div class="row">
        <div class="col-md-2">Название</div>
        <div class="col-md-5">Описание</div>
        <div class="col-md-1">Тип</div>
        <div class="col-md-2">Производительность</div>
        <div class="col-md-1">Цена</div>
    </div>

    <c:forEach items="${goods}" var="good">
        <br>
        <div class="row">
            <div class="col-md-2">${good.title} </div>
            <div class="col-md-5">${good.discription} </div>
            <div class="col-md-1">${good.type} </div>
            <div class="col-md-2">${good.productivity} </div>
            <div class="col-md-1">${good.price} </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
