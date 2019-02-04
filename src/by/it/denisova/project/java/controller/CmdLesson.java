package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Lesson;
import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.beans.Theme;
import by.it.denisova.project.java.beans.TypeLesson;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLesson implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
     List<Test> tests = Dao.getDao().test.getAll();
        List<TypeLesson> types = Dao.getDao().type.getAll();
        List<Theme>  themes = Dao.getDao().theme.getAll();
        req.setAttribute("themes", themes);
        req.setAttribute("types",types);
      req.setAttribute("tests", tests);
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)){

            long test = Form.getLong(req,"test");
            long type =  Form.getLong(req,"type");
            String theory = Form.getString(req,"theory");
            long theme =  Form.getLong(req, "theme");
            Lesson lesson = new Lesson(0,theory,theme,test,type);
            Dao dao = Dao.getDao();
            dao.lesson.create(lesson);
            return Action.PROFILE;


        }
        return Action.LESSON;
    }
}
