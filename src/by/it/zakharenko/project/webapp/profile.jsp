<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>







<div class="page-header">
    <h1>Корзина</h1>

</div>

<div class="row">
    <div class="col-md-2">Дата</div>
    <div class="col-md-2">Время</div>
    <div class="col-md-2">Товар</div>
</div>

<c:forEach items="${orders}" var="varOrders">
    <br>
    <div class="row">
        <div class="col-md-2">${varOrders.date} </div>
        <div class="col-md-2">${varOrders.time} </div>
        <div class="col-md-2">${varOrders.items_id} </div>
    </div>
</c:forEach>
<br><br>







<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Form Name -->

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-success">LogOut</button>
  </div>
</div>
</fieldset>
</form>


</div>
</body>
</html>
