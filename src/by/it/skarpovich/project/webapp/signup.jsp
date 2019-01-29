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
  <label class="col-md-4 control-label" for="username">Username</label>
  <div class="col-md-4">
  <input id="username" name="username" value="john2" type="text" placeholder="min 6 symbols" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="john1" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" value="test-email@email.com" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="fullname">Full Name</label>
  <div class="col-md-4">
  <input id="fullname" name="fullname" value="John McAfee" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Phone</label>
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
    <button id="signup" name="signup" class="btn btn-success">Sign Up</button>
  </div>
</div>
</fieldset>
</form>




</div>
</body>
</html>




