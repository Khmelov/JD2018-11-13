<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
 <div class="container">

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">passport</th>
      <th scope="col">firstName</th>
      <th scope="col">lastName</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${id}</th>
      <td>${passport}</td>
      <td>${firstName}</td>
      <td>${lastName}</td>
    </tr>

  </tbody>
</table>
  </div>
</body>
</html>
