<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cocktails list</title>
	<style>
           #recipes {
            color: #fff;
           }
        </style>
	<%@ include file="include/head.jsp" %>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<div class="container">
	<c:if test="${error_message!=null}">
        <br>
        <div class="alert alert-danger" role="alert">${error_message}</div>
        <c:remove var="error_message" scope="session" />
    </c:if>
		${recipe_list}
	</div>
</body>
</html>