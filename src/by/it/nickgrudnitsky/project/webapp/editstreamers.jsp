<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menuStreamer.htm" %>


    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Имя канала</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-2>Роль</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${streamers}" var="streamer">
            <form class="update-user-${streamer.id}" action="do?command=EditStreamers" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${streamer.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="channelname" class="form-control input-md" name="channelname"
                               value="${streamer.channelname}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="email" class="form-control input-md" name="email"
                               value="${streamer.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="role" name="role" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==streamer.roles_id?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
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


