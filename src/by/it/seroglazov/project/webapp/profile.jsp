<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Profile</title>
	<%@ include file="include/head.jsp" %>
</head>
<body>
	<div class="container">
		<%@ include file="include/menu.jsp" %>
		<div class="m-3">
			<h5>
				Name = ${user.name}<br>
				Email = ${user.email}
			</h5>
		</div>	
		<form class="form-horizontal" action="do?command=Profile" method="POST">
			<fieldset>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="logout"></label>
					<div class="col-md-4">
						<button id="logout" name="logout" value="logout" class="btn btn-success">Выйти</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
