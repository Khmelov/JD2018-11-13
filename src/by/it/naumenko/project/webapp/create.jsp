<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <%@ include file="include/head.jsp" %>

 <body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>

        <div class ="Forms">
                        <form class="form-horizontal" action="do?command=Create" method="POST">
                        <fieldset>

                        <!-- Form Name -->
                        <legend>Регистрация</legend>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="login">Логин</label>
                          <div class="col-md-8">
                          <input id="login" name="login" type="text" placeholder="min6" class="form-control input-md" required="">

                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="password">Пароль</label>
                          <div class="col-md-8">
                          <input id="password" name="password" type="text" placeholder="min6" class="form-control input-md" required="">

                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="email">Email</label>
                          <div class="col-md-8">
                          <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">

                          </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="role">Role</label>
                          <div class="col-md-6">
                            <select id="id_role" name="id_role" class="form-control">
                              <c:forEach items="${roles}" var="role">
                                <option value ="${role.id_role}" role=${role.id_role} ${role.id_role==user.id_role?"selected":""}>
                                            ${id_role.role}
                                </option>
                              </c:forEach>
                            </select>
                          </div>
                        </div>


                        <!--<div class=col-md-2>
                                                <select id="role" name="roles_Id" class="form-control">
                                                    <c:forEach items="${roles}" var="role">
                                                        <option value="${role.id}" role=${role.id} ${role.id==user.roles_Id?"selected":""}>
                                                                ${id_role.role}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                            -->


                        <!-- Button -->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="createUser"></label>
                          <div class="col-md-8">
                            <button id="createUser" name="createUser" class="btn btn-success">Зарегистрироваться</button>
                          </div>
                        </div>

                        </fieldset>
                        </form>
                     </div>

                <div class="Forms">

                    <form class="form-horizontal" action="do?command=CreateRole" method="POST">
                    <fieldset>

                    <!-- Form Name -->
                    <legend>CreateRole</legend>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-8 control-label" for="role">Role</label>
                      <div class="col-md-8">
                      <input id="role" name="role" type="text" placeholder="" class="form-control input-md" required="">

                      </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-8 control-label" for="createRole"></label>
                      <div class="col-md-8">
                        <button id="createRole" name="createRole" class="btn btn-success">Создать</button>
                      </div>
                    </div>

                    </fieldset>
                    </form>


                </div>

                <div class="Forms">
                       <form class="form-horizontal" action="do?command=CreateCake" method="POST">
                       <fieldset>

                       <!-- Form Name -->
                       <legend>CreateCake</legend>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="name_cake">NameCake</label>
                         <div class="col-md-8">
                         <input id="name_cake" name="name_cake" type="text" placeholder="" class="form-control input-md" required="">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="size_cake">SizeCake</label>
                         <div class="col-md-8">
                         <input id="size_cake" name="size_cake" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="weight_cake">Weight</label>
                         <div class="col-md-8">
                         <input id="weight_cake" name="weight_cake" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="bescuit">Biscuit</label>
                         <div class="col-md-8">
                         <input id="bescuit" name="bescuit" type="text" placeholder="" class="form-control input-md" required="">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="decoration">Decoration</label>
                         <div class="col-md-8">
                         <input id="decoration" name="decoration" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="price_cake">PriceCake</label>
                         <div class="col-md-8">
                         <input id="price_cake" name="price_cake" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Button -->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="createCake"></label>
                         <div class="col-md-8">
                           <button id="createCake" name="createCake" class="btn btn-success">Create</button>
                         </div>
                       </div>

                       </fieldset>
                     </form>

                </div>

     </d1iv>
 </body>


</html>
