<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/menu.jsp" %>
<c:choose>
    <c:when test="${roleID==1}">
        <c:forEach items="${posts}" var="post">
            <div class="row">
                <div class="col-md-9"><a class="link" href="do?command=Post">${post.head}</a></div>
                <div class="col-md-2">${post.date} </div>
                <button type="button" class="btn btn-danger"><a class="link" href="do?command=RemovePost&id=${post.id}">Удалить</a></button>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <c:forEach items="${posts}" var="post">
             <div class="row">
                 <div class="col-md-10"><a class="link" href="do?command=Post">${post.head}</a></div>
                 <div class="col-md-2">${post.date} </div>
             </div>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
