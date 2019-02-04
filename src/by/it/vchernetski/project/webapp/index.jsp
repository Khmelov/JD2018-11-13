<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h1>Машины пользователя</h1>
</div>
<div class="row">
    <div class="col-md-2"> </div>
    <div class="col-md-2">Модель</div>
    <div class="col-md-1">Цвет</div>
    <div class="col-md-1">Год</div>
 </div>

<c:forEach items="${cars}" var="car">
     <form class="update-user-${user.id}" action="do?command=Index" method=POST>
    <br>
    <div class="row">
        <div class="col-md-2">
        <img src="image/im${car.id}" height="40"/>
        </div>
        <div class="col-md-2">${car.model} </div>
        <div class="col-md-1">${car.color} </div>
        <div class="col-md-1">${car.year} </div>
        <div class=col-md-3>
            <button id="Deletecar" value="Deletecar" name="Deletecar" class="btn btn-danger">
                Запрос на удаление
            </button>
        </div>
    </div>
    <input id="id" name="id" hidden="true" value="${car.id}"/>
    </form>
</c:forEach>
<br><br>
</div>
</body>
</html>
