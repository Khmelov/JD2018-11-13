package by.it.markelov.jd03_03.dao;

import by.it.markelov.jd03_03.beans.Role;
import by.it.markelov.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        Role role = new Role(0, "test");
        User user = new User(0, "test", "ptest", "testmail", 1);
//================CREATE===============================
        DAO.getInstance().role.create(role);
        DAO.getInstance().user.create(user);

//================READ=++==============================
        Role read1 = DAO.getInstance().role.read(4);
        System.out.println(read1);
        User read = DAO.getInstance().user.read(3);
        System.out.println(read);

//================UPDATE===============================
        role = new Role(3, "test---");
        DAO.getInstance().role.update(role);

        user = new User(4, "test+", "ptest+", "testmail+", 1);
        DAO.getInstance().user.update(user);

//================DELETE===============================
        DAO.getInstance().role.delete(role);
        DAO.getInstance().user.delete(user);

//================GETALL===============================
        List<Role> allr = DAO.getInstance().role.getAll("");
        System.out.println(allr);

        List<User> all = DAO.getInstance().user.getAll("");
        System.out.println(all);
    }
}
