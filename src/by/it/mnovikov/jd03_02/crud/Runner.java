package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.Role;
import by.it.mnovikov.jd03_02.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role();
        role.setRole("guest");
        if (roleCRUD.create(role))
            System.out.println("CREATE: " + role);

        UserCRUD userCRUD = new UserCRUD();
        User user = new User();
        user.setLogin("barabashka3");
        user.setPassword("pas9999");
        user.setEmail("barabashka3@mail.ru");
        user.setFirst_name("Барабаш");
        user.setLast_name("Иванович");
        user.setBirthday(Timestamp.valueOf("1986-02-12 11:0:00"));
        user.setAdress("д. Малиновка, ул. Центральна, д 18, под печкой");
        user.setRoles_id(2);
        if (userCRUD.create(user))
            System.out.println("CREATE: " + user);
        user.setLast_name("Михайлович");
        if (userCRUD.update(user))
            System.out.println("UPDATE: " + user);

    }
}
