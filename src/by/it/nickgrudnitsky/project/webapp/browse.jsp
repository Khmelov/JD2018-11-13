<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menuIn.htm" %>

<!-- Основное содержимое -->

<div class="page-header">
    <h1>Игры</h1>

</div>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-3"></div>
</div>

<c:forEach items="${games}" var="game">
    <br>
    <div class="row">
        <div class="col-md-1">${game.game} </div>
        <div class="col-md-3">${game.link} </div>
    </div>
</c:forEach>

</body>
</html>
