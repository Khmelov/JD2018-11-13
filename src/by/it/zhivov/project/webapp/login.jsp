<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Login" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Войти</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="zhivov" type="text" placeholder=" "
                           class="form-control input-md" pattern="[a-zA-Z][a-zA-Z0-9_]*" required minlength="4"
                           maxlength="45">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="zhivov" type="password" placeholder=" "
                           class="form-control input-md" pattern="[a-zA-Z][a-zA-Z0-9_^]*" required minlength="5"
                           maxlength="26">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signin"></label>
                <div class="col-md-4">
                    <button id="signin" name="signin" class="btn btn-success">Login</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

