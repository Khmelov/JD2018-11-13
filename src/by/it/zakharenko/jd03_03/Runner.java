package by.it.zakharenko.jd03_03;

import by.it.zakharenko.jd03_03.beans.Item;
import by.it.zakharenko.jd03_03.beans.Order;
import by.it.zakharenko.jd03_03.beans.Role;
import by.it.zakharenko.jd03_03.beans.User;
import by.it.zakharenko.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        //dao.reset();          // сбрасываем базу данных (в Connect)

        // USERS test
        User user = new User();
        user.setUsername("Sasha");
        user.setPassword("john1");
        user.setEmail("one@tut.by");
        user.setFullname("Sasha");
        user.setPhone("111-222-333");
        user.setAddress("Drozdy 1");
        user.setRoles_id(2);
        if (dao.user.create(user))
            System.out.println("CREATED: " + user);
        user.setUsername("Kolya");
        if (dao.user.update(user))
            System.out.println("UPDATED: " + user);
        user = dao.user.read(user.getId());
        System.out.println("READ: " + user);
        if (dao.user.delete(user))
            System.out.println("DELETE: " + user);
        System.out.println("*****************************************************************************");

        ///ROLES test
        Role role = new Role();
        role.setRole("Blocked");
        if (dao.role.create(role))
            System.out.println("CREATED: " + role);
        role.setRole("Moderator");
        if (dao.role.update(role))
            System.out.println("UPDATED: " + role);
        role = dao.role.read(role.getId());
        System.out.println("OUTPUT: " + role);
        if (dao.role.delete(role))
            System.out.println("DELETED: " + role);
        System.out.println("*****************************************************************************");

        ///ITEMS test
        Item item = new Item(5, "Z300", 670);
        if (dao.item.create(item))
            System.out.println("CREATED: " + item);
        item.setTitle("Zx777");
        if (dao.item.update(item))
            System.out.println("UPDATED: " + item);
        item = dao.item.read(item.getId());
        System.out.println("OUTPUT: " + item);
        if (dao.item.delete(item))
            System.out.println("DELETED: " + item);
        System.out.println("*****************************************************************************");

        //ORDERS test
        Order order = new Order(5, "2019-01-23", "08:22:55", 2, 2);
        if (dao.order.create(order))
            System.out.println("CREATED: " + order);
        order.setDate("2019-01-22");

        if (dao.order.update(order))
            System.out.println("UPDATED: " + order);
        order = dao.order.read(order.getId());
        System.out.println("OUTPUT: " + order);
        if (dao.order.delete(order))
            System.out.println("DELETED: " + order);
        System.out.println("*****************************************************************************");
    }
}
