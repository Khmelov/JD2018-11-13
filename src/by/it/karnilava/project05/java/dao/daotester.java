package by.it.karnilava.project05.java.dao;

import by.it.karnilava.project05.java.beans.Client;

import java.util.List;

public class daotester {
    public static void main(String[] args) {
//        String passport="9999999A999AA9";
//        String password="admin";
//        if (!passport.matches("[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}")){
//            System.out.println("not suitable");
//        }
//
        DAO dao =DAO.getDao();
//        String sql =  ("WHERE `passport`=\""+passport+"\" AND `password`=\""+password+"\"");
//        List<Client> clients = dao.client.getAll(sql);
//        if (clients.isEmpty()){
//            System.out.println("not working");
//        }
//        else {
//            System.out.println(clients);
//        }
//        clients=dao.client.getAll("WHERE `idRoles`=1");
//        for (int i = 0; i <clients.size() ; i++) {
//            System.out.println(clients.get(i));
//
//        }

        Client client = dao.client.read(1);
        List<AccountDAO.TableAccount> list=dao.account.getAllAcconts(client);
        System.out.println(list);



    }
}
