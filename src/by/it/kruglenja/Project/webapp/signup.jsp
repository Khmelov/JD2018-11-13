<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>SignUp</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" value="testUSER" name="login" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" value="testPASSWORD" name="password" type="password" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="passwordrepeat" value="testPASSWORD"  name="passwordrepeat" type="password" placeholder="" class="form-control input-md">

                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Password</label>
                <div class="col-md-4">
                    <input id="email" value="test@EMAIL" name="email" type="email"
                           placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signUpButton"></label>
                <div class="col-md-4">
                    <button id="signUpButton" name="signUpButton" class="btn btn-primary">SignUp</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




