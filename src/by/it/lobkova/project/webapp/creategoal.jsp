<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action=do?command=CreateGoal method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создние цели</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name_goal">Название</label>
  <div class="col-md-4">
  <input id="name_goal" name="name_goal" value="TestGoal" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description_goal">Описание</label>
  <div class="col-md-4">
  <input id="description_goal" name="description_goal" value="TestDescriptionGoal" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="beginDate">Дата начала</label>
  <div class="col-md-4">
  <input id="beginDate" name="beginDate" value="2020" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="endDate">Дата завершения</label>
  <div class="col-md-4">
  <input id="endDate" name="endDate" value="2019" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

