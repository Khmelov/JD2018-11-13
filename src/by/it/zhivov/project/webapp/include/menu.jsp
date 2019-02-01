<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="do?command=Index">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:choose>
                <c:when test="${user==null}">
                    <a class="nav-item nav-link" href="do?command=Reset">Сброс БД</a>
                    <a class="nav-item nav-link" href="do?command=SignUp">Регистрация</a>
                    <a class="nav-item nav-link" href="do?command=Login">Войти</a>
                </c:when>
                <c:otherwise>
                    <a class="nav-item nav-link" href="do?command=Profile">Профиль</a>
                    <c:if test="${user.roles_Id==1}">
                        <a class="nav-item nav-link" href="do?command=EditUsers">Админка</a>
                    </c:if>
                    <a class="nav-item nav-link" href="do?command=CreateAd">Создать объявление</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</nav>
