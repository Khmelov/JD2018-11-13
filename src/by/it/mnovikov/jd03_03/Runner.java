package by.it.mnovikov.jd03_03;

import by.it.mnovikov.jd03_03.beans.User;
import by.it.mnovikov.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();
        dao.reset();
        User user = new User();
        user.setLogin("barabashka3");
        user.setPassword("pas9999");
        user.setEmail("barabashka3@mail.ru");
        user.setFirst_name("Барабаш");
        user.setLast_name("Иванович");
        user.setBirthday(Timestamp.valueOf("1986-02-12 11:0:00"));
        user.setAdress("д. Малиновка, ул. Центральна, д 18, под печкой");
        user.setRoles_id(2);
        if (dao.user.create(user))
            System.out.println("CREATE: " + user);
        System.out.println("READ: " + dao.user.read(user.getId()));
        user.setLast_name("Михайлович");
        if (dao.user.update(user))
            System.out.println("UPDATE: " + user);

        if (dao.user.delete(user)) {
            System.out.println("user deleted");
        }
    }
}

