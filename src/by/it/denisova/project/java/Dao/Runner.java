package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Role;
import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao =  Dao.getDao();

        System.out.println("-------------------USER----------------------");

        User user = new User();
        user.setLogin("katiaDEn23.01");
        user.setPassword("qwerty23");
        user.setEmail("katua@mail.ru");
        user.setIdRole(1);
        if(dao.user.create(user)) {
            System.out.println("Created " + user);
        }
        user.setLogin("belebirda");
        if (dao.user.update(user)) {
            System.out.println("Updated " + user);
        }
        user = dao.user.read(user.getId());
        System.out.println("read" +user);

        if(dao.user.delete(user)){
            System.out.println("user deleted " + user);
        }

        System.out.println("-------------------ROLE----------------------");
        Role role = new Role();
        role.setRole("Admin");
        if(dao.role.create(role)) {
            System.out.println("created " + role);
        }
        role.setRole("user");
        if(dao.role.update(role)){
            System.out.println("Updated " + role);
        }
        role = dao.role.read((role.getId()));
        System.out.println("read " + role);

        System.out.println("-------------------TEST----------------------");
        Test test = new Test();
        test.setTest_name("work");
        if(dao.test.create(test)) {
            System.out.println("Created " + test);
        }

        test.setTest_name("parent");
        if(dao.test.update(test)){
            System.out.println("Updated " + test);
        }

        test = dao.test.read(test.getId());
        System.out.println(test);

        if(dao.test.delete(test)) {
            System.out.println("test deleted" + test);
        }
  }
}
