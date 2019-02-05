<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>


    <div class="container">
        <div class="row">
            <div class=col-md-1>Name</div>
            <div class=col-md-2>Link</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${games}" var="game">
            <form class="update-game-${game.id}" action="do?command=EditGames" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${game.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="game" class="form-control input-md" name="game"
                               value="${game.game}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="link" class="form-control input-md" name="link"
                               value="${game.link}"/>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success  md-1">
                        Обновить
                    </button>
                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger md-1">
                        Удалить
                    </button>
                </div>
            </form>
        </c:forEach>
    </div>



</body>
</html>


