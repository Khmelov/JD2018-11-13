<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.jsp" %>

<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
    <c:forEach items="${ads}" var="ad">
        <form class="update-ads-${ad.id}" action="do?command=EditAds" method="POST">
            <div class="row">
                <div class="col-md-3">
                    <label for="id">ID</label>
                    <input readonly id="id" class="form-control input-md" name="id" value="${ad.id}"/>
                </div>
                <div class="col-md-3">
                    <label for="title">Заголовок</label>
                    <input readonly id="title" class="form-control input-md" name="title" value="${ad.title}"/>
                </div>
                <div class="col-md-3">
                    <label for="description">Описание</label>
                    <input readonly id="description" class="form-control input-md" name="description"
                           value="${ad.description}"/>
                </div>
                <div class="col-md-3">
                    <label for="brnd">Марка</label>
                    <input readonly id="brnd" class="form-control input-md" name="brnd" value="${ad.brnd}"/>
                </div>
                <div class="col-md-3">
                    <label for="model">Модель</label>
                    <input readonly id="model" class="form-control input-md" name="model" value="${ad.model}"/>
                </div>
                <div class="col-md-3">
                    <label for="color">Цвет</label>
                    <input readonly id="color" class="form-control input-md" name="color" value="${ad.color}"/>
                </div>
                <div class="col-md-3">
                    <label for="body">Кузов</label>
                    <input readonly id="body" class="form-control input-md" name="body" value="${ad.body}"/>
                </div>
                <div class="col-md-3">
                    <label for="year">Год</label>
                    <input readonly id="year" class="form-control input-md" name="year" value="${ad.year}"/>
                </div>
                <div class="col-md-3">
                    <label for="engine">Объем двигателя</label>
                    <input readonly id="engine" class="form-control input-md" name="engine" value="${ad.engine}"/>
                </div>
                <div class="col-md-3">
                    <label for="at">Коробка передач</label>
                    <input readonly id="at" class="form-control input-md" name="at" value="${ad.at}"/>
                </div>
                <div class="col-md-3">
                    <label for="driveunit">Привод</label>
                    <input readonly id="driveunit" class="form-control input-md" name="driveunit"
                           value="${ad.driveunit}"/>
                </div>
                <div class="col-md-3">
                    <label for="equipment">Комплектация</label>
                    <input readonly id="equipment" class="form-control input-md" name="equipment"
                           value="${ad.equipment}"/>
                </div>
                <div class="col-md-3">
                    <label for="millage">Пробег</label>
                    <input readonly id="millage" class="form-control input-md" name="millage" value="${ad.millage}"/>
                </div>
                <div class="col-md-3">
                    <label for="crashed">ДТП</label>
                    <input readonly id="crashed" class="form-control input-md" name="crashed" value="${ad.crashed}"/>
                </div>

                <div class="col-md-3">
                    <label for="price">Цена</label>
                    <input readonly id="price" class="form-control input-md" name="price" value="${ad.price}"/>
                </div>

                <div class=col-md-3>
                    <label for="id_User">Пользователь</label>

                    <input readonly id="id_User" class="form-control input-md" name="id_User" value="${ad.id_User}"/>

                        <%--<select disabled id="id_User" name="id_User" class="form-control">--%>
                        <%--<c:forEach items="${users}" var="user">--%>
                        <%--<option value="${ad.id_User}"--%>
                        <%--user=${user.id} ${user.id==ad.id_User?"selected":""}>--%>
                        <%--${user.login}--%>
                        <%--</option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                </div>

                <div class="col-md-3">
                    <div class="container">
                        <br>
                        <button id="delete" value="Delete" name="delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>
                </div>
            </div>
        </form>
        <hr>
    </c:forEach>
</div>
</body>
</html>


