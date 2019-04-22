package by.it.naumenko.jd03_03;


import by.it.naumenko.jd03_03.beens.*;
import by.it.naumenko.project.java.beens.Profil;

import java.sql.SQLException;
import java.util.List;

public class RunnerMyDao {
    public static void main(String[] args) throws SQLException {
        MyDAO<Users> myDAOU = new MyDAO<>(new Users(),"users");
        Users user = new Users(0,"login1","passw","ema",2);
        myDAOU.create(user);
        System.out.println("CREATE: "+user);
        user.setLogin("login23");
        myDAOU.update(user);
        System.out.println("UPDATE: "+user);
        myDAOU.read(5);
        System.out.println("READ: "+user);
        myDAOU.delete(user);
        System.out.println("DELETE: "+user);

        //myDAOU.getAll()
        List<Users> lU =  myDAOU.getAll();
        System.out.println("\n\n===============================================вся таблица USER=========================================");
        for (int i = 0; i < lU.size(); i++)
            System.out.println(lU.get(i));
        String where = String.format(" WHERE password='%s' and login='%s' LIMIT 0,1", "vasya", "vasrtya");
        List <Users> IIU = myDAOU.getAll(where);
        System.out.println("USER SERCH:");
        for (int i = 0; i < IIU.size(); i++)
            System.out.println(IIU.get(i));
        System.out.println("========================================================================================================\n\n");


        MyDAO<Roles> myDAO = new MyDAO<>(new Roles(),"roles");
        Roles role = new Roles(0,"ggu");
        myDAO.create(role);
        System.out.println("CREATE: "+role);
        role.setRole("efefefeqf");
        myDAO.update(role);
        System.out.println("UPDATE: "+role);
        myDAO.read(9);
        System.out.println("READ: "+role);
        myDAO.delete(role);
        System.out.println("DELETE: "+role);
        List<Roles> lR =  myDAO.getAll();
        System.out.println("\n\n===============================================вся таблица ROLE=========================================");
        for (int i = 0; i < lR.size(); i++)
            System.out.println(lR.get(i));
        System.out.println("========================================================================================================\n\n");


        MyDAO<Cake> myDAOC = new MyDAO<>(new Cake(),"cake");
        Cake cake = new Cake(0,"egre",20,2.2,"ergerg","rgsag","rgrg",7);

        myDAOC.create(cake);
        System.out.println("cake создан");
        cake.setBescuit("глвый бимквит");
        myDAOC.update(cake);
        System.out.println("UPDATE:"+cake);
        myDAOC.read(5);
        System.out.println("READ:"+cake);
        myDAOC.delete(cake);
        System.out.println("DELETE:"+cake);
        List<Cake> lC =  myDAOC.getAll();
        System.out.println("\n\n===============================================вся таблица CAKE=========================================");
        for (int i = 0; i < lC.size(); i++)
            System.out.println(lC.get(i));
        System.out.println("========================================================================================================\n\n");


        MyDAO<Zakaz> myDAOZ = new MyDAO<>(new Zakaz(),"zakaz");
        Zakaz zakaz = new Zakaz(0,"2018-12-25 10:10:10",2,100.3,1,2);
        myDAOZ.create(zakaz);
        System.out.println("заказ создан");
        System.out.println("CREATE:"+zakaz);
        zakaz.setKoltort(4);
        myDAOZ.update(zakaz);
        System.out.println("UPDATE:"+zakaz);
        myDAOZ.read(5);
        System.out.println("READ:"+zakaz);
        myDAOZ.delete(zakaz);
        System.out.println("DELETE:"+zakaz);
        List<Zakaz> lZ =  myDAOZ.getAll();
        System.out.println("\n\n===============================================вся таблица ZAKAZ=========================================");
        for (int i = 0; i < lZ.size(); i++)
            System.out.println(lZ.get(i));
        System.out.println("========================================================================================================\n\n");


        MyDAO<Profil> myDAOP = new MyDAO<>(new Profil(),"profil");

        List<Profil> lP =  myDAOP.getAll();
        System.out.println("\n\n===============================================вся таблица profil=========================================");
        for (int i = 0; i < lP.size(); i++)
            System.out.println(lP.get(i));
        System.out.println("========================================================================================================\n\n");
//        List <Users> IIU = myDAOU.getAll(where);
//        System.out.println("USER SERCH:");
//        for (int i = 0; i < IIU.size(); i++)
//            System.out.println(IIU.get(i));
//        System.out.println("========================================================================================================\n\n");


    }
}
