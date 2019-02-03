<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cocktails list</title>
	<%@ include file="include/head.jsp" %>
</head>
<body>

	<div class="container">
        <%@ include file="include/menu.jsp" %>
        <c:if test="${error_message!=null}">
            <br>
            <div class="alert alert-danger" role="alert">${error_message}</div>
            <c:remove var="error_message" scope="session" />
        </c:if>

        <c:if test="${user!=null}">
            <a class="btn btn-lg btn-primary m-2" role="button" href="do?command=RecipesList&userid=${user.id}">Choose cocktails by your ingredients</a>
            <div class="container mb-3">
                <h3 class="p-2">Ingredients in your bar:</h3>
                <c:forEach var="user_ingredient" items="${user_ingredients}">
                    <div class="row">
                        <div class="col-sm-10">
                            <form action="do?command=RemIngFromBar" method="POST">
                                <input type="hidden" name="ingredient_id" value="${user_ingredient.id}" >
                                <input type="submit" class="btn btn-success btn-lg btn-block text-left my-2" name="ing" value="${user_ingredient.name}" />
                            </form>
                        </div>
                        <div class="col-sm-2">
                            <form action="do" method="GET">
                                <input type="hidden" name="command" value="RecipesList">
                                <input type="hidden" name="id" value="${user_ingredient.id}">
                                <input type="submit" class="btn btn-secondary btn-lg my-2" value="search" />
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <div class="container">
            <h3 class="p-2">Choose ingredients you already have:</h3>
            <c:forEach var="other_ingredient" items="${other_ingredients}">
                <div class="row">
                    <div class="col-sm-10">
                    <form action="do?command=AddIngToBar" method="POST">
                        <input type="hidden" name="ingredient_id" value="${other_ingredient.id}" >
                        <input type="submit" class="btn btn-info btn-lg btn-block text-left my-2" name="ing" value="${other_ingredient.name}" />
                    </form>
                    </div>
                    <div class="col-sm-2">
                    <form action="do" method="GET">
                        <input type="hidden" name="command" value="RecipesList">
                        <input type="hidden" name="id" value="${other_ingredient.id}">
                        <input type="submit" class="btn btn-secondary btn-lg my-2" value="search" />
                    </form>
                    </div>
                </div>
            </c:forEach>
		</div>

	</div>
</body>
</html>