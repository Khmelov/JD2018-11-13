<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="container">
        <div class="row">
            <div class=col-md-12>
                <p class="text-center">Товары</p>
            </div>
        </div>
        <div class="row">
            <div class=col-md-0><!--ID--></div>
            <div class=col-md-2>Название</div>
            <div class=col-md-4>Описание</div>
            <div class=col-md-1>Тип</div>
            <div class=col-md-2>Производительность</div>
            <div class=col-md-1>Цена</div>

        </div>
    </div>

    <div class="container">
        <c:forEach items="${goods}" var="good">
            <form class="update-user-${good.id}" action="do?command=EditGoods" method="POST">
                <div class="row">
                    <div class=col-md-0>
                        <input id="id" class="form-control input-md" name="id" type="hidden"
                               value="${good.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="title" class="form-control input-md" name="title"
                               value="${good.title}"/>
                    </div>
                    <div class=col-md-4>
                        <input id="discription" class="form-control input-md" name="discription"
                               value="${good.discription}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="type" class="form-control input-md" name="type"
                               value="${good.type}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="productivity" class="form-control input-md" name="productivity"
                               value="${good.productivity}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${good.price}"/>
                    </div>

                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>

</div>
</body>
</html>