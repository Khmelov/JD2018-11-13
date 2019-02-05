<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="page-header">
        <p>co: <br> ${co}</p>
        <h1>Заказы</h1>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">АйДи</th>
            <th scope="col">Адрес</th>
            <th scope="col">Доп. Информация</th>
            <th scope="col">Полная стоимость</th>
            <th scope="col">Номер заказа</th>
        </tr>
        </thead>
            <tbody>
            <c:forEach items="${co}" var="co">

            <tr>
                <td>${co.id}</td>
                <td>${co.address}</td>
                <td>${co.info}</td>
                <td>${co.totalPrice}</td>
                <td>${co.users_id}</td
            </tr>
            </c:forEach>

            </tbody>
    </table>
</div>
</body>
</html>
