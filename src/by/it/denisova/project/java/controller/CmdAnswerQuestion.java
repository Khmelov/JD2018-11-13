package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Answer;
import by.it.denisova.project.java.beans.Question;
import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdAnswerQuestion implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)) {
            Test test = Util.findTest(req);
            String questionReq = Form.getString(req,"question");
            Question question = new Question(0,questionReq,test.getId());
            Dao.getDao().question.create(question);

            String answerReq = Form.getString(req,"answerOne");
            String status = "Some status";
            Answer answer = new Answer(0, question.getId(),answerReq,status);
            Dao.getDao().answer.create(answer);

            String answerReq2 = Form.getString(req,"answerTwo");
            Answer answer2 = new Answer(0, question.getId(),answerReq2,status);
            Dao.getDao().answer.create(answer2);

            String answerReq3 = Form.getString(req,"answerThree");
            Answer answer3 = new Answer(0, question.getId(),answerReq3,status);
            Dao.getDao().answer.create(answer3);

            String answerReq4 = Form.getString(req,"answerFour");
            Answer answer4 = new Answer(0, question.getId(),answerReq4,status);
            Dao.getDao().answer.create(answer4);

            return Action.ANSWERQUESTION;
        }
        return null;
    }
}
