package by.it.denisova.jd03_02.CRUD;

import by.it.denisova.jd03_02.beans.Role;
import by.it.denisova.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        System.out.println("-------------------USER----------------------");
        UserCRUD userCRUD = new UserCRUD();
        User user = new User();
        user.setLogin("katiaDEn23.01");
        user.setPassword("qwerty23");
        user.setEmail("katua@mail.ru");
        user.setIdRole(1);
        if(userCRUD.create(user)) {
            System.out.println("Created" + user);
        }
        user.setLogin("belebirda");
        if (userCRUD.update(user)) {
            System.out.println("Updated " + user);
        }
        user =userCRUD.read(user.getId());
        System.out.println("read" +user);
        System.out.println("-------------------ROLE----------------------");
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role();
        role.setRole("Admin");
        if(roleCRUD.create(role)) {
            System.out.println("created " + role);
        }
        role.setRole("user");
        if(roleCRUD.update(role)){
            System.out.println("Updated " + role);
        }
        role = roleCRUD.read((role.getId()));
        System.out.println("read " + role);
    }
}
