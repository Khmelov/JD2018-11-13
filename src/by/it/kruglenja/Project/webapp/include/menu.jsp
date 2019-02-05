<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Catalog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
                        <c:if test="${user == null}">

            <li class="nav-item">

                <a class="nav-link" href="do?command=Login">Войти</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=SignUp">Регистрация</a>
            </li>
            <li class="nav-item">
                        </c:if>
                <c:if test="${user != null}">
                <a class="nav-link" href="do?command=Profile">Профиль</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Order">Корзина</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=FILLCATALOG">Каталог(админ.)</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=EditUsers">Польз(админ.)</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=CompletedOrder">Заказы(админ.)</a>
            </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Reset">RESET DB</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Delete">DELETE DB</a>
            </li>
        </ul>
    </div>
</nav>

