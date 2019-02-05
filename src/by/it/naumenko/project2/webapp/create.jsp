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
                        <legend>Регистрация пользователя</legend>

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
                          <label class="col-md-6 control-label" for="role">Роль</label>
                          <div class="col-md-6">
                            <select id="id_role" name="id_role" class="form-control">
                              <c:forEach items="${roles}" var="role">
                                <option value ="${role.id_role}">
                                            ${role.role}
                                </option>
                              </c:forEach>
                            </select>
                          </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="createUser"></label>
                          <div class="col-md-8">
                            <button id="createUser" name="createUser" class="btn btn-outline-success my-2 my-sm-0">Добавить пользователя</button>
                          </div>
                        </div>

                        </fieldset>
                        </form>
                     </div>

                <div class="Forms">

                    <form class="form-horizontal" action="do?command=CreateRole" method="POST">
                    <fieldset>

                    <!-- Form Name -->
                    <legend>Добавить роль</legend>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-8 control-label" for="role">Новая роль</label>
                      <div class="col-md-8">
                      <input id="role" name="role" type="text" placeholder="" class="form-control input-md" required="">

                      </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-8 control-label" for="createRole"></label>
                      <div class="col-md-8">
                        <button id="createRole" name="createRole" class="btn btn-outline-primary my-2 my-sm-0">Создать роль</button>
                      </div>
                    </div>

                    </fieldset>
                    </form>


                </div>


                <div class="Forms">
                       <form class="form-horizontal" action="do?command=CreateCake" method="POST">
                       <fieldset>

                       <!-- Form Name -->
                       <legend>Добавить товар</legend>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="kategoriya">Категория товара</label>
                         <div class="col-md-8">
                         <input id="kategoriya" name="kategoriya" type="text" placeholder="" class="form-control input-md" required="">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="price">цена категории</label>
                         <div class="col-md-8">
                         <input id="price" name="price" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="biscuit">Бисквит</label>
                         <div class="col-md-8">
                         <input id="biscuit" name="biscuit" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="nachinka">Начинка</label>
                         <div class="col-md-8">
                         <input id="nachinka" name="nachinka" type="text" placeholder="" class="form-control input-md" required="">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="decoration">Украшение</label>
                         <div class="col-md-8">
                         <input id="decoration" name="decoration" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="cream">Крем</label>
                         <div class="col-md-8">
                         <input id="cream" name="cream" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Button -->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="createCake"></label>
                         <div class="col-md-8">
                           <button id="createCake" name="createCake" class="btn btn-outline-warning my-2 my-sm-0">Create</button>
                         </div>
                       </div>

                       </fieldset>
                     </form>
                </div>
     </d1iv>
 </body>


</html>
