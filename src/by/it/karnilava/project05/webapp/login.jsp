<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>


<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=login" method="POST">
 <div class="container">
<fieldset>

<!-- Form Name -->
<legend>Log in</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passport">passport</label>
  <div class="col-md-4">
  <input id="passport" name="passport" type="text" placeholder="" class="form-control input-md" required="">


  </div>
</div>


<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="login"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-info">Log in</button>
  </div>
</div>

</fieldset>
  </div>
</form>



</body>
</html>

