<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Имя</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-2>Роль</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${user.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="nickname" class="form-control input-md" name="login"
                               value="${user.login}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="email" class="form-control input-md" name="email"
                               value="${user.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="role" name="roles_Id" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.roles_Id?"selected":""}>
                                        ${id_role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success  md-1">
                        Обновить
                    </button>
                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger md-1">
                        Удалить
                    </button>
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
