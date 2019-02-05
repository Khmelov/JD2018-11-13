<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/menu.jsp" %>

<c:forEach items="${users}" var="user">
            <div class="row">
                <div class="col-md-9"><a class="link">${user.nickname}</a></div>
                <button type="button" class="btn btn-danger"><a class="link" href="do?command=RemoveUser&id=${user.id}">Удалить</a></button>
            </div>
</c:forEach>