<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Пароль</th>
            <th scope="col">Почта</th>
            <th scope="col">Телефон</th>

        </tr>
        </thead>

        <tbody>

        <form class="update-user" action="do?command=EditUsers" method=post>
            <tr>
                <td><input type="password" id="password" class="form-control input-sm" name="password"
                           value="${user.password}"/></td>
                <td><input id="email" class="form-control input-sm" name="email" value="${user.email}"/></td>
                <td><input id="phone_number" class="form-control input-sm" name="phone_number"
                           value="${user.phone_number}"/></td>
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