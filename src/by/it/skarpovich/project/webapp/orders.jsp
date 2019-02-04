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
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr>
    <th scope="col">ID</th>
    <th scope="col">Дата</th>
    <th scope="col">Время</th>
    <th scope="col">Пользователь</th>
    <th scope="col">Проект</th>

 </tr>
  </thead>
 <tbody>
    <tr>
<c:forEach items="${orders}" var="varOrders">
     <td>${varOrders.id}</td>
         <td>${varOrders.date}</td>
        <td>${varOrders.time}</td>
        <td>${varOrders.users_id}</td>
 <td>${varOrders.items_id} </td>
 </tr>
</c:forEach>
      </tbody>
    </table>
</div>
</body>
</html>
