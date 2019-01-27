<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=SignUp" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="Example" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="ExamplePass"
                           class="form-control input-md" required="">
                    <span class="help-block">min 6 symbols</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="example@mail.com"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="first_name">First name</label>
                <div class="col-md-4">
                    <input id="first_name" name="first_name" type="text" placeholder="Ivan"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="last_name">Last name</label>
                <div class="col-md-4">
                    <input id="last_name" name="last_name" type="text" placeholder="Ivanov"
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="birthday">Date of birthday</label>
                <div class="col-md-4">
                    <input id="birthday" name="birthday" type="text" placeholder="2000-01-20 20:00:00"
                           class="form-control input-md" required="">
                    <span class="help-block">example: 2000-01-20 20:00:00</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="adress">Address</label>
                <div class="col-md-4">
                    <input id="adress" name="adress" type="text" placeholder="Minck, Knorina str., 1"
                           class="form-control input-md" required="">

                </div>
            </div>

        </fieldset>
    </form>

</body>
</html>




