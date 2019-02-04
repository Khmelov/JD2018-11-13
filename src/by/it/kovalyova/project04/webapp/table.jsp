<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<!-- Основное содержимое -->

<div class="page-header">
    <h1>Все объявления</h1>
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
<c:forEach items="${ads}" var="ad" varStatus="loop">
    <br>

    <div class="row">
        <div class="col-md-1">${ad.price} </div>
        <div class="col-md-3">${flats[loop.index].address} </div>
        <div class="col-md-4">${flats[loop.index].description} </div>
        <div class="col-md-1">${flats[loop.index].rooms} </div>
        <div class="col-md-1">${flats[loop.index].area} </div>
        <div class="col-md-1">${flats[loop.index].floor} </div>
        <div class="col-md-1">${flats[loop.index].floors} </div>
    </div>
</c:forEach>

<br><br>



</div>
</body>
</html>
