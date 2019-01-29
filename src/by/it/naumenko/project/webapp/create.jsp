<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <%@ include file="include/head.htm" %>

 <body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <div class ="Forms">
                        <form class="form-horizontal">
                        <fieldset>

                        <!-- Form Name -->
                        <legend>CreateUser</legend>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="login">login</label>
                          <div class="col-md-8">
                          <input id="login" name="login" type="text" placeholder="min6" class="form-control input-md" required="">

                          </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="password">password</label>
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
                          <div class="col-md-1">
                            <select id="role" name="role" class="form-control">
                              <option value="1">Option one</option>
                              <option value="2">Option two</option>
                            </select>
                          </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                          <label class="col-md-8 control-label" for="createU"></label>
                          <div class="col-md-8">
                            <button id="createU" name="createU" class="btn btn-success">Create</button>
                          </div>
                        </div>

                        </fieldset>
                        </form>
                     </div>

                <div class="Forms">

                    <form class="form-horizontal">
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
                      <label class="col-md-8 control-label" for="createC"></label>
                      <div class="col-md-8">
                        <button id="createC" name="createC" class="btn btn-success">Create</button>
                      </div>
                    </div>

                    </fieldset>
                    </form>


                </div>

                <div class="Forms">
                       <form class="form-horizontal">
                       <fieldset>

                       <!-- Form Name -->
                       <legend>CreateCake</legend>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="namecake">NameCake</label>
                         <div class="col-md-8">
                         <input id="namecake" name="namecake" type="text" placeholder="" class="form-control input-md" required="">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="sizecake">SizeCake</label>
                         <div class="col-md-8">
                         <input id="sizecake" name="sizecake" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Text input-->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="weight">Weight</label>
                         <div class="col-md-8">
                         <input id="weight" name="weight" type="text" placeholder="" class="form-control input-md">

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
                         <label class="col-md-8 control-label" for="pricecake">PriceCake</label>
                         <div class="col-md-8">
                         <input id="pricecake" name="pricecake" type="text" placeholder="" class="form-control input-md">

                         </div>
                       </div>

                       <!-- Button -->
                       <div class="form-group">
                         <label class="col-md-8 control-label" for="createC"></label>
                         <div class="col-md-8">
                           <button id="createC" name="createC" class="btn btn-success">Create</button>
                         </div>
                       </div>

                       </fieldset>
                     </form>

                </div>

     </d1iv>
 </body>


</html>
