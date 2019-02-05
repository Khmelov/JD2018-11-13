package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


class CmdCreateGoal implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            String name_goal = Form.getString(req, "name_goal");
            String description_goal = Form.getString(req, "description_goal");
            long beginDate = Form.getLong(req, "beginDate");
            long endDate = Form.getLong(req, "endDate");
            User user = Util.findUser(req);
            Goal goal = new Goal(0, name_goal, description_goal, beginDate, endDate, user.getId());
            Dao.getDao().goal.create(goal);
            return Action.PROFILE;
        }
        return Action.CREATEGOAL;
    }
}