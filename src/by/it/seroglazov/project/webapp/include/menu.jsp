<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
	<a class="navbar-brand" href="/seroglazov">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
		    <c:if test="${user==null}">
			    <a id="loginmenu" class="nav-item nav-link ${var_login}" href="do?command=Login">Login</a>
			    <a id="signup" class="nav-item nav-link ${var_signup}" href="do?command=SignUp">SignUp</a>
			</c:if>
			<c:if test="${user!=null}">
			    <a id="profile" class="nav-item nav-link ${var_profile}" href="do?command=Profile">Profile</a>
			</c:if>
			<a id="recipes" class="nav-item nav-link ${var_recipeslist}" href="do?command=RecipesList">Cocktails</a>
			<a id="ingredients" class="nav-item nav-link ${var_inglist}" href="do?command=IngList">Ingredients</a>
			<a id="addrecipe" class="nav-item nav-link ${var_addrecipe}" href="do?command=AddRecipe">Add Cocktail</a>
			<a id="reset" class="nav-item nav-link ${var_reset}" href="do?command=Reset">Reset DB</a>
		</div>
	</div>
</nav>
