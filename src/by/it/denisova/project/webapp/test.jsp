<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal"  action="do?command=Test" method="POST">
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

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createTest"></label>
                <div class="col-md-4">
                    <button id="createTest" name="createTest" class="btn btn-primary">Create</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

