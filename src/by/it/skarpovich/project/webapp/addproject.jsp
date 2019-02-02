<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<form class="form-horizontal" action="do?command=AddProject" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Add Project</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Title</label>
  <div class="col-md-4">
  <input id="title" name="title" type="text" placeholder="" value="Zx400" class="form-control input-md" required="">

  </div>
</div>


<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="floors">Floors</label>
  <div class="col-md-4">
    <select id="floors" name="floors" class="form-control">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>

    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="square">Square</label>
  <div class="col-md-4">
  <input id="square" name="square" type="text" placeholder="" value="299" class="form-control input-md" required="">

  </div>
</div>


<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="materials">Materials</label>
  <div class="col-md-4">
<textarea class="form-control" id="materials" name="materials">Bricks</textarea>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" value="500" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Add Project</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

