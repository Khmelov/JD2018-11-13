<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Profile user:<br> ${user}</p>
    <p>Ads user: ${ads}</p>

    <form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>
