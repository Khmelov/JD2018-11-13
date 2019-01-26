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
                <input id="login" name="login" value="testUser" type="text" placeholder="enter login" class="form-control input-md"
                       required="">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" value="testPassword" type="password" placeholder="placeholder"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email" name="email" value="test@mail.ru" type="text" placeholder="placeholder" class="form-control input-md"
                       required="">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="signup"></label>
            <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-success">Sign Up</button>
            </div>
        </div>

    </fieldset>
</form>
</div>
</body>
</html>




