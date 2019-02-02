<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Sign Up</title>
	<style>
           #signup {
            color: #fff;
           }
        </style>
	<%@ include file="include/head.jsp" %>
</head>
<body>
    <%@ include file="include/menu.jsp" %>
    <div class="container">
        <c:if test="${wrong_login!=null}">
            <div class="alert alert-danger" role="alert">Login is incorrect</div>
        </c:if>
        <c:if test="${wrong_password!=null}">
            <div class="alert alert-danger" role="alert">Password is incorrect</div>
        </c:if>
        <c:if test="${wrong_email!=null}">
            <div class="alert alert-danger" role="alert">Email address is incorrect</div>
        </c:if>
        <form class="form-horizontal" action="do?command=SignUp" method="POST">
            <fieldset>

            <!-- Form Name -->
            <legend>Sign Up</legend>

            <!-- login input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login">Login</label>
              <div class="col-md-4">
              <input id="login" name="login" value="TestUser" type="text" placeholder="min 6 symbols" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="password">Password</label>
              <div class="col-md-4">
                <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- email input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="email">E-mail</label>
              <div class="col-md-4">
              <input id="email" name="email" value="test-email@email.com" type="text" placeholder="" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Sign Up Button -->
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









