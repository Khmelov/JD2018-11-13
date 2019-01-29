<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
  <div class="FormLogin">
    <form class="form-horizontal">
    <fieldset>

    <!-- Form Name -->
    <legend>LogIN</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login">login</label>
      <div class="col-md-4">
      <input id="login" name="login" value="vasya" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">password</label>
      <div class="col-md-4">
        <input id="password" name="password" value="vasya" type="password" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login"></label>
      <div class="col-md-4">
        <button id="login" name="login" class="btn btn-success">LogIN</button>
      </div>
    </div>

    </fieldset>
    </form>
  </div>

</div>
</body>

</html>

