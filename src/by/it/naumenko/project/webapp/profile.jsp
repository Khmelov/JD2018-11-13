<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>
        <p><img src="image/error.png" width="100" height="100" alt="ERROR"> Profile ${message}</p>
        <p><br> ${user}</p>

        <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login"></label>
              <div class="col-md-4">
                <button id="logout" name="logout" class="btn btn-success">LogOUT</button>
              </div>
            </div>
    </div>
</body>
</html>


