<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=profile" method="POST">
 <div class="container">

 <!-- Form Name -->
    <legend>${fullName}</legend>



<div class="row">
    <div class="col-md-3">Number</div>
    <div class="col-md-2">Balance, BYN</div>
    <div class="col-md-1">Type</div>
    <div class="col-md-1">State</div>


</div>

<c:forEach items="${accounts}" var="account">
    <br>
    <div class="row">
        <div class="col-md-3">${account.number} </div>
        <div class="col-md-2">${account.balance} </div>
        <div class="col-md-1">${account.type} </div>
        <div class="col-md-1">${account.state} </div>

    </div>
</c:forEach>

<br><br>
  </div>





</body>
</html>