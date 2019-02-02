<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cocktails list</title>
	<%@ include file="include/head.jsp" %>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<p>ERROR: ${message}</p>
	<c:remove var="message" scope="session" /> 
</body>
</html>


