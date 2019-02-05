package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Lesson;
import by.it.denisova.project.java.beans.Question;
import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {

        List<Test> tests = Dao.getDao().test.getAll();
        List<Question> testQuestions = new ArrayList<>();

        for (Test test: tests) {
            String where = String.format("WHERE `questions`.`id_test` = '%d'", test.getId());
            List<Question> questions = Dao.getDao().question.getAll(where);
            test.setQuestionList(questions);
        }

       req.setAttribute("tests",tests);
        return null;
    }


}
