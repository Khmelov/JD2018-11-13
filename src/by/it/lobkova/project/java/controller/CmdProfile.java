package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.beans.Task;
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

        Dao dao = Dao.getDao();
        User user = Util.findUser(req);

        if (user == null) return Action.LOGIN;

        if (Form.isPost(req)) {
            if (req.getParameter("Update_task") != null) {
                Task task = new Task();
                long id = Form.getLong(req, "id_task");
                task.setId(id);
                dao.task.delete(task);
            } else {
                long id = Form.getLong(req, "id");
                String name_goal = Form.getString(req, "name");
                String description_goal = Form.getString(req, "description");
                long beginDate = Form.getLong(req, "beginDate");
                long endDate = Form.getLong(req, "endDate");
                Goal goal = new Goal(id, name_goal, description_goal, beginDate, endDate, user.getId());
                if (req.getParameter("Update_goal") != null)
                    dao.goal.update(goal);
                else if (req.getParameter("Delete_goal") != null)
                    dao.goal.delete(goal);
            }
        }

        List<Goal> goals = Dao.getDao().goal.getAll();

        for (Goal goal : goals) {
            String whereGoal = String.format(" WHERE `tasks`.`goals_ID` = '%d'", goal.getId());
            List<Task> tasks = Dao.getDao().task.getAll(whereGoal);
            goal.setTasks(tasks);
        }

        req.setAttribute("goals", goals);

        return Action.PROFILE;
    }
}
