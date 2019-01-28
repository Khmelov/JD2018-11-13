package by.it.naumenko.jd03_02.CRUD;

import by.it.naumenko.jd03_02.beens.Zakaz;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
//        UserCRUD userCRUD = new UserCRUD();
//        Users users = new Users();
//        users.setLogin("wr2r23r23");
//        users.setPassword("password");
//        users.setEmail("email");
//        users.setId_roles(1);
//        if (userCRUD.create(users))
//            System.out.println("CREATE: "+users);
//        users.setLogin("login");
//        if (userCRUD.update(users))
//            System.out.println("UPDATE: "+users);
//        users=userCRUD.read(users.getId_user());
//        System.out.println("READ: "+users);
//        if (userCRUD.delete(users))
//            System.out.println("DELETE: "+users);
//
//
//        RoleCRUD roleCRUD = new RoleCRUD();
//        Roles roles = new Roles();
//        System.out.println("РОЛЬ создана");
//        roles.setRole("sadfhuashfh");
//        if (roleCRUD.create(roles))
//            System.out.println("CREATE: "+roles);
//        roles.setRole("role");
//        if (roleCRUD.update(roles))
//            System.out.println("UPDATE: "+roles);
//        roles=roleCRUD.read(roles.getId_role());
//        System.out.println("READ: "+roles);
//
//
//        CakeCRUD cakeCRUD = new CakeCRUD();
//        Cake cake = new Cake();
//        cake.setName_cake("name_cake");
//        cake.setBescuit("bescuit");
//        cake.setCream("cream");
//        cake.setDecoration("decoration");
//        cake.setSize_cake(2);
//        cake.setWeight_cake(3);
//        cake.setPrice_cake(7);
//
//        if (cakeCRUD.create(cake))
//            System.out.println("CREATE: "+cake);
//        cake.setName_cake("цупцупцуп");
//        cake.setBescuit("цкпцкпц");
//        cake.setCream("цпцкп");
//        cake.setDecoration("цкпцкпцкп");
//        cake.setSize_cake(3);
//        cake.setWeight_cake(5);
//        cake.setPrice_cake(40.5);
//        if(cakeCRUD.update(cake))
//            System.out.println("UPDATE:"+cake);
//        cake=cakeCRUD.read(cake.getId_cake());
//        System.out.println("READ: "+cake);
//        if(cakeCRUD.delete(cake))
//            System.out.println("DELETE:" + cake);
//

        ZakazCRUD zakazCRUD = new ZakazCRUD();
        Zakaz zakaz = new Zakaz();
        //zakaz.setDate_zakaz(1528699);
        //zakaz.setId_zakaz(6);
        zakaz.setDate_zakazS("2018-12-25 10:10:10");
        zakaz.setKoltort(1);
        zakaz.setPrice_zakaz(55.5);
        zakaz.setId_user(2);
        zakaz.setId_cake(2);

        if (zakazCRUD.create(zakaz))
            System.out.println("CREATE: " + zakaz);

//        //zakaz.setDate_zakaz(1528699);
//        zakaz.setDate_zakazS("2019-01-20 15:52:30");
//        zakaz.setKoltort(2);
//        zakaz.setPrice_zakaz(100.55);
//        zakaz.setId_user(1);
//        zakaz.setId_cake(1);
//        if(zakazCRUD.update(zakaz))
//            System.out.println("UPDATE:" + zakaz);
//        zakaz=zakazCRUD.read(zakaz.getId_zakaz());
//        System.out.println("READ: "+zakaz);
//        if(zakazCRUD.delete(zakaz))
//            System.out.println("DELETE:" + zakaz);


    }
}
