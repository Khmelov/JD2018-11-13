<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cocktails list</title>
	<style>
           #ingredients {
            color: #fff;
           }
        </style>
	<%@ include file="include/head.jsp" %>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<div class="container">
		${ing_list}
	</div>
</body>
</html>