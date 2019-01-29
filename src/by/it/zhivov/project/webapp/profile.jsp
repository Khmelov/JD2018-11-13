<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Profile user:<br> ${user}</p>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
<legend>Logout</legend>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="profile"></label>
                <div class="col-md-4">
                    <button id="profile" name="signin" class="btn btn-success">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
