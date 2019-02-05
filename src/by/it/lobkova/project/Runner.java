package by.it.lobkova.project;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.beans.Task;
import by.it.lobkova.project.java.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        Task task = new Task();
        task.setId(14);

        if (dao.task.delete(task))
            System.out.println("UPDATE: " + task);
    }
}
