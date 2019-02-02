<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Логин</th>
            <th scope="col">Пароль</th>
            <th scope="col">Почта</th>
            <th scope="col">Телефон</th>
            <th scope="col">Роль</th>

        </tr>
        </thead>

        <tbody>

        <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=EditUsers" method=post>
            <tr>
                <td><input type="hidden" id="id" class="form-control input-sm" name="id" value="${user.id}"/></td>
                <td><input id="login" class="form-control input-sm" name="login" value="${user.login}"/></td>
                <td><input id="password" class="form-control input-sm" name="password" value="${user.password}"/></td>
                <td><input id="email" class="form-control input-sm" name="email" value="${user.email}"/></td>
                <td><input id="phone_number" class="form-control input-sm" name="phone_number" value="${user.phone_number}"/></td>
                <td>
                    <select id="role" class="form-control" name="role">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.roles_Id?"selected":""}>${role.role}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button id="update" value="update" name="update" class="btn btn-success">Обновить</button>
                </td>
                <td>
                    <button id="delete" value="delete" name="delete" class="btn btn-danger">Удалить</button>
                </td>

            </tr>
            </form>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
</html>

