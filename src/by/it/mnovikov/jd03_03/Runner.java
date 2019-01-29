package by.it.mnovikov.jd03_03;

import by.it.mnovikov.jd03_03.beans.Role;
import by.it.mnovikov.jd03_03.beans.User;
import by.it.mnovikov.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();
        dao.reset();

        System.out.println("==============// USER // ==============");
        User user = new User(0, "barabashka3", "pas9999", "barabashka3@mail.ru",
                "Барабаш", "Иванович", Timestamp.valueOf("1986-02-12 11:0:00"),
                "д. Малиновка, ул. Центральна, д 18, под печкой", 2);
//        user.setLogin("barabashka3");
//        user.setPassword("pas9999");
//        user.setEmail("barabashka3@mail.ru");
//        user.setFirst_name("Барабаш");
//        user.setLast_name("Иванович");
//        user.setBirthday(Timestamp.valueOf("1986-02-12 11:0:00"));
//        user.setAdress("д. Малиновка, ул. Центральна, д 18, под печкой");
//        user.setRoles_id(2);
        if (dao.user.create(user))
            System.out.println("CREATE: " + user);
//        user = dao.user.read(user.getId());
        System.out.println("READ: " + user);
        user.setLast_name("Михайлович");
        if (dao.user.update(user))
            System.out.println("UPDATE: " + user);
        if (dao.user.delete(user))
            System.out.println("DELETE: " + user);


        System.out.println("\n==============// ROLE // ==============");
        Role role = new Role();
        role.setRole("Guest");
        if (dao.role.create(role)) {
            System.out.println("CREATE: " + role);
        }
        role.setRole("NewGuest");
        if ((dao.role.update(role))) {
            System.out.println("UPDATE: " + role);
        }
        role = dao.role.read(role.getId());
        System.out.println("READ: " + role);
        if (dao.role.delete(role)) {
            System.out.println("DELETE: " + role);
        }
    }
}

