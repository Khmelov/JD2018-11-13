package by.it.naumenko.jd03_03;


import by.it.naumenko.jd03_03.beens.Cake;
import by.it.naumenko.jd03_03.beens.Roles;
import by.it.naumenko.jd03_03.beens.Users;
import by.it.naumenko.jd03_03.beens.Zakaz;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        Users users = new Users();
        users.setLogin("wr2r23r23");
        users.setPassword("password");
        users.setEmail("email");
        users.setId_roles(1);
        if (userDAO.create(users))
            System.out.println("CREATE: "+users);
        users.setLogin("login");
        if (userDAO.update(users))
            System.out.println("UPDATE: "+users);
        users=userDAO.read(users.getId_user());
        System.out.println("READ: "+users);
        if (userDAO.delete(users))
            System.out.println("DELETE: "+users);
        System.out.println("\n\n===============================================вся таблица USER=========================================");
        List<Users> lR =  userDAO.getAll();
        for (int i = 0; i < lR.size(); i++)
            System.out.println(lR.get(i));
        System.out.println("========================================================================================================\n\n");

//
//
        RoleDAO roleDAO = new RoleDAO();
        Roles roles = new Roles();
        System.out.println("РОЛЬ создана");
        roles.setRole("sadfhuashfh");
        if (roleDAO.create(roles))
            System.out.println("CREATE: "+roles);
        roles.setRole("role");
        if (roleDAO.update(roles))
            System.out.println("UPDATE: "+roles);
        roles=roleDAO.read(roles.getId_role());
        System.out.println("READ: "+roles);
        if (roleDAO.delete(roles))
            System.out.println("DELETE: "+roles);
        System.out.println("\n\n===============================================вся таблица ROLE=========================================");
        List<Roles> lU =  roleDAO.getAll();
        for (int i = 0; i < lU.size(); i++)
            System.out.println(lU.get(i));
        System.out.println("========================================================================================================\n\n");


//
//
        CakeDAO cakeDAO = new CakeDAO();
        Cake cake = new Cake();
        cake.setName_cake("name_cake");
        cake.setBescuit("bescuit");
        cake.setCream("cream");
        cake.setDecoration("decoration");
        cake.setSize_cake(2);
        cake.setWeight_cake(3);
        cake.setPrice_cake(7);

        if (cakeDAO.create(cake))
            System.out.println("CREATE: "+cake);
        cake.setName_cake("цупцупцуп");
        cake.setBescuit("цкпцкпц");
        cake.setCream("цпцкп");
        cake.setDecoration("цкпцкпцкп");
        cake.setSize_cake(3);
        cake.setWeight_cake(5);
        cake.setPrice_cake(40.5);
        if(cakeDAO.update(cake))
            System.out.println("UPDATE:"+cake);
        cake=cakeDAO.read(cake.getId_cake());
        System.out.println("READ: "+cake);
        if(cakeDAO.delete(cake))
            System.out.println("DELETE:" + cake);

        System.out.println("\n\n===============================================вся таблица CAKE=========================================");
        List<Cake> lC =  cakeDAO.getAll();
        for (int i = 0; i < lC.size(); i++)
            System.out.println(lC.get(i));
        System.out.println("========================================================================================================\n\n");
//

        ZakazDAO zakazDAO = new ZakazDAO();
        Zakaz zakaz = new Zakaz();
        //zakaz.setDate_zakaz(1528699);
        //zakaz.setId_zakaz(6);
        zakaz.setDate_zakazS("2018-12-25 10:10:10");
        zakaz.setKoltort(1);
        zakaz.setPrice_zakaz(55.5);
        zakaz.setId_user(2);
        zakaz.setId_cake(2);

        if (zakazDAO.create(zakaz))
            System.out.println("CREATE: " + zakaz);

        //zakaz.setDate_zakaz(1528699);
        zakaz.setDate_zakazS("2019-01-20 15:52:30");
        zakaz.setKoltort(2);
        zakaz.setPrice_zakaz(100.55);
        zakaz.setId_user(1);
        zakaz.setId_cake(1);
        if(zakazDAO.update(zakaz))
            System.out.println("UPDATE:" + zakaz);
        zakaz=zakazDAO.read(zakaz.getId_zakaz());
        System.out.println("READ: "+zakaz);
        if(zakazDAO.delete(zakaz))
            System.out.println("DELETE:" + zakaz);

        System.out.println("\n\n===============================================вся таблица ZAKAZ=========================================");
        List<Zakaz> lZ =  zakazDAO.getAll();
        for (int i = 0; i < lZ.size(); i++)
            System.out.println(lZ.get(i));
        System.out.println("========================================================================================================\n\n");


    }
}
