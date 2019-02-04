<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="page-header">
        <p>sesionUserId: <br> ${sesionUserId}</p>


        <h1>Каталог запчастей</h1>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Марка авто</th>
            <th scope="col">Наименование</th>
            <th scope="col">Серийный номер</th>
            <th scope="col">Вес</th>
            <th scope="col">Цена</th>
            <th scope="col">На складе</th>

            <th scope="col" colspan="2">В корзину</th>
        </tr>
        </thead>
        <c:forEach items="${catalog}" var="sparepart">
            <tbody>
            <form action="do?command=partToBucket" method="post">
            <tr>
                <td>${sparepart.model}<input type="hidden" id="model" name="model" value="${sparepart.model}"/></td>
                <td>${sparepart.name}<input type="hidden" id="name" name="name" value="${sparepart.name}"/> </td>
                <td>${sparepart.serial_number}</td>
                <td>${sparepart.weight}</td>
                <td>${sparepart.price}<input type="hidden" id="price" name="price" value="${sparepart.price}"/></td>
                <td>${sparepart.storageQuanity}</td>

                <td colspan="2">

                        <fieldset>
                            <input id="quanity" name="quanity" type="text" value="3"/>
                            <button id="iD" name="iD" value="${sparepart.id}" class="btn btn-success">В корзину</button>
                        </fieldset>
                    </form>
                </td>

            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
