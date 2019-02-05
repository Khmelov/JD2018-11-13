<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h1>Объявления ${user.login}</h1>
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

    <hr>
    <div class="row">
        <mytag:paginator count="${adsSize}" step="5" urlprefix="do?command=Profile&start="/>
    </div>


<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Logout</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" value="logout" class="btn btn-success">Выйти</button>
  </div>
</div>
</fieldset>
</form>

</div>
</body>
</html>
