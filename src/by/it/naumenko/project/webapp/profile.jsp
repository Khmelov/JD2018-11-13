<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>
        <p><img src="image/error.png" width="100" height="100" alt="ERROR"> Profile ${message}</p>
        <p><br> ${user}</p>

      <!--   Button
             <form class="form-inline my-2 my-lg-0" action ="do?command=profile" method="POST">
                <button class="btn btn-outline-success my-2 my-sm-0" id="logout" name="logout" type="submit">Выход</button>
             </form>
             -->
    </div>
</body>
</html>


