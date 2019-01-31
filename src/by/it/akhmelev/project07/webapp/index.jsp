<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<!-- Основное содержимое -->

<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
</div>

<div class="row">
    <div class="col-md-1">Цена</div>
    <div class="col-md-3">Адрес</div>
    <div class="col-md-4">Описание</div>
    <div class="col-md-1">Число комнат</div>
    <div class="col-md-1">Площадь</div>
    <div class="col-md-1">Этаж</div>
    <div class="col-md-1">Этажность</div>

</div>

<c:forEach items="${ads}" var="ad">
    <br>
    <div class="row">
        <div class="col-md-1">${ad.price} </div>
        <div class="col-md-3">${ad.address} </div>
        <div class="col-md-4">${ad.description} </div>
        <div class="col-md-1">${ad.rooms} </div>
        <div class="col-md-1">${ad.area} </div>
        <div class="col-md-1">${ad.floor} </div>
        <div class="col-md-1">${ad.floors} </div>
    </div>
</c:forEach>

<br><br>



</div>
</body>
</html>
