<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>


<!-- Основное содержимое -->

<div class="page-header">
    <h1>Все заказы покупателей</h1>
    <p class="lead"></p>
</div>

<div class="row">
    <div class="col-md-1">Товар</div>
    <div class="col-md-1">Размер</div>
    <div class="col-md-1">Цвет</div>
    <div class="col-md-1">Цена</div>
    <div class="col-md-1">ID</div>

</div>

<c:forEach items="${orders}" var="order">
    <br>
    <div class="row">
        <div class="col-md-1">${order.shoeName} </div>
        <div class="col-md-1">${order.shoeSize} </div>
        <div class="col-md-1">${order.shoeColour} </div>
        <div class="col-md-1">${order.price} </div>
        <div class="col-md-1">${order.id} </div>
    </div>
</c:forEach>

<br><br>


</div>
</body>
</html>
