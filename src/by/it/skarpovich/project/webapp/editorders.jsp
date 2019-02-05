<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=EditOrders" method="POST">
<fieldset>

<div class="page-header">
    <h2>Редактирование заказов</h2>
    <p class="lead">Редактирование заказов пользователей</p>
</div>

<!-- Text input-->
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr>
            <th scope="col">ID</th>
            <th scope="col">Дата</th>
            <th scope="col">Время</th>
            <th scope="col">Пользователь</th>
            <th scope="col">Проект</th>
            <th scope="col"></th>
            <th scope="col"></th>
 </tr>
 </thead>

 <tbody>
  <c:forEach items="${orders}" var="vrd">
  <tr>
            <form class="update-vrd-${vrd.id}" action="do?command=editorders" method="POST">
            <td><input id="id" class="form-control input-md" name="id" value="${vrd.id}" readonly/></td>
            <td><input id="date" class="form-control input-md" name="date" value="${vrd.date}"/></td>
            <td><input id="time" class="form-control input-md" name="time" value="${vrd.time}"/></td>
            <td><input id="users_id" class="form-control input-md" name="users_id" value="${vrd.users_id}"/></td>
            <td><input id="items_id" class="form-control input-md" name="items_id" value="${vrd.items_id}"/></td>
            <td><button id="Update" value="Update" name="Update" class="btn btn-info">Обновить</button></td>
            <td><button id="Delete" value="Delete" name="Delete" class="btn btn-danger">Удалить</button></td></form></tr>
 </c:forEach>
        </tbody>
      </table>

</div>
</body>
</html>
