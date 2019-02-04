<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<style>
    div.hiden { /* this will hide all divs on the page */
        display: none;
    }
</style>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <div class="page-header">
        <h3>Профиль ${user.login}</h3>
    </div>
    <div class="row">
        <div class="col-md-2">Лоигн</div>
        <div class="col-md-2">Имя</div>
        <div class="col-md-2">Дата рождения</div>
        <div class="col-md-2">Email</div>
        <div class="col-md-2">Телефон</div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-2">${user.login}</div>
        <div class="col-md-2">${user.name}</div>
        <div class="col-md-2">${user.dateOfBirth}</div>
        <div class="col-md-2">${user.email}</div>
        <div class="col-md-2">${user.tel}</div>
    </div>
    <br>

    <div class="page-header">
        <h3>Объявления ${user.login}</h3>
    </div>

    <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <label class="btn btn-secondary active">
            <input type="radio" name="ad_list" id="ad_list" autocomplete="off" checked>Список
        </label>
        <label class="btn btn-secondary">
            <input type="radio" name="ad_edit" id="ad_edit" autocomplete="off"> Редактировать
        </label>
    </div>

    <br>

    <div class="row">
        <div class="col-md-2">Заголовок</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Марка</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Цвет</div>
        <div class="col-md-1">Объем двигателя</div>
        <div class="col-md-2">Цена</div>
    </div>

    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
            <div class="col-md-2">${ad.title}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.brnd}</div>
            <div class="col-md-1">${ad.model}</div>
            <div class="col-md-1">${ad.color}</div>
            <div class="col-md-1">${ad.engine} л.</div>
            <div class="col-md-2">${ad.price} руб.</div>
            <hr>
        </div>
    </c:forEach>

    <c:forEach items="${ads}" var="ad">
        <form class="update-ads-${ad.id}" action="do?command=Profile" method="POST">
            <div class="row">

                <div class="hiden">
                    <label for="id">ID</label>
                    <input readonly type="number" id="id" class="form-control input-md" name="id" value="${ad.id}"/>
                </div>

                <div class="col-md-3">
                    <label for="title">Заголовок</label>
                    <input id="title" name="title" type="text" value="${ad.title}" placeholder=" "
                           class="form-control input-md" required
                           pattern="[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\-!?,. ]*" minlength="8" maxlength="50">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>первый символ - буква в верхнем или нижнем регистре</div>
                        <div>от 8 до 50 символов</div>
                        <div>буквы в верхнем и нижнем регистре, цифры</div>
                        <div>символы \ - ! ? , . ]*</div>
                      </span>
                </div>
                <div class="col-md-3">
                    <label for="description">Описание</label>
                    <input minlength="7" max="2000" type="text" id="description" class="form-control input-md"
                           name="description"
                           value="${ad.description}"/>
                </div>
                <div class="col-md-3">
                    <label for="brnd">Марка</label>
                    <input readonly type="text" id="brnd" class="form-control input-md" name="brnd" value="${ad.brnd}"/>
                </div>
                <div class="col-md-3">
                    <label for="model">Модель</label>
                    <input readonly type="text" id="model" class="form-control input-md" name="model"
                           value="${ad.model}"/>
                </div>
                <div class="col-md-3">
                    <label for="color">Цвет</label>
                    <input id="color" name="color" type="text" value="${ad.color}" placeholder=" "
                           class="form-control input-md" required
                           pattern="[a-zA-Zа-яА-Я- ]*" minlength="1" maxlength="45">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>от 1 до 45 символов</div>
                        <div>буквы в верхнем и нижнем регистре</div>
                        <div>символ "-"</div>
                      </span>
                </div>
                <div class="col-md-3">
                    <label for="body">Кузов</label>
                    <input readonly id="body" type="text" class="form-control input-md" name="body" value="${ad.body}"/>
                </div>
                <div class="col-md-3">
                    <label for="year">Год</label>
                    <input id="year" name="year" type="number" value="${ad.year}" placeholder=" "
                           class="form-control input-md" required
                           minlength="4" maxlength="4" min="1900" max="2019">
                </div>
                <div class="col-md-3">
                    <label for="engine">Объем двигателя</label>
                    <input id="engine" name="engine" type="number" value="${ad.engine}" step="0.1" placeholder="2.5"
                           class="form-control input-md"
                           required/>
                </div>
                <div class="col-md-3">
                    <label for="at">Коробка передач</label>
                    <input readonly id="at" class="form-control input-md" name="at" value="${ad.at}"/>
                </div>
                <div class="col-md-3">
                    <label for="driveunit">Привод</label>
                    <input readonly id="driveunit" class="form-control input-md" name="driveunit"
                           value="${ad.driveunit}"/>
                </div>
                <div class="col-md-3">
                    <label for="equipment">Комплектация</label>
                    <input readonly id="equipment" class="form-control input-md" name="equipment"
                           value="${ad.equipment}"/>
                </div>
                <div class="col-md-3">
                    <label for="millage">Пробег</label>
                    <input id="millage" type="number" class="form-control input-md" name="millage"
                           value="${ad.millage}"/>
                </div>
                <div class="col-md-3">
                    <label for="crashed">ДТП</label>
                    <input id="crashed" class="form-control" name="crashed" value="${ad.crashed}">

                </div>

                <div class="col-md-3">
                    <label for="price">Цена</label>
                    <input id="price" type="number" step="0.01" class="form-control input-md" name="price"
                           value="${ad.price}"/>
                </div>


                <div class=hiden>
                    <label for="id_User">Пользователь</label>
                    <input readonly id="id_User" class="form-control input-md" name="id_User" value="${ad.id_User}"/>
                        <%--<select disabled id="id_User" name="id_User" class="form-control">--%>
                        <%--<c:forEach items="${users}" var="user">--%>
                        <%--<option value="${user.id}"--%>
                        <%--user=${user.id} ${user.id==ad.id_User?"selected":""}>--%>
                        <%--${user.login}--%>
                        <%--</option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                </div>


                <div class="container">
                    <br>
                    <button id="delete" name="delete" value="delete" class="btn btn-danger">
                        Удалить
                    </button>
                    <button id="update" name="update" value="update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

            </div>
        </form>
        <hr>
    </c:forEach>
    <!--<form class="form-horizontal" action="do?command=Profile" method="POST">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>
        </fieldset>
    </form>-->

</div>
</body>
</html>
