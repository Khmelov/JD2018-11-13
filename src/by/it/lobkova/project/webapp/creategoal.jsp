<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action=do?command=CreateGoal method="POST">
<fieldset>

<!-- Form Name -->
<legend>Create Goal</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name_goal">Name goal</label>
  <div class="col-md-4">
  <input id="name_goal" name="name_goal" value="TestGoal" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description_goal">Description goal</label>
  <div class="col-md-4">
  <input id="description_goal" name="description_goal" value="TestDescriptionGoal" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="beginDate">Begin date</label>
  <div class="col-md-4">
  <input id="beginDate" name="beginDate" value="2020" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="endDate">End date</label>
  <div class="col-md-4">
  <input id="endDate" name="endDate" value="2019" type="text" placeholder="" class="form-control input-md" required="">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Create</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

