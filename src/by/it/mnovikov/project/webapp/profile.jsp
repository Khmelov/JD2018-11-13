<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Profile User:<br> ${user}</p>

    <form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>LogOUT</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-primary">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
