<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.html" %>
<body>
<div class="container">
    <%@ include file="include/menu.html" %>
<form class="form-horizontal" action="do?command=AnswerQuestion" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="question">Question</label>
            <div class="col-md-4">
                <input id="question" name="question" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="answerOne">Answer №1</label>
            <div class="col-md-4">
                <input id="answerOne" name="answerOne" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="radiosAnswerOne"></label>
            <div class="col-md-4">
                <label class="radio-inline" for="radiosAnswerOne-0">
                    <input type="radio" name="radiosAnswerOne" id="radiosAnswerOne-0" value="Right" checked="checked">
                    Right
                </label>
                <label class="radio-inline" for="radiosAnswerOne-1">
                    <input type="radio" name="radiosAnswerOne" id="radiosAnswerOne-1" value="Wrong">
                    Wrong
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="answerTwo">Answer №2</label>
            <div class="col-md-4">
                <input id="answerTwo" name="answerTwo" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="radiosAnswerTwo"></label>
            <div class="col-md-4">
                <label class="radio-inline" for="radiosAnswerTwo-0">
                    <input type="radio" name="radiosAnswerTwo" id="radiosAnswerTwo-0" value="Right" checked="checked">
                    Right
                </label>
                <label class="radio-inline" for="radiosAnswerTwo-1">
                    <input type="radio" name="radiosAnswerTwo" id="radiosAnswerTwo-1" value="Wrong">
                    Wrong
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="answerThree">Answer №3</label>
            <div class="col-md-4">
                <input id="answerThree" name="answerThree" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="radiosAnswerThree"></label>
            <div class="col-md-4">
                <label class="radio-inline" for="radiosAnswerThree-0">
                    <input type="radio" name="radiosAnswerThree" id="radiosAnswerThree-0" value="Right" checked="checked">
                    Right
                </label>
                <label class="radio-inline" for="radiosAnswerThree-1">
                    <input type="radio" name="radiosAnswerThree" id="radiosAnswerThree-1" value="Wrong">
                    Wrong
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="answerFour">Answer №4</label>
            <div class="col-md-4">
                <input id="answerFour" name="answerFour" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="radiosAnswerFour"></label>
            <div class="col-md-4">
                <label class="radio-inline" for="radiosAnswerFour-0">
                    <input type="radio" name="radiosAnswerFour" id="radiosAnswerFour-0" value="Right" checked="checked">
                    Right
                </label>
                <label class="radio-inline" for="radiosAnswerFour-1">
                    <input type="radio" name="radiosAnswerFour" id="radiosAnswerFour-1" value="Wrong">
                    Wrong
                </label>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="createQuestion-Answer"></label>
            <div class="col-md-4">
                <button id="createQuestion-Answer" name="createQuestion-Answer" class="btn btn-primary">Create</button>
            </div>
        </div>

    </fieldset>
</form>
</div>
</body>
</html>