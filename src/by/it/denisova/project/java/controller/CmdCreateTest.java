package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdCreateTest implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)){
            String test_name = Form.getString(req,"test_name");
            Test test = new Test(0,test_name);
            Dao dao = Dao.getDao();
            if(dao.test.create(test)) {
                req.getSession().setAttribute("test",test);
                return Action.ANSWERQUESTION;
            }
        }
        return Action.TEST;
    }
}
