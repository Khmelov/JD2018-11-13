<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:choose>
                <c:when test="${user==null}">
                    <a class="nav-item nav-link" href="do?command=SignUp">Регистрация</a>
                    <a class="nav-item nav-link" href="do?command=Login">Вход</a>
                    <a class="nav-item nav-link" href="do?command=Reset">Пересоздать БД</a>
                    <a class="nav-item nav-link" href="do?command=Delete">Удалить БД</a>
                </c:when>
                <c:otherwise>
                    <a class="nav-item nav-link" href="do?command=Profile">Профиль</a>
                    <a class="nav-item nav-link" href="do?command=CreateGood">Добавить товар</a>
                    <a class="nav-item nav-link" href="do?command=EditGoods">Исправить товар</a>
                    <a class="nav-item nav-link" href="do?command=EditUsers">Админка</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>