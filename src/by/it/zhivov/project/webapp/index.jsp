<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<style type="text/css">
    /*.zoom:hover {*/
    /*-webkit-transform: scale(4.2);*/
    /*-ms-transform: scale(4.2);*/
    /*transform: scale(4.2);*/
    /*}*/
    /*img {*/
    /*cursor: pointer;*/
    /*max-width: 150px;*/
    /*}*/

    /*img:hover {*/
    /*max-width: none;*/
    /*}*/
    .zoom_img img {
        -moz-transition: all 1s ease-out;
        -o-transition: all 1s ease-out;
        -webkit-transition: all 1s ease-out;
    }

    .zoom_img img:hover {
        -webkit-transform: scale(1.1);
        -moz-transform: scale(1.1);
        -o-transform: scale(1.1);
    }
</style>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="page-header">
        <h3>Объявления</h3>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-2">Заголовок</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Марка</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Цвет</div>
        <div class="col-md-1">Объем двигателя</div>
        <div class="col-md-2">Цена</div>
    </div>
    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
            <div class="zoom_img">
                <div class="col-md-1">

                    <a target="_blank" href="images/ad${ad.id}">
                        <img src="images/ad${ad.id}" height="40px" alt="${ad.price}"
                             onmouseover="this.height=150" ;
                             onmouseout="this.height=40"/>
                    </a>
                </div>
            </div>
            <div class="col-md-2">${ad.title}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.brnd}</div>
            <div class="col-md-1">${ad.model}</div>
            <div class="col-md-1">${ad.color}</div>
            <div class="col-md-1">${ad.engine} л.</div>
            <div class="col-md-2">${ad.price} руб.</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
