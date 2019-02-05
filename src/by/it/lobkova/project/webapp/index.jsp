<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<!-- Основное содержимое -->

<div class="page-header">
    <h1>Все цели</h1>
</div>

<div class="row">
    <div class="col-md-3">Цель</div>
    <div class="col-md-3">Описание</div>
    <div class="col-md-3">Дата начала</div>
    <div class="col-md-3">Дата завершения</div>
</div>

<c:forEach items="${goals}" var="goal">
    <br>
    <div class="row">
        <div class="col-md-3">${goal.name} </div>
        <div class="col-md-3">${goal.description} </div>
        <div class="col-md-3">${goal.beginDate} </div>
        <div class="col-md-3">${goal.endDate} </div>
    </div>
</c:forEach>

<br><br>

</div>
</body>
</html>
