<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=adminprofile" method="POST">
 <div class="container">
 <!-- Form Name -->
    <legend>Admin</legend>

     <p>${clients}</p>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col-md-1">id</th>
      <th scope="col-md-2">firstName</th>
      <th scope="col-md-3">lastName</th>
      <th scope="col-md-4">passport</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <c:forEach items="${clients}" var="client">
      <th scope="row"></th>


      <td scope=col-md-1>
        <input id="textinput" name="ID" type="id"
        value="${client.id}" class "form-control input-md">
      </td>

       <td scope=col-md-2>
              <input id="textinput" name="First name" type="firstName"
              value="${client.firstName}" class "form-control input-md">
       </td>

      <td scope=col-md-3>
             <input id="textinput" name="Last name" type="lastName"
             value="${client.lastName}" class "form-control input-md">
      </td>

      <td scope=col-md-4>
                   <input id="textinput" name="Passport ID" type="passport"
                   value="${client.passport}" class "form-control input-md">
            </td>


      <td>${lastName}</td>
    </tr>

  </tbody>
</table>
  </div>
</body>
</html>
