<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Change cocktail recipe</title>
	<%@ include file="include/head.jsp" %>
</head>
<body>

	<div class="container">
	<%@ include file="include/menu.jsp" %>
	    <c:if test="${error_message!=null}">
            <br>
            <div class="alert alert-danger" role="alert">${error_message}</div>
        </c:if>
		<form class="form-horizontal" action="do?command=ChangeRecipe" method="POST">

			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <fieldset>
                <legend>Change cocktail recipe</legend>

                <!-- Name -->
                <div class="form-row form-group">
                    <label class="col-md-2 col-form-label text-right" for="recipe_name">Name</label>
                    <input class="form-control col-md-4" type="text"  name="recipe_name" value="${recipe.name}" required>
                </div>

                <!-- Type -->
                <div class="form-row form-group">
                    <label class="col-md-2 col-form-label text-right" for="recipe_type">Type</label>
                    <input class="form-control col-md-4" type="text" name="recipe_type" value="${rtype.text}"  required>
                </div>


                <!-- Description -->
                <div class="form-row form-group">
                    <label class="col-md-2 control-label text-right" for="description">Description</label>
                    <textarea class="form-control col-md" name="description">${recipe.description}</textarea>
                </div>
            </fieldset>

            <fieldset>

                <!-- Ingredient 1 -->
                <div class="form-row form-group">
                    <div class="form-group col-sm-4">
                        <label class="control-label" for="ingredient_1">Ingredient</label>
                        <input id="ingredient_1" name="ingredient_1" type="text" class="form-control input-md" value="${ingredient1.name}" placeholder="name" required>
                    </div>
                    <div class="form-group col-sm-2">
                        <label class="control-label" for="amount_1">Amount</label>
                        <input id="amount_1" name="amount_1" type="text" class="form-control input-md" value="${amount1.text}" placeholder="amount" required>
                    </div>
                    <div class="form-group col-sm-3">
                        <label class="control-label" for="unit_1">Unit</label>
                        <input id="unit_1" name="unit_1" type="text" class="form-control input-md" value="${unit1.name}" placeholder="unit" required>
                    </div>
                </div>
                <!-- Ingredient 2 -->
                <div class="form-row form-group">
                    <div class="form-group col-sm-4">
                        <input id="ingredient_2" name="ingredient_2" type="text" class="form-control input-md" value="${ingredient2.name}" placeholder="name" required>
                    </div>
                    <div class="form-group col-sm-2">
                        <input id="amount_2" name="amount_2" type="text" class="form-control input-md" value="${amount2.text}" placeholder="amount" required>
                    </div>
                    <div class="form-group col-sm-3">
                        <input id="unit_2" name="unit_2" type="text" class="form-control input-md" value="${unit2.name}" placeholder="unit" required>
                    </div>
                </div>
                <!-- Ingredient 3 -->
                <div class="form-row form-group">
                    <div class="form-group col-sm-4">
                        <input id="ingredient_3" name="ingredient_3" type="text" class="form-control input-md" value="${ingredient3.name}" placeholder="name" >
                    </div>
                    <div class="form-group col-sm-2">
                        <input id="amount_3" name="amount_3" type="text" class="form-control input-md" value="${amount3.text}" placeholder="amount" >
                    </div>
                    <div class="form-group col-sm-3">
                        <input id="unit_3" name="unit_3" type="text" class="form-control input-md" value="${unit3.name}" placeholder="unit" >
                    </div>
                </div>
                <!-- Ingredient 4 -->
                <div class="form-row form-group">
                    <div class="form-group col-sm-4">
                        <input id="ingredient_4" name="ingredient_4" type="text" class="form-control input-md" value="${ingredient4.name}" placeholder="name" >
                    </div>
                    <div class="form-group col-sm-2">
                        <input id="amount_4" name="amount_4" type="text" class="form-control input-md" value="${amount4.text}" placeholder="amount" >
                    </div>
                    <div class="form-group col-sm-3">
                        <input id="unit_4" name="unit_4" type="text" class="form-control input-md" value="${unit4.name}" placeholder="unit" >
                    </div>
                </div>
                <!-- Ingredient 5 -->
                <div class="form-row form-group">
                    <div class="form-group col-sm-4">
                        <input id="ingredient_5" name="ingredient_5" type="text" class="form-control input-md" value="${ingredient5.name}" placeholder="name" >
                    </div>
                    <div class="form-group col-sm-2">
                        <input id="amount_5" name="amount_5" type="text" class="form-control input-md" value="${amount5.text}" placeholder="amount" >
                    </div>
                    <div class="form-group col-sm-3">
                        <input id="unit_5" name="unit_5" type="text" class="form-control input-md" value="${unit5.name}" placeholder="unit" >
                    </div>
                </div>
            </fieldset>
            <input type="hidden" name="changed_recipe_id" value="${recipe.id}"/>
			<input type="submit" class="btn btn-warning" value="change">
		</form>
	</div>
</body>
</html>