package by.it.karnilava.jd03_02.CRUD;

import java.sql.SQLException;

import by.it.karnilava.jd03_02.beans.Client;


public class CRUD_ClientTester {
    public static void main(String[] args) throws SQLException {

        ClientCRUD clientCRUD = new ClientCRUD();
        Client client = new Client();


       client.setFirstName("Michael");
       client.setLastName("Volkov");
       client.setID_passport("4210119E011PB0");
       client.setPassword("mathematics");
       client.setRoles_idRoles(1);


        if (clientCRUD.create(client)) {
            System.out.println("CREATE: " + client);
            client.setFirstName("Misha");
            client.setLastName("Volkoff");
            client.setID_passport("3210119E011PB1");
        }

        if (clientCRUD.update(client)) {
            System.out.println("UPDATE: " + client);
            client = clientCRUD.read(client.getIdClient());
            System.out.println("READ: " + client);
        }

//        if (clientCRUD.delete(client))
//            System.out.println("DELETE: " + client);
    }

}
