<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>Create Test</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="test_name">Test name</label>
                <div class="col-md-4">
                    <input id="test_name" name="test_name" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>