package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.Role;

import java.sql.SQLException;

public class CRUD_RoleTester {
    public static void main(String[] args) throws SQLException {

        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role();


role.setRole("Guest");



        if (roleCRUD.create(role)) {
            System.out.println("CREATE: " + role);
            role.setRole("Unexpected guest");

        }


        if (roleCRUD.update(role)) {
            System.out.println("UPDATE: " + role);
            role = roleCRUD.read(role.getId());
            System.out.println("READ: " + role);
        }

        if (roleCRUD.delete(role))
            System.out.println("DELETE: " + role);
    }
}
