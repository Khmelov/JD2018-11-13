<!DOCTYPE html>
<html>
<head>
	<title>Cocktails list</title>
	<%@ include file="include/head.htm" %>
</head>
<body>
	<%@ include file="include/menu.htm" %>
	<p>ERROR: ${message}</p>
	<c:remove var="message" scope="session" /> 
</body>
</html>


