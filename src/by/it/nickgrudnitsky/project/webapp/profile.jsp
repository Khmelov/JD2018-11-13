<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menuIn.htm" %>
<p>Cmd Profile:<br> ${user}</p>
<form class="form-horizontal" action="do?command=logout" method="POST">

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Log Out</button>
  </div>

</div>
</body>
</html>
