<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action=do?command=CreateGoal method="POST">
<fieldset>

<!-- Form Name -->
<legend>Create Goal</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name goal</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Name goal</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description_goal">Description goal</label>
  <div class="col-md-4">
  <input id="description_goal" name="description_goal" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Description goal</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="endDate">End date</label>
  <div class="col-md-4">
  <input id="endDate" name="endDate" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">End date</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="beginDate">Begin date</label>
  <div class="col-md-4">
  <input id="beginDate" name="beginDate" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Begin date</span>
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

