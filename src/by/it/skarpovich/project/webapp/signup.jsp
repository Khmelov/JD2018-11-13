<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">


<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<div class="page-header">
    <h2>Регистрация</h2>
    <p class="lead">Введите данные для регистрации аккаунта</p>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="username">Логин</label>
  <div class="col-md-4">
  <input id="username" name="username" value="" type="text" placeholder="min 4 symbols" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" value="john1" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" value="test-email3@email.com" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="fullname">Ф.И.О.</label>
  <div class="col-md-4">
  <input id="fullname" name="fullname" value="John McAfee" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Телефон</label>
  <div class="col-md-4">
  <input id="phone" name="phone" value="111-777-222" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>
  <div class="col-md-4">
  <input id="address" name="address" value="Neutral territory 1" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-info">Зарегистрироваться</button>
  </div>
</div>
</fieldset>
</form>




</div>
</body>
</html>




