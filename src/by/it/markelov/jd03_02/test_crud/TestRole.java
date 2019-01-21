package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.Role;
import by.it.markelov.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

public class TestRole {
    public static void main(String[] args) {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role(0, "Guest");
        try {
//==================CREATE=========================
            roleCRUD.create(role);

//==================READ===========================
            Role readRole = roleCRUD.read(1);
            System.out.println(readRole);

//===================UPDATE========================
            roleCRUD.update(role);

//===================DELETE========================
            roleCRUD.delete(role);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
