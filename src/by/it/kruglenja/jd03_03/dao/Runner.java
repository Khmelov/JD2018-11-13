package by.it.kruglenja.jd03_03.dao;

import by.it.kruglenja.jd03_03.beans.Roles;
import by.it.kruglenja.jd03_03.beans.Spareparts;
import by.it.kruglenja.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //User dao
        User user = new User();
        Dao dao = Dao.getDao();

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
        System.out.println("\n" + "+-+-+-+-+-+-+-+Spareparts dao+-+-+-+-+-+-+-+");

        Spareparts spareparts = new Spareparts();

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
        if (dao.spareparts.update(spareparts)) {
            spareparts = dao.spareparts.read(spareparts.getId());
            System.out.println("read -------->" + spareparts);
        }
//        if (dao.spareparts.delete(spareparts)) {
//            System.out.println("spareparts -------->" + spareparts.getName() + " deleted");
//        }
        System.out.println("\n" + "+-+-+-+-+-+-+-+Roles dao+-+-+-+-+-+-+-+");
        Roles roles = new Roles();

        roles.setRole("Cleaner");

        if (dao.roles.create(roles)) {
            System.out.println("create -------->" + roles);
            roles.setRole("Special customer");
        }
        if (dao.roles.update(roles)) {
            roles = dao.roles.read(roles.getId());
            System.out.println("read -------->" + roles);
        }
    }
}
