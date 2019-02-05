package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Task;
import by.it.lobkova.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


class CmdCreateTask implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            String name_task = Form.getString(req, "name_task");
            String description_task = Form.getString(req, "description_task");
            long date = Form.getLong(req, "date");
            long id_goals = Form.getLong(req, "id_goals");
            Task task = new Task(0, name_task, description_task, date, id_goals);
            Dao.getDao().task.create(task);
            return Action.PROFILE;
        }
        return Action.CREATETASK;
    }
}