<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.jsp" %>

<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
    <c:forEach items="${users}" var="user">
        <form class="update-user-${user.id}" action="do?command=EditUsers" method="POST">
            <div class="row">
                <div class="col-md-3">
                    <label for="id">ID</label>
                    <input readonly id="id" class="form-control input-md" name="id" type="" value="${user.id}"/>
                </div>
                <c:choose>
                    <c:when test="${user.id==1}">
                        <div class="col-md-3">
                            <label for="login">Логин</label>
                            <input readonly id="login" class="form-control input-md" name="login"
                                   value="${user.login}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="password">Пароль</label>
                            <input readonly id="password" class="form-control input-md" name="password"
                                   value="${user.password}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="name">Имя</label>
                            <input readonly id="name" class="form-control input-md" name="name"
                                   value="${user.name}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="dateofbirth">Дата рожения</label>
                            <input readonly id="dateofbirth" class="form-control input-md" name="dateofbirth"
                                   value="${user.dateOfBirth}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="email">Email</label>
                            <input readonly id="email" class="form-control input-md" name="email"
                                   value="${user.email}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="tel">Телефон</label>
                            <input readonly id="tel" class="form-control input-md" name="tel" value="${user.tel}"/>
                        </div>

                        <div class=col-md-3>
                            <label for="role">Привелегии</label>
                            <input readonly id="role" class="form-control input-md" name="role" value="admin"/>

                        </div>

                    </c:when>

                    <c:otherwise>
                        <div class="col-md-3">
                            <label for="dateofbirth">Логин</label>
                            <input id="login" class="form-control input-md" name="login" value="${user.login}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="password">Пароль</label>
                            <input id="password" class="form-control input-md" name="password"
                                   value="${user.password}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="name">Имя</label>
                            <input id="name" class="form-control input-md" name="name" value="${user.name}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="dateofbirth">Дата рожения</label>
                            <input id="dateofbirth" class="form-control input-md" name="dateofbirth"
                                   value="${user.dateOfBirth}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="email">Email</label>
                            <input id="email" class="form-control input-md" name="email" value="${user.email}"/>
                        </div>

                        <div class="col-md-3">
                            <label for="tel">Телефон</label>
                            <input id="tel" class="form-control input-md" name="tel" value="${user.tel}"/>
                        </div>

                        <div class=col-md-3>
                            <label for="role">Привелегии</label>
                            <select id="role" name="roles_Id" class="form-control">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}"
                                            role=${role.id} ${role.id==user.roles_Id?"selected":""}>
                                            ${role.role}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="container">
                            <br>
                            <button id="Update" value="Update" name="Update" class="btn-success">
                                Обновить
                            </button>

                            <button id="Delete" value="Delete" name="Delete" class="btn-danger">
                                Удалить
                            </button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </form>
        <hr>

    </c:forEach>


</div>

</body>
</html>


