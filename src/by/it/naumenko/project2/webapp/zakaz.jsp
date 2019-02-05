<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
     <%@ include file="include/menu.jsp" %>
     <div class="container">
        <p><img src="image/zakaz2.png" width="100" height="100" alt="zakaz">${pusto}</p>
        <c:forEach items="${zakaz}" var="zak">
             <form class="zakaz${zak.id_zakaz}" action="do?command=zakaz" method="POST" >
                <legend>Заказ ${zak.tovar}</legend>
                <div class="row">
                    <div class="Brakets">
                        <div>
                            <p>id_zakaz</p>
                            <input id="id_zakaz" class="form-control input-md" name="id_zakaz"
                                                        value="${zak.id_zakaz}"/>
                        </div>

                         <div>
                            <p>id_user</p>
                            <input id="id_user" class="form-control input-md" name="id_user"
                                                                    value="${zak.id_user}"/>
                         </div>

                         <div>
                            <p>id_tovar</p>
                            <input id="id_tovar" class="form-control input-md" name="id_tovar"
                                                              value="${zak.id_tovar}"/>
                         </div>


                        <div>
                            <p>Товар</p>
                            <input id="tovar" class="form-control input-md" name="tovar"
                                                          value="${zak.tovar}"/>
                        </div>

                         <div>
                            <p>цена за ед.</p>
                            <input id="priceHt" class="form-control input-md" name="priceHt"
                                                             value="${zak.priceHt}"/>
                         </div>

                         <div>
                             <p>Количество товара</p>
                             <input id="kolTovar" class="form-control input-md" name="kolTovar"
                                                                value="${zak.kolTovar}"/>
                         </div>



                    </div>


                    <div class="Brakets">

                        <div>
                          <p>Бисквит</p>
                          <input id="biscuit" class="form-control input-md" name="biscuit"
                                                         value="${zak.biscuit}"/>
                        </div>

                        <div>
                          <p>Начинка</p>
                          <input id="nachinka" class="form-control input-md" name="nachinka"
                                                     value="${zak.nachinka}"/>
                        </div>

                        <div class="row">
                          <div class="col-md-6">
                            <p>Украшения</p>
                            <input id="decoration" class="form-control input-md" name="decoration"
                                                              value="${zak.decoration}"/>
                          </div>

                          <div class="col-md-6">
                            <p>за украшения</p>
                            <input id="doplatadecor" class="form-control input-md" name="doplatadecor"/>
                          </div>
                        </div>

                          <div>
                               <p>Крем</p>
                               <input id="cream" class="form-control input-md" name="cream"
                                                                                                value="${zak.cream}"/>
                          </div>



                           <div>
                             <p>Цена всего заказа</p>
                             <input id="price_zakaz" class="form-control input-md" name="price_zakaz"
                                                                        value="${zak.price_zakaz}"/>
                           </div>

                           <select id="status" name="status" class="form-control">
                              <option value="в процессе">в процессе</option>
                              <option value="в ожидании">в ожидании</option>
                              <option value="выполнен">выполнен</option>
                           </select>

                            <div class="Brakets">
                               <button id="update" name="update" class="btn btn-outline-warning my-2 my-sm-0">Обновить заказ</button>
                               <!--<button id="cancel" name="cancel" class="btn btn-outline-danger my-2 my-sm-0">Отменить</button>-->
                            </div>
                    </div>
                </div>
            </form>
        </c:forEach>
     </div>
</div>
</body>
</html>
