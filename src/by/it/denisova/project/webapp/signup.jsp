<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign Up</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="TestLogin" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password </label>
                <div class="col-md-4">
                    <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="TestEmail" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singup"></label>
                <div class="col-md-4">
                    <button id="singup" name="singup" class="btn btn-primary">sign up</button>
                </div>
            </div>

        </fieldset>
    </form>

<p>Cmd Sign-up: ${message}</p>
</div>
</body>
</html>




