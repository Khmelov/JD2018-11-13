<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<p>User Profile:<br> ${user}</p>
<p>Orders List: <br> ${orders}</p>
<em>(Shows USER ORDERS LIST for Users and FULL ORDERS LIST for admins)</em>
<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Form Name -->

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-success">LogOut</button>
  </div>
</div>
</fieldset>
</form>


</div>
</body>
</html>
