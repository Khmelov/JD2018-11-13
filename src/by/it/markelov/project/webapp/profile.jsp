<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>

<!--<p>Profile User: <br> ${user}</p>
<p>Orders User: <br> ${orders}</p>-->

<!-- Основное содержимое -->

<div class="page-header">
    <h1>Заказы покупателя ${user.login}</h1>
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


<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Logout</legend>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Logout button"></label>
  <div class="col-md-4">
    <button id="Logout" name="Logout" class="btn btn-success">Logout</button>
  </div>
</div>

</fieldset>
</form>



</div>
</body>
</html>
