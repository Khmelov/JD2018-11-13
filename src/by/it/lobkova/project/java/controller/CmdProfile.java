package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
       if (!Util.checkUser(req)) {
           return Action.LOGIN;
       }
        if(Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        User user = Util.findUser(req);
        String where=String.format(" WHERE `user_id`='%d'",user.getId());

        List<Goal> goals = Dao.getDao().goal.getAll(where);
        req.setAttribute("goals",goals);
        return Action.PROFILE;
    }
}
