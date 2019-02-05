<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<%--<p>ALL ADS:<br> ${ads}</p>--%>
    <p> hello </p>
<c:forEach items="${tests}" var="test">
    <form>
        <hr>
        <p> <b>Тест на тему:</b> ${test.test_name}</p>
    <c:forEach items="${test.questionList}" var="question">
        <p> Вопрос № "${question.id}":"${question.question}" </p>
    </c:forEach>

    </form>
</c:forEach>
</div>
</body>
</html>
