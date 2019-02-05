<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Add cocktail recipe</title>
	<%@ include file="include/head.jsp" %>
</head>
<body>

	<div class="container">
	<%@ include file="include/menu.jsp" %>
	    <c:if test="${error_message!=null}">
            <br>
            <div class="alert alert-danger" role="alert">${error_message}</div>
        </c:if>
		<form class="form-horizontal" action="do?command=AddRecipe" method="POST">

			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <fieldset>
                <legend>New cocktail recipe</legend>

                <!-- Name -->
                <div class="form-row form-group">
                    <label class="col-md-2 col-form-label text-right" for="recipe_name">Name</label>
                    <input class="form-control col-md-4" type="text"  name="recipe_name" value="test mojito" required>
                </div>

                <!-- Type -->
                <div class="form-row form-group">
                    <label class="col-md-2 col-form-label text-right" for="recipe_type">Type</label>
                    <input class="form-control col-md-4" type="text" name="recipe_type" value="test after dinner cocktail"  required>
                </div>


                <!-- Description -->
                <div class="form-row form-group">
                    <label class="col-md-2 control-label text-right" for="description">Description</label>
                    <textarea class="form-control col-md" name="description">Test recipe text: pour all ingredients into a glass and drink!</textarea>
                </div>
            </fieldset>

                <fieldset>

                    <c:forEach var="vari" begin="1" end="5">
                        <div class="form-row form-group">
                            <div class="form-group col-sm-4">
                                <label class="control-label" for="ingredient_${vari}">Ingredient</label>
                                <input id="ingredient_${vari}" name="ingredient_${vari}" type="text" class="form-control input-md" value="" placeholder="name">
                            </div>
                            <div class="form-group col-sm-2">
                                <label class="control-label" for="amount_${vari}">Amount</label>
                                <input id="amount_${vari}" name="amount_${vari}" type="text" class="form-control input-md" value="" placeholder="amount">
                            </div>
                            <div class="form-group col-sm-3">
                                <label class="control-label" for="unit_${vari}">Unit</label>
                                <input id="unit_${vari}" name="unit_${vari}" type="text" class="form-control input-md" value="" placeholder="unit">
                            </div>
                        </div>
                    </c:forEach>


                </fieldset>
			<input type="submit" class="btn btn-primary" value="create">	
		</form>
	</div>
</body>
</html>