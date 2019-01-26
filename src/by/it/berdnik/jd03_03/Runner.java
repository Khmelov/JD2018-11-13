package by.it.berdnik.jd03_03;


import by.it.berdnik.jd03_03.beans.*;
import by.it.berdnik.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        //dao.reset();
        User user = new User();
        user.setNickname("LLLLLL");
        user.setPassword("PPPPPP");
        user.setEmail("EEEEEE");
        user.setRoles_Id(2);
        if (dao.user.create(user))
            System.out.println("CREATE: " + user);
        user.setNickname("LLLL22222222");
        if (dao.user.update(user))
            System.out.println("UPDATE: " + user);
        user = dao.user.read(user.getId());
        System.out.println("READ: " + user);
        if (dao.user.delete(user))
            System.out.println("DELETE: " + user);
        ///role
        Role role= new Role();
        role.setRole("RRRRR");
        if (dao.role.create(role))
            System.out.println("CREATE: " + role);
        role.setRole("RRRRR2222222");
        if (dao.role.update(role))
            System.out.println("UPDATE: " + role);
        role = dao.role.read(role.getId());
        System.out.println("READ: " + role);
        if (dao.role.delete(role))
            System.out.println("DELETE: " + role);
        ///buyer
        Buyer buyer= new Buyer(2, "Notebook", "MSI", 222, "Adddress", 2);
        if (dao.buyer.create(buyer))
            System.out.println("CREATE: " + buyer);
        buyer.setItem("описание");
        if (dao.buyer.update(buyer))
            System.out.println("UPDATE: " + buyer);
        buyer = dao.buyer.read(buyer.getId());
        System.out.println("READ: " + buyer);
        if (dao.buyer.delete(buyer))
            System.out.println("DELETE: " + buyer);
    }
}
