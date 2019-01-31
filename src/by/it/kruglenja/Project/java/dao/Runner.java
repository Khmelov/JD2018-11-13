package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Roles;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.beans.User;

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
        Spareparts spareparts = new Spareparts();
        Order order = new Order();

        user.setLogin("RTX");
        user.setPassword("2012");
        user.setEmail("sadf@s");
        user.setPhone_number("+123456789!");
        user.setRoles_Id(2);
        System.out.println("+-+-+-+-+-+-+-+Users dao+-+-+-+-+-+-+-+");

        if (dao.user.create(user)) {
            System.out.println("create -------->" + user);
            user.setLogin("VAsyA");
            System.out.println("change login -------->" + user);
        }
        if (dao.user.update(user)) {
            user = dao.user.read(user.getId());
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


        spareparts.setModel("Opel");
        spareparts.setCategory("engune");
        spareparts.setName("coils");
        spareparts.setSerial_number("41dfsaf5");
        spareparts.setWeight(14.5);
        spareparts.setPrice(99.9);

        if (dao.spareparts.create(spareparts)) {
            System.out.println("create -------->" + spareparts);
            spareparts.setModel("Lada");
        }
//        if (dao.spareparts.update(spareparts)) {
//            spareparts = dao.spareparts.read(spareparts.getId());
//            System.out.println("read -------->" + spareparts);
//        }
        List<Spareparts> all = new ArrayList<>();
        all = dao.spareparts.getAll("");
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

/////////////////////////////////////
        order.setQuanity(555);
        order.setDeliveryTime("After tommorow");
        order.setTotalPrice(222.599);
        order.setSparePart_id(1);
        order.setUsers_id(2);
        if (dao.order.create(order)) {

            System.out.println("create -------->" + order);
            order.setTotalPrice(228.322);
            System.out.println("change price ---222.599----->228.322" + order);
        }
        if (dao.order.update(order)) {
            dao.order.read(order.getId());
        }
        System.out.println("<_USER GETALL_>");
        List<Order> allo = dao.order.getAll("WHERE `users_id`='2'");
        for (Order s : allo) {
            System.out.println(s);
        }

//        if (dao.order.delete(order)) {
//            System.out.println("order -------->" + order.getQuanity() + "--------> deleted");
//        }
    }
}
