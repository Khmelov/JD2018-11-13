<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="do?command=ndex">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">


                <a class="nav-item nav-link active" href="do?command=Login">Вход<span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="do?command=SignUp">Регистрация</a>
                <a class="nav-item nav-link" href="do?command=Profile">Профиль</a>

                <a class="nav-item nav-link" href="do?command=Create">Добавить в БД</a>
                <a class="nav-item nav-link" href="do?command=ResetDB">Пересоздать БД</a>
                <a class="nav-item nav-link" href="do?command=DropDB">Удалить БД</a>
                <a class="nav-item nav-link" href="do?command=basket">Корзина</a>
                <a class="nav-item nav-link" href="do?command=Zakaz">Заказы</a>
               <!-- <a class="nav-item nav-link" href="do?command=Error">Ошибка</a>-->

                <form class="form-inline my-2 my-lg-0" action ="do?command=Logout" method="POST">
                    <button class="btn btn-outline-success my-2 my-sm-0" id="logout", name="logout" type="submit">Выход</button>
                </form>

        </div>
    </div>
</nav>