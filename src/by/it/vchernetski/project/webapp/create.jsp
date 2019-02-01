<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=create" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="model">Model</label>
  <div class="col-md-4">
  <input id="model" name="model" value="model" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="color">Color</label>
  <div class="col-md-4">
  <input id="color" name="color" value="color"type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="year">Year</label>
  <div class="col-md-4">
  <input id="year" name="year" type="text" value="2018" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Garage">Garage</label>
  <div class="col-md-4">
  <input id="garage" name="garage" type="text" value="2" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"  for="Create"></label>
  <div class="col-md-4">
    <button id="Create" name="Create" class="btn btn-success">Create</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>


