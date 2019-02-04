<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="page-header">
        <h1>Объявления ${user.login}</h1>
        <p class="lead">Ваши объявления:</p>
    </div>

    <div class="row">
        <div class="col-md-4">Краткое описание</div>
        <div class="col-md-4">Полное описание</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>

    </div>

        <c:forEach items="${buyers}" var="buyer">
            <br>
            <div class="row">
                <div class="col-md-4">${buyer.item} </div>
                <div class="col-md-4">${buyer.specif} </div>
                <div class="col-md-1">${buyer.price} </div>
                <div class="col-md-3">${buyer.address} </div>
            </div>
        </c:forEach>

        <br><br>

        <form class="form-horizontal" action="do?command=Profile" method="POST">
            <fieldset>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="logout"></label>
                    <div class="col-md-4">
                        <button id="logout" name="logout" value="logout" class="btn btn-success">Выйти</button>
                    </div>
                </div>
            </fieldset>
        </form>

    </div>
</body>
</html>
