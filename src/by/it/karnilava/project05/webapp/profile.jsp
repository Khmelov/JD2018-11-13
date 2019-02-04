<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=profile" method="POST">
 <div class="container">

 <!-- Form Name -->
    <legend>${fullName}</legend>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">passport</th>
      <th scope="col">firstName</th>
      <th scope="col">lastName</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${id}</th>
      <td>${passport}</td>
      <td>${firstName}</td>
      <td>${lastName}</td>
    </tr>

  </tbody>
</table>
  </div>
</body>
</html>
