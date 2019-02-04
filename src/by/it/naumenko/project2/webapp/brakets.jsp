<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>

<div class="container">
     <%@ include file="include/menu.jsp" %>
     <p> заказы:${zakaz}</p>

      <div class="container">
         <c:forEach items="${zakaz}" var="zak">
            <form class="zakaz${zak.id_zakaz}" action="do?command=brakets" method="POST" >
                  <legend>Заказ</legend>
                   <div class="row">

                     <div class="Brakets">
                        <div>
                            <p>id_zakaz</p>
                            <input id="id_zakaz" class="form-control input-md" name="id_zakaz"
                                      value="${zak.id_zakaz}"/>
                    </div>
                        <div>
                            <p>tovar</p>
                            <input id="tovar" class="form-control input-md" name="tovar"
                                                                       value="${zak.tovar}"/>
                        </div>

                    <div>
                        <p>priceht</p>
                        <input id="priceHt" class="form-control input-md" name="priceHt"
                                                                   value="${zak.priceHt}"/>
                        </div>

                        <div>
                            <p>kolTovar</p>
                            <input id="kolTovar" class="form-control input-md" name="kolTovar"
                                                                       value="${zak.kolTovar}"/>
                        </div>

                        <div>
                            <p>biscuit</p>
                            <input id="biscuit" class="form-control input-md" name="biscuit"
                                                                       value="${zak.biscuit}"/>
                        </div>

                        <div>

                            <p>nachinka</p>
                            <input id="nachinka" class="form-control input-md" name="nachinka"
                                                                        value="${zak.nachinka}"/>
                        </div>

                    </div>

                    <div class="Brakets">

                        <div>
                            <p>decoration</p>
                                    <input id="decoration" class="form-control input-md" name="decoration"
                                                               value="${zak.decoration}"/>
                        </div>

                        <div>
                            <p>cream</p>
                            <input id="cream" class="form-control input-md" name="cream"
                                                                       value="${zak.cream}"/>
                        </div>

                        <div>
                            <p>price_zakaz</p>
                            <input id="price_zakaz" class="form-control input-md" name="price_zakaz"
                                                                       value="${zak.price_zakaz}"/>
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


                      <div class="Brakets">
                        <button id="button1id" name="button1id" class="btn btn-outline-primary my-2 my-sm-0">Подтвердить заказ</button>
                        <button id="button2id" name="button2id" class="btn btn-outline-danger my-2 my-sm-0">Удалить из карзины</button>
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
