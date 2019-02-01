<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Login</title>
	<style>
	   #loginmenu {
	    color: #fff;
	   }
	</style>
	<%@ include file="include/head.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>

<div class="container">

<c:if test="${wrong_name!=null}">
    <p>User with this login and password does&apos;t exists</p>
</c:if>
<c:if test="${wrong_password!=null}">
    <p>Password is incorrect</p>
</c:if>

<form class="form-horizontal" action="do?command=Login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- login input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="TestUser" type="text" placeholder="min 6 symbols" class="form-control input-md" required>

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required>

  </div>
</div>

<!-- login Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-success">Login</button>
  </div>
</div>
</fieldset>
</form>

</div>
</body>
</html>

