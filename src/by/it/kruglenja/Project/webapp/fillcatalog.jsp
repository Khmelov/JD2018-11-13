<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=FillCatalog" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>FillCatalog</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectModel">Марка автомобиля</label>
            <div class="col-md-4">
                <select id="selectModel" name="selectModel" class="form-control">
                    <option value="---">Choose something</option>
                    <option value="Toyota">Toyota</option>
                    <option value="Volkswagen">Volkswagen</option>
                    <option value="Hyundai">Hyundai</option>
                    <option value="Kia South Korea">Kia South Korea</option>
                    <option value="General Motors">General Motors</option>
                    <option value="Ford" selected>Ford</option>
                    <option value="Honda Japan">Honda Japan</option>
                    <option value="FCA Italy">FCA Italy</option>
                    <option value="Renault France">Renault France</option>
                    <option value="Groupe PSA France">Groupe PSA France</option>
                    <option value="Suzuki Japan">Suzuki Japan</option>
                    <option value="SAIC China">SAIC China</option>
                    <option value="Daimler Germany">Daimler Germany</option>
                    <option value="BMW Germany">BMW Germany</option>
                    <option value="Changan China">Changan China</option>
                    <option value="Mazda Japan">Mazda Japan</option>
                    <option value="BAIC China">BAIC China</option>
                    <option value="Dongfeng Motor">Dongfeng Motor</option>
                    <option value="Geely China">Geely China</option>
                    <option value="Great Wall">Great Wall</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectCategory">Категория</label>
            <div class="col-md-4">
                <select id="selectCategory" name="selectCategory" class="form-control">
                    <option value="---">Choose something</option>
                    <option value="Wheels">Wheels</option>
                    <option value="Engine">Engine</option>
                    <option value="Electrronic" selected>Electrronic</option>
                    <option value="Glass">Glass</option>
                    <option value="Clutch">Clutch</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="partCategory">part_category</label>--%>
            <%--<div class="col-md-4">--%>
                <%--<input id="partCategory" name="partCategory" type="text" placeholder="" class="form-control input-md">--%>

            <%--</div>--%>
        <%--</div>--%>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="partName">Наименование</label>
            <div class="col-md-4">
                <input id="partName" name="partName" value="Катушки зажигания" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="serialNumber">Серийный номер</label>
            <div class="col-md-4">
                <input id="serialNumber" name="serialNumber" value="015875AASC644548" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="weigth">Вес</label>
            <div class="col-md-4">
                <input id="weigth" name="weigth" value="22.11" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="price">Цена</label>
            <div class="col-md-4">
                <input id="price" name="price" type="text" value="48.36" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="storageQuanity">Остаток</label>
            <div class="col-md-4">
                <input id="storageQuanity" name="storageQuanity" value="6" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="ADD"></label>
            <div class="col-md-4">
                <button id="ADD" name="ADD" class="btn btn-primary">ДОБАВИТЬ</button>
            </div>
        </div>
    </fieldset>
</form>
</div>
</body>
</html>
