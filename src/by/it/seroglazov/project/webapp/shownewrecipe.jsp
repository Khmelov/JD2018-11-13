<!DOCTYPE html>
<html>
<head>
	<title>New cocktail</title>
	<%@ include file="include/head.htm" %>
</head>
<body>
	<%@ include file="include/menu.htm" %>
	<div class="container">

		<p>Name: ${recipe_name}</p>
		<c:remove var="recipe_name" scope="session" />

		<p>Type: ${recipe_type}</p>
		<c:remove var="recipe_type" scope="session" /> 

		<p>Description: ${recipe_description}</p>
		<c:remove var="recipe_description" scope="session" /> 

		<p>Ingredient 1: ${ingredient1}</p>
		<c:remove var="ingredient1" scope="session" /> 

		<p>Ingredient 2: ${ingredient2}</p>
		<c:remove var="ingredient2" scope="session" /> 

		<p>Ingredient 3: ${ingredient3}</p>
		<c:remove var="ingredient3" scope="session" /> 

		<p>Ingredient 4: ${ingredient4}</p>
		<c:remove var="ingredient4" scope="session" /> 

	</div>	
</body>
</html>