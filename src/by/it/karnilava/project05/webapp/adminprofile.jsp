<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=adminprofile" method="POST">
 <div class="container">
 <!-- Form Name -->
 <legend>Admin</legend>





<div class="row">
    <div class="col-md-1" data-href="do?command=clientprofile" method="POST">ID</div>
    <div class="col-md-2">First Name</div>
    <div class="col-md-3">Last Name</div>
    <div class="col-md-4">Passport</div>


</div>

<c:forEach items="${clients}" var="client">
    <br>
    <div class="row">
        <div class="col-md-1" >${client.id} </div>

        <div class="col-md-2">${client.firstName} </div>
        <div class="col-md-3">${client.lastName} </div>
        <div class="col-md-4">${client.passport} </div>
        <a href="clientprofile.jsp?id=client.id">edit</a>


    </div>
</c:forEach>

<br><br>

  </div>
</body>
</html>


