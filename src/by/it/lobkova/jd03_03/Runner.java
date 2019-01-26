package by.it.lobkova.jd03_03;

import by.it.lobkova.jd03_03.beans.Task;
import by.it.lobkova.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Task role= new Task();
        role.setName_task("RRR8888RR");
        role.setDescription_task("hhh");
        role.setDate(2020);
        role.setGoals_ID(1);
        if (dao.task.create(role))
            System.out.println("CREATE: " + role);
        role.setDescription_task("RRRRR2222222");
        if (dao.task.update(role))
            System.out.println("UPDATE: " + role);
        role = dao.task.read(role.getId());
        System.out.println("READ: " + role);
    }
}
