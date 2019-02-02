<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<!-- Основное содержимое -->








<div class="page-header">
    <h1>Каталог проектов</h1>
    <p class="lead">Список проектов домов</p>
</div>

<div class="row">
    <div class="col-md-2">Название</div>
    <div class="col-md-2">Этажность</div>
    <div class="col-md-2">Площадь(м2)</div>
    <div class="col-md-4">Материал стен</div>
    <div class="col-md-1">Цена</div>


</div>

<c:forEach items="${items}" var="varItems">
    <br>
    <div class="row">
        <div class="col-md-2">${varItems.title} </div>
        <div class="col-md-2">${varItems.floors} </div>
        <div class="col-md-2">${varItems.square} </div>
        <div class="col-md-4">${varItems.materials} </div>
        <div class="col-md-1">${varItems.price} </div>

    </div>
</c:forEach>

<br><br>



</div>
</body>
</html>
