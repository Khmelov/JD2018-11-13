<!DOCTYPE html>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

	<form class="form-horizontal" action ="do?command=signup" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>registration</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logininput">nickname</label>
      <div class="col-md-4">
      <input id="logininput" name="login" value="naymchik" type="text" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="emailinput">email</label>
      <div class="col-md-4">
      <input id="email" name="email" value="naymchik@yandex.ru" type="text" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="passwordinput">password</label>
      <div class="col-md-4">
        <input id="password" name="password" value ="password" type="password" placeholder="placeholder" class="form-control input-md">

      </div>
    </div>

    <!-- Button (Double) -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="OKbutton"></label>
      <div class="col-md-8">
        <button id="submith" name="submith" class="btn btn-success">OK</button>

      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>