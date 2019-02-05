<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<div class="page-header">
    <h1>Все цели</h1>
</div>

<div class="container">
    <div class="row">
            <div class=col-md-1>Номер</div>
            <div class=col-md-2>Цель</div>
            <div class=col-md-2>Описание</div>
            <div class=col-md-2>Дата начала</div>
            <div class=col-md-2>Дата завершения</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${goals}" var="goal">
    <hr>
    <h5>Цель ${goal.name}</h5>
            <form class="update-goal-${goal.id}" action="do?command=Profile" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${goal.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="name_goal" class="form-control input-md" name="name"
                               value="${goal.name}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="description_goal" class="form-control input-md" name="description"
                               value="${goal.description}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="beginDate" class="form-control input-md" name="beginDate"
                               value="${goal.beginDate}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="endDate" class="form-control input-md" name="endDate"
                               value="${goal.endDate}"/>
                    </div>


                    <div class=col-md-1>
                        <button id="Update_goal" value="Update_goal" name="Update_goal" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                    <div class=col-md-1>
                        <button id="Delete_goal" value="Delete_goal" name="Delete_goal" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>

                    <div class="container">
                    <br>
                        <h6>Задания ${goal.name}</h6>
                    <c:forEach items="${goal.tasks}" var="task">

                        <form class="update-task-${task.id}" action="do?command=Profile" method=POST>
                        <div class="row">
                            <div class=col-md-1>
                                <input id="id" class="form-control input-md" name="id_task" value="${task.id}"/>
                            </div>
                            <div class=col-md-2>
                                 <input id="name_task" class="form-control input-md" name="name" value="${task.name_task}"/>
                            </div>
                            <div class=col-md-6>
                                 <input id="description_task" class="form-control input-md" name="description" value="${task.description_task}"/>
                            </div>

                            <div class=col-md-1>
                                 <button id="Update_task" value="Update_task" name="Update_task" class="btn btn-success">
                                     Выполнено
                                 </button>
                            </div>

                         </div>
                         </form>
                    <br>
                    </c:forEach>
                    </div>
                </div>

            </form>
    </c:forEach>
</div>

</div>
</body>
</html>
