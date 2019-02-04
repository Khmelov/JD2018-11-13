<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.jsp" %>
<body>

<div class="container">
    <div class="home">
        <%@ include file="include/menu.jsp" %>

        <p> message:${cakes}</p>
        <p> message:${p}</p>

       <form class="form-horizontal" action="do?command=brakets" method="POST">
            <fieldset>

            <!-- Form Name -->
            <legend>Собери свой торт</legend>

            <!-- Select kategoriya -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="kategoriya">Выберите категорию</label>
              <div class="col-md-6">
                <select id="kategoriya" name="kategoriya" class="form-control">
                  <c:forEach items="${cakes}" var="cake">
                    <option value="${cake.kategoriya}" cake="${cake.kategoriya}">
                      ${cake.kategoriya}
                    </option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <!--<c:forEach items="${cakes} var=t">
                <input id="price" name="price" value="${t.price}" type="text" ${t.kategoriya}=="selected"?t.price:"ytn" >

            </c:forEach>-->


            <!-- Select biscuit -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="selectbasic">Выберите бисквит</label>
              <div class="col-md-6">
                <select id="price" name="selectbasic" class="form-control">
                  <c:forEach items="${cakes}" var="cake">
                    <option value="${cake.biscuit}" cake="{cake.biscuit}" >
                        ${cake.biscuit}
                    </option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <!-- Select nachinka -->
              <div class="form-group">
                <label class="col-md-4 control-label" for="selectbasic">Выбирите начинку</label>
                <div class="col-md-6">
                  <select id="nachinka" name="nachinka" class="form-control">
                    <c:forEach items="${cakes}" var="cake">
                      <option value="${cake.nachinka}" cake="{cake.nachinka}" >
                         ${cake.nachinka}
                      </option>
                    </c:forEach>
                  </select>
                </div>
              </div>

            <!-- Select decoration -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="selectbasic">Выбирите укращения</label>
              <div class="col-md-6">
                <select id="decoration" name="decoration" class="form-control">
                  <c:forEach items="${cakes}" var="cake">
                    <option value="${cake.decoration}" cake="{cake.decoration}" >
                      ${cake.decoration}
                    </option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <!-- Select cream -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="selectbasic">Выбирите крем</label>
              <div class="col-md-6">
                <select id="cream" name="cream" class="form-control">
                  <c:forEach items="${cakes}" var="cake">
                   <option value="${cake.cream}" crecakeam="{cake.cream}" >
                      ${cake.cream}
                   </option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
                        <label class="form-inline my-2 my-lg-0" for="ok"></label>
                        <div class="col-md-4">
                            <button id="ok" name="ok" class="btn btn-outline-primary my-2 my-sm-0">Оформить заказ</button>
                        </div>
                    </div>

            </fieldset>
        </form>

    </div>
</div>
</body>

</html>
