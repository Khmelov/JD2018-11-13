<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>


<div class="page-header">
    <h2>Каталог проектов</h2>
    <p class="lead">Список архитектурных проектов домов и коттеджей</p>
</div>
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr><th scope="col">Фото</th>
        <th scope="col">Название</th>
        <th scope="col">Этажность</th>
        <th scope="col">Площадь(м2)</th>
        <th scope="col">Материал стен</th>
        <th scope="col">Цена</th>
        <th scope="col"></th>
    </tr>
  </thead>
 <tbody>
        <c:forEach items="${items}" var="item">
        <tr>
        <form class="update-item-${item.id}" action="do?command=buynow" method="POST">
        <td><img src="image/item${item.id}" height="88px"></td>
        <input id="id" type="hidden" class="form-control input-md" name="id" value="${item.id}"/>
        <td>${item.title}</td>
        <td>${item.floors}</td>
        <td>${item.square}</td>
        <td>${item.materials}</td>
        <td>${item.price}</td>
        <td><button id="Update" value="Buy" name="Buy" class="btn btn-info">Заказать</button></td>
        </form>
        </tr></c:forEach>
   </tbody>
 </table>

</div>
</body>
</html>
