package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.*;
import by.it.kruglenja.Project.java.controller.Form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(new Locale("en", "US"));
        //User dao
        Dao dao = Dao.getDao();
        User user = new User();
        Order order = new Order();
        CompletedOrder co = new CompletedOrder();

        user.setLogin("RTX");
        user.setPassword("2012");
        user.setEmail("sadf@s");
        user.setPhone_number("+123456789!");
        user.setRoles_Id(2);
        System.out.println("+-+-+-+-+-+-+-+Users dao+-+-+-+-+-+-+-+");

        if (dao.user.create(user)) {
            System.out.println("create -------->" + user);
            System.out.println("change login -------->" + user);
        }
        user.setLogin("XXX");
        user.setRoles_Id(1);
        if (dao.user.update(user)) {
            System.out.println("Updated " + dao.user.getAll());
        }
//        if (dao.user.delete(user)) {
//            System.out.println("user -------->" + user.getLogin() + "--------> deleted");
//        }
        System.out.println("<_USER GETALL_>");
        List<User> all1;
        all1 = dao.user.getAll();
        for (User s : all1) {
            System.out.println(s);
        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Spareparts dao+-+-+-+-+-+-+-+");


//        spareparts.setModel("Opel");
//        spareparts.setCategory("engune");
//        spareparts.setName("coils");
//        spareparts.setSerial_number("41dfsaf5");
//        spareparts.setWeight(14.5);
//        spareparts.setPrice(99.9);
        Spareparts spareparts = new Spareparts(0, "fgh", "gh", "ghj", "ghjgh", 456.56, 56.66, 6);

        if (dao.spareparts.create(spareparts)) {
            System.out.println("create  fgh-------->" + spareparts);
//            spareparts.setModel("Lada");
        }
//        if (dao.spareparts.update(spareparts)) {
//            spareparts = dao.spareparts.read(spareparts.getId());
//            System.out.println("read -------->" + spareparts);
//        }
        List<Spareparts> all = new ArrayList<>();
        all = dao.spareparts.getAll();
        System.out.println("\n" + "+-+-+-+-+-+-+-+SP getall+-+-+-+-+-+-+-+");
        for (Spareparts s : all) {
            System.out.println(s);
        }
//        if (dao.spareparts.delete(spareparts)) {
//            System.out.println("spareparts -------->" + spareparts.getName() + " deleted");
//        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Roles dao+-+-+-+-+-+-+-+");
        Roles roles = new Roles();

        roles.setRole("Cleaner");

        if (dao.role.create(roles)) {
            System.out.println("create -------->" + roles);
            roles.setRole("Special customer");
        }
        if (dao.role.update(roles)) {
            roles = dao.role.read(roles.getId());
            System.out.println("read -------->" + roles);
        }
//        List<Order> all12;
//        all12 = dao.order.getAll();
//        for (Order f : all12) {
//            System.out.println(f);
//        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Order dao+-+-+-+-+-+-+-+");

        System.out.println("////////////////TEST///CREATE//////////////");
        order.setQuanity(555);
        order.setModel("Ziablyk");
        order.setName("Anaconda");
        order.setPrice(22.33);
        order.setSpareParts_id(1);
        order.setUsers_id(2);
        if (dao.order.create(order)) {
            System.out.println("created -------->" + order);
        }


        System.out.println("////////////////TEST///UPDATE//////////////");
        order.setQuanity(228);
        long id = order.getId();
        System.out.println(id);
        if (dao.order.update(order)) {
            System.out.println(order);
        }

        System.out.println("////////////////TEST/GETALL////////////////");
//
//
        System.out.println("<_USER GETALL_>");
        List<Order> allo = dao.order.getAll("WHERE `users_id`='1'");
        for (Order s : allo) {
            System.out.println(s);
        }

        if (dao.order.delete(order)) {
            System.out.println("order -------->" + order.getQuanity() + "--------> deleted");
        }
        System.out.println("////////////////TEST///CREATE//CO////////////");
        co.setAddress("Golodeda");
        co.setInfo("12-28");
        co.setTotalPrice(228.22);
        co.setUsers_id(1);
        if (dao.completedOrder.create(co)) {
            System.out.println("created -------->" + co);
        }


        System.out.println("////////////////TEST///UPDATE//////////////");
//        co.setTotalPrice(999.99);
//        long id1 = co.getId();
//        System.out.println(id);
//        if (dao.completedOrder.update(co)) {
//            System.out.println(co);
//        }
co = new CompletedOrder(0, "", "", 0, 0);
        System.out.println("////////////////TEST/GETALL////////////////");
//
//
        System.out.println("<CO GETALL_>");
        List<CompletedOrder> alloc = dao.completedOrder.getAll("WHERE `order_id`='1'");
        for (CompletedOrder s : alloc) {
            System.out.println(s);
        }

//        if (dao.completedOrder.delete(co)) {
//            System.out.println("order -------->" + co.getId() + "--------> deleted");
//        }
    }
}
