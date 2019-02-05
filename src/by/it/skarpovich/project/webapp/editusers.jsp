
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<div class="page-header">
    <h2>Редактирование пользователей</h2>
    <p class="lead">Редактирование данных пользователей</p>
</div>

<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr>
            <th scope="col">ID</th>
            <th scope="col">Логин</th>
            <th scope="col">Пароль</th>
            <th scope="col">E-mail</th>
            <th scope="col">ФИО</th>
            <th scope="col">Телефон</th>
            <th scope="col">Адрес</th>
            <th scope="col">Роль</th>
            <th scope="col"></th>
            <th scope="col"></th>
 </tr>
 </thead>
 <tbody>  <c:forEach items="${users}" var="user">
  <tr>
            <form class="update-user-${user.id}" action="do?command=editusers" method="POST">
            <td><input size="1" id="id" class="form-control input-md" name="id" value="${user.id}" readonly/></td>
            <td><input size="3" id="username" class="form-control input-md" name="username" value="${user.username}"/></td>
            <td><input size="2" id="password" class="form-control input-md" name="password" value="${user.password}"/></td>
            <td><input size="10" id="email" class="form-control input-md" name="email" value="${user.email}"/>
            <td><input size="6" id="fullname" class="form-control input-md" name="fullname" value="${user.fullname}"/></td>
            <td><input size="9" id="phone" class="form-control input-md" name="phone" value="${user.phone}"/></td>
            <td><input size="12" id="address" class="form-control input-md" name="address" value="${user.address}"/></td>

            <td><select id="role" name="roles_id" class="form-control">
            <c:forEach items="${roles}" var="varka">
            <option value="${varka.id}" role=${varka.id} ${varka.id==user.roles_id?"selected":""}> ${varka.role}</option>
            </c:forEach></select></td>
            <td><button id="Update" value="Update" name="Update" class="btn btn-info">Обновить</button></td>
            <td><button id="Delete" value="Delete" name="Delete" class="btn btn-danger">Удалить</button></td>
            </form> </tr></c:forEach>
  </tbody>
  </table>

</div>
</body>
</html>

