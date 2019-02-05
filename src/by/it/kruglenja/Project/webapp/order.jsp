<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Марка</th>
            <th scope="col">Наименование</th>
            <th scope="col">Цена за шт</th>
            <th scope="col">Колличество</th>
            <th scope="col">Общая стоимость</th>


        </tr>
        </thead>

        <tbody>
        <c:forEach items="${order}" var="order">

        <form class="update-user-${order.id}" action="do?command=EditOrder" method="post">

            <tr>
                <td>${order.model}</td>
                <td>${order.name}</td>
                <td>${order.price}</td>
                <td>
                    <input class="form-control input-sm" type="text" id="quanity" class="form-control input-sm" name="quanity"
                           value="${order.quanity}"/>
                </td>
                <td>${order.price * order.quanity}</td>

                <td>
                    <button id="update" value="${order.id}" name="update" class="btn btn-success">ОБНОВИТЬ</button>
                </td>
                <td>
                    <button id="delete" value="${order.id}" name="delete" class="btn btn-danger">УДАЛИТЬ</button>
                </td>
            </tr>
        </form>
        </c:forEach>

        </tbody>
    </table>
    <form class="form-horizontal" action="do?command=makeOrder" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Адрес доставки</label>
                <div class="col-md-4">
                    <input id="address" name="address" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>
            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="info">Доп. информация</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="info" name="info"></textarea>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="order_id"></label>
                <div class="col-md-4">
                    <button id="order_id" value="order_id" name="order_id" class="btn btn-primary">Подтвердить заказ</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>