<html>
<%@ include file="include/head.htm" %>
<body>
<div    class="container">
    <%@ include file="include/menu.htm" %>
    <p>USER PROFILE: <br> ${user}</p>
            <form class="form-horizontal"  action="do?command=Submit" method="post">
                <fieldset>
                    <!-- Form Name -->
                    <%--<legend>Phone number</legend>--%>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="pNumber">Phone number</label>
                        <div class="col-md-4">
                            <input id="pNumber" value="+375296354877" name="pNumber" type="text" placeholder="" class="form-control input-md">

                        </div>
                    </div>
                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="Submit"></label>
                        <div class="col-md-4">
                            <button id="Submit" name="Submit" class="btn btn-success">Submit</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
</body>
</html>