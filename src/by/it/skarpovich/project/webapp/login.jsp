<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=login" method="POST">
<fieldset>

<div class="page-header">
    <h2>Авторизация</h2>
    <p class="lead">Введите логин и пароль</p>
</div>

<!-- Text input-->
<div class="form-group">
    <label class="col-md-4 control-label" for="username">Имя пользователя</label>
    <div class="col-md-4">
    <input id="username" name="username" value="john" type="text" placeholder="min 4 symbols" class="form-control input-md" required="">
</div>
</div>

<!-- Password input-->
<div class="form-group">
    <label class="col-md-4 control-label" for="password">Пароль</label>
    <div class="col-md-4"><input id="password" name="password" value="john1" type="password" placeholder="" class="form-control input-md" required="">
    </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="username"></label>
  <div class="col-md-4"><button id="login" name="login" class="btn btn-info">Войти</button></div>
</div>
</fieldset>
</form>
<div class="page-header">

    <p class="lead">Нет аккаунта? <a href="http://localhost:28080/skarpovich/do?command=signup">Зарегистрируйтесь!</a></p>
</div>
</div>
</body>
</html>

