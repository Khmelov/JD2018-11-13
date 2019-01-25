package by.it.kovalyova.jd03_03;

import by.it.kovalyova.jd03_03.beans.User;
import by.it.kovalyova.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        dao.reset();

        User user=new User();
        user.setLogin("LLLLLL");
        user.setPassword("PPPPPP");
        user.setEmail("EEEEEE");
        user.setRoles_Id(2);
        if (dao.user.create(user))
            System.out.println("CREATE: "+user);
        user.setLogin("LLLL2222222");
        if (dao.user.update(user))
            System.out.println("UPDATE: "+user);
        user=dao.user.read(user.getId());
        System.out.println("READ: "+user);
        if (dao.user.delete(user))
            System.out.println("DELETE"+user);
    }
}
