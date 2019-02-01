package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Lesson;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdLesson implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!Util.checkUser(req))
            return Action.LOGIN;

//        if (Form.isPost(req)){
//            long test = (long) Form.getInteger(req,"test");
//            long type = (long) Form.getInteger(req,"type");
//            String theory = Form.getString(req,"theory");
//            long theme = (long) Form.getInteger(req, "theme");
//            Lesson lesson = new Lesson(0,theory,theme,test,type);
//            Dao dao = Dao.getDao();
//            if(dao.lesson.create(lesson)) {
////                req.getSession().setAttribute("test",test);
//                return Action.TEST;
//            }
//        }
        return null;
    }
}
