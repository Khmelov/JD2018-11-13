<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>

<div class="container">
     <%@ include file="include/menu.jsp" %>
     <p> <img src="image/basket.png" width="100" height="100" alt="basket">${pusto}</p>

      <div class="container">
         <c:forEach items="${basket}" var="bask">
            <form class="basket${bask.id_basket}" action="do?command=basket" method="POST" >
                  <legend>Корзинка ${bask.tovar}</legend>
                   <div class="row">

                     <div class="Brakets">
                        <div>
                            <p>id_basket</p>
                            <input id="id_basket" class="form-control input-md" name="id_basket"
                                      value="${bask.id_basket}"/>
                    </div>
                        <div>
                            <p>Товар</p>
                            <input id="tovar" class="form-control input-md" name="tovar"
                                                                       value="${bask.tovar}"/>
                        </div>

                    <div>
                        <p>Цена за одны единицу товара</p>
                        <input id="priceHt" class="form-control input-md" name="priceHt"
                                                                   value="${bask.priceHt}"/>
                        </div>

                        <div>
                            <p>Количество единиц товара </p>
                            <input id="kolTovar" class="form-control input-md" name="kolTovar"
                                                                       value="${bask.kolTovar}"/>
                        </div>

                        <div>
                            <p>Бисквит</p>
                            <input id="biscuit" class="form-control input-md" name="biscuit"
                                                                       value="${bask.biscuit}"/>
                        </div>

                        <div>

                            <p>Начинка</p>
                            <input id="nachinka" class="form-control input-md" name="nachinka"
                                                                        value="${bask.nachinka}"/>
                        </div>

                    </div>

                    <div class="Brakets">

                        <div>
                            <p>Украшения</p>
                                    <input id="decoration" class="form-control input-md" name="decoration"
                                                               value="${bask.decoration}"/>
                        </div>

                        <div>
                            <p>Крем</p>
                            <input id="cream" class="form-control input-md" name="cream"
                                                                       value="${bask.cream}"/>
                        </div>

                        <div>
                            <p>Цена за данныю козинку</p>
                            <input id="price_basket" class="form-control input-md" name="price_basket"
                                                                       value="${bask.price_basket}"/>
                        </div>

                      <div class="Brakets">
                        <button id="go" name="go" value="go" class="btn btn-outline-primary my-2 my-sm-0">Подтвердить заказ</button>
                        <button id="delete" name="delete" value="delete" class="btn btn-outline-danger my-2 my-sm-0">Удалить из карзины</button>
                        <button id="update" name="update" value="update" class="btn btn-outline-warning my-2 my-sm-0">Обновить карзину</button>
                      </div>
                             </div>
                           </div>
                        </form>

            <hr>
         </c:forEach>
      </div>
</div>
</body>

</html>
