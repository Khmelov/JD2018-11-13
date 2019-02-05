<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<%--<p>Profile User:<br> ${user}</p>--%>
    <form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>
            <div class="container">
                <div class="row">
                    <div class=col-md-1>ID</div>
                    <div class=col-md-2>Имя</div>
                    <div class=col-md-2>Пароль</div>
                    <div class=col-md-2>Email</div>
                    <div class=col-md-2>Роль</div>
                </div>
                <hr>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-1">${user.id} </div>
                    <div class=col-md-2>${user.login}</div>
                    <div class=col-md-2>${user.password}</div>
                    <div class=col-md-2>${user.email}</div>
                <div class=col-md-2>${user.id_role}</div>
                </div>
            </div>
            <div class="form-group">
        <label class="col-md-4 control-label" for="logout"></label>
        <div class="col-md-4">
            <button id="logout" name="logout" class="btn btn-success">Выйти</button>
        </div>
    </div>
    </fieldset>
    </form>

</div>
</body>
</html>
