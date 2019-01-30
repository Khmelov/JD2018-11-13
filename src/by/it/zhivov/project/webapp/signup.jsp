<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=SignUp" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Регистрация</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин*</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль*</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">ФИО*</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="dateofbirth">Дата рождения*</label>
                <div class="col-md-4">
                    <input id="dateofbirth" name="dateofbirth" type="date" placeholder="yyyy-mm-dd"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email*</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="email" placeholder="" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="tel">Телефон*</label>
                <div class="col-md-4">
                    <input id="tel" name="tel" type="text" placeholder="+375xxxxxxxxx" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-primary">Зарегистрироваться</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>




