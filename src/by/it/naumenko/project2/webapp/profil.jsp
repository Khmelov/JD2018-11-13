<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
    <div class="container">
        <%@ include file="include/menu.jsp" %>
        <p><img src="image/profil2.png" width="300" height="300" alt="Профиль"> </p>
        <p><input id="foto" name="foto" class="input-file" type="file"></p>

        <form class="form-horizontal" action ="do?command=editProfil" method="POST">
        		<fieldset>
        		  	<div class="FormProfil">
        				<legend>Профиль</legend>



        		          <!-- Text input-->
        		          <div class="form-group">
        		            <label class="col-md-4 control-label" for="name">Имя</label>
        		          	<div class="col-md-4">
        		            	<input id="name_profile" name="name_profile" value="${profil.name_profil}" type="text" placeholder="" class="form-control input-md">
        		          	</div>
        		          </div>


        		          <div class="form-group">
        		            <label class="col-md-4 control-label"  for="lastName">Фамилия</label>
        		            <div class="col-md-4">
        		            	<input id="lastName_profil" name="lastName_profil" value="${profil.lastName_profil}" type="text" placeholder="" class="form-control input-md">
        		            </div>
        		          </div>


        		        <p style="color: yellow">День Рождения:</p>
        		        <div class="row">
        		        	<div class="col-md-1">
        		        	    <!--<input id="dayBirth" name="dayBirth" value="${profil.dayBirth}" type="text" placeholder="число" class="form-control input-md">-->
        		                <select id="dayBirth" name="dayBirth" class="form-control">
        		                    <c:forEach var="day" begin="1" end="31" step="1">
        		                        <option value="${day}" ${day==profil.dayBirth?"selected":""}>${day}</option>
        		                    </c:forEach>
        		                </select>
        		             </div>

        		            <div class="col-md-2">
        		                  <!--<input id="mountBirth" name="mountBirth" value="${profil.mountBirth}" type="text" placeholder="месяц" class="form-control input-md">-->

        		                  <select id="mountBirth" name="mountBirth" class="form-control">
        		                    <option value="Январь" ${value==profil.mountBirth?"selected":""}>Январь</option>
        		                    <option value="Февраль" ${value==profil.mountBirth?"selected":""}>Февраль</option>
        		                    <option value="Март" ${value==profil.mountBirth?"selected":""}>Март</option>
        		                    <option value="Апрель" ${value==profil.mountBirth?"selected":""}>Апрель</option>
        		                    <option value="Май" ${value==profil.mountBirth?"selected":""}>Май</option>
        		                    <option value="Июнь" ${value==profil.mountBirth?"selected":""}>Июнь</option>
        		                    <option value="Июль" ${value==profil.mountBirth?"selected":""}>Июль</option>
        		                    <option value="Август" ${value==profil.mountBirth?"selected":""}>Август</option>
        		                    <option value="Сентябрь" ${value==profil.mountBirth?"selected":""}>Сентябрь</option>
        		                    <option value="Октябрь" ${value==profil.mountBirth?"selected":""}>Октябрь</option>
        		                    <option value="Ноябрь" ${value==profil.mountBirth?"selected":""}>Ноябрь</option>
        		                    <option value="Декабрь" ${value==profil.mountBirth?"selected":""}>Декабрь</option>
        		                  </select>
        		             </div>


                            <div>
                                <select id="yearBirth" name="yearBirth" class="form-control">
                                    <c:forEach var="year" begin="1940" end="2019" step="1" >
                                        <option value = "${year}" ${year==profil.yearBirth?"selected":""}>${year}</option>
                                    </c:forEach>
                                </select>

                                <!--<input id="yearBirth" name="yearBirth" value="${profil.yearBirth}"  type="text" placeholder="" class="form-control input-md">-->
                            </div>


        				 </div>

        				<div class="form-group">
        		            <label class="col-md-4 control-label" for="pol">Пол</label>
        		            <div class="col-md-4">
        		            	<select id="pol" name="pol" class="form-control">
        		            	    <option value="мужской" ${value==profil.pol?"selected":""}>мужской</option>
        		            	    <option value="женский" ${value==profil.pol?"selected":""}>женский</option>
        		            	<select>
        		            </div>
        		        </div>

        				<p style="color: yellow">Адрес:</p>
        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="city">Город</label>
        		            <div class="col-md-4">
        		            	<input id="city" name="city" value="${profil.city}" type="text" placeholder="" class="form-control input-md">
        		            </div>
        		        </div>


        				<div class="form-group">
        		            <label class="col-md-4 control-label" for="street">Улица</label>
        		            <div class="col-md-4">
        		            <input id="street" name="street" value="${profil.street}" type="text" placeholder="" class="form-control input-md">

        		            </div>
        		          </div>


        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="home">Дом</label>
        		            <div class="col-md-4">
        		        	    <input id="home" name="home" value="${profil.home}" type="text" placeholder="" class="form-control input-md">
        		            </div>
        		        </div>

        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="korpus">Корпус</label>
        		            <div class="col-md-4">
        			            <input id="korpus" name="korpus" value="${profil.korpus}" type="text" placeholder="" class="form-control input-md">
        		            </div>
        		        </div>


        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="kvartira">квартира</label>
        		            <div class="col-md-4">
        		        	    <input id="kvartira" name="kvartira" value="${profil.kvartira}" type="text" placeholder="" class="form-control input-md">
        		            </div>
        		        </div>


        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="tel">Тел</label>
        		            <div class="col-md-4">
        		        	    <input id="tel" name="tel" value="${profil.tel}" type="text" placeholder="+375" class="form-control input-md">
        		            </div>
        		         </div>


        		        <div class="form-group">
        		            <label class="col-md-4 control-label" for="about">О себе</label>
        		            <div class="col-md-8">
        			            <textarea class="form-control" id="about"  name="about">${profil.about}</textarea>
        		            </div>
        		        </div>


        		        <div class="form-group">
        		            <label class="form-inline my-2 my-lg-0" for="save"></label>
        		            <div class="col-md-4">
        		        	    <button id="save" name="save" class="btn btn-outline-primary my-2 my-sm-0">Сохранить</button>
        		            </div>
        		        </div>
        		  	</div>
        		</fieldset>
        	</form>
    </div>
</body>
</html>


