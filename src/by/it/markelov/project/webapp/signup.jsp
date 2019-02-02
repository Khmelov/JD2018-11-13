<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=SignUp" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Sign Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value="TestUser" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password</label>
  <div class="col-md-4">
    <input id="Password" name="Password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="E-mail">E-mail</label>
  <div class="col-md-4">
  <input id="E-mail" name="E-mail" value="Testemail@email.com" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Sign Up button"></label>
  <div class="col-md-4">
    <button id="Sign Up button" name="Sign Up button" class="btn btn-success">Sign Up</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>




