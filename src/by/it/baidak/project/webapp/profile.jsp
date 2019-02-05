<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="${user.nickname}" type="text" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="${user.pass}" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" value="${user.email}" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-success">Изменить</button>
  </div>
</div>
</fieldset>
</form>

<p>Мои посты:</p>
<c:forEach items="${posts}" var="post">
             <div class="row">
                 <div class="col-md-10"><a class="link" href="do?command=Post">${post.head}</a></div>
                 <div class="col-md-2">${post.date}</div>
             </div>
        </c:forEach>
</body>
</html>