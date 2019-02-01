<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <div class="page-header">
        <h3>Профиль ${user.login}</h3>
    </div>
    <div class="row">
        <div class="col-md-2">Лоигн</div>
        <div class="col-md-2">Имя</div>
        <div class="col-md-2">Дата рождения</div>
        <div class="col-md-2">Email</div>
        <div class="col-md-2">Телефон</div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-2">${user.login}</div>
        <div class="col-md-2">${user.name}</div>
        <div class="col-md-2">${user.dateOfBirth}</div>
        <div class="col-md-2">${user.email}</div>
        <div class="col-md-2">${user.tel}</div>
    </div>
    <br>
    <div class="page-header">
        <h3>Объявления ${user.login}</h3>
    </div>

    <div class="row">
        <div class="col-md-2">Заголовок</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Марка</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Цвет</div>
        <div class="col-md-1">Объем двигателя</div>
        <div class="col-md-2">Цена</div>
    </div>
    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
            <div class="col-md-2">${ad.title}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.brnd}</div>
            <div class="col-md-1">${ad.model}</div>
            <div class="col-md-1">${ad.color}</div>
            <div class="col-md-1">${ad.engine} л.</div>
            <div class="col-md-2">${ad.price} руб.</div>
        </div>
    </c:forEach>

    <form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>
