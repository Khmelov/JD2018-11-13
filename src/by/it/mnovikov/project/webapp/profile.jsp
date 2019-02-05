<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>Профиль пользователя:<br> ${user}</p>

    <form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-primary">Оттудыть</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
