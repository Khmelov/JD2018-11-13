<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

  <div class="FormSignup">
	<form class="form-horizontal" action ="do?command=signup" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>Регистрация</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logininput">Имя пользователя</label>
      <div class="col-md-4">
      <input id="logininput" name="login" value="naymchik" type="text" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="emailinput">E-mail</label>
      <div class="col-md-4">
      <input id="email" name="email" value="naymchik@yandex.ru" type="text" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="passwordinput">Пароль</label>
      <div class="col-md-4">
        <input id="password" name="password" value ="password" type="password" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="signup"></label>
      <div class="col-md-4">
        <button type="submit" id="signup" name="signup" class="btn btn-success">SignUP</button>
      </div>
    </div>

    </fieldset>
    </form>
  </div>
</div>
</body>
</html>