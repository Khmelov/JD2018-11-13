<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>


<div class="page-header">
    <h1>Каталог проектов</h1>
    <p class="lead">Список архитектурных проектов домов</p>
</div>

<div class="row">
    <div class="col-md-2">Название</div>
    <div class="col-md-2">Этажность</div>
    <div class="col-md-2">Площадь(м2)</div>
    <div class="col-md-3">Материал стен</div>
    <div class="col-md-1">Цена</div>
 <div class="col-md-1"> </div>

</div>

<c:forEach items="${items}" var="varItems">
<form class="update-varItems-${varItems.id}" action="do?command=buynow" method="POST">
    <br>
    <div class="row">
       <input id="id" type="hidden" class="form-control input-md" name="id"
                                                       value="${varItems.id}"/>
        <div class="col-md-2">${varItems.title} </div>
        <div class="col-md-2">${varItems.floors} </div>
        <div class="col-md-2">${varItems.square} </div>
        <div class="col-md-3">${varItems.materials} </div>
        <div class="col-md-1">${varItems.price} </div>
   <div class="col-md-1">

                         <button id="Update" value="Buy" name="Buy" class="btn btn-success">
                             Купить
                         </button>

    </div>   </div>
    </form>
</c:forEach>



</div>
</body>
</html>
