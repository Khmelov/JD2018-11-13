<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <p>order:  <c:out value="${order}"/><p>
    <p>partsByOrder:
        <c:out value="${partsByOrder}"/>
    <p>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th class="col-md-3" scope="col">Марка</th>
            <th class="col-md-3" scope="col">Наименование</th>
            <th class="col-md-1" scope="col">Цена</th>
            <th class="col-md-1" scope="col">Колличество</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${partsByOrder}" var="sparepart">
        <form class="update-user-${user.id}" action="do?command=EditOrder" method="post">

            <tr>
                <td>${sparepart.model}</td>
                <td>${sparepart.name}</td>
                <td>${sparepart.price}</td>

                <c:forEach items="${order}" var="order">
                    <c:if test="${order.spareParts_id == sparepart.id}">
                        <td>
                        <input type="text" id="quanity" class="form-control input-sm" name="quanity"
                               value="${order.quanity}"/>
                        </td>
                        <td>
                            <button id="update" value="${order.id}" name="update" class="btn btn-success">ОБНОВИТЬ</button>
                        </td>
                        <td>
                            <button id="delete" value="${order.id}" name="delete" class="btn btn-danger">УДАЛИТЬ</button>
                        </td>
                    </c:if>

                </c:forEach>
            </tr>
            </c:forEach>

        </form>
        </tbody>

    </table>
</div>
</body>
</html>