<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=SignUp" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Регистрация</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин*</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder=" " class="form-control input-md"
                           required pattern="[a-zA-Z][a-zA-Z0-9_]*" minlength="4" maxlength="45">
                    <span class="form__error">
                        <div>латиница</div>
                        <div>от 4 до 45 символов</div>
                        <div>первый символ - буква в верхнем или нижнем регистре</div>
                        <div>буквы в верхнем и нижнем регистре, цифры, символ "_"</div>
                      </span>
                </div>

            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль*</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder=" "
                           class="form-control input-md" pattern="[a-zA-Z][a-zA-Z0-9_^@!]*" required minlength="5"
                           maxlength="26">
                    <span class="form__error">
                        <div>латиница</div>
                        <div>от 5 до 26 символов</div>
                        <div>первый символ - буква в верхнем или нижнем регистре</div>
                        <div>буквы в верхнем и нижнем регистре, цифры</div>
                        <div>символы  _ ^ @ ! </div>
                      </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">ФИО*</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder=" " class="form-control input-md"
                           required pattern="[a-zA-zа-яА-я ]*" minlength="4" maxlength="100">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>от 4 до 100 символов</div>
                        <div>буквы в верхнем и нижнем регистре</div>
                      </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="dateofbirth">Дата рождения*</label>
                <div class="col-md-4">
                    <input id="dateofbirth" name="dateofbirth" type="date" placeholder="yyyy-mm-dd"
                           class="form-control input-md" required
                           pattern="(19|20)\d\d[.-](0[1-9]|1[012])[.-](0[1-9]|[12][0-9]|3[01])">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email*</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="email" placeholder=" " class="form-control input-md"
                           required pattern="[a-z][a-z0-9_]+@[a-z]+\.[a-z]+" minlength="5" maxlength="45">
                    <span class="form__error">
                        <div>невалидный email адрес</div>
                      </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="tel">Телефон*</label>
                <div class="col-md-4">
                    <input id="tel" name="tel" type="text" placeholder="+375xxxxxxxxx" class="form-control input-md"
                           required pattern="[+](375)(33|29|44)[0-9]{7}" minlength="13" maxlength="13">
                    <span class="form__error">
                        <div>невалидный телефон</div>
                      </span>
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




