<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Profile</title>
	<style>
       #profile {
        color: #fff;
       }
    </style>
	<%@ include file="include/head.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<div class="container">
<p class="text-info">
Name = ${user.name}<br>
Email = ${user.email}
</p>

<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" value="logout" class="btn btn-success">Выйти</button>
  </div>
</div>
</fieldset>
</form>

<!--<div class="container">
    <c:forEach items="${ingredients}" var="ingredient">
        <div class="border border-info rounded px-3 my-2">
            <p>${ingredient.name}</p>
        </div>
    </c:forEach>
</div>-->


</div>
</body>
</html>
