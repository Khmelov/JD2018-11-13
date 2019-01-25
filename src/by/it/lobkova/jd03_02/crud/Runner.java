package by.it.lobkova.jd03_02.crud;

import by.it.lobkova.jd03_02.beans.Role;
import by.it.lobkova.jd03_02.beans.Task;
import by.it.lobkova.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        TaskCRUD taskCRUD = new TaskCRUD();
        Task task =new Task();
        task.setName_task("user77772010");
        task.setDescription_task("task5p");
        task.setDate(2201);
        task.setGoals_ID(1);
        if (taskCRUD.create(task))
            System.out.println("CREATE: "+task);
        task.setName_task("uuutask");
        if (taskCRUD.update(task))
            System.out.println("UPDATE: "+task);
        task=taskCRUD.read(task.getId());
        System.out.println("READ: "+task);
    }
}
