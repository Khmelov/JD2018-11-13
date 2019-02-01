package by.it.zhivov.project.java;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.Role;
import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;
import by.it.zhivov.project.java.dao.InnerJoin_id;

import java.sql.SQLException;

public class TesterDao {
    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 20; i++) {
            //Dao.restoreDB();
            Dao dao = Dao.getDao();
            Role role = new Role();
            User user = new User();
            Ad ad = new Ad();


            //манипуляции с role
            //create
            role.setRole("moderator");
            if (dao.role.create(role))
                System.out.println("\tCreate role successful\n" + role + "\n");
            //update
            role.setRole("superuser");
            if (dao.role.update(role))
                System.out.println("\tUpdate role successful\n" + role + "\n");
            //read
            role = dao.role.read(role.getId());
            System.out.println("\tRead role successful\n" + role + "\n");

            //манипуляции с таблицей user
            //create
            user.setName("Genady");
            user.setLogin("4iba");
            user.setPassword("root");
            user.setDateOfBirth("1994.05.24");
            user.setEmail("gen4ik@mail.ru");
            user.setTel("+79038652555");
            user.setRoles_Id(2);
            if (dao.user.create(user))
                System.out.println("\tCreate user successful\n" + user + "\n");
            //update
            user.setEmail("changed!_setEmail done");
            if (dao.user.update(user))
                System.out.println("\tUpdate user successful\n" + user + "\n");
            //read
            user = dao.user.read(user.getId());
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
            ad.setEngine(2.5);
            ad.setAt(1);
            ad.setDriveunit("Full");
            ad.setEquipment("Lux");
            ad.setMillage(42000);
            ad.setCrashed(0);
            ad.setPrice(156000.3);
            ad.setId_User(user.getId());
            if (dao.ad.create(ad))
                System.out.println("\tCreate ad successful\n" + ad + "\n");
            //update
            ad.setYear(2014);
            ad.setPrice(140000);
            if (dao.ad.update(ad))
                System.out.println("\tUpdate ad successful\n" + ad + "\n");
            //read
            ad = dao.ad.read(ad.getId());
            System.out.println("\tRead ad successful\n" + ad + "\n");
            {
//                //delete ad
//                if (dao.ad.delete(ad))
//                    System.out.println("\tDelete ad succefull\n" + ad + "\n");
//                //delete user
//                if (dao.user.delete(user))
//                    System.out.println("\tDelete user successful\n" + user + "\n");
                //delete role
                if (dao.role.delete(role))
                    System.out.println("\tDelete role successful\n" + role + "\n");
            }
            InnerJoin_id.getAllRows();
            InnerJoin_id.getRolesRows();
            //Dao.restoreDB();
        }
        //Dao.restoreDB();
    }
}
