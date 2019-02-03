<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h1>Профиль</h1>
    <p class="lead">Здравствуйте, <font color=green><strong>${user.username}!</strong></font></p>
</div>

<div class="container">
    <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-1>User</div>
            <div class=col-md-1>Пароль</div>
            <div class=col-md-1>Email</div>
            <div class=col-md-1>ФИО</div>
            <div class=col-md-1>Тел</div>
            <div class=col-md-1>Адрес</div>
            <div class=col-md-1>Роль</div>
    </div>
</div>

<div class="container">

            <form class="update-userid-${user.id}" action="do?command=Profile" method="POST">
                <div class="row">
                    <div class=col-md-1 >
                                        <input id="id" class="form-control input-md" name="id"
                                               value="${user.id}"readonly/>
                                    </div>
                                        <div class=col-md-1>
                                                            <input id="username" class="form-control input-md" name="username"
                                                                   value="${user.username}"readonly/>
                                                                   </div>

                    <div class=col-md-1>
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="email" class="form-control input-md" name="email"
                               value="${user.email}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="user" class="form-control input-md" name="fullname"
                               value="${user.fullname}"/>
                    </div>
                           <div class=col-md-1>
                                            <input id="phone" class="form-control input-md" name="phone"
                                                   value="${user.phone}"/>
                                        </div>



                           <div class=col-md-1>
                                            <input id="address" class="form-control input-md" name="address"
                                                   value="${user.address}"/>
                                        </div>
            <div class=col-md-1>
                                <select id="role" name="roles_id" class="form-control">
                                    <c:forEach items="${roles}" var="role">
                                        <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                                ${role.role}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>


 <div class=col-md-1>


                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>


                    </div>
                </div>
            </form>

</div>




</div>
</body>
</html>
