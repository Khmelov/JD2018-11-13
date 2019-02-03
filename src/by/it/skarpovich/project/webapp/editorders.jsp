<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=EditOrders" method="POST">
<fieldset>

<div class="page-header">
    <h1>Редактирование заказов</h1>
    <p class="lead">Редактирование заказов пользователей</p>
</div>

<!-- Text input-->

<div class="container">
    <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-1>Дата</div>
            <div class=col-md-1>Время</div>
            <div class=col-md-1>Пользователь</div>
            <div class=col-md-1>Проект</div>
  <div class=col-md-1>Email</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${orders}" var="vrd">
            <form class="update-vrd-${vrd.id}" action="do?command=editusers" method="POST">
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${vrd.id}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="date" class="form-control input-md" name="date"
                               value="${vrd.date}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="time" class="form-control input-md" name="time"
                               value="${vrd.time}"/>
                    </div>
                       <div class=col-md-1>
                                            <input id="users_id" class="form-control input-md" name="users_id"
                                                   value="${vrd.users_id}"/>
                                        </div>

                    <div class=col-md-1>
                        <input id="items_id" class="form-control input-md" name="items_id"
                               value="${vrd.items_id}"/>
                    </div>



                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>

                </div>
            </form>
    </c:forEach>
</div>





</div>
</body>
</html>

