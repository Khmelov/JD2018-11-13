<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Lesson" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Создать Урок</legend>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="test">Test</label>
                <div class="col-md-4">

                    <select id="test" name="test" class="form-control">
                        <c:forEach items="${tests}" var="test">
                        <option value="${test.id}">${test.test_name}</option>
                        </c:forEach>
                        <%--<option value="2">2</option>--%>
                    </select>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="type">Type</label>
                <div class="col-md-4">
                    <select id="type" name="type" class="form-control">
                        <c:forEach items="${types}" var="type">
                        <option value="${type.id}">${type.type}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="theory">Theory</label>
                <div class="col-md-4">
                    <input id="theory" name="theory" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="theme">Theme</label>
                <div class="col-md-4">
                    <select id="theme" name="theme" class="form-control">
                        <c:forEach items="${themes}" var="theme">
                        <option value="${theme.id}">${theme.theme}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="theoryFile">Theory file</label>
                <div class="col-md-4">
                    <input id="theoryFile" name="theoryFile" class="input-file" type="file">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createLesson"></label>
                <div class="col-md-4">
                    <button id="createLesson" name="createLesson" class="btn btn-primary">Create</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>