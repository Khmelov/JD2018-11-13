<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>


<div class="page-header">
    <h1>Каталог проектов</h1>
    <p class="lead">Список архитектурных проектов домов</p>
</div>
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr>
        <th scope="col">  Название </th>
        <th scope="col"> Этажность </th>
        <th scope="col"> Площадь(м2) </th>
        <th scope="col"> Материал стен </th>
        <th scope="col"> Цена </th>
        <th scope="col">  Заказ </th>
    </tr>
  </thead>
 <tbody>
        <c:forEach items="${items}" var="varItems">
        <tr>
        <form class="update-varItems-${varItems.id}" action="do?command=buynow" method="POST">
        <input id="id" type="hidden" class="form-control input-md" name="id" value="${varItems.id}"/>
        <td> ${varItems.title} </td>
        <td> ${varItems.floors} </td>
        <td> ${varItems.square} </td>
        <td> ${varItems.materials} </td>
        <td> ${varItems.price} </td>
        <td><button id="Update" value="Buy" name="Buy" class="btn btn-success">Купить</button></td>
        </form>
        </tr></c:forEach>
   </tbody>
 </table>

</div>
</body>
</html>
