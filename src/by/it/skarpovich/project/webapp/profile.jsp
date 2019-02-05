<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h2>Профиль</h2>
    <p class="lead">Здравствуйте, <font color=green><strong>${user.username}!</strong></font></p>
</div>
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr>
            <th scope="col">ID</th>
            <th scope="col">Логин</th>
            <th scope="col">Пароль</th>
            <th scope="col">E-mail</th>
            <th scope="col">Ф.И.О</th>
            <th scope="col">Телефон</th>
            <th scope="col">Адрес</th>
            <th scope="col">Роль</th>
 </tr>
 </thead>
 <tbody>
  <tr>
            <form class="update-userid-${user.id}" action="do?command=Profile" method="POST">
            <td><input size="1" id="id" class="form-control input-md" name="id" value="${user.id}" readonly/></td>
            <td><input size="2" id="username" class="form-control input-md" name="username" value="${user.username}" readonly/></td>

            <td><input size="3" id="password" class="form-control input-md" name="password" value="${user.password}"/></td>
            <td><input size="11" id="email" class="form-control input-md" name="email" value="${user.email}"/>
            <td><input size="9" id="fullname" class="form-control input-md" name="fullname" value="${user.fullname}"/></td>
            <td><input size="9" id="phone" class="form-control input-md" name="phone" value="${user.phone}"/></td>
            <td><input size="11" id="address" class="form-control input-md" name="address" value="${user.address}"/></td>                                                                            </td>
            <td>
            <select id="role" name="roles_id" class="form-control">
            <c:forEach items="${roles}" var="role">
            <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>${role.role}</option>
            </c:forEach></select>
            </td>
            <td><button id="Update" value="Update" name="Update" class="btn btn-info">Обновить</button> </td>
            </form></tr>
  </tbody>
  </table>


</div>
</body>
</html>
