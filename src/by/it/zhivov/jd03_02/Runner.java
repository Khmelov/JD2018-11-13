package by.it.zhivov.jd03_02;

import by.it.zhivov.jd03_02.beans.Ad;
import by.it.zhivov.jd03_02.beans.User;
import by.it.zhivov.jd03_02.crud.AdCRUD;
import by.it.zhivov.jd03_02.crud.C_Reset;
import by.it.zhivov.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        {
            C_Reset.restoreDB();
            C_Reset.resetAds();
            C_Reset.resetUsers();
            C_Reset.resetDB();
            C_Reset.restoreDB();
        }

        UserCRUD userCRUD = new UserCRUD();
        AdCRUD adCRUD = new AdCRUD();
        User user = new User();
        Ad ad = new Ad();
        //манипуляции с таблицей user
        //create
        user.setName("Genady");
        user.setLogin("Gena4iba");
        user.setPassword("root");
        user.setDateOfBirth("24.05.1989");
        user.setEmail("gen4ik@mail.ru");
        user.setTel("+79038652555");
        user.setRoles_Id(2);
        if (userCRUD.create(user))
            System.out.println("\tCreate user successful\n" + user + "\n");
        //update
        user.setEmail("changed!_setEmail done");
        if (userCRUD.update(user))
            System.out.println("\tUpdate user successful\n" + user + "\n");
        user.setTel("changed!_setTel done");
        ;
        //read
        user = userCRUD.read(user.getId());
        System.out.println("\tRead user successful\n" + user + "\n");

        //манипуляции с таблицей ads
        //create
        ad.setTitle("Лучшее авто за 5000$");
        ad.setDescription("norm auto");
        ad.setBrnd("BMW");
        ad.setModel("X5m");
        ad.setColor("Black");
        ad.setBody("Hatchback");
        ad.setYear(2016);
        ad.setEquipment("Lux");
        ad.setMillage(42000);
        ad.setCrashed(false);
        ad.setPrice(156000);
        ad.setId_User(user.getId());
        if (adCRUD.create(ad))
            System.out.println("\tCreate ad successful\n" + ad + "\n");
        //update
        ad.setYear(2014);
        if (adCRUD.update(ad))
            System.out.println("\tUpdate ad successful\n" + ad + "\n");
        ad.setPrice(140000);
        adCRUD.update(ad);
        //read
        ad = adCRUD.read(ad.getId());
        System.out.println("\tRead ad successful\n" + ad + "\n");
            //delete ad
            if (adCRUD.delete(ad))
                System.out.println("\tDelete ad succefull\n" + ad + "\n");
            //delete user
            if (userCRUD.delete(user))
                System.out.println("\tDelete user successful\n" + user + "\n");

    }
}

