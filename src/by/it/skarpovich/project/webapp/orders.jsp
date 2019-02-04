<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h1>Мои Заказы</h1>
    <p class="lead">Список заказанных проектов</p>
</div>

<div class="row">
    <div class="col-md-2">ID</div>
    <div class="col-md-2">Дата</div>
    <div class="col-md-2">Время</div>
    <div class="col-md-2">Пользователь</div>
    <div class="col-md-2">Проект</div>
 <div class="col-md-1"> </div>

</div>

<c:forEach items="${orders}" var="varOrders">

    <br>
    <div class="row">
     <div class="col-md-2">${varOrders.id} </div>
        <div class="col-md-2">${varOrders.date} </div>
        <div class="col-md-2">${varOrders.time} </div>
        <div class="col-md-2">${varOrders.users_id} </div>
 <div class="col-md-2">${varOrders.items_id} </div>

  </div>

</c:forEach>




</div>
</body>
</html>
