<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<div class="row">
 <div class="col-md-1">ID</div>
 <div class="col-md-2">ФИО</div>
 <div class="col-md-2">Гаражи</div>
 <div class="col-md-2">Login</div>
 <div class="col-md-2">Email</div>
</div>
<div class="row">
<div class="col-md-1">${user.id}</div>
<div class="col-md-2">${user.fio}</div>
<div class="col-md-2">${user.numbergarages}</div>
<div class="col-md-2">${user.nickname}</div>
<div class="col-md-2">${user.email}</div>
</div>
</body>
</html>
