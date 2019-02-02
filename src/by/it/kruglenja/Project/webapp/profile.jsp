<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.htm" %>
<body>
<div    class="container">
    <%@ include file="include/menu.htm" %>
    <p>USER PROFILE: <br> ${user}</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Логин</th>
            <th scope="col">Роль</th>
            <th scope="col">Пароль</th>
            <th scope="col">Почта</th>
            <th scope="col">Телефон</th>

        </tr>
        </thead>

        <tbody>

            <form class="update-user-${user.id}" action="do?command=EditUsers" method=post>
                <tr>
                    <td><input type="hidden" id="id" class="form-control input-sm" name="id" value="${user.id}"/></td>
                    <td><input type="hidden" id="login" class="form-control input-sm" name="login" value="${user.login}"/></td>
                    <td><input type ="password" id="password" class="form-control input-sm" name="password" value="${user.password}"/></td>
                    <td><input id="email" class="form-control input-sm" name="email" value="${user.email}"/></td>
                    <td><input id="phone_number" class="form-control input-sm" name="phone_number" value="${user.phone_number}"/></td>
                    <td><input type="hidden" id="role" class="form-control input-sm" name="role" value="${user.roles_Id}"/></td>

                    <td>
                        <button id="update" value="update" name="update" class="btn btn-success">Обновить</button>
                    </td>
                </tr>
            </form>
        </tbody>

    </table>
        </div>
</body>
</html>