<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">

    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=CreateGood" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Создать товар</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="title">Название</label>
                <div class="col-md-4">
                    <input id="title" name="title" value="EIJKELKAMP 01 11 SO" type="text"
                           placeholder="Введите название товара" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="discription">Описание</label>
                <div class="col-md-4">
                    <input id="discription" name="discription" value="Набор ручных буров для гетерогенных почв (со штыковым соединением).
                    Пробоотбор в гомогенных почвах в большинстве случаев может быть выполнен с помощью одного типа бура.
                    Исследование же гетерогенных почв может потребовать использования нескольких различных типов буров."
                           type="text" placeholder="Введите краткое описание товара" class="form-control input-md"
                           required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="type">Тип</label>
                <div class="col-md-4">
                    <input id="type" name="type" value="ручной" type="text" placeholder="ручной или автоматический"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="productivity">Производительность</label>
                <div class="col-md-4">
                    <input id="productivity" name="productivity" value="2.3" type="text" placeholder="Производительность, проб/час (1.1)"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input id="price" name="price" value="245" type="text" placeholder="Введите цену ex: 7777"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="creategood"></label>
                <div class="col-md-4">
                    <button id="creategood" name="creategood" class="btn btn-primary">Втудыть</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>


