<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="do?command=Index">Home</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${user==null}">
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="do?command=Reset">Сброс БД</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="do?command=SignUp">Регистрация</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="do?command=Login">Войти</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item dropdown">
                        <a class="nav-item nav-link" href="do?command=CreateAd">Создать объявление</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-item nav-link" href="do?command=Profile">Профиль</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Админка
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="do?command=EditUsers">Пользователи</a>
                            <a class="dropdown-item" href="#">Объявления</a>
                            <a class="dropdown-item" href="#">БД</a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
        <c:if test="${user!=null}">
            <form class="form-inline my-2 my-lg-0" action="do?command=Profile" method="POST">
                <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
            </form>
        </c:if>
    </div>
</nav>
