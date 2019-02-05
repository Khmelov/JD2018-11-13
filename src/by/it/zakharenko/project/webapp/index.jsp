<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>


<div class="page-header">
    <h1>Каталог товаров</h1>
    <p class="lead">Список товаров</p>
</div>

<div class="row">
    <div class="col-md-2">Название</div>
    <div class="col-md-1">Цена</div>
 <div class="col-md-1"> </div>

</div>

<c:forEach items="${items}" var="varItems">
    <br>
    <div class="row">
        <div class="col-md-2">${varItems.title} </div>
        <div class="col-md-1">${varItems.price} </div>
   <div class="col-md-1"><form class="update-varItems-${varItems.id}" action="do?command=" method=POST>

                         <button id="Update" value="Buy" name="Buy" class="btn btn-success">
                             Купить
                         </button>

    </div>   </div>
</c:forEach>



</div>
</body>
</html>
