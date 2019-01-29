package by.it.kruglenja.jd03_02.crud;

import by.it.kruglenja.jd03_02.beans.Spareparts;
import by.it.kruglenja.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
//        User user = new User();
//        UserCRUD userCRUD = new UserCRUD();
//
//        user.setLogin("RTX");
//        user.setPassword("2012");
//        user.setEmail("sadf@s");
//        user.setPhone_number("+123456789!");
//        user.setRoles_Id(2);
//
//        if (userCRUD.crate(user)) {
//            System.out.println("create " + user);
//            user.setLogin("VAsyA");
//        }
//        if (userCRUD.update(user)) {
//            System.out.println(user);
//            user = userCRUD.read(user.getId());
//            System.out.println("read" + user);
//        }
//        if (userCRUD.delete(user)) {
//            System.out.println("user " + user.getLogin() + " deleted");
//        }


        Spareparts spareparts = new Spareparts();
        SparepartsCRUD sparepartsCRUD = new SparepartsCRUD();

        spareparts.setModel("Opel");
        spareparts.setCategory("REM");
        spareparts.setName("SSD");
        spareparts.setSerial_number("41dfsaf5");
        spareparts.setWeight(14.5);
        spareparts.setPrice(99.9);
        System.out.println(spareparts.toString());

        if (sparepartsCRUD.crate(spareparts)) {
            spareparts.setPrice(9999.9);
        }

//        if (sparepartsCRUD.update(spareparts)) {
//            System.out.println(spareparts);
//            spareparts = sparepartsCRUD.read(spareparts.getId());
//            System.out.println("read" + spareparts);
//        }

        if (sparepartsCRUD.delete(spareparts)){
            System.out.println("sparepart " + spareparts.getName() + " was deleted");
        }
        System.out.println(sparepartsCRUD.read(1).toString());

    }
}
