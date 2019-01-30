package by.it.kruglenja.jd03_03.dao;

import by.it._examples_.jd03_03.beans.Role;
import by.it.kruglenja.jd03_03.beans.Order;
import by.it.kruglenja.jd03_03.beans.Roles;
import by.it.kruglenja.jd03_03.beans.Spareparts;
import by.it.kruglenja.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(new Locale("en", "US"));
        //User dao
        User user = new User();
        Dao dao = Dao.getDao();
        Spareparts spareparts = new Spareparts();

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
        user.setLogin("VAsyA");
        if (dao.user.update(user)) {
            user = dao.user.read(user.getId());
        }
//        if (dao.user.delete(user)) {
//            System.out.println("user -------->" + user.getLogin() + "--------> deleted");
//        }
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
        if (dao.role.create(roles)) {
            System.out.println("create -------->" + roles);
            roles.setRole("Special customer");
            roles.setRole("Cleaner");
        }
        if (dao.role.update(roles)) {
            roles = dao.role.read(roles.getId());
            System.out.println("read -------->" + roles);
        }
        List<Roles> all1 = new ArrayList<>();
        all1 = dao.role.getAll("VAsyA");
        for (Roles roles1 : all1) {
            System.out.println(roles1);
        }

        System.out.println("\n" + "+-+-+-+-+-+-+-+Order dao+-+-+-+-+-+-+-+");
        Order order = new Order();
        order.setQuanity(12);
        order.setDeliveryTime("Доставка в полшестого");
        order.setTotalPrice(20.22);
        order.setUsers_id(1);
        if (dao.order.create(order)) {
            System.out.println("create -------->" + order);
        }
        order.setQuanity(22);
        order.setDeliveryTime("Доставка в 12");

        if (dao.order.update(order)) {
            order = dao.order.read(order.getId());
            System.out.println("read -------->" + order);
        }
//        List<Order> all11 = new ArrayList<>();
//        all11 = dao.order.getAll("Доставка в полшестого");
//        for (Order order1 : all11) {
//            System.out.println(order1);
//        }

    }
}
