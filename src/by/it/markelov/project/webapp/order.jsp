<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>


<form class="form-horizontal" action="do?command=Order" method="POST">
<fieldset>


<!-- Form Name -->
<legend>Order</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Shoe_name">Shoe_name</label>
  <div class="col-md-4">
    <select id="Shoe_name" name="Shoe_name" class="form-control">
      <option value="Sneakers">Sneakers</option>
      <option value="Boots">Boots</option>
      <option value="Sandals">Sandals</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Shoe_size">Shoe_size</label>
  <div class="col-md-4">
    <select id="Shoe_size" name="Shoe_size" class="form-control">
      <option value="36">36</option>
      <option value="40">40</option>
      <option value="42">42</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Shoe_colour">Shoe_colour</label>
  <div class="col-md-4">
    <select id="Shoe_colour" name="Shoe_colour" class="form-control">
      <option value="Green">Green</option>
      <option value="White">White</option>
      <option value="Black">Black</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Price</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="users_ID">users_ID</label>
  <div class="col-md-4">
    <select id="users_ID" name="users_ID" class="form-control">
      <option value="1">Administrator</option>
      <option value="2">User</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Order">Order</label>
  <div class="col-md-4">
    <button id="Order" name="Order" class="btn btn-success">Order</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>




