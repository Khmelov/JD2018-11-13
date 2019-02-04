<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="container">
        <form class="form-horizontal" action="do?command=CreateBuyer" method="POST">
            <fieldset>

                <!-- Form Name -->
                <legend>Создание вашего объявления</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="item">Item</label>
                    <div class="col-md-4">
                        <input id="item" name="item" value="Lenovo P500" type="text" placeholder=""
                               class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="specif">Specif</label>
                    <div class="col-md-4">
                        <input id="specif" name="specif" type="text" value="15.6 / 4Gb / SSD 240Gb / GTX 1050Ti" placeholder=""
                               class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="price">Price</label>
                    <div class="col-md-4">
                        <input id="price" name="price" value="907" type="text" placeholder=""
                               class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="address">Address</label>
                    <div class="col-md-4">
                        <input id="address" name="address" type="text" value="SV-Trayding Минск, Танка 3-33" placeholder=""
                               class="form-control input-md" required="">
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="create"></label>
                    <div class="col-md-4">
                        <button id="create" name="create" class="btn btn-primary">Create Buyer</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </div>
</body>
</html>
