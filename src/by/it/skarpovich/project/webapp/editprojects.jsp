<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<div class="page-header">
    <h2>Каталог проектов</h2>
    <p class="lead">Список архитектурных проектов домов и коттеджей</p>
</div>
<table class="table table-striped table-responsive-md btn-table">
  <thead>
    <tr><th scope="col">Фото</th>
     <th scope="col"></th>
        <th scope="col">Название</th>
        <th scope="col">Этажность</th>
        <th scope="col">Площадь(м2)</th>
        <th scope="col">Материал стен</th>
        <th scope="col">Цена</th>
        <th scope="col"></th>
         <th scope="col"></th>
    </tr>
  </thead>
 <tbody>
        <c:forEach items="${items}" var="item">
        <tr>
        <form class="update-items-${item.id}" action="do?command=editprojects" method="POST">
        <td><img src="image/item${item.id}" height="40px"></td>
        <td><input id="id" type="hidden" class="form-control input-md" name="id" value="${item.id}"/>
        <td><input id="title" class="form-control input-md" name="title" value="${item.title}"/></td>
        <td><input id="floors" class="form-control input-md" name="floors" value="${item.floors}"/></td>
        <td><input id="square" class="form-control input-md" name="square" value="${item.square}"/></td>
        <td><input id="materials" class="form-control input-md" name="materials" value="${item.materials}"/></td>
        <td><input id="price" class="form-control input-md" name="price" value="${item.price}"/></td>
                    <td><button id="Update" value="Update" name="Update" class="btn btn-info">Обновить</button></td>
                    <td><button id="Delete" value="Delete" name="Delete" class="btn btn-danger">Удалить</button></td></form>
         </tr>
        </form>
        </tr></c:forEach>
   </tbody>
 </table>

</div>
</body>
</html>
