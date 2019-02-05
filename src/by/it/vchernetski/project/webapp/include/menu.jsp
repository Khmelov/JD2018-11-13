<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="."><img src="images/im" height="40px"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="do?command=reset">Reset DB</a>
            <a class="nav-item nav-link" href="do?command=signup">Sign-Up</a>
            <a class="nav-item nav-link" href="do?command=Login">LogIn</a>
            <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
            <c:if test="${user!=null}">
            <a class="nav-item nav-link" href="do?command=create">Create Car</a>
            <a class="nav-item nav-link" href="do?command=getlist">ListCar</a>
            <a class="nav-item nav-link" href="do?command=editusers">Edit Users</a>
            <a class="nav-item nav-link" href="do?command=logout">Logout</a>
            </c:if>
            </a>
        </div>
    </div>
</nav>



