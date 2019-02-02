<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Марка</th>
            <th scope="col">Наименование</th>
            <th scope="col">Цена</th>
            <th scope="col">Колличество</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${partsByOrder}" var="sparepart">
            <c:forEach items="${order}" var="orderItem">

                <tr>
                    <td>${sparepart.model}</td>
                    <td>${sparepart.name}</td>
                    <td>${orderItem.quanity}</td>
                    <td>${sparepart.price}</td>


                </tr>

            </c:forEach>
        </c:forEach>
        <tr>
            <td>Время доставки</td>
            <td>${deliveryTime}</td>
            <td>Общая стоимость</td>
            <td>${totalPrice}</td>

        </tr>
        </tbody>

    </table>
</div>
</body>
</html>