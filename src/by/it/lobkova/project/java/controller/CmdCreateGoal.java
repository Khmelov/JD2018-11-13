package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;
import by.it.lobkova.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdCreateGoal implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
//        if (Form.isPost(req)) {
////            User user = new User();
////            String name_goal = Form.getString(req, "name_goal");
////            String description_goal = Form.getString(req, "description_goal");
////            long beginDate = Form.getLong(req, "beginDate");
////            long endDate = Form.getLong(req, "endDate");
////            String where = String.format(" WHERE id='%d' LIMIT 0,1", user.getId());
////            List<User> all = Dao.getDao().user.getAll(where);
////            if (all.size() == 1) {
////                User user1 = all.get(0);
////                req.getSession().setAttribute("user", user1);
////                Goal goal = new Goal(0, name_goal, description_goal, beginDate, endDate, 2);
////            }
////        }
//        }
        return null;
    }
}